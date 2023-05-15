public class Alumnos {
    //atributos
    int numControl;
    String nombre, apellidos;
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
}
