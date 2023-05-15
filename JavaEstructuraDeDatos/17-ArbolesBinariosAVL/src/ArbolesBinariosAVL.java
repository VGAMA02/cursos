
public class ArbolesBinariosAVL {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(13);
        arbol.insertar(1);
        arbol.insertar(6);
        arbol.insertar(17);
         arbol.insertar(16);
        
        
        arbol.preOrden(arbol.obtenerRaiz());
        
    }
    
}
