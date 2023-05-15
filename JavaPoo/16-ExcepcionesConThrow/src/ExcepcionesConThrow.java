
import javax.swing.JOptionPane;

public class ExcepcionesConThrow {
    public static void main(String[] args) {
        //excepciones son problemas o errores que pueden ocurri mientras se
        //ejecuta el codigo
        //los tipos errores se pueden ver en la consola en la primera y segunda linea.
        int x,y;
        int vector[] = {1,2,3,4,5};
        boolean errores = false;
        
        try {
            x = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa un numero entero: ", "solicitando datos", 3) );
        
            y = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa otro numero entero: ", "solicitando datos", 3) );
        
            //majenado excepciones mediante throw
            if( y == 0)
            {
                //creando una excepcion de tipo throw
                throw new ArithmeticException("Error en numero 2, ");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"La division de " + x + "/" + y + " es " + (x/y), "Mostrando resultado",1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " No se puede dividir entre 0");
        }
    }
    
}
