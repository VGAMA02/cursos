
import javax.swing.JOptionPane;


public class ListasSimplementeEnlazadasCI {

    public static void main(String[] args) {
        Lista list = new Lista();
        int opcion = 0,dato = 0;
        do
        {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"1. Agregar un elemento al inicio de la lista \n"
                        + "2.Agregar un elemento al final de la lista\n"
                        + "3.Mostrar los datos de la lista\n"
                        + "4.Eliminar elemento del inicio de la lista\n"
                        + "5.Eliminar elemento al final de la lista\n"
                        + "6.Eliminar un elemento en especifico\n"
                        + "7.Verificar existencia de un elemento\n"
                        + "8.Salir.","Menu de opciones",3));
                
                switch(opcion)
                {
                    case 1:
                        //Insertando al inicio
                        try {
                            dato = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el elemento: ","Insertando al inicio",3));
                            //agregando al nodo
                            list.agregarAlInicio(dato);
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null,"error" + n.getMessage());
                        }
                    break;
                    
                    case 2:
                        //Insertando al final
                         try {
                            dato = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el elemento: ","Insertando al inicio",3));
                            //agregando al nodo
                            list.agregarAlFinal(dato);
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null,"error" + n.getMessage());
                        }
                    break;
                    
                    case 3:
                        list.mostrarLista();
                    break;
                    
                    case 4:
                        dato = list.borrarInicio();
                        JOptionPane.showMessageDialog(null,"El elemento eliminado es: " + dato,"eliminando nodos del inicio",JOptionPane.INFORMATION_MESSAGE);
                    break;
                    
                     case 5:
                        dato = list.borrarFin();
                        JOptionPane.showMessageDialog(null,"El elemento eliminado es: " + dato,"eliminando nodos del inicio",JOptionPane.INFORMATION_MESSAGE);
                     break;
                     
                     case 6:
                     {
                     dato = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el elemento a eliminar: ","Eliminando especifico",3));
                     boolean respuesta = list.borrarEspecifico(dato);
                        if(respuesta)
                        {
                             JOptionPane.showMessageDialog(null,"El elemento ha sido eliminado","eliminando nodos",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                             JOptionPane.showMessageDialog(null,"No se encontro al elemento","eliminando nodos",JOptionPane.INFORMATION_MESSAGE);
                        }
                     
                     }
                     break;
                     
                     case 7:
                        dato = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el elemento a verificar: ","buscado datos",3));
                         boolean respuesta = list.existe(dato);
                        if(respuesta)
                        {
                             JOptionPane.showMessageDialog(null,"El elemento existe","buscando nodos",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                             JOptionPane.showMessageDialog(null,"El elemento no existe","buscando nodos",JOptionPane.INFORMATION_MESSAGE);
                        }
                     break;
                     
                     case 8:
                        list.mostrarLista();
                     break;
                    
                    
                    
                    default:
                        JOptionPane.showMessageDialog(null,"Opcion incorrecta");
                }
            } catch (Exception e) {
            }
        }while(opcion != 8);
    }
    
}
