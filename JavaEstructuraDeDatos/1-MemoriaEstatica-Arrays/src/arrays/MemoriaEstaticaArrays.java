package arrays;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.io.*;
public class MemoriaEstaticaArrays {
    public static void main(String[] args) {
       int numeros [] = new int [5];
       String palabras []  = new String [5];
       int numerotes [] = new int[numeros.length];
       short i;
       for(i=0;i<5;i++)
       {
           numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(null,""
                   + "Ingresa el elemento del indice: " + i));
       }
       
        System.out.println("Los datos sin ordenar son: ");
        
        for(i=0;i<5;i++)
        {
           System.out.print("[" + numeros[i] + "]"); 
        }
        System.out.println("");
        System.out.println("Los datos ordenados son: ");
        Arrays.sort(numeros);
        for(i=0;i<5;i++)
        {
           System.out.print("[" + numeros[i] + "]"); 
        }
         
         //llenando al arreglo palabras
         Arrays.fill(palabras,"Bienvendido a la fiesta");
         System.out.println("");
         System.out.println("Elementos del arreglo palabras");
        for(i=0;i<5;i++)
        {
           System.out.print("[" + palabras[i] + "]"); 
        }
         //copiando los elementos del arreglo numeros a numerotes
        System.arraycopy(numeros, 0, numerotes, 0, numeros.length);
         Arrays.fill(palabras,"Bienvendido a la fiesta");
         System.out.println("");
         System.out.println("Elementos del arreglo numerotes");
        for(i=0;i<5;i++)
        {
           System.out.print("[" + numerotes[i] + "]"); 
        }
    }//main
  
}//clase base
