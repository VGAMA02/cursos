using Portafolio.Models;

namespace Portafolio.Servicios
{

    public interface IRepositorioProyectos
    {
        List<ProyectoDTO> _ObtenerProyectos();
    }

    public class RepositorioProyectos : IRepositorioProyectos
    {
       
        public List<ProyectoDTO> _ObtenerProyectos()
        {
            return new List<ProyectoDTO>()
            {
                new ProyectoDTO
                {
                    Titulo = "Unicorn",
                    Descripcion = "Aplicacion IONIC-Angular de manejo de finanzas",
                    Link="https://twitter.com/home",
                    imagenURL = "/imagenes/unicorn.png"
                },
                new ProyectoDTO
                {
                    Titulo = "Forshop",
                    Descripcion = "Pagina web para la venta de articulos forros",
                    Link="https://www.twitch.tv/vgama02e",
                    imagenURL = "/imagenes/frshop.png"
                },
                 new ProyectoDTO
                {
                    Titulo = "Astromoon",
                    Descripcion = "Videojuego realizado en GameMaker",
                    Link="https://www.youtube.com/@VGAMA02/videose",
                    imagenURL = "/imagenes/Astro.gif"
                },
                  new ProyectoDTO
                {
                    Titulo = "FireXX",
                    Descripcion = "Videojuego realizado en GameMaker",
                    Link="https://www.youtube.com/@VGAMA02/videose",
                    imagenURL = "/imagenes/Astro.gif"
                },
                   new ProyectoDTO
                {
                    Titulo = "RocketsFly",
                    Descripcion = "Videojuego realizado en GameMaker",
                    Link="https://www.youtube.com/@VGAMA02/videose",
                    imagenURL = "/imagenes/Astro.gif"
                },

            };
        }
    }
}
