import javax.swing.JOptionPane;
public class AdministradorBD {
  public void sueldo(double pago)
    {
        JOptionPane.showMessageDialog(null,"El pago es: " + pago);
    }
    public void datos(String nom)
    {
        JOptionPane.showMessageDialog(null,"Nombre: " + nom);
    }
    public void labores(String lab)
    {
        JOptionPane.showMessageDialog(null,"Soy Administrador y me dedico a adminsitrar el changarro y a " + lab);
    }  
}
