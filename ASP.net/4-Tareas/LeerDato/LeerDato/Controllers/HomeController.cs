using LeerDato.Models;
using Microsoft.AspNetCore.Mvc;
using SpreadsheetLight;
using System.Data.SqlTypes;
using System.Diagnostics;
using System.Security.Cryptography.X509Certificates;

namespace LeerDato.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            string path = @"C:\\Users\ngama\Desktop\Por hacer.xlsx";
            int iRow = 2;
            
            DatoViewModel Lista = new DatoViewModel();

            string data = "";
            List<string> accion = new List<string>();



            SLDocument s1 = new SLDocument(path);
            _logger.LogCritical("Entrando a while");
            while (!string.IsNullOrEmpty(s1.GetCellValueAsString(iRow, 1)))
            {
 
                data = s1.GetCellValueAsString(iRow, 1);
                _logger.LogCritical(iRow + " : " + data);
                accion.Add(data);

                Dato dat = new Dato();
                dat.datoRow = s1.GetCellValueAsString(iRow, 1);
                Lista.LDato.Add(dat);
                iRow++;
            }


            foreach (var info in accion)
            {
                _logger.LogCritical(info);
            }
            
            return View(Lista);
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