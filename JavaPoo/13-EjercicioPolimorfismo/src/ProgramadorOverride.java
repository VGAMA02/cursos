
import javax.swing.JOptionPane;

public class ProgramadorOverride extends InformaticosOverride{
    @Override
    public void sueldo(double pago)
    {
      JOptionPane.showMessageDialog(null,"El pago de un Programador es $" + pago);
    }
    @Override
    public void datos(String nom)
    {
      JOptionPane.showMessageDialog(null,"El nombre del Programador es: " + nom);
    }
    @Override
    public void labores(String lab)
    {
      JOptionPane.showMessageDialog(null,"Las labores del programador son: " + lab);
    }
    
}
