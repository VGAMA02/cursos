
import javax.swing.JOptionPane;

public class ArbolesBinarios {

    public static void main(String[] args) {
        int opcion = 0, elemento;
        String nombre;
        Arbol arbol = new Arbol();
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un nodo\n"
                      + "2. Recorrer el arbol inOrden\n"
                                + "3. Recorrer el arbol en preOrden\n"
                                + "4. Recorrer el arbol postOrden\n"
                                + "5. Buscar dato\n"
                                + "6. Eliminar un nodo\n"
                                + "7. Salir\n"
                      + "Elige una opcion\n", "Menu", JOptionPane.QUESTION_MESSAGE));
                
                switch(opcion)
                {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,"Inserta el dato numerico del nodo","agregando Nodo",JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null,"Inserta el nombre del nodo","agregando Nodo",JOptionPane.QUESTION_MESSAGE);
                        arbol.agregarNodo(elemento, nombre);
                        break;
                    
                    case 2:
                        if(!arbol.vacio())
                        {
                              System.out.println("");
                              arbol.inOrden(arbol.raiz);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Cuidado", JOptionPane.INFORMATION_MESSAGE);

                        }
                        break;
                    case 3:
                        if(!arbol.vacio())
                        {
                             System.out.println("");
                              arbol.preOrden(arbol.raiz);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Cuidado", JOptionPane.INFORMATION_MESSAGE);

                        }                       
                        break;
                     case 4:
                         if(!arbol.vacio())
                        {
                              System.out.println("");
                              arbol.postOrden(arbol.raiz);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Cuidado", JOptionPane.INFORMATION_MESSAGE);

                        }   
                         break;
                        
                        case 5:
                            if(!arbol.vacio())
                            {
                                  elemento = Integer.parseInt(JOptionPane.showInputDialog(null,"Inserta el dato numerico a buscar","buscando nodo",JOptionPane.QUESTION_MESSAGE));
                                 
                                  if( arbol.buscarNodo(elemento) == null)
                                  {
                                      JOptionPane.showMessageDialog(null, "No se encontro el nodo", ":c", JOptionPane.INFORMATION_MESSAGE);
                                  }
                                  else
                                  {
                                      JOptionPane.showMessageDialog(null, "El nodo existe, Sus datos son: " + arbol.buscarNodo(elemento), ":D", JOptionPane.INFORMATION_MESSAGE);

                                  }

                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                            }         
                        break;
                        
                        case 6:
                            if(!arbol.vacio())
                            {
                                  elemento = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el nodo a eliminar","buscando nodo",JOptionPane.QUESTION_MESSAGE));
                                  
                                  if( arbol.eliminar(elemento) == false)
                                  {
                                      JOptionPane.showMessageDialog(null, "No se encontro el nodo", ":c", JOptionPane.INFORMATION_MESSAGE);
                                  }
                                  else
                                  {
                                      JOptionPane.showMessageDialog(null, "El nodo ha sido eliminado con exito", ":D", JOptionPane.INFORMATION_MESSAGE);

                                  }

                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                            }   
                        break;
                        
                        case 7:
                        JOptionPane.showMessageDialog(null, "Aplicacion finalizada", "Adios!", JOptionPane.INFORMATION_MESSAGE);
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta", "OH NO", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "OH NO", JOptionPane.INFORMATION_MESSAGE);
            }

        } while (opcion != 7);
    }

}
