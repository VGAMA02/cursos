
public class Lista {

    protected Nodo inicio, fin; //punteros para saber donde esta el inicio y el fin

    public Lista() {
        inicio = null;
        fin = null;
    }
    //Metodo para saber si la lista esta vacia

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo para agregar un nodo al inicio de la lista
    public void agregarAlInicio(int elemento) {
        //creando al nodo
        inicio = new Nodo(elemento, inicio);
        if (fin == null) {
            fin = inicio;
        }
    }

    //Metodo para insertar al final de la lista
    public void agregarAlFinal(int elemento) {
        if (!vacia()) {
            fin.siguiente = new Nodo(elemento);
            fin = fin.siguiente;
        } else {
            inicio = fin = new Nodo(elemento);
        }
    }

    //Metodo para eliminar un nodo del inicio
    public int borrarInicio() {
        int elemento = inicio.dato;
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.siguiente;
        }
        return elemento;
    }

    //Metodo para eliminar un nodo al final
    public int borrarFin() {
        int elemento = fin.dato;
        if (inicio == fin) {
            inicio = fin = null;

        } else {
            Nodo temporal = inicio;
            while (temporal.siguiente != fin) {
                temporal = temporal.siguiente;
            }
            fin = temporal;
            fin.siguiente = null;
        }
        return elemento;
    }

    ///Rliminar Nodo especifico
    public boolean borrarEspecifico(int dato) {
        int elemento = dato;
        if (!vacia()) {
            if (inicio == fin && dato == inicio.dato) {
                inicio = fin = null;
                return true;
            } else if (inicio.dato == dato) {
                inicio = inicio.siguiente;
                return true;
            } else {
                Nodo temporal, anterior;
                anterior = inicio;
                temporal = inicio.siguiente;
                while (temporal != null && temporal.dato != dato) {
                    anterior = anterior.siguiente;
                    temporal = temporal.siguiente;

                }
                if (temporal != null) {
                    anterior.siguiente = temporal.siguiente;
                    if (temporal == fin) {
                        fin = anterior;
                        return true;
                    }
                    return true;
                }
                else
                {
                      return false;
                }
            }//else

        }//vacia
        else {
            return false;
        }
      

    }
    //Buscar elemento
   public boolean existe(int dato)
   {
       if(!vacia())
       {
            Nodo temporal = inicio;
            while(temporal != null && temporal.dato != dato)
            {
               temporal = temporal.siguiente;   
            }
            return temporal!=null;
       }
       else
       {
           return false;
       }
      
   }
    //Mostrar datos
    public void mostrarLista() {
        Nodo recorrer = inicio;
        System.out.println("");
        while (recorrer != null) {
            System.out.print("[" + recorrer.dato + "]--->");
            recorrer = recorrer.siguiente;
        }
    }

}
