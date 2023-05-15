package pkg19.leerarchivodetexto;
import java.io.*;
import javax.swing.JOptionPane;
public class LeerArchivoDeTexto {

    public static void main(String[] args) {
      /*algoritmo para escribir en un archivo desde java
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
      //paso 1
      File archivoso;
      //Paso 2
      FileReader lectoroso; 
      //paso 3
      String cadenosa;
      //Paso 4
      archivoso = new File("archivoso.txt");
      //paso 5
      String KDNCH="";
        try {
            lectoroso = new FileReader(archivoso);
            //paso 6
            BufferedReader buferoso = new BufferedReader(lectoroso);
            //paso 7
            cadenosa = "";
            //paso 8
            while(cadenosa != null)
            {
                //try de leer
                try {
                 //paso 8.1
                 cadenosa = buferoso.readLine(); //almacenar una linea de texto
                 //Paso 8.2
                 if(cadenosa != null)
                 {
                     System.out.println(cadenosa);
                     KDNCH = KDNCH + cadenosa + "\n";
                 }   
                
                } catch (Exception e) {
                }
             
            }
             JOptionPane.showMessageDialog(null,KDNCH);
            //try de cerrar
            try {
                 buferoso.close();
                lectoroso.close();
            } catch (Exception e) {
            }
           
        } catch (Exception e) {
        }
     
      
    }
    
}
