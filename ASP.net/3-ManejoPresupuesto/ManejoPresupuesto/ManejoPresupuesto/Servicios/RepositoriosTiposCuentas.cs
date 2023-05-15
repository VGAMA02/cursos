using Dapper;
using ManejoPresupuesto.Models;
using System.Data.SqlClient;

namespace ManejoPresupuesto.Servicios
{
    public interface IRepositoriosTiposCuentas
    {
        Task Actualizar(TipoCuentaDTO tipoCuenta);
        Task Borrar(int id);
        Task Crear(TipoCuentaDTO tipoCuentaDTO);
        Task<bool> Existe(string nombre, int? usuarioId, int id = 0);
        Task<IEnumerable<TipoCuentaDTO>> Obtener(int usuarioId);
        Task<TipoCuentaDTO> ObtenerPorId(int? id, int usuarioId);
        Task Ordenar(IEnumerable<TipoCuentaDTO> tipoCuentasOrdenados);
    }
    public class RepositoriosTiposCuentas: IRepositoriosTiposCuentas
    {
        private readonly string connectionString;
        public RepositoriosTiposCuentas(IConfiguration configuration) {
            connectionString = configuration.GetConnectionString("DefaultConnection");
        }
        public async Task Crear(TipoCuentaDTO tipoCuenta)
        {
            using var connection = new SqlConnection(connectionString);
            var id = await connection.QuerySingleAsync<int>("TiposCuentas_Insertar", new {UsuarioId = tipoCuenta.UsuarioId, nombre = tipoCuenta.Nombre},commandType: System.Data.CommandType.StoredProcedure);
            tipoCuenta.Id = id;
        }

        public async Task<bool> Existe(string nombre, int? usuarioId, int id)
        {
            using var connection = new SqlConnection(connectionString);
            var existe = await connection.QueryFirstOrDefaultAsync<int>(@"SELECT 1 FROM TiposCuentas WHERE Nombre = @Nombre AND UsuarioId = @UsuarioId AND Id <> @Id;",new {nombre,usuarioId,id});
            return existe == 1;

        }

        public async Task<IEnumerable<TipoCuentaDTO>> Obtener(int usuarioId)
        {
            using var connection = new SqlConnection(connectionString);
            return await connection.QueryAsync<TipoCuentaDTO>(@"SELECT Id, Nombre, Orden FROM TiposCuentas WHERE UsuarioId = @UsuarioId ORDER BY Orden", new {usuarioId});
        }

        public async Task Actualizar(TipoCuentaDTO tipoCuenta)
        {
            using var connection = new SqlConnection(connectionString);
            await connection.ExecuteAsync(@"UPDATE TiposCuentas SET Nombre = @Nombre WHERE Id = @Id",tipoCuenta);
        }
        public async Task<TipoCuentaDTO> ObtenerPorId(int? id, int usuarioId)
        {
            using var connection = new SqlConnection(connectionString);
            return await connection.QueryFirstOrDefaultAsync<TipoCuentaDTO>(@"SELECT Id, Nombre, Orden FROM TiposCuentas WHERE Id = @Id AND UsuarioId = @UsuarioId", new { id, usuarioId });
        }

        public async Task Borrar(int id)
        {
            using var connection = new SqlConnection(connectionString);
            await connection.ExecuteAsync(@"DELETE TiposCuentas WHERE Id = @Id", new {id});
        }

        public async Task Ordenar(IEnumerable<TipoCuentaDTO> tipoCuentasOrdenados)
        {
            var query = "UPDATE TiposCuentas SET Orden = @Orden WHERE Id = @Id;";
            using var connection = new SqlConnection(connectionString);
            await connection.ExecuteAsync(query,tipoCuentasOrdenados);
        }


    }
}
