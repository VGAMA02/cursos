
import javax.swing.JOptionPane;

//Subclase
public class Optimista extends Personalidad {
    @Override
    public void hablar()
    {
        JOptionPane.showMessageDialog(null,"hoy va a ser un buen dia :3");
    }
}
