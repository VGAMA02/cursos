public class Nodo {
    public int dato;
    Nodo siguiente;
    public Nodo(int d){
        this.dato = d;
        this.siguiente = this;
    }
}
