import javax.swing.JOptionPane;
public class AnalistaOverride extends InformaticosOverride{
     @Override 
    public void sueldo(double pago)
    {
      JOptionPane.showMessageDialog(null,"El pago de un Analista es $" + pago);
    }
    @Override
    public void datos(String nom)
    {
      JOptionPane.showMessageDialog(null,"El nombre del Analista es: " + nom);
    }
    @Override
    public void labores(String lab)
    {
      JOptionPane.showMessageDialog(null,"Las labores del analista son: " + lab);
    }
}
