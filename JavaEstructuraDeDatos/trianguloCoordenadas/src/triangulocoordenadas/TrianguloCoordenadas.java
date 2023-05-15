/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulocoordenadas;

import java.io.Console;
import static java.lang.Math.abs;
import javax.swing.JOptionPane;

/**
 *
 * @author ngama
 */
public class TrianguloCoordenadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // area = (1/2) * abs(x1*(y2-y3)+x2 * (y3-y1)+x3 * (y1-y2));
       
       double x1 = 0;
       double x2 = 0;
       double x3 = 0;
       double y1 = 0;
       double y2 = 0;
       double y3 = 0;
       
       String valor = "";
       double area = 0;
       
       System.out.print("Dame x1");
       x1 = Double.parseDouble(JOptionPane.showInputDialog(null,"x1: ",0));
       System.out.print("Dame x2");
       x2 =Double.parseDouble(JOptionPane.showInputDialog(null,"x2: ",0));
       System.out.print("Dame x3");
       x3 = Double.parseDouble(JOptionPane.showInputDialog(null,"x3: ",0));
       System.out.print("Dame y1");
       y1 = Double.parseDouble(JOptionPane.showInputDialog(null,"y1: ",0));
       System.out.print("Dame y2");
       y2 = Double.parseDouble(JOptionPane.showInputDialog(null,"y2: ",0));
       System.out.print("Dame y3");
       y3 = Double.parseDouble(JOptionPane.showInputDialog(null,"y3: ",0));
        System.out.println();
       area = (1.0/2.0) * abs(x1 * (y2 - y3) + x2 * (y3-y1) + x3 * (y1-y2));
       
       System.out.print("El area es: " + area);
       System.out.println();
    }
    
}
