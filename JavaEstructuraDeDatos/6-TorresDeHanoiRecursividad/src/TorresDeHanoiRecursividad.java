
public class TorresDeHanoiRecursividad {

    public static void main(String[] args) {
       TorresDeHanoiRecursividad obj = new TorresDeHanoiRecursividad();
       obj.TorresHanoi(3, 1, 2, 3);
    }
     //implementando metodo recursivo 
    public void TorresHanoi(int discos,int torreA,int torreB, int torreC)
    {
        //caso base
        if(discos == 1)
        {
            System.out.println("Mover Disco de torre" + torreA + " a Torre" + torreC);
        }
        else
        {
             TorresHanoi(discos-1, torreA, torreC, torreB);
             System.out.println("Mover Disco de torre" + torreA + " a Torre" + torreC);
             TorresHanoi(discos-1, torreB, torreA, torreC);
        }
     
    }
}

  
