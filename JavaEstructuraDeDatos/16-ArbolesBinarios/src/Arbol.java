public class Arbol {
    Nodo raiz;
    
    public Arbol()
    {
        this.raiz = null;
    }
    //Metodo para insertar un nodo al arbol
    public void agregarNodo(int d,String nom)
    {
        Nodo nuevo = new Nodo(d,nom);
        if(raiz == null)
        {
            raiz = nuevo;
        }
        else
        {
            Nodo auxiliar = raiz;
            Nodo padre;
            while(true)
            {
                padre = auxiliar;
                if(d < auxiliar.dato)
                {
                    auxiliar = auxiliar.izquierdo;
                    if(auxiliar == null)
                    {
                        padre.izquierdo = nuevo;
                        return; //salir de la funcion;
                    }
                }
                else
                {
                    auxiliar = auxiliar.derecho;
                    if(auxiliar == null)
                    {
                        padre.derecho = nuevo;
                        return; //salir de la funcion;
                    }
                }
            }//while
        }//else vacio
    }//metodo agregar nodo
    
    //metodo para saber si el arbol esta vacio
    public boolean vacio()
    {
        return this.raiz == null;
    }
    //Metodo para recorrer el arbol inOrden
    public void inOrden(Nodo r)
    {
        if(r != null)
        {
            inOrden(r.izquierdo);
             System.out.print(r.dato + ", ");
            inOrden(r.derecho);
        }
        else
        {
            
        }
    }
    //Metodo para reccorrer el arbol en preORDEN
    public void preOrden(Nodo r)
    {
        if(r != null)
        {
            System.out.print(r.dato + ", ");
            preOrden(r.izquierdo);
            preOrden(r.derecho);
        }
        else
        {
            
        }
    }
    //metodo para recorrer el arbol en postOrden
    public void postOrden(Nodo r)
    {
        if(r != null)
        {
            
            postOrden(r.izquierdo); 
            postOrden(r.derecho);
            System.out.print(r.dato + ", ");
        }
        else
        {
            
        }
    }
    //Metodo para buscar en el arbol
    public Nodo buscarNodo(int d){
        Nodo aux = raiz;
        while(aux.dato != d)
        {
            if(d < aux.dato)
            {
                aux = aux.izquierdo;
            }
            else
            {
                aux = aux.derecho;
            }
            if(aux == null)
            {
                return null;
            }
        }//while
      return aux;
    }
    //Metodo para eliminar un nodo del arbol
    public boolean eliminar(int d)
    {
        Nodo aux = raiz;
        Nodo padre = raiz;
        boolean esHijoIzq = true;
        while(aux.dato != d)
        {
            padre = aux;
            if(d <aux.dato) 
            {
                aux = aux.izquierdo;
            }
            else
            {
                esHijoIzq = false;
                aux = aux.derecho;
            }
            if(aux == null)
            {
                return false;
            }
        }//while
        if(aux.izquierdo == null && aux.derecho == null)//cuando el nodo no tiene hijos
        {
            if(aux == raiz){ 
                raiz = null;
            }else if(esHijoIzq){
                padre.izquierdo = null;
            }
            else
            {
                padre.derecho = null;
            }
        }else if(aux.derecho == null)
        {
            if(aux == raiz){ 
                raiz = raiz.izquierdo;
            }else if(esHijoIzq){
                padre.izquierdo = aux.izquierdo;
            }
            else
            {
                padre.derecho = aux.izquierdo;
            }
        }else if(aux.izquierdo == null)
        {
            if(aux == raiz){ 
                raiz = raiz.derecho;
            }else if(esHijoIzq){
                padre.izquierdo = aux.derecho;
            }
            else
            {
                padre.derecho = aux.izquierdo;
            }
        }
        else
        {
            Nodo reemplazo = obtenerReemplazo(aux);
            if(aux == raiz){
                raiz = reemplazo;
            }
            else if(esHijoIzq)
            {
                padre.izquierdo = reemplazo;
            }
            else{
                padre.derecho = reemplazo;
            }
            
            reemplazo.izquierdo = aux.izquierdo;
        }
        return true;
    }//Eliminar
    
    //Metodo encargado de devolvernos el nodo Reemplazado
    public Nodo obtenerReemplazo(Nodo nodoReemp){
        Nodo reemplazarPadre = nodoReemp;
        Nodo reemplazo = nodoReemp;
        Nodo aux = nodoReemp.derecho;
        while(aux != null)
        {
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.izquierdo;
        }
        if(reemplazo != nodoReemp.derecho)
        {
            reemplazarPadre.izquierdo = reemplazo.derecho;
            reemplazo.derecho = nodoReemp.derecho;
        }
        System.out.println("El nodo remplazo es: " + reemplazo);
        return reemplazo;
    }
}//arbol
