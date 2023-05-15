
import javax.swing.JOptionPane;

public class Empleado extends Persona{
    long sueldo;
    String telefono, direccion;
    
    public Empleado(String Nombre, int edad, long sueldo, String tel, String direccion)
    {
        //super coloca los parametros de la clase heredada para el constructor
        super(Nombre, edad);
        this.sueldo = sueldo;
        this.telefono = tel;
        this.direccion = direccion;
    }
    //override tiene que estar fuera del metodo
    @Override
    public void verDatos()
    {
        JOptionPane.showMessageDialog(null,"Nombre: " + Nombre + "\nEdad: " + edad +
        "\nSueldo: " + sueldo + "\nTelefono: " + telefono + "\n Direccion: " +
        direccion, "Datos del empleado", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
