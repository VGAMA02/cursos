public class Encapsulamiento {
    public static void main(String[] args) {
      Alumnos alu1 = new Alumnos(1,"Pedro","Gao Prieto","alu1@chale.com");
      Alumnos alu2 = new Alumnos(2,"Jose","Gao Prieto","alu2@chale.mx");
      
      alu1.setControl(10);
      alu1.nombre = "Kevin";
      alu1.apellidos = "perrazo";
      alu1.setEmail("asaltos90@oblatos.com");
      alu1.verDatos();
      
    }
    
}
