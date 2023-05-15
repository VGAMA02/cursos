
import javax.swing.JOptionPane;


//subclase
public class Extrovertido extends Personalidad{
   public int hola;
   public String dialogo;
   @Override
    public void hablar()
    {
        JOptionPane.showMessageDialog(null,"si hola muy bunas tardes guapisimos y guapisimas.");
    }  
}
