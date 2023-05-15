package pkg3.reccursividadescalones;
public class ReccursividadEscalones {
    public static void main(String[] args) throws InterruptedException {
      ReccursividadEscalones objEsc = new ReccursividadEscalones();
      objEsc.bajarEscalera(20);
    }
    //crendo un metodo para bajar una escalera de manera recursiva
    public void bajarEscalera(int escalones) throws InterruptedException
    {
        if(escalones < 0)
        {
            System.out.println("nada de escalones negativos");
            return;
        }
        if(escalones == 0)
        {
            //Caso base, respuesta explicita
            System.out.println("Has terminado de bajar la escalera");
        }
        else
        {
            Thread.sleep(500);
            //Dominio, divisaion del problema original (problema - 1)
             System.out.println("Bajando Escalon: " + escalones);
             //haciendo uso de la recursividad
             bajarEscalera(escalones-1);
        }
    }
}
