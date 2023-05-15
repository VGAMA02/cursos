import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EscribirArchivoConservandoDatos {

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
            4.2.3 Cerrar el archivo
         */
        String nombre = "", dir = "", email = "";
        //paso 1
        File archivoso;
        //paso 2
        FileWriter escritoso;
        PrintWriter linea;
        //paso 3, preparando archivo
        archivoso = new File("usuario.txt"); //como parametro es el nombre, tambien va la ruta como tal

        if (!archivoso.exists()) {
            // =>try de creacion de archivo
            try {
                archivoso.createNewFile();
                nombre = JOptionPane.showInputDialog(null, "Ingresa el Nombre", "Solicitando datos", 3);
                dir = JOptionPane.showInputDialog(null, "Ingresa la direccion", "Solicitando datos", 3);
                email = JOptionPane.showInputDialog(null, "Ingresa el email", "Solicitando datos", 3);

                escritoso = new FileWriter(archivoso, true); //si ya existe escribe al final del archivo, en una sola linea
                linea = new PrintWriter(escritoso); //escribir en varias lineas de texto
                linea.println(nombre);
                linea.println(dir);
                linea.println(email);

                linea.close();
                escritoso.close();
            } catch (IOException ex) {
                Logger.getLogger(EscribirArchivoConservandoDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            // <= try de creacion de archivo
        } else {
            // =>try de creacion de archivo
            try {

                nombre = JOptionPane.showInputDialog(null, "Ingresa el Nombre", "Solicitando datos", 3);
                dir = JOptionPane.showInputDialog(null, "Ingresa la direccion", "Solicitando datos", 3);
                email = JOptionPane.showInputDialog(null, "Ingresa el email", "Solicitando datos", 3);

                escritoso = new FileWriter(archivoso, true); //si ya existe escribe al final del archivo, en una sola linea
                linea = new PrintWriter(escritoso); //escribir en varias lineas de texto
                linea.println(nombre);
                linea.println(dir);
                linea.println(email);

                linea.close();
                escritoso.close();
            } catch (IOException ex) {
                Logger.getLogger(EscribirArchivoConservandoDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            // <= try de creacion de archivo
        }

    }

}
