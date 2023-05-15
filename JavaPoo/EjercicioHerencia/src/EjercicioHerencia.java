
import javax.swing.JOptionPane;

public class EjercicioHerencia {
    public static void main(String[] args) {
       String nom,tel,dir;
       int ed;
       long suel;
       nom = JOptionPane.showInputDialog(null,"ingrese el nombre del empleado: ","Solicitando Datos: ",3);
       ed = Integer.parseInt( JOptionPane.showInputDialog(null,"infrese la edad del empleado: ","Solicitando Datos: ",3));
       suel = Long.parseLong(JOptionPane.showInputDialog(null,"infrese el sueldo del empleado: ","Solicitando Datos: ",3));
       tel = JOptionPane.showInputDialog(null,"infrese el telefono del empleado: ","Solicitando Datos: ",3);
       dir = JOptionPane.showInputDialog(null,"infrese la direccion del empleado: ","Solicitando Datos: ",3);
       Empleado E1 = new Empleado(nom, ed, suel,tel,dir);
       Empleado E2 = new Empleado("Brayan", 31, 8500,"331423333","las muertas  #900");
       Empleado E3 = new Empleado("Victoria", 24, 5500,"3314253590", "las curiosas #9000");
       
       E1.verDatos();
       E2.verDatos();
       E3.verDatos();
    }
    
}
