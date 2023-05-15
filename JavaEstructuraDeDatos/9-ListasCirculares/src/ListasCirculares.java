
import javax.swing.JOptionPane;

public class ListasCirculares {

    public static void main(String[] args) {
        Lista list = new Lista();
        int opcion = 0, elemento;
        boolean eliminado = false;
        do{
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,""
                        + "1.Agregar un Nodo\n"
                        + "2.Elimina un nodo\n"
                        + "3.Mostrar los datos\n"
                        + "4.Salir\n"
                        + "Que deceas hacer?","Menu de opciones",JOptionPane.INFORMATION_MESSAGE));
                switch(opcion)
                {
                   case 1:
                       elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                       "Ingresa el elemento","Agregando elemento a la lista",JOptionPane.INFORMATION_MESSAGE) ); 
                       list.InsertarNodo(elemento);
                   break;  
                   case 2:
                       if(!list.vacia())
                       {
                           elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingresa el elemento a eliminar","Eliminando elemento de la lista",JOptionPane.INFORMATION_MESSAGE) ); 
                            eliminado = list.eliminar(elemento);
                            if(eliminado)
                            {
                                 JOptionPane.showMessageDialog(null,"Nodo eliminado","Dominacion total del mundo!",JOptionPane.INFORMATION_MESSAGE);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Nodo no encontrado","No hay dominacion total del mundo :c",JOptionPane.INFORMATION_MESSAGE);
                            } 
                       }
                       else
                       {
                            JOptionPane.showMessageDialog(null,"No hay nodos pibe","Lista vacia",JOptionPane.INFORMATION_MESSAGE);
                       }
                      
                       
                   break; 
                   case 3:
                      if(!list.vacia())
                      {
                          list.mostrarLista();
                      }
                      else
                      {
                            JOptionPane.showMessageDialog(null,"No hay nodos pibe","Lista vacia",JOptionPane.INFORMATION_MESSAGE);
                      }
                   break; 
                   case 4:
                       JOptionPane.showMessageDialog(null,"Aplicacion Finalizada","Saliendo",JOptionPane.INFORMATION_MESSAGE);
                   break; 
               
                   default:
                        JOptionPane.showMessageDialog(null,"ERROR OPCION FUERA DE MENU!","finalizacion",JOptionPane.INFORMATION_MESSAGE);
                }
               
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Error " + e.getMessage());
            }
        }while(opcion != 4 );
    }
    
}
