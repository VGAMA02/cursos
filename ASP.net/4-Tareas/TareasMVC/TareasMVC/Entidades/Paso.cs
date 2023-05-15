namespace TareasMVC.Entidades
{
    public class Paso
    {
        public Guid Id { get; set; } //1651564189409189480
        public int TareaId { get; set; }
        public Tarea Tarea { get; set; } //propiedad de navegacion por que nos ayuda navegas a una entidad relacionada.
        public string Descripcion { get; set; }
        public bool Realizado { get; set; }
        public bool Orden { get; set; }
    }
}
