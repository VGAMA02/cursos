public class Nodo {
    public int dato;
    public Nodo siguiente; //Puntero enlace
    public Nodo(int d) //Constructor para insertar al final
    {
        this.dato = d;
    }
    public Nodo(int d, Nodo n) //Constructor para insertar al inicio
    {
        dato = d;
        siguiente = n;
    }
}
