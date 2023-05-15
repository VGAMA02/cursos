using AutoMapper;
using ManejoPresupuesto.Models;
using ManejoPresupuesto.Servicios;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ModelBinding;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.Extensions.Logging;
using System.Reflection;

namespace ManejoPresupuesto.Controllers
{
    public class CuentasController : Controller
    {
        private readonly IRepositoriosTiposCuentas repositoriosTiposCuentas;
        private readonly IServicioUsuarios servicioUsuarios;
        private readonly IRepositorioCuentas repositorioCuentas;
        private readonly ILogger<HomeController> _logger;
        private readonly IMapper mapper;
        private readonly IRepositorioTransacciones repositorioTransacciones;
        private readonly IServicioReportes servicioReportes;

        public CuentasController(IRepositoriosTiposCuentas repositoriosTiposCuentas, IServicioUsuarios servicioUsuarios,
            IRepositorioCuentas repositorioCuentas,ILogger<HomeController> logger,
            IMapper mapper, IRepositorioTransacciones  repositorioTransacciones,
            IServicioReportes servicioReportes  )
        {
            this.repositoriosTiposCuentas = repositoriosTiposCuentas;
            this.servicioUsuarios = servicioUsuarios;
            this.repositorioCuentas = repositorioCuentas;
            _logger = logger;
            this.mapper = mapper;
            this.repositorioTransacciones = repositorioTransacciones;
            this.servicioReportes = servicioReportes;
            _logger.LogInformation("Entrando a constructor");
        }
        public async Task<IActionResult> Index()
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var cuentasConTipoCuenta = await repositorioCuentas.Buscar(usuarioId);
            var modelo = cuentasConTipoCuenta.GroupBy(x => x.TipoCuenta).Select(grupo => new IndiceCuentasViewModel
            {
                TipoCuenta = grupo.Key,
                Cuentas = grupo.AsEnumerable()
            }).ToList();
            return View(modelo);
        }

        public async Task<IActionResult> Detalle(int id, int mes, int año)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var cuenta = await repositorioCuentas.ObtenerPorId(id,usuarioId);
            if (cuenta is null)
            {
                return RedirectToAction("NoEncontrado","Home");
            }
  
            ViewBag.Cuenta = cuenta.Nombre;
            var modelo = await servicioReportes.ObtenerReporteTransaccionesDetalladasPorCuenta(usuarioId,id,mes,año,ViewBag);

            return View(modelo);
        }


        [HttpGet]
        public async Task<IActionResult> Crear()
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            _logger.LogInformation("Entrando a creacion sin modelo, user: " + usuarioId);
            
           
            var modelo = new CuentaCreacionViewModel();
            modelo.TiposCuentas = await ObtenerTiposCuentas(usuarioId);
            //_logger.LogInformation("\n Modelo: " + modelo.TiposCuentas.Count());
            return View(modelo);
        }

        [HttpPost]
        public async Task<IActionResult> Crear(CuentaCreacionViewModel cuenta)
        {
            _logger.LogInformation("Entrando a creacion con modelo");
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var tipoCuenta = await repositoriosTiposCuentas.ObtenerPorId(cuenta.TipoCuentaId, usuarioId);

            if (tipoCuenta is null)
            {
                _logger.LogInformation("Is null modelo");
                return RedirectToAction("NoEncontrado","Home");
            }
            /*if (!ModelState.IsValid)
            {
                //_logger.LogInformation(cuenta);
                //_logger.LogInformation("\n Modelo: " + cuenta.TiposCuentas.First());
                _logger.LogInformation("Is not valid modelo");
                cuenta.TiposCuentas = await ObtenerTiposCuentas(usuarioId);
                return View(cuenta);
            }*/

            await repositorioCuentas.Crear(cuenta);
            return RedirectToAction("Index");
        }
        public async Task<IActionResult> Editar(int id)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var cuenta = await repositorioCuentas.ObtenerPorId(id, usuarioId);
            if (cuenta is null)
            {
                return RedirectToAction("NoEncontrado", "Home");
            }

            var modelo = mapper.Map<CuentaCreacionViewModel>(cuenta);
            /*var modelo = new CuentaCreacionViewModel()
            {
                Id = cuenta.Id,
                Nombre = cuenta.Nombre,
                TipoCuentaId = cuenta.TipoCuentaId,
                Descripcion = cuenta.Descripcion,
                Balance = cuenta.Balance
            };
            */
            modelo.TiposCuentas = await ObtenerTiposCuentas(usuarioId);

            return View(modelo);

        }

        [HttpPost]
        public async Task<IActionResult> Editar(CuentaCreacionViewModel cuentaEditar)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var cuenta = await repositorioCuentas.ObtenerPorId(cuentaEditar.Id, usuarioId);
            if (cuenta is null)
            {
                return RedirectToAction("NoEncontrado", "Home");
            }
            var tipoCuenta = await repositoriosTiposCuentas.ObtenerPorId(cuentaEditar.TipoCuentaId, usuarioId);

            if(tipoCuenta is null)
            {
                return RedirectToAction("NoEncontrado","Home");
            }

            await repositorioCuentas.Actualizar(cuentaEditar);
            return RedirectToAction("Index");
        }

        [HttpGet]
        public async Task<IActionResult> Borrar(int id)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var cuenta = await repositorioCuentas.ObtenerPorId(id, usuarioId);
            if (cuenta is null)
            {
                return RedirectToAction("NoEncontrado","Home");
            }

            return View(cuenta);
        }
        [HttpPost]
        public async Task<IActionResult> BorrarCuenta(int id)
        {
            var usuarioId = servicioUsuarios.ObtenerUsuarioId();
            var cuenta = await repositorioCuentas.ObtenerPorId(id, usuarioId);
            if (cuenta is null)
            {
                return RedirectToAction("NoEncontrado","Home");
           
            }
            await repositorioCuentas.Borrar(id);
            return RedirectToAction("Index");
        }

        private async Task<IEnumerable<SelectListItem>> ObtenerTiposCuentas(int usuarioId)
        {
            var tiposCuentas = await repositoriosTiposCuentas.Obtener(usuarioId);
            return tiposCuentas.Select(x => new SelectListItem(x.Nombre, x.Id.ToString()));
        }
    }
}
