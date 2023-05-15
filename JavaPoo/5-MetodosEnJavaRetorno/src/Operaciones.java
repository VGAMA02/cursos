public class Operaciones {
    int x,y;
    
    int suma(int x, int y)
    {
        return (x+y);
    }
    int resta(int x, int y)
    {
        return (x-y);
    }
    int multiplicacion(int x, int y)
    {
        return (x*y);
    }
    int division(int x, int y)
    {
        return (x/y);
    }
    double areaCirculo(double radio)
    {
        return (3.1416 * (radio*radio) );
    }
    boolean estado(int tequila)
    {
        boolean e = false;
        if(tequila >= 5)
        {
            return e = true;
        }
        else
        {
            return e = false;
        }
    }
}
