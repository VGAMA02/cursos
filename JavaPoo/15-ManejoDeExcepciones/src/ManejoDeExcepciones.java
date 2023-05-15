
import javax.swing.JOptionPane;

public class ManejoDeExcepciones {

    public static void main(String[] args) {
        //excepciones son problemas o errores que pueden ocurri mientras se
        //ejecuta el codigo
        
        //los tipos errores se pueden ver en la consola en la primera y segunda linea.
        int x,y;
        int vector[] = {1,2,3,4,5};
        boolean errores = false;
        try{
        //Codigo donde puede ocurrir una excepcion o excepcion
        x = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa un numero entero: ", "solicitando datos", 3) );
        
        y = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa otro numero entero: ", "solicitando datos", 3) );
        
        JOptionPane.showMessageDialog(null,"La division de " + x + "/" + y + " es " + (x/y), "Mostrando resultado",1);
        
        for(int i=0;i<5;i++)
        {
            System.out.print("[" + vector[i] + "] ");
        }
        }catch(NumberFormatException e) //capturando el tipo de error en este caso numerico
        {
            errores = true;
            System.out.println(e.getMessage() + " No ingresaste un numero entero"); 
        }catch(ArithmeticException e)
        {
            errores = true;
            System.out.println(e.getMessage() + " No se puede dividir entre 0"); 
        }catch(ArrayIndexOutOfBoundsException e)
        {
            errores = true;
            System.out.println("El vector se salio de los indices");
        }finally //opcional que siempre se ejecuta
        {
            if(errores == false)
            {
                System.out.println("Todo concluyo OK");
            }
            else
            {
                System.out.println("Todo concluyo con errores");
            }
            
            
            System.out.println("esta seccion siempre se ejecuta :3");
        }
    }
    
}
