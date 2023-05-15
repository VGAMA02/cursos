public class MetodosEnJavaRetorno {
 public static void main(String[] args) {
       Operaciones op = new Operaciones();
       //int
       System.out.println("la suma es: " + op.suma(5, 2));
       System.out.println("la resta es: " +op.resta(5, 2));
       System.out.println("la multiplicacion es: " + op.multiplicacion(5, 2));
       System.out.println("la division es: " + op.division(5, 2));
       //double
       System.out.println("el ara del circulo es: " + op.areaCirculo(5) );
       //boolean
       if(op.estado(8))
       {
           System.out.println("Usted esta ebrio, al torito joven");
       }
       else
       {
           System.out.println("Usted no esta ebrio, sigale");
       }
    }//main
}//MetodosEnJavaRetorno
