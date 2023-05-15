//TDA = tipo de dato abstracto = clase
package pkg0.tda.esferaact;
public class TDAEsferaAct {

    public static void main(String[] args) {
        Esfera esf = new Esfera(4);
        System.out.println("Radio: " + esf.getRadio() );
        System.out.println("Diametro: " + esf.getDiametro());
        System.out.println("Circunferencia: " + esf.getCircunferencia());
        System.out.println("Area: " + esf.getArea());
        System.out.println("Volumen: " + esf.getVolumen());
    }
    
}
