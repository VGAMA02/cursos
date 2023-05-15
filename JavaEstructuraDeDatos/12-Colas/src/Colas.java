
import javax.swing.JOptionPane;

public class Colas {
    public static void main(String[] args) {
        int opcion=0, elemento=0;
        Cola cola = new Cola();
        do {            
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Insertar un elemento en la cola\n"
                                + "2.Quitar un elemento de la cola\n"
                                + "3.Verificar si la cola esta vacia\n"
                                + "4.Elemento ubicado al inicio de la cola\n"
                                + "5.Tamaño de la cola\n"
                                + "6. Salir","Menu",3));
                
                
                switch(opcion)
                {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrea el elemento a insertar","insertando en la cola",JOptionPane.QUESTION_MESSAGE));
                        cola.insertar(elemento);
                        break;
                    case 2:
                        if(!cola.vacia())
                        {
                           JOptionPane.showMessageDialog(null,"El elemento atendido fue: " + cola.eliminar(),"atendiendo :D",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"La cola esta vacia","no hay no existe",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        break;
                    case 3:
                        if(!cola.vacia())
                        {
                            JOptionPane.showMessageDialog(null,"La cola NO esta vacia","si hay si existe",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"La cola esta vacia","no hay no existe",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        
                        break;
                     case 4:
                        if(!cola.vacia())
                        {
                            JOptionPane.showMessageDialog(null,"El elemento al inicio es: " + cola.inicioCola(),"ya casi le atienden",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"La cola esta vacia","no hay no existe",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        
                        break;
                     case 5:
                        if(!cola.vacia())
                        {
                            JOptionPane.showMessageDialog(null,"El tamaño de la cola es: " + cola.tamanioCola(),"its...",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"La cola esta vacia","no hay no existe",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        
                        break;
                        case 6:

                            JOptionPane.showMessageDialog(null,"ADIOS!",":D",JOptionPane.INFORMATION_MESSAGE);  
                        break;
                        
                        default:
                            JOptionPane.showMessageDialog(null,"Opcion incorrecta pibe","D:",JOptionPane.INFORMATION_MESSAGE);    
                    
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Error" + e.getMessage(),"error",JOptionPane.INFORMATION_MESSAGE);
            }
        } while (opcion != 6);
    }
    
}
