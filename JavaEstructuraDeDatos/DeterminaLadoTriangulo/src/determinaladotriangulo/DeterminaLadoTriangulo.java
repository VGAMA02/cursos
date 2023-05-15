/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package determinaladotriangulo;

import java.util.Scanner;

/**
 *
 * @author ngama
 */
public class DeterminaLadoTriangulo {


    public static void main(String[] args) {
        // TODO code application logic here
       Scanner lector = new Scanner(System.in);
       double a, b, c, s, area;
       System.out.println("Ingrese un primer lado del triangulo: ");
       a = lector.nextDouble();
       System.out.println("Ingrese el segundo lado del triangulo: ");
       b = lector.nextDouble();
       System.out.println("Ingrese el tercer lado del triangulo: ");
       c = lector.nextDouble();
       
       if((a+b) > c && (a+c) > b && (b+c) > a){
           System.out.println("Los datos corresponden a un triangulo");
           s = (a+b+c)/2;
           area = Math.sqrt((s * (s - a) * (s-b) * (s-c) ));
           System.out.println("El area es: " + area);
           
           if(a == b && a == c && b==c){
               System.out.println("El triangulo es equilatero");
           }
           else if(a == b || a == c || b==c){
               System.out.println("El triangulo es isosceles");
           }
           else {
               System.out.println("El triangulo es escaleno");
           }
           
       }
       else{
               System.out.println("Los lados no corresponden a un triangulo.5");
       }
       
    }
    
}
