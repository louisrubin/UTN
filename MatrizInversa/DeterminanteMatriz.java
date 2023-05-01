package MatrizInversa;

public class DeterminanteMatriz {
    // =====================================================================================

    public int determinante(int [][]matrizMayor, int filaSelect){
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
            resultAdj[i] = menorComplementario(matrizMayor, filaSelect, i);
        }

        int Deter =0;
        for (int i=0; i < matrizMayor.length; i++) {
            // multiplica todos los elem de la ecuacionesAdj por su menor complem
            //      2x5 + 5x23 + (-2)x6
            Deter += (filaAdj[i] * resultAdj[i]);
        }

        return Deter;
    }




    // =====================================================================================



    // retorna una matriz de tipo entero
    public int menorComplementario(int[][] matrizParam, int subXAdj, int subYAdj){
        
        // MATRIZ QUE ALMACENA LOS ELEMENTOS DEL MENOR COMPLEMENTARIO (FILAS Y COLUM IGNORADAS)
        int[][] matrizMC = new int[matrizParam.length][matrizParam.length];

        // estos 2 for, pero con el IF ignora la fila y colum para sacar M.C
        int fil=0, col=0;
        for (int x=0; x < matrizParam.length; x++){
            for (int y=0; y < matrizParam.length; y++){
                if(  (x != subXAdj)   &&   (y != subYAdj ) ){    // aca ignora las filas y colum para el MC
                    matrizMC[fil][col] = matrizParam[x][y];
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
                    diagPrinc[i] = matrizMC[i][j];
                }
            }
        }

        int k = 0;
        for (int i = matrizParam.length -2; i >= 0; i--) {
            // guardando la diagonal SECUNDARIA
            for (int j = matrizParam.length -2; j >=0; j--) {
                if (i != j) {
                    diagSec[k] = matrizMC[i][j];
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

    
    // =====================================================================================

    

    public int[][] matrizTraspuesta(int[][] MatrizOriginal) {
        // funcion que hace la traspuesta de una matriz
        int[][] matrizReturn = new int[MatrizOriginal.length][MatrizOriginal.length];

        for (int i = 0; i < MatrizOriginal.length; i++) {
            for (int j = 0; j < MatrizOriginal.length; j++) {
                matrizReturn[j][i] = MatrizOriginal[i][j];
            }
        }
        return matrizReturn;
    }

    
    // =====================================================================================

    
    public void imprimirMat(int[][] matParam, String nombreMat, boolean esTrasp) {
        // funcion que imprime una matriz cualquiera ENTERA

        System.out.println("\n IMPRIMIENDO MATRIZ "+ nombreMat.toUpperCase() + ":\n");
        for (int x = 0; x < matParam.length; x++) {
            for (int y = 0; y < matParam.length; y++) {
                if ( x ==1 && y ==0 ) {
                    if (esTrasp) {
                        System.out.print(" C.T " + "=\t[ " + matParam[x][y] + " ]\t");                        
                    } else {
                        System.out.print(" C " + "=\t[ " + matParam[x][y] + " ]\t");
                    }
                }else{
                    System.out.print("\t[ " + matParam[x][y] + " ]\t");
                }
            }
            System.out.println();
        }
    }

    public void imprimirMatInversa(String[][] matParam, int determ) {
        // funcion que imprime una matriz cualquiera ENTERA

        System.out.println("\n IMPRIMIENDO MATRIZ "+ "INVERSA" + ":\n");
        for (int x = 0; x < matParam.length; x++) {
            for (int y = 0; y < matParam.length; y++) {
                if ( x ==1 && y ==0 ) {
                        System.out.print(" C-1 " + "=\t[ " + matParam[x][y] + "/" + determ + " ]\t");
                }else{
                    System.out.print("\t[ " + matParam[x][y] + "/" + determ + " ]\t");
                }
            }
            System.out.println();
        }
    }
}