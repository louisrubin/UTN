package MatrizInversa;

public class DeterminanteMatriz {

    // =====================================================================================

    public static int Determinante(int [][]matrizMayor, int filaSelect){
        // funcion para hacer las operaciones de determinante (2 x Adj21  +  3 x Adj22  +  1 x Adj23)


        // GUARDO CADA ELEM DE LA FILA SELECCIONADA
        int[]filaAdj = new int[matrizMayor.length];

        for (int y=0; y < matrizMayor.length; y++){
            // arreglo de la fila seleccionada para sacar el MC
            filaAdj[y] = matrizMayor[filaSelect][y];      
        }
        


        // ESTE ARREGLO GUARDA LOS RESULTADOS DE LAS ECUACIONES DE 
        // MENOR COMPLEMENTARIO DE CADA ELEM DE LA MATRIZ INGRESADA
        int [] resultAdj = new int[matrizMayor.length];

        // FOR PARA SACAR MENOR COMPLEMENTARIO DE CADA ELEM DE LA FILA SELECT
        for (int i=0; i < matrizMayor.length; i++) {
            resultAdj[i] = MenorComplementario(matrizMayor, filaSelect, i);
        }

        int Determinante=0;
        for (int i=0; i < matrizMayor.length; i++) {
            // multiplica todos los elem de la ecuacionesAdj por su menor complem
            //      2x5 + 5x23 + (-2)x6
            Determinante += (resultAdj[i] * filaAdj[i] );
        }

        return Determinante;
    }




    // =====================================================================================



    // retorna una matriz de tipo entero
    public static int MenorComplementario(int[][] matrizParam, int subXAdj, int subYAdj){
        
        int[][] matrizCopia = new int[matrizParam.length][matrizParam.length];   // matriz cuadrada (menor complem)

        // estos 2 for es para imprimir toda la matrizParam, pero con el IF ignora la fila y colum para sacar M.C
        int fil=0, col=0;
        for (int x=0; x < matrizParam.length; x++){
            for (int y=0; y < matrizParam.length; y++){
                if(  (x != subXAdj)   &&   (y != subYAdj ) ){    // aca ignora las filas y colum para el MC
                    matrizCopia[fil][col] = matrizParam[x][y];
                    col++;
                    if (col == matrizParam.length-1) {
                        col=0;
                        fil++;
                    }
                }
            }
        }
        

        // 2 matrices para guardar las diagonales, princ y secund
        int diagPrinc[] = new int [matrizParam.length-1];
        int diagSec[] = new int [matrizParam.length-1];

        for (int i=0; i < matrizParam.length -1; i++) {
            // guardando la diagonal PRINCIPAL
            for (int j=0; j < matrizParam.length -1; j++) {
                if (i == j) {
                    diagPrinc[i] = matrizParam[i][j];
                }
            }
        }

        int k = 0;
        for (int i = matrizParam.length -2; i >= 0; i--) {
            // guardando la diagonal SECUNDARIA
            for (int j = matrizParam.length -2; j >=0; j--) {
                if (i != j) {
                    diagSec[k] = matrizParam[i][j];
                }
            }
            k++;
        }

        int mult1=1, mult2=1;

        for (int i : diagPrinc) {
            // multiplica todos los elementos de la diagonal Principal
            mult1 *= i;
        }
        for (int j : diagSec) {
            // multiplica todos los elementos de la diagonal Secundaria
            mult2 *= j;
        }

        int resultDiagonales = (mult1) - (mult2);
        //                  (-1)^3 * MC
        double A = Math.pow( -1, ((subXAdj+1) + (subYAdj+1)) ) * resultDiagonales;

        // pasar double to int =>  (int) A;
        return (int) A;
    }
}