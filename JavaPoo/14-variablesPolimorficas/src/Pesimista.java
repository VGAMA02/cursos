
import javax.swing.JOptionPane;

public class Pesimista extends Personalidad {
    @Override
    public void hablar()
    {
        JOptionPane.showMessageDialog(null,"hoy va a ser un mal dia :c");
    } 
}
