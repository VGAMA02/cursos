public class Auto {
      //Creandp los atributos del auto
      String marca,color;
      int modelo;
      double precio;
      //Creando Metodo
      void encederAuto(String marca, String color, int modelo)
      {
          System.out.println("El auto " + marca + "Color: "+ color + "Modelo: "+ modelo +" encendio");
      }
      void apagarAuto(String marca)
      {
         System.out.println("El auto se apago");
      }
      void acelerarAuto(String marca)
      {
         System.out.println("El auto esta acelerando");
      }
      void frenarAuto(String marca)
      {
         System.out.println("El auto esta frenando");
      }
      
      
      
}
