
import java.util.Arrays;

public class TablasHash {
    
    //Constructor
    String[] arreglo;
    int tamanio,contador;
    public TablasHash(int tam){
        tamanio = tam;
        arreglo = new String[tam];
        Arrays.fill(arreglo,"-1");
    }
    
    public void funcionHash(String[] cadenaArreglo, String[] arreglo){
        int i;
        for(i=0;i<arreglo.length;i++){
            String elemento = cadenaArreglo[i];
            int indiceArreglo = Integer.parseInt(elemento)%7;
            System.out.println("El indice es: " + indiceArreglo + "Para el elemento o valor " + elemento);
            
            while(arreglo[indiceArreglo] != "-1"){
                indiceArreglo++;
                System.out.println("Ocurrio una colision en el indice " + (indiceArreglo-1) + "cambiar a indice " + indiceArreglo) ;
                indiceArreglo %= tamanio;
            }
            arreglo[indiceArreglo] = elemento;
        }
    }
    //Metodo para mostrar la tabla.
    public void mostrar(){
        int incremento = 0, i,j;
        for(i=0; i<1; i++){
            incremento+=8;
            for(j=0; j<71; j++){
                System.out.print("-");
            }
            System.out.println("");
            for(j = incremento - 8; j < incremento; j++){
                System.out.format("| %3s" + " ", j);
            }
            System.out.println("|");
            for(int n=0; n<71;n++){
                System.out.print("-");
            }
            System.out.println("");
            
            for(j = incremento - 8; j < incremento; j++){
                if(arreglo[j].equals("-1")){
                    System.out.print("|    ");
                }
                else{
                    System.out.print(String.format("| %3s" + " ", arreglo[j]));
                }
            }
            System.out.println("|");
            for(j=0; j<71; j++){
                System.out.print("-");
            }
            System.out.println("");
            System.out.println("");
            
        }
        System.out.println("");
    }
    
    //buscar clave
    public String buscarClave(String elemento){
        int indiceArreglo = Integer.parseInt(elemento)%7;
        int contador = 0;
        while(arreglo[indiceArreglo] != "-1"){
            if(arreglo[indiceArreglo] == elemento)
            {
                System.out.println("El elemento " + elemento + " fue encontrado en el indice: " + indiceArreglo);
                return arreglo[indiceArreglo];
            }
            indiceArreglo++;
            indiceArreglo %= tamanio;
            contador++;
            if(contador > 7){
                break;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        TablasHash hash = new TablasHash(8);
        String[] elementos = {"20","33","21","10","12","14","56","100"};
        hash.funcionHash(elementos, hash.arreglo);
        hash.mostrar();
        String buscado = hash.buscarClave("100");
        if(buscado == null)
        {
            System.out.println("No se encontro el elemento 333");
        }
    }
    
}
