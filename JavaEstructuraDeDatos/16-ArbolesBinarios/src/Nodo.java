public class Nodo {
    int dato;
    String nombre;
    Nodo izquierdo,derecho;
    public Nodo(int d, String nom)
    {
        this.dato = d;
        this.nombre = nom;
        this.izquierdo = null;
        this.derecho = null;
    }
    public String toString(){
        return " El nodo se llama: " + nombre + ", su dato numerico es " + dato;
    }
}
