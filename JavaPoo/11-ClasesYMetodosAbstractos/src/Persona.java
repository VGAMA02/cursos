///Super clase
//hacinedo la clase abstracta para evitar que se instanciada
public abstract class Persona {
    String Nombre;
    int edad;
    
    public Persona(String nombre, int edad)
    {
        this.edad = edad;
        this.Nombre = nombre;
    }
    //metodo abstracto que sirve para ser subescrito.
    abstract public void verDatos();
    
}
