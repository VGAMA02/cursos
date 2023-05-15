using Microsoft.AspNetCore.Mvc;
using Portafolio.Models;
using Portafolio.Servicios;
using System.Diagnostics;



namespace Portafolio.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly IRepositorioProyectos repositorioProyectos;
        private readonly ServicioTransitorio servicioTransitorio;
        private readonly ServicioUnico servicioUnico;
        private readonly ServicioDelimitado servicioDelimitado;
        private readonly IConfiguration configuration;

        public HomeController(ILogger<HomeController> logger, IRepositorioProyectos repositorioProyectos,
            ServicioTransitorio servicioTransitorio,
            ServicioUnico servicioUnico,
            ServicioDelimitado servicioDelimitado,
            IConfiguration configuration)
        {
            _logger = logger;
            this.repositorioProyectos = repositorioProyectos;
            this.servicioTransitorio = servicioTransitorio;
            this.servicioUnico = servicioUnico;
            this.servicioDelimitado = servicioDelimitado;
            this.configuration = configuration;
        }

        public IActionResult Index()
        {
            var apellido = configuration.GetValue<string>("apellido");
            _logger.LogCritical("Este es un mensaje de log");
            _logger.LogWarning("Este es un mensaje de log");
            _logger.LogInformation("Este es un mensaje de log " + apellido);
            var persona = new Persona()
            {
                Nombre = "Desarrollador de ASP.NET",
                Edad = 22
            };
            

            ViewBag.Nombre = "Gama";

            var proyectos = repositorioProyectos._ObtenerProyectos().Take(3).ToList();

            var guidViewModel = new EjemploViewModel()
            {
                Delimitado = servicioDelimitado.ObtenerGuid,
                Transitorio = servicioTransitorio.ObtenerGuid,
                Unico = servicioUnico.ObtenerGuid
            };
            
            var modelo = new HomeIndexViewModel()
            {
                Proyectos = proyectos,
                EjemploGUID_1 = guidViewModel
            };

            return View(modelo);
        }

        public IActionResult Contacto()
        {

            return View();
        }
        [HttpPost] //Los atributos van antes de las acciones (Funciones) y indican que dicha accion sera cuando se cumple el atributo
        public IActionResult Contacto(ContactoDTO contactoDto)
        {

            return RedirectToAction("Gracias");
        }
        public IActionResult Gracias()
        {

            return View();
        }
        public IActionResult Proyectos()
        {
            var proyectos = repositorioProyectos._ObtenerProyectos();
            return View(proyectos);
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}