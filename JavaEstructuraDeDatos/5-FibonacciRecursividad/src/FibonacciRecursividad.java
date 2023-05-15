
public class FibonacciRecursividad {

    public static void main(String[] args) {
        FibonacciRecursividad obj = new FibonacciRecursividad();
        System.out.println("La sucesion fibonacci de 12 mediante recursividad es: " +
                obj.fibonacciRecursivo(12) );
        System.out.println("La sucesion fibonacci de 12 mediante ciclo es: " +
                obj.fibonacciCiclo(12) );
    }
    //creando el metodo recursivo para la sucesion de Fibonacci
    public int fibonacciRecursivo(int n)
    {
        
        if(n == 1 || n ==2)
        {
            return 1; //respuesta explicita
        }
        else
        {
            return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
        }
    }
    
    public int fibonacciCiclo(int n)
    {
        int fibo = 0, primero = 1, segundo = 0;
        while(n>0)
        {
            fibo = primero + segundo;
            primero = segundo;
            segundo = fibo;
            n--;
        }
        return fibo;
    }
}

