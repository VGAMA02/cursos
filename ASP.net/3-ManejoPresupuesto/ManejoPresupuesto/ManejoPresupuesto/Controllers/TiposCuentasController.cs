using Dapper;
using ManejoPresupuesto.Models;
using ManejoPresupuesto.Servicios;
using Microsoft.AspNetCore.Mvc;
using System.Data.SqlClient;

namespace ManejoPresupuesto.Controllers
{
    public class TiposCuentasController : Controller
    {
        //private readonly string connectionString;
        private readonly IRepositoriosTiposCuentas repositoriosTiposCuentas;
        private readonly IServicioUsuarios servicioUsuarios;

        public TiposCuentasController(IRepositoriosTiposCuentas repositoriosTiposCuentas,
            IServicioUsuarios servicioUsuarios) {
            this.repositoriosTiposCuentas = repositoriosTiposCuentas;
            this.servicioUsuarios = servicioUsuarios;
            //connectionString = configuration.GetConnectionString("DefaultConnection");
        }

        public async Task<IActionResult> Index()
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tiposCuentas = await repositoriosTiposCuentas.Obtener(usuarioId);
            return View(tiposCuentas);
        }

        public IActionResult Crear()
        {
            //using (
            //    var connection = new SqlConnection(connectionString))
            //{
            //    var query = connection.Query("SELECT 1").FirstOrDefault();
            //}
                return View();
        }
        [HttpPost]
        public async Task<IActionResult> Crear(TipoCuentaDTO tipoCuentaDTO)
        {
            if (!ModelState.IsValid)
            {
                return View(tipoCuentaDTO);
            }
            tipoCuentaDTO.UsuarioId = servicioUsuarios.ObtenerUsuarioId();

            var yaExisteTipoCuenta = await repositoriosTiposCuentas.Existe(tipoCuentaDTO.Nombre,tipoCuentaDTO.UsuarioId);
            if (yaExisteTipoCuenta)
            {
                ModelState.AddModelError(nameof(tipoCuentaDTO.Nombre),$"El nombre {tipoCuentaDTO.Nombre} ya existe.");
                return View(tipoCuentaDTO);
            }
            await repositoriosTiposCuentas.Crear(tipoCuentaDTO);

            return RedirectToAction("Index");
        }

        [HttpGet]
        public async Task<ActionResult> Editar(int id)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tipoCuenta = await repositoriosTiposCuentas.ObtenerPorId(id,usuarioId);
            if (tipoCuenta is null)
            {
                return RedirectToAction("NoEncontrado","Home");
            }

            return View(tipoCuenta);
        }

        [HttpPost]
        public async Task<ActionResult> Editar(TipoCuentaDTO tipoCuenta)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tipoCuentaExiste = await repositoriosTiposCuentas.ObtenerPorId(tipoCuenta.Id,usuarioId);
            if (tipoCuentaExiste is null)
            {
                return RedirectToAction("NoContrado","Home");
            }

            await repositoriosTiposCuentas.Actualizar(tipoCuenta);
            return RedirectToAction("Index");
        }

        public async Task<IActionResult> Borrar(int id)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tipoCuenta = await repositoriosTiposCuentas.ObtenerPorId(id, usuarioId);
            if (tipoCuenta is null)
            {
                return RedirectToAction("NoEncotrado", "Home");
            }
            return View(tipoCuenta);
        }
        [HttpPost]
        public async Task<IActionResult> BorrarTipoCuenta(int id)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tipoCuenta = await repositoriosTiposCuentas.ObtenerPorId(id, usuarioId);
            if (tipoCuenta is null)
            {
                return RedirectToAction("NoEncotrado", "Home");
            }
            await repositoriosTiposCuentas.Borrar(id);
            return RedirectToAction("Index");
        }


        [HttpGet]
        public async Task<IActionResult> VerificarExisteTipoCuenta(string nombre, int id)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var yaExisteTipoCuenta = await repositoriosTiposCuentas.Existe(nombre,usuarioId,id);
            if (yaExisteTipoCuenta)
            {
                return Json($"El nombre {nombre} ya existe");
              
            }

            return Json(true);
        }
        [HttpPost]
        public async Task<IActionResult> Ordenar([FromBody] int[] ids)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tiposCuentas = await repositoriosTiposCuentas.Obtener(usuarioId);
            var idsTiposCuentas = tiposCuentas.Select(x => x.Id);
            var idsTiposCuentasNoPertenecenAlUsuario = ids.Except(idsTiposCuentas).ToList();

            if (idsTiposCuentasNoPertenecenAlUsuario.Count > 0)
            {
                return Forbid();
            }

            var tipoCuentasOrdenados = ids.Select((valor, indice) =>
            new TipoCuentaDTO() { Id = valor, Orden = indice + 1 }).AsEnumerable();

            await repositoriosTiposCuentas.Ordenar(tipoCuentasOrdenados);

            return Ok();
        }
    }
}
