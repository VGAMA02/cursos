//subclase
import javax.swing.JOptionPane;
//Una clase abstracta contiene al menos un metodo que no ha sido especificado
//es decir este sera heredado para sobreescribirse. 

//Enfermo es una clase abstracta de por si, esto es herencia multiple pero java
//necesita interfaces para hacerla
public class Empleado extends Persona implements Enfermo{
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
    //cuando se hace una clase abstracta es necesario declarar los metodos abstractos
    @Override
    public void verDatos()
    {
        JOptionPane.showMessageDialog(null,"Nombre: " + Nombre + "\nEdad: " + edad +
        "\nSueldo: " + sueldo + "\nTelefono: " + telefono + "\n Direccion: " +
        direccion, "Datos del empleado", JOptionPane.INFORMATION_MESSAGE);
        
    }
    @Override
    public void tos()
    {
        JOptionPane.showMessageDialog(null, "Hola, estoy enfermo, Cof Cof");
    }
    @Override
    public void diarrea()
    {
        JOptionPane.showMessageDialog(null, "Hola, estoy enfermo, Snif Snif");
    }
}
