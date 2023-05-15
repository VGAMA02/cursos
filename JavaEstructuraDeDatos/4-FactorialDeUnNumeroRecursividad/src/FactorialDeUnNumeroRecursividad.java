//factorial --> 4! = 1*2*3*4 =24

public class FactorialDeUnNumeroRecursividad {

    public static void main(String[] args) {
        // TODO code application logic here
        FactorialDeUnNumeroRecursividad obj = new FactorialDeUnNumeroRecursividad();
        System.out.println("El factorial de 4 mediante metodo recursivo es: " +   obj.factorialRecursivo(4));
        System.out.println("El factorial de 4 mediante Ciclo es: " +   obj.factorialCiclo(4));
        
    }

    public int factorialRecursivo(int n) {
        //validando
        if (n < 0) {
            return 0;
        }else{
            if (n == 0) //caso Base
            {
               return 1; 
            }
            else
            {
                //Dominio
                return n * factorialRecursivo(n-1);
            }
        }

    }
    
    public int factorialCiclo(int n)
    {
        int factor = 1;
        //validando
        if (n < 0) {
            return 0;
        }else{
            while(n!=0)
            {
               factor = n * factor;
               n--;
            }
            return factor;
        }
    }

}
