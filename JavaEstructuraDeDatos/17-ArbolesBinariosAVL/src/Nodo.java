public class Nodo {
    // fe, factor de equilibrio.
    int dato,fe;
    Nodo izquierdo, derecho;

    public Nodo(int d) {
        this.dato = d;
        this.fe = 0;
        this.izquierdo = null;
        this.derecho = null;
    }
    
}
