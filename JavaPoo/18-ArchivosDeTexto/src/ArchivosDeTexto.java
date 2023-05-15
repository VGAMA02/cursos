//import necesario
// java.io.*; //invoca a todo lo de io
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivosDeTexto {

    public static void main(String[] args) {
      /*algoritmo para escribir en un archivo desde java
        1.- crear una varaible de tipo file
        2.- crear una variable de tipo printWriter
        3.- preparar al archivo
        4.- verificar si el archivo no existe
            4.1- crear el arcivo
        4.2- En otro caso Else
            4.2.1 Preparar el archivo para escribir
            4.2.2 Escribir en el archivo
            4.2.3 Ceerar el archivo
      */
      //paso 1
      File archivoso;
      //paso 2
      PrintWriter escritoso; 
      //paso 3, preparando archivo
      archivoso = new File("archivoso.txt"); //como parametro es el nombre, tambien va la ruta como tal
      //paso 4
      if(!archivoso.exists())
      {
          try {
              //4.1 crear el archivo
              archivoso.createNewFile();
              System.out.println("archivo creado OK");
          } catch (IOException ex) {
              Logger.getLogger(ArchivosDeTexto.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      else
      {
         try {
              //4.2.1 preparar el archivo para escribir
              System.out.println("archivo ya existe");
              escritoso = new PrintWriter(archivoso,"utf-8");
              escritoso.println("si hola muy buenas tardes");
              escritoso.close();
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(ArchivosDeTexto.class.getName()).log(Level.SEVERE, null, ex);
          } catch (UnsupportedEncodingException ex) {
              Logger.getLogger(ArchivosDeTexto.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
      
    }
    
}
