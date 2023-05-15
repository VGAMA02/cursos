public class Cola {
    Nodo inicio, fin;
    int tamanio;
    public Cola()
    {
        this.inicio = fin  = null;
        this.tamanio = 0;
    }
    //Metodo para saber si esta vacia la cola
    public boolean vacia()
    {
        return inicio == null;
    }
    //Metodo para insertar datos
    public void insertar(int elemento)
    {
        Nodo nuevo = new Nodo(elemento);
        if(vacia())
        {
            inicio = nuevo;
        }
        else
        {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamanio++;
    }
    //Metodo para eliminar un elemento
    public int eliminar()
    {
        int aux = inicio.dato;
        inicio = inicio.siguiente;
        tamanio--;
        return aux;     
    }
    //metoro para saber el inicio
    public int inicioCola()
    {
        return inicio.dato;
    }
    //metodo para saber tamaño
    public int tamanioCola()
    {
        return tamanio;
    }
}
