public class Set_y_Get {

    public static void main(String[] args) {
      //creando objectos
      Alumnos alu1 = new Alumnos(1,"Pedro","Gao Prieto");
      Alumnos alu2 = new Alumnos(2,"Jose","Gao Prieto");
      alu1.verDatos();
      alu2.verDatos();
      //llamando a los metodos get
      System.out.println("Obteniendo el nombre del alumno 2:" + alu2.getNombre());
      //asignandole un nuevo nombre a alumno 2
      alu2.setNombre("Kokun");
      System.out.println("Obteniendo el nuevo nombre del alumno 2:" + alu2.getNombre());
    }
    
}
