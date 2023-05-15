public class Pila {
 private NodoPila cima;
 int tamanio;

    public Pila() {
        cima = null;
        tamanio = 0;
    }
    //Metodo para saber cuando la pila esta vacia
    public boolean vacia()
    {
        return cima == null;
    }
    //Metodo para insertar un elemento en la pila
    public void push(int elemento)
    {
        NodoPila nuevo = new NodoPila(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamanio++;
    }
    //Metodo para sacar un elemento en la pila
    public int pop()
    {
        int auxiliar = cima.dato;
        cima = cima.siguiente;
        tamanio--;
        return auxiliar;
    }
    //Metodo para saber que elemento esta en la cima
    public int cima()
    {
        return cima.dato;
    }
    //Metodo para saber el tamaño de la pila
    public int tamanio()
    {
        return tamanio;
    }
    //Metodo para limpiar la pila
    public void Limpiar()
    {
        while(!vacia())
        {
            pop();
        }
    }
    
    
}
