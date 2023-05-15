package pkg0.tda.esferaact;

public class Esfera {
    private double radio;
    //constructor
    public Esfera(double radioInicial)
    {
        if(radioInicial > 0)
        {
            this.radio = radioInicial;
        }
        else
        {
            this.radio = 0;
        }
    }
    //Creando los metodos u operaciones del TDA esfera
    public double getRadio()
    {
        return radio;
    }
    public void setRadio(double radioA)
    {
        this.radio = radioA;
    }
    public double getDiametro()
    {
        return (radio*2);
    }
    public double getCircunferencia()
    {
        return (Math.PI * getDiametro());
    }
    public double getArea()
    {
        return (4*Math.PI*radio*radio);
    }
    public double getVolumen()
    {
        return (4 * Math.PI *(Math.pow(radio, 3) ) ) / 3;
    }
    
    
    
}
