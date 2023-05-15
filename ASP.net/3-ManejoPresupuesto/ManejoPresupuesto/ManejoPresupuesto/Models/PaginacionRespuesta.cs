namespace ManejoPresupuesto.Models
{
    public class PaginacionRespuesta
    {
        public int Pagina { get; set; } = 1;
        public int RecordsPorPaginia { get; set; } = 10;
        public int CantidadTotalRecords { get; set; }
        public int CantidadTotalDePaginas => (int)Math.Ceiling((double)CantidadTotalRecords / RecordsPorPaginia );
        public string BaseUrl { get; set; }
    }

    public class PaginacionRespuesta<T>: PaginacionRespuesta
    {
        public IEnumerable<T> Elementos { get; set; }
    }
}
