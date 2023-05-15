/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ngama
 */
public class Instanciacion {
    //declarando los atributos de la clase y asignandole valores iniciales
    String marca = "", modelo = "", color = "";
    double precio = 0;
    public static void main(String[] args)
    {
       //creando objectos de la clase Instanciacion 
        Instanciacion auto = new Instanciacion();
        Instanciacion auto2 = new Instanciacion();
        Instanciacion auto3 = new Instanciacion();
        //Asignacion de valores a los atriburos
        auto.marca = "Nissan";
        auto.modelo = "2000";
        auto.color = "Azul";
        auto.precio = 50000;
        
        auto2.marca = "Ford";
        auto2.modelo = "2018";
        auto2.color = "Negro";
        auto2.precio = 150000;
        
        auto3.marca = "Ferrari";
        auto3.modelo = "2018";
        auto3.color = "Verde";
        auto3.precio = 850000.55;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Marca: " + auto.marca);
        System.out.println("Modelo: " + auto.modelo);
        System.out.println("Color: " + auto.color);
        System.out.println("Precio: " + auto.precio);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("Marca: " + auto2.marca);
        System.out.println("Modelo: " + auto2.modelo);
        System.out.println("Color: " + auto2.color);
        System.out.println("Precio: " + auto2.precio);
         System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Marca: " + auto3.marca);
        System.out.println("Modelo: " + auto3.modelo);
        System.out.println("Color: " + auto3.color);
        System.out.println("Precio: " + auto3.precio);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<");
    }
    
}
