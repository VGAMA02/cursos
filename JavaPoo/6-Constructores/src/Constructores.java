/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ngama
 */
public class Constructores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //creando objectos
      Alumnos alu1 = new Alumnos(1,"Pedro","Gao Prieto");
      Alumnos alu2 = new Alumnos(2,"Jose","Gao Prieto");
      alu1.verDatos();
      alu2.verDatos();
    }
    
}
