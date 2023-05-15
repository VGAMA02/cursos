public class Nodo {
    public int dato;
    Nodo siguiente,anterior;
    //Constructor para cuando ya hay nodos
    public Nodo(int elemento,Nodo s, Nodo a)
    {
        this.dato = elemento;
        this.siguiente = s;
        this.anterior = a;
    }
    //Para cuando no hay nodos
    public Nodo(int elemento)
    {
        this(elemento,null,null);
    }
}
