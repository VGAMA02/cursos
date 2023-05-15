
public class Algoritmos {

    int i, j, temporal, pasadas = 0;

    public Algoritmos() {
        this.i = 0;
        this.j = 0;
        this.temporal = 0;
    }

    //Metodo Burbuja version 1
    public void burbuja1(int[] arreglo) {
        pasadas = 0;
        for (i = 0; i < arreglo.length; i++) {
            for (j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    temporal = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temporal;
                }
                pasadas++;
            }
        }
        System.out.println("\n termino en: " + pasadas + " pasadas \n");
    }////burbuja 1

    //Metodo Burbuja version 2
    public void burbuja2(int[] arreglo) {
        pasadas = 0;
        for (i = 1; i < arreglo.length; i++) {
            for (j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                }
                pasadas++;
            }
        }
        System.out.println("\n termino en: " + pasadas + " pasadas \n");
    }////burbuja 2

    //Mostrar los datos del vector
    public void mostrarArreglo(int[] arreglo) {
        int k;
        for (k = 0; k < arreglo.length; k++) {
            System.out.print("[" + arreglo[k] + "]");
        }
        System.out.println("");
    }

    //algoritmo radix :D
    public void radix(int[] arr) {
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x--) {
            int aux[] = new int[arr.length];
            j = 0;
            for (i = 0; i < arr.length; i++) {
                boolean mover = arr[i] << x >= 0;
                /*operador ternario
                    resultado = (condicion) ? valor1:valor2;
                    boolean hola = (x<y) ? true:false;
                 */
                if (x == 0 ? !mover : mover) {
                    aux[j] = arr[i];
                    j++;
                } else {
                    arr[i - j] = arr[i];
                }
            }

            for (i = j; i < aux.length; i++) {
                aux[i] = arr[i - j];
            }

            arr = aux;

        }//for
        System.out.println("El arreglo ordenado con radix: ");
        mostrarArreglo(arr);

    }

    public void quickSort(int[] arreglo, int primero, int ultimo) {
        int i, j, pivote, auxiliar;
        i = primero;
        j = ultimo;
        pivote = arreglo[(primero + ultimo) / 2];
        System.out.println("El pivote es: " + pivote);
        do {
            while (arreglo[i] < pivote) {
                i++;
            }
            while (arreglo[j] > pivote) {
                j--;
            }
            //aqui hacemos el intercambio
            if (i <= j) {

                auxiliar = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = auxiliar;
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            quickSort(arreglo, primero, j);
        }
        if (i < ultimo) {
            quickSort(arreglo, i, ultimo);
        }
        mostrarArreglo(arreglo);
    }

    //algoritmo por insercion
    public void insercion(int[] arreglo, int n) {
        int i, j, auxiliar;
        for (i = 1; i < n; i++) {
            auxiliar = arreglo[i];
            j = i - 1;
            while (j >= 0 && arreglo[j] > auxiliar) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = auxiliar;
        }
        System.out.println("arreglo ordenado por insercion");
        mostrarArreglo(arreglo);
    }

    public void shell(int[] arreglo) {
        int salto, i, j, k, aux;
        salto = arreglo.length / 2;
        while (salto > 0) {
            for (i = salto; i < arreglo.length; i++) {
                j = i - salto;
                while (j >= 0) {
                    k = j + salto;
                    if (arreglo[j] <= arreglo[k]) {
                        j = -1;
                    } else {
                        aux = arreglo[j];
                        arreglo[j] = arreglo[k];
                        arreglo[k] = aux;
                        j -= salto;
                    }

                }
            }
            salto = salto / 2;
        }//WHILE
        System.out.println("Arreglo ordenado con shell");
        mostrarArreglo(arreglo);
    }

    //ordenar 2 vectores
    public void intercalacion(int[] v1, int[] v2) {
        int i, j, k;
        int[] v3 = new int[v1.length + v2.length];

        //repetir mientras los arreglos 1 y 2 tengan elementos
        for (i = j = k = 0; i < v1.length && j < v2.length; k++) {
            if (v1[i] < v2[j]) {
                v3[k] = v1[i];
                i++;
            } else {
                v3[k] = v2[j];
                j++;
            }
        }
        //para añadir los elementos del arregloA sobrantes en caso de haberlos
        for (; i < v1.length; i++, k++) {
            v3[k] = v1[i];
        }
        //para añadir los elementos del arregloB sobrantes en caso de haberlos
        for (; j < v2.length; j++, k++) {
            v3[k] = v1[j];
        }
        mostrarArreglo(v3);
    }//funcion

    //Mezcla directa
    public int[] MezclaDirecta(int[] arreglo) {
        int i, j, k;
        if (arreglo.length > 1) {
            int nElementosIzq = arreglo.length / 2;
            int nElementosDer = arreglo.length - nElementosIzq;
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];
            //Copiando los elementos de la parte primera al arreglo izquierdo.
            for (i = 0; i < nElementosIzq; i++) {
                arregloIzq[i] = arreglo[i];
            }
            //Copiando los elementos de la parte segunda al arreglo derecho.
            for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
                arregloDer[i - nElementosIzq] = arreglo[i];
            }
            //Recursividad
            arregloIzq = MezclaDirecta(arregloIzq);
            arregloDer = MezclaDirecta(arregloDer);
            i = 0;
            j = 0;
            k = 0;
            while (arregloIzq.length != j && arregloDer.length != k) {
                if (arregloIzq[j] < arregloDer[k]) {
                    arreglo[i] = arregloIzq[j];
                    i++;
                    j++;
                } else {
                    arreglo[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }//while
            //Arreglo final
            while (arregloIzq.length != j) {
                arreglo[i] = arregloIzq[j];
                i++;
                j++;
            }
            while (arregloDer.length != k) {
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            }
        }

        return arreglo;

    }//mezcla

    //Metodo mezcla natural
    public void mezclaNatural(int arreglo[]) {
        int izquierda = 0, izq = 0, derecha = arreglo.length - 1, der = derecha;
        boolean ordenado = false;
        do {
            ordenado = true;
            izquierda = 0;
            while (izquierda < derecha) {
                izq = izquierda;
                while (izq < derecha && arreglo[izq] <= arreglo[izq + 1]) {
                    izq++;
                }
                der = izq + 1;
                while (der == derecha - 1 || der < derecha && arreglo[der] <= arreglo[der + 1]) {
                    der++;
                }
                if (der <= derecha) {
                    MezclaDirecta2(arreglo);
                    ordenado = false;
                }
                izquierda = izq;
            }
        } while (!ordenado);
    }

    //Mezcla directa
    public void MezclaDirecta2(int[] arreglo) {
        int i, j, k;
        if (arreglo.length > 1) {
            int nElementosIzq = arreglo.length / 2;
            int nElementosDer = arreglo.length - nElementosIzq;
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];
            //Copiando los elementos de la parte primera al arreglo izquierdo.
            for (i = 0; i < nElementosIzq; i++) {
                arregloIzq[i] = arreglo[i];
            }
            //Copiando los elementos de la parte segunda al arreglo derecho.
            for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
                arregloDer[i - nElementosIzq] = arreglo[i];
            }
            //Recursividad
            arregloIzq = MezclaDirecta(arregloIzq);
            arregloDer = MezclaDirecta(arregloDer);
            i = 0;
            j = 0;
            k = 0;
            while (arregloIzq.length != j && arregloDer.length != k) {
                if (arregloIzq[j] < arregloDer[k]) {
                    arreglo[i] = arregloIzq[j];
                    i++;
                    j++;
                } else {
                    arreglo[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }//while
            //Arreglo final
            while (arregloIzq.length != j) {
                arreglo[i] = arregloIzq[j];
                i++;
                j++;
            }
            while (arregloDer.length != k) {
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            }
        }

    }//mezcla

    ////////////////////////////////////////////////////////////////////////////
    //busqueda
    public int busquedaSecuencial(int arreglo[], int elemento) {
        int i;
        boolean encontrado = false;
        for (i = 0; i < arreglo.length && encontrado == false; i++) {
            if (elemento == arreglo[i]) {
                encontrado = true;
                return i;
            }
        }

        return -1;
    }

    //busqueda binaria
    public int busquedaBinaria(int arreglo[], int elemento) {
        int centro, primero, ultimo, valorCentro;
        primero = 0;
        ultimo = arreglo.length - 1;
        while (primero <= ultimo) {
            centro = (primero + ultimo) / 2;
            valorCentro = arreglo[centro];
            System.out.println("Comparando a " + elemento + " Con " + arreglo[centro]);
            if (elemento == valorCentro) {
                return centro;
            } else if (elemento < valorCentro) {
                ultimo = centro - 1; //desplazarnos izquierda
            } else {
                primero = centro + 1; //desplazar derecha;
            }
        }
        return -1;
    }

}//clase algoritmos
