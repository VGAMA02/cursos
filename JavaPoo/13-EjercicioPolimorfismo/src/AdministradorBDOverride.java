import javax.swing.JOptionPane;
public class AdministradorBDOverride extends InformaticosOverride{
      @Override 
    public void sueldo(double pago)
    {
      JOptionPane.showMessageDialog(null,"El pago de un AdmisnitradorBD es $" + pago);
    }
    @Override
    public void datos(String nom)
    {
      JOptionPane.showMessageDialog(null,"El nombre del AdminsitradorBD es: " + nom);
    }
    @Override
    public void labores(String lab)
    {
      JOptionPane.showMessageDialog(null,"Las labores del AdministradorBD son: " + lab);
    }
}
