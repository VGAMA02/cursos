
import javax.swing.JOptionPane;

public class ListasDoblementeEnlazadas {

    public static void main(String[] args) {
        Lista list = new Lista();
        int opcion = 0, elemento;
        do{
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,""
                        + "1.Agregar un Nodo al inicio\n"
                        + "2.Agregar un nodo al final\n"
                        + "3.Mostrar la lista de inicio a fin\n"
                        + "4.Mostrar la lista de fin a inicio\n"
                        + "5.Eliminar un nodo del inicio\n"
                        + "6.Eliminar un nodo del final\n"
                        + "7.Eliminar un nodo en especifico\n"
                        + "8.Salir\n"
                        + "Que deceas hacer?","Menu de opciones",JOptionPane.INFORMATION_MESSAGE));
                switch(opcion)
                {
                   case 1:
                       elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                       "Ingresa el elemento","Agregando elemento al inicio",JOptionPane.INFORMATION_MESSAGE) ); 
                       list.agregarAlInicio(elemento);
                   break;  
                   case 2:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                       "Ingresa el elemento","Agregando elemento al final",JOptionPane.INFORMATION_MESSAGE) ); 
                       list.agregarAlFin(elemento);
                   break; 
                   case 3:
                       if(!list.vacia())
                       {
                           list.mostrarListaIF();
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null,"No hay nodos pibe","chale",JOptionPane.INFORMATION_MESSAGE);
                       }
                   break; 
                   case 4:
                       if(!list.vacia())
                       {
                           list.mostrarListaFI();
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null,"No hay nodos pibe","chale",JOptionPane.INFORMATION_MESSAGE);
                       }
                   break; 
                   
                   case 5:
                       if(!list.vacia())
                       {
                          elemento = list.eliminarInicio();
                          JOptionPane.showMessageDialog(null,"El elemento eliminado es: " + elemento,"Elemento eliminado",JOptionPane.INFORMATION_MESSAGE);
                       }
                       else
                       {
                            JOptionPane.showMessageDialog(null,"No hay nodos pibe","chale",JOptionPane.INFORMATION_MESSAGE);
                       }
     
                   break;
                   
                    case 6:
                        if(!list.vacia())
                       {
                          elemento = list.eliminarFinal();
                          JOptionPane.showMessageDialog(null,"El elemento eliminado es: " + elemento,"Elemento eliminado",JOptionPane.INFORMATION_MESSAGE);
                       }
                       else
                       {
                            JOptionPane.showMessageDialog(null,"No hay nodos pibe","chale",JOptionPane.INFORMATION_MESSAGE);
                       }
                   break;
                   
                   case 7:
                       elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                       "Ingresa el elemento","Eliminando elemento",JOptionPane.INFORMATION_MESSAGE) ); 
                       boolean resultado = list.buscarEliminar(elemento);
                       if(!resultado)
                       {
                           JOptionPane.showMessageDialog(null,"No se encontro el elemento","No hay no existe",JOptionPane.INFORMATION_MESSAGE);
                       }
                   break;
                   
                    case 8:
                       JOptionPane.showMessageDialog(null,"ADIOS :D","finalizacion",JOptionPane.INFORMATION_MESSAGE);
                   break;
                   
                   default:
                        JOptionPane.showMessageDialog(null,"ERROR OPCION FUERA DE MENU!","finalizacion",JOptionPane.INFORMATION_MESSAGE);
                }
               
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Error " + e.getMessage());
            }
        }while(opcion != 8 );
    }
    
}
