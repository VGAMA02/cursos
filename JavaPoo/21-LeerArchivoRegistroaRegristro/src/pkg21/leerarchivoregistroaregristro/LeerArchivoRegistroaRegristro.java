package pkg21.leerarchivoregistroaregristro;
import java.io.*;
import javax.swing.JOptionPane;
public class LeerArchivoRegistroaRegristro {
    public static void main(String[] args) {
      /*
        algoritmo para escribir en un archivo desde java
        1.- crear una varaible de tipo File
        2.- crear una variable de tipo FileReader
        3.- declarar una variable de tipo String
        4.- preparar al archivo
        5.- crear una instancia de tipo FileReader(lector);
        6.- crear una instnacia de tipo BufferReader
        7.- Iniciarlizar una variable de tipo cadena a nada
        8.- crear un ciclo que se repita mientras la variable de tipo cadena sea diferente de nula.
            8.1.- Asignar una variable de tipo cadena buffer.readLine()
            8.2.- Si la varaible de tipo cadena es diferente de nulo mostrar su contenido
        9.- cerrar buffer.
        10.- cerrar el lector
        */
        File archivo;
        FileReader leer;
        BufferedReader almacenamiento;
        String cadena, nombre = "", dir = "",email="";
        int registros = 1;
        archivo = new File("../20-escribirArchivoConservandoDatos/usuario.txt");
        try {
           leer = new FileReader(archivo);
           almacenamiento = new BufferedReader(leer);
           cadena = "";
           while(cadena != null)
           {
               //try de leer datos
               try {
                    cadena = almacenamiento.readLine();
                    nombre = cadena;
                    cadena = almacenamiento.readLine();
                    dir = cadena;
                    cadena = almacenamiento.readLine();
                    email = cadena;
                    
                    if(cadena != null)
                    {
                        JOptionPane.showMessageDialog(null,"Nombre: " + nombre + "\nDireccion: " + dir + "\nEmail: " + email, "Mostrando datos del registro #" + registros,1);
                        registros++;
                    }
               } catch (Exception e) {
               }//catch 
           }//while
            //cerrar
            try {
                almacenamiento.close();
                leer.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
       
    }
    
}
