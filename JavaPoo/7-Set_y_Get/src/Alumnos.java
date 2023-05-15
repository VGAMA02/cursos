public class Alumnos {
    //atributos
    private int  numControl;
    private String nombre, apellidos;
    //creando el constructor que va abajo de los atributos.
    Alumnos(int numControl,String nombre, String apellidos)
    {
      //Inicializando los atributos
      this.numControl = numControl;
      this.nombre = nombre;
      this.apellidos = apellidos;
    }
    //metodos
    void verDatos()
    {
        System.out.println("Num. Control: " + numControl);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
    }
    //creando los metodos get & set
    int getControl()
    {
       return this.numControl; 
    }
    String getNombre()
    {
        return this.nombre;
    }
    String getApellidos()
    {
        return this.apellidos;
    }
    void setControl(int control)
    {
       this.numControl = control; 
    }
    void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }
    
    
    
    
}
