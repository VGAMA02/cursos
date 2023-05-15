import java.util.ArrayList;
import javax.swing.JOptionPane;
public class MemoriaDinamicaArrayList {

    public static void main(String[] args) {
       //Creando un objecto de tipo ArrayList
       ArrayList <String> cadenas = new  ArrayList <String>();
       String frase, respuesta;
       
       do
       {
          frase = JOptionPane.showInputDialog(null,"introduce la frase");
          //agregando la frase a la lista
          cadenas.add(frase);
          respuesta = JOptionPane.showInputDialog(null,"deceas ingresar otra Frase (SI/NO)?");
          respuesta = respuesta.toUpperCase();
       }while(!respuesta.equals("NO") );
       System.out.println("Frases Originales");
       //Mostrando el contenido de las cadenas
       for(int i=0; i<cadenas.size();i++)
       {
           System.out.println("frase #" + i + "'" + cadenas.get(i) + "'"  );
       }
       //utilizando el metodo set
       cadenas.set(1, "la que modifique");
       System.out.println("Frases modificadas");
       for(int i=0; i<cadenas.size();i++)
       {
           System.out.println("frase #" + i + "'" + cadenas.get(i) + "'"  );
       }
       //borrando el indice 0
       cadenas.remove(0);
       //fraces menos la 0
       for(int i=0; i<cadenas.size();i++)
       {
           System.out.println("frase #" + i + "'" + cadenas.get(i) + "'"  );
       }
    }
    
}
