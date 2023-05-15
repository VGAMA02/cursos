
import javax.swing.JOptionPane;

public class Lista {
 private Nodo inicio,fin;
    //Constructor por defecto
    public Lista()
    {
        inicio = fin = null;
    }
    //Metodo para saber si la lista esta vacia
    public boolean vacia()
    {
        return inicio == null;
    }
    //Metodo para agregar nodos al final
    public void agregarAlFin(int dato)
    {
        if(!vacia())
        {
            fin = new Nodo(dato,null,fin);
            //         []↓
            // *-> *-> #fin->
            // |<-*->|<- *->| <-#-> <-[]fin->
            fin.anterior.siguiente = fin;
        }
        else
        {
            inicio = fin = new Nodo(dato);
        }
    }
     //Metodo para agregar nodos al Inicio
    public void agregarAlInicio(int dato)
    {
        if(!vacia())
        {
            inicio = new Nodo(dato,inicio,null);
            inicio.siguiente.anterior = inicio;
        }
        else
        {
            inicio = fin = new Nodo(dato);
        }
    }
    //Metodo para mostrar la lista de inicio a Fin
    public void mostrarListaIF()
    {
        if(!vacia())
        {
            String datos = " <=> "; 
            Nodo auxiliar = inicio;
            while(auxiliar != null)
            {
                datos = datos + "[" + auxiliar.dato+"] <=> ";
                auxiliar = auxiliar.siguiente; 
           }
            JOptionPane.showMessageDialog(null,datos,
            "Mostrando Lista de inicio a fin",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //Metodo para mostrar la lista desde fin a inicio
    public void mostrarListaFI()
    {
        if(!vacia())
        {
            String datos = "<=>"; 
            Nodo auxiliar = fin;
            while(auxiliar != null)
            {
                datos = datos + "[" + auxiliar.dato+"] <=> ";
                auxiliar = auxiliar.anterior; 
           }
            JOptionPane.showMessageDialog(null,datos,
            "Mostrando Lista de inicio a fin",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //Metodo para eliminar desde el inicio
    public int eliminarInicio()
    {
        int elemento = inicio.dato;
        if(inicio == fin)
        {
            inicio = fin = null;
        }
        else
        {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        return elemento;
    }
    
    //Metodo para eliminar al final
    public int eliminarFinal()
    {
        int elemento = fin.dato;
        if(inicio == fin)
        {
            inicio = fin = null;
        }
        else
        {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return elemento;
    }
    //Eliminar el que gustes
    public boolean buscarEliminar(int elemento)
    {
        if(!vacia())
        {
            Nodo auxiliar = inicio;
            
            if(inicio == fin && inicio.dato == elemento)
            {
                inicio = fin = null;
                return true;
            }
            else 
            {
                while(auxiliar != null)
                {
                    if(auxiliar.dato == elemento)
                    {
                        if(auxiliar == inicio)
                        {
                            inicio = inicio.siguiente;
                            inicio.anterior = null;
                             return true;
                        }
                        else if(auxiliar == fin)
                        {
                            fin = fin.anterior;
                            fin.siguiente = null;
                            return true;
                        }
                        else
                        {
                            auxiliar.anterior.siguiente = auxiliar.siguiente;
                            auxiliar.siguiente.anterior = auxiliar.anterior;
                            return true;
                        }
                       
                    }
                    else
                    {
                        auxiliar = auxiliar.siguiente;
                    }
                }//while
            }
        }//if
       
        return false;
    }
    
    
}
