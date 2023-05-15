
import javax.swing.JOptionPane;

public class Lista {

    Nodo ultimo;

    public Lista() {
        this.ultimo = null;
    }

    //Metodo para saber cuando la lista esta vacia
    public boolean vacia() {
        return ultimo == null;
    }

    //Metodo para  insertar Nodos
    public Lista InsertarNodo(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (ultimo != null) {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
        } else {
            ultimo = nuevo;
        }
        return this;
    }

    //Mostrar la lista
    public void mostrarLista() {
        Nodo auxiliar = ultimo.siguiente;
        String cadena = "";
        do {
            cadena = cadena + "[" + auxiliar.dato + "] ->";
            auxiliar = auxiliar.siguiente;
        } while (auxiliar != ultimo.siguiente);
        JOptionPane.showMessageDialog(null, cadena, "Mostrando la Lista Cicular", JOptionPane.INFORMATION_MESSAGE);
    }

    //Metodo para eliminar un nodo de la lista
    public boolean eliminar(int elemento) {
        Nodo actual = ultimo;
        boolean encontrado = false;
        while (actual.siguiente != ultimo && !encontrado) {
            encontrado = (actual.siguiente.dato == elemento);
            if (!encontrado) {
                actual = actual.siguiente;
            }
        }
        encontrado = (actual.siguiente.dato == elemento);

        if (encontrado) {
            Nodo auxiliar = actual.siguiente;
            if (ultimo == ultimo.siguiente) {
                ultimo = null;
            } else {
                if (auxiliar == ultimo) {
                    ultimo = actual;
                }
                actual.siguiente = auxiliar.siguiente;
            }
            auxiliar = null;
        }
        return encontrado == true;
    }
}
