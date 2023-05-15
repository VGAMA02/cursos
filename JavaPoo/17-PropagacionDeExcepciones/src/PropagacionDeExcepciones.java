
import javax.swing.JOptionPane;
   
public class PropagacionDeExcepciones {
   static int x,y;
    public static void main(String[] args) {
      try{
          sumar();
          dividir(x,y);
      }catch(ArithmeticException e)
      {
          System.out.println(e.getMessage());
      }catch(NumberFormatException e)
      {
          System.out.println(e.getMessage());
      }
    }
    public static void sumar() throws NumberFormatException
    {
        x = Integer.parseInt( JOptionPane.showInputDialog(null,"ingresa X", "ingresando datos",3) );
        y = Integer.parseInt( JOptionPane.showInputDialog(null,"ingresa Y", "ingresando datos",3) );
        JOptionPane.showMessageDialog(null,"El resultado de " + x + " mas " + y + " es " + (x+y),"mostrando resultados",1);
    }
    public static void dividir(int x, int y) throws ArithmeticException
    {
        if(y==0){
            throw new ArithmeticException(" Error no se puede dividir entre 0");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El resultado de " + x + " / " + y + " es " + (x/y),"mostrando resultados",1);
        }

    }
}
