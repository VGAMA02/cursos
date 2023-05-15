/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ngama
 */
public class Atributos {
    //declarando los atributos de la clase y asignandole valores iniciales
    String marca = "Ford", modelo = "2014", color = "Azul";
    double precio = 150000.502;
    public static void main(String[] args)
    {
       //crear una instancia de mi clase Atributos es decir un objecto
       Atributos atributo = new Atributos();
       //Accediendo a los atributos de la instancia.
       System.out.println("Marca: "  + atributo.marca);
       System.out.println("Modelo: " + atributo.modelo);
       System.out.println("Color: "  + atributo.color);
       System.out.println("Precio: " + atributo.precio);
       
    }
}
