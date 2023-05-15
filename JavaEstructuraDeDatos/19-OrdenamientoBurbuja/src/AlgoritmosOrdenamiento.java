
import javax.swing.JOptionPane;


public class AlgoritmosOrdenamiento {

    public static void main(String[] args) {
        Algoritmos algo = new Algoritmos();
        int vector1[] = {5,6,3,44,22,1,9,1,5,4,6,3,2,1,4,7,8,9,6,54,22,1,0,5,4,7,6,7,5,9,7,5,7,5,4,9,4,7,5,74,5,7,4,0,5,4,7,6,1,9,3,1,0,5,7,9,3,1,47,6,9,7,2,14,8,9,3,4,7,9,33,1,7,9,5,4,8,96,18,48,6,1,8,997,6,9,7,5,6,9,7,46,3,5,4,20,6,49,6,74,6,4,58,8,6,5};
        int vector2[] = {55,4,43,44,2,10,4567,638,3,0,-5,-9};
        int vector3[] = {5,2,1,8,3,9,7};
        /*
        System.out.println("Arreglo original");
        algo.mostrarArreglo(vector1);
         System.out.println("Arreglo ordenado con burbuja 1");
        algo.burbuja1(vector1);
        algo.mostrarArreglo(vector1);
        
        /*
        System.out.println("");
        
        System.out.println("Arreglo original");
        algo.mostrarArreglo(vector2);
         System.out.println("Arreglo ordenado con burbuja 2");
        algo.burbuja1(vector2);
        algo.mostrarArreglo(vector2);
        */
        
       /*
       System.out.println("Arreglo original");
       algo.mostrarArreglo(vector1);
       System.out.println("Arreglo ordenado con Radix");
       algo.radix(vector1);
       */
       
       /*
       System.out.println("Arreglo original");
       algo.mostrarArreglo(vector3);
       System.out.println("Arreglo ordenado con quick");
       algo.quickSort(vector3, 0, vector3.length-1);
       */
       
      /*
       int tam;
       tam = Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa el tamaño del arreglo"));
       int vector[] = new int [tam];
       for(int i = 0; i < tam; i++){
           vector[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el elemento del indice" + i));
           algo.insercion(vector, i+1);
       }
        */
      
      /*
       System.out.println("Arreglo original");
       algo.mostrarArreglo(vector3);
       algo.shell(vector3);
       */
      
      /*
      System.out.println("Arreglo Vector 1 original");
      algo.mostrarArreglo(vector2);
      System.out.println("Arreglo Vector 1 original");
      algo.mostrarArreglo(vector3);
      algo.burbuja1(vector2);
      algo.burbuja1(vector3);
      
       System.out.println("Ordenando ambos vectores");
       algo.intercalacion(vector2, vector3);
       */
      
      /*
        System.out.println("Arreglo original");
        algo.mostrarArreglo(vector2);
        System.out.println("Arreglo ordenado:");
        vector2 = algo.MezclaDirecta(vector2);
        algo.mostrarArreglo(vector2);
      */
      
      /*
        System.out.println("Arreglo original");
        algo.mostrarArreglo(vector2);
        System.out.println("Arreglo ordenado:");
        algo.mezclaNatural(vector2);
        algo.mostrarArreglo(vector2);
      */
      
      /*
        System.out.println("Arreglo original");
        algo.mostrarArreglo(vector2);
        int indice = algo.busquedaSecuencial(vector2, 43);
        if(indice != -1)
        {
             System.out.println("numero encontrado en la posicion: " + ++indice);
        }
        else
        {
            System.out.println("Elemento no encontrado");
        }
        
      */
       
        System.out.println("Arreglo original");
         algo.mezclaNatural(vector2);
        algo.mostrarArreglo(vector2);
        int indice = algo.busquedaBinaria(vector2, 3);
        if(indice != 1)
        {
            System.out.println("numero encontrado en la posicion: " + indice);
        }
        else
        {
            System.out.println("Elemento no encontrado");
        }
        
      
      
    }
    
    
    
}
