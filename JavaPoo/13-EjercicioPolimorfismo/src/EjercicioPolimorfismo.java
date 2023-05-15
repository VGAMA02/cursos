
import javax.swing.JOptionPane;

public class EjercicioPolimorfismo {

    public static void main(String[] args) {
       //Overload
       JOptionPane.showMessageDialog(null,"Overload");
       Programador p1 = new Programador();
       Analista a1 = new Analista();
       AdministradorBD adm1 = new AdministradorBD();
       
       p1.datos("juan", "escopeta");
       p1.sueldo(24,120);
       p1.labores("escribir");
       
       a1.datos("Alfonso", "Lopez", "la brigada");
       a1.sueldo(24,120,1200);
       a1.labores("Analizar datos",8);
       
       adm1.datos("Pepe");
       adm1.sueldo(15000);
       adm1.labores("existir");
       JOptionPane.showMessageDialog(null,"Overide");
       ProgramadorOverride po1 = new ProgramadorOverride();
       AnalistaOverride ao1 = new AnalistaOverride();
       AdministradorBDOverride admo1 = new AdministradorBDOverride();
       
       po1.datos("jose");
       po1.sueldo(7500.50);
       po1.labores("programar");
       
       ao1.datos("Alex");
       ao1.sueldo(7200.50);
       ao1.labores("analizar esta");
       
       admo1.datos("Kevin");
       admo1.sueldo(6000);
       admo1.labores("ver bases");
    }
    
}
