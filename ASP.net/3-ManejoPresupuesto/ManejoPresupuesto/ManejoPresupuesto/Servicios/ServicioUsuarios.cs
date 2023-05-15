using DocumentFormat.OpenXml.Spreadsheet;
using System.Security.Claims;

namespace ManejoPresupuesto.Servicios
{
    public interface IServicioUsuarios
    {
        int ObtenerUsuarioId();
    }
    public class ServicioUsuarios: IServicioUsuarios
    {
        private readonly HttpContext httpContext;

        public ServicioUsuarios(IHttpContextAccessor httpContextAccessor)
        {
            httpContext = httpContextAccessor.HttpContext;
        }

        public IHttpContextAccessor HttpContextAccessor { get; }

        public int ObtenerUsuarioId()
        {

            if (httpContext.User.Identity.IsAuthenticated)
            {
                //solamente si el usuario esta autenticado
                var idClaim = httpContext.User.Claims.Where(x => x.Type == ClaimTypes.NameIdentifier).FirstOrDefault();
                var id = int.Parse(idClaim.Value);
                return id;
            }
            else
            {
                //solamente si el usuario no esta autenticado
                throw new ApplicationException("El usuario no esta autenticado");
            }
           
        }
    }
}
