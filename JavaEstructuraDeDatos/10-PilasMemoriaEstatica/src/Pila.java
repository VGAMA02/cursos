class Pila {
    int vectorPila[];
    int cima;
    //Constructor
    public Pila(int tamanio){
        vectorPila = new int[tamanio];
        cima = -1;
    }
    //Metodo push
    public void push(int dato)
    {
        cima++;
        vectorPila[cima] = dato;
    }
    //Metodo pop
    public int pop()
    {
        int re = vectorPila[cima];
        cima--;
        return re;
    }
    //metodo para saber si esta llena la pila
    public boolean llena()
    {
        return (cima == (vectorPila.length-1) );
    }
    //metodo para saber si esta llena la pila
    public boolean vacia()
    {
        return (cima == -1);
    }
    //metodo para saber que elemento se encuentra en la cima
    public int cimaPila()
    {
        return vectorPila[cima];
    }
    //Metodo para saber el tamaño de la pila
    public int tamanioPila()
    {
        return vectorPila.length;
    }
    
}
