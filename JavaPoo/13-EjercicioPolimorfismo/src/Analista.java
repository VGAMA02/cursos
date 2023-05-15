
import javax.swing.JOptionPane;

public class Analista extends Informaticos{
    public void sueldo(int horas, double pagoH, double incen)
    {
        JOptionPane.showMessageDialog(null,"El pago es: " + ( (horas*pagoH) + incen) );
    }
    public void datos(String nom, String ape, String dir)
    {
        JOptionPane.showMessageDialog(null,"Nombre: " + nom + "\nApellidos: " + ape + "\nDir: " + dir);
    }
    public void labores(String lab, int horas)
    {
        JOptionPane.showMessageDialog(null,"Soy analista y me dedico a analizar cosas :3"
                + " tambien  a " + lab + " durante " + horas + " horas");
    }   
}
