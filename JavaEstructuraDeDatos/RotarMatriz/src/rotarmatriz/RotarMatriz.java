/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotarmatriz;

/**
 *
 * @author ngama
 */
public class RotarMatriz {

    public static void Rotar90(int[][] M, int[][] N){
        int z = M.length -1;
        for(int x = 0; x < M.length;x++){
            for(int j = 0; j < M.length;j++){
                N[x][j] = M[j][z];
            }
            z--;
        }
    }
    
    public static void Rotar90M(int[][] M, int[][] N){
        int z = 0;
        for(int x = 0; x < M.length;x++){
            for(int j = 0; j < M.length;j++){
                N[x][j] = M[j][z];
            }
            z++;
        }
    }
    
    public static void Rotar180(int[][] M, int[][] N){
        int z = M.length -1;
        for(int x = 0; x < M.length;x++){
            int u = M.length -1;
            for(int j = 0; j < M[x].length;j++){
                N[x][j] = M[z][u];
                u--;
            }
            z--;
        }
    }
    
    public static void Rotar270(int[][] M, int[][] N){
        for(int x = 0; x < M.length;x++){
            for(int j = 0, u = 2; j < M[x].length;j++, u--){
                N[x][j] = M[u][x];
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matriz = { {1,2,3},{4,5,6},{7,8,9} };
        int[][] rot90 = new int [3][3];
        int[][] rot180 = new int [3][3];
        int[][] rot270 = new int [3][3];
        System.out.print("Matriz normal \n");
        mostrar(matriz);
        
        System.out.print("Matriz 90+ \n");
        Rotar90(matriz, rot90);
        mostrar(rot90);
        System.out.print("Matriz 90 \n");
        Rotar90M(matriz, rot90);
        mostrar(rot90);
        System.out.print("Matriz 180 \n");
        Rotar180(matriz, rot180);
        mostrar(rot180);
        System.out.print("Matriz 270 \n");
        Rotar270(matriz, rot270);
        mostrar(rot270);
        
        
    }
    
     public static void mostrar(int[][] M){
        for(int x = 0; x < M.length;x++){
            for(int j = 0; j < M.length;j++){
                System.out.print(M[x][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
