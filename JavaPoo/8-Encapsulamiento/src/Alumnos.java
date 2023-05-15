public class Alumnos {
    //atributos
    private int  numControl;
    private String email;
    public String nombre, apellidos;
    //creando el constructor que va abajo de los atributos.
    Alumnos(int numControl,String nombre, String apellidos,String email)
    {
      //Inicializando los atributos
      this.numControl = numControl;
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.email = email;
    }
    //metodos
    void verDatos()
    {
        System.out.println("Num. Control: " + numControl);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Email: " + email);
    }
    //creando los metodos get & set
    int getControl()
    {
       return this.numControl; 
    }
    String getEmail()
    {
        return this.email;
    }
    void setControl(int control)
    {
       this.numControl = control; 
    }
    void setEmail(String mail)
    {
        this.email = mail;
    }
    
    
    
}
