import java.util.Scanner;

public class SacarDeterminanteMatriz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        int[] notas = {10,5,6,3,8,75}; // declaramos el arreglo con valores ya definidos
        */

        int matrizOrden = 3;    // 3x3

        int[][] matriz = {  {-1,3,5}, 
                            {2,1,0}, 
                            {-9,-8,-4} 
        };
        int selecFilaAdj = 1;
        int subColumAdj = 0;
        int[]filaAdj = new int[matrizOrden];

        System.out.println();
        

        for (int y=0; y < matrizOrden; y++){
            // arreglo de la fila seleccionada para sacar el MC
            filaAdj[y] = matriz[selecFilaAdj][y];
        }

        System.out.print("sacando la determinante de una matriz (sin ser traspuesta)");

        // primero recorro la fila seleccionada para sacar adjunta
        System.out.println( menorComplen(matriz, selecFilaAdj, subColumAdj) );
    }



    // retorna una matriz de tipo entero 
    //public static int[][] matrices
    public static int menorComplen(int[][]matriz, int subXAdj, int subYAdj){

        int[][] matrizReturn = new int[matriz.length][matriz.length];   // matriz cuadrada (menor complem)

        // estos 2 for es para imprimir toda la matriz, pero con el IF ignora la fila y colum para sacar M.C
        int fil=0, col=0;
        for (int x=0; x < matriz.length; x++){
            for (int y=0; y < matriz.length; y++){
                //
                if( (x != subXAdj) && (y != subYAdj ) ){    // aca ignora las filas y colum para el MC
                    matrizReturn[fil][col] = matriz[x][y];
                    col++;
                    if (col == matriz.length-1) {
                        col=0;
                        fil++;
                    }
                }
            }
            System.out.println();
        }

        int diagPrinc[] = new int [2];
        int diagSec[] = new int [2];


        //3333333333333333333333
        // for (int index = 0; index < matrizReturn.length; index++) {
        //     for (int index2 = 0; index2 < matrizReturn.length; index2++) {
        //         System.out.print(matrizReturn[index][index2]+",");
        //     }
        //     System.out.println();
        // }
        //3333333333333333333333

        for (int i=0; i < matrizReturn.length -1; i++) {
            // diagonal principal
            for (int j=0; j < matrizReturn.length -1; j++) {
                if (i == j) {
                    diagPrinc[i] = matrizReturn[i][j];
                }
            }
        }

        int k = 0;
        for (int i = matrizReturn.length -2; i >= 0; i--) {
            // diagonal secundaria
            for (int j = matrizReturn.length -2; j >=0; j--) {
                if (i != j) {
                    diagSec[k] = matrizReturn[i][j];
                }
            }
            k++;
        }

        int mult1=1, mult2=1;

        // multiplica todos los elementos de la diagonal Principal
        for (int i : diagPrinc) {
            mult1 *= i;
        }

        // multiplica todos los elementos de la diagonal Secundaria
        for (int j : diagSec) {
            mult2 *= j;
        }

        int resultDiagonales = (mult1) - (mult2);
        System.out.println("resultado MUL1 MUL2: "+mult1+" - "+mult2);
        //              (-1)^3 * MC
        double A = Math.pow( -1, ((subXAdj+1) + (subYAdj+1)) ) * resultDiagonales;
        System.out.println("resultado diagonales: "+resultDiagonales);
        System.out.println(": (-1)^"+ ((subXAdj+1) + (subYAdj+1)) + " x "+resultDiagonales);
        System.out.println("RESULTADO FINAL ADJ: "+ (int) A);

        // pasar double to int =>  (int) A;
        return (int) A;
    }

}