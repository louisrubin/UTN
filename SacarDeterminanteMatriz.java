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
        int[]filaAdj = new int[matrizOrden];
        System.out.println();
        
        for (int y=0; y < matrizOrden; y++){
            // arreglo de la fila seleccionada para sacar el MC
            filaAdj[y] = matriz[selecFilaAdj][y];
        }

        System.out.println("\nsacando la determinante de una matriz (sin ser traspuesta)");
        System.out.println("    [-1] [ 3] [ 5]\n C= [ 2] [ 1] [ 0]\n    [-9] [-8] [-4]");
        System.out.println( " DETERMINANTE DE LA MATRIZ ==> " + Determinantes(matriz, filaAdj,selecFilaAdj) );
    }


    public static int Determinantes(int [][]matrizMayor, int[] filaSelect, int subXAdj){
        // funcion para hacer las operaciones de determinante (2 x Adj21  +  3 x Adj22  +  1 x Adj23)
        
        int [] adjuntas = new int[filaSelect.length];

        int f=0;
        for (int i=0; i<filaSelect.length; i++) {
            if (filaSelect[i] != 0){
                // si el elemento guardado es 0 ignora toda la operación (0 x Adj23)
                adjuntas[f] = menorComplen(matrizMayor, subXAdj, i);
                f++;
            }
        }
        int sum=0;
        for (int i=0; i<adjuntas.length; i++) {
            // aca multiplica todos los elementos de la fila Adj por su menor complem
            sum += (adjuntas[i] * filaSelect[i] );
        }

        return sum;
    }




    // retorna una matriz de tipo entero 
    //public static int[][] matrices
    public static int menorComplen(int[][]matriz, int subXAdj, int subYAdj){

        int[][] matrizReturn = new int[matriz.length][matriz.length];   // matriz cuadrada (menor complem)

        // estos 2 for es para imprimir toda la matriz, pero con el IF ignora la fila y colum para sacar M.C
        int fil=0, col=0;
        for (int x=0; x < matriz.length; x++){
            for (int y=0; y < matriz.length; y++){
                if(  (x != subXAdj)   &&   (y != subYAdj ) ){    // aca ignora las filas y colum para el MC
                    matrizReturn[fil][col] = matriz[x][y];
                    col++;
                    if (col == matriz.length-1) {
                        col=0;
                        fil++;
                    }
                }
            }
        }
        

        // 2 matrices para guardar las diagonales, princ y secund
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
            // guardando la diagonal PRINCIPAL
            for (int j=0; j < matrizReturn.length -1; j++) {
                if (i == j) {
                    diagPrinc[i] = matrizReturn[i][j];
                }
            }
        }

        int k = 0;
        for (int i = matrizReturn.length -2; i >= 0; i--) {
            // guardando la diagonal SECUNDARIA
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
        //System.out.println("resultado MUL1 MUL2: "+mult1+" - "+mult2);
        //              (-1)^3 * MC
        double A = Math.pow( -1, ((subXAdj+1) + (subYAdj+1)) ) * resultDiagonales;
        //System.out.println("resultado diagonales: "+resultDiagonales);
        //System.out.println(": (-1)^"+ ((subXAdj+1) + (subYAdj+1)) + " x "+resultDiagonales);
        //System.out.println("RESULTADO FINAL ADJ: "+ (int) A);

        // pasar double to int =>  (int) A;
        return (int) A;
    }

}