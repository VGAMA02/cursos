
public class CaminosMinimos {

    //metodo para determinar todos los caminos floyd
    public String algoritmoFloyd(long[][] mAdy) {
        int vertices = mAdy.length;
        long matrizAdyacencia[][] = mAdy;
        String caminos[][] = new String[vertices][vertices];
        String caminosAux[][] = new String[vertices][vertices];
        String CaminoRecorrido = "", cadena = "", caminitos = "";
        int i, j, k;
        float temporal1, temporal2, temporal3, temporal4, minimo;

        //inicializar las matrices caminos y caminos auxiliares.
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                caminosAux[i][j] = "";

            }
        }//for
        //CAMINOS MINIMOS
        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;
                    //encontrando al minimo
                    minimo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            CaminoRecorrido = "";
                            caminosAux[i][j] = k + "";
                            caminos[i][j] = caminosR(i, k, caminosAux, CaminoRecorrido) + (k + 1);
                        }
                    }
                    matrizAdyacencia[i][j] = (long) minimo;
                }
            }
        }//for anidado

        //agregando el camino a cadena
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
            }
            cadena = cadena + "\n";
        }//for

        //////////////////VIP
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizAdyacencia[i][j] != 1000000000) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse Por...(" + (i + 1) + "," + (j + 1) + "\n";
                        } else {
                            caminitos = "De (" + (i + 1) + "--->" + (j + 1) + ") Irse Por...(" + (i + 1) + "," + caminos[i][j] + ", " + (j + 1) + ") \n";
                        }
                    }
                }
            }
        }//for
        return "La Matriz de caminos mas cortos entre los diferentes vertices es: \n" + cadena +
                "\nLos diferentes caminos mas cortos entre vectices son: \n" + caminitos;
    }//algoritmo

    private String caminosR(int i, int k, String[][] caminosAux, String CaminoRecorrido) {
       
            if( caminosAux[i][k].equals("") )
            {
                return "";
            }
            else
            {
                //Recursividad al millon
                CaminoRecorrido += caminosR(i,Integer.parseInt(caminosAux[i][k].toString()), caminosAux, CaminoRecorrido) + (Integer.parseInt(caminosAux[i][k].toString() ) + 1 ) + ", ";
                return CaminoRecorrido;
            }
            
           
    }
}//clase
