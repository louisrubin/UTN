import java.util.Scanner;

public class SacarDeterminanteMatriz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrizDefault = {   // declaramos la matriz por defecto y tamaño (3x3)
                                {2,0,3},
                                {-1,3,5},
                                {-2,1,4} 
                                }; 

        int [][] matrizOriginal;    // matriz sin definir tamaño, solo inicializada

        System.out.println("\n PROGRAMA PARA OBTENER LA DETERMINANTE DE UNA MATRIZ 3x3\n");

        // VALIDANDO OPCION
        int opc=0;
        while (opc != 1 && opc != 2) {
            System.out.print("  [1] -> Cargar matriz manualmente \n  [2] -> Usar una por defecto\n      -> ");
            opc = sc.nextInt();
            System.out.println();
        }

        // 
        if (opc == 1) {
            matrizOriginal = new int[3][3];     // 3x3
            // CARGANDO LA MATRIZ
            System.out.println(" Ingrese los elementos de la matriz (todo de corrido) ");
            for (int x = 0; x < matrizOriginal.length; x++) {
                for (int y = 0; y < matrizOriginal.length; y++) {
                    System.out.print(" -> ");
                    matrizOriginal[x][y] = sc.nextInt();
                }
            } 
        } else {    // opc == 2
            matrizOriginal = matrizDefault;     // la matriz a utilizar será la default
        }
        int selecFilaAdj;       // defino la variable de la fila a elegir

        while (true) {
            // IMPRIMIENDO LA MATRIZ INGRESADA
            System.out.println("\n IMPRIMIENDO LA MATRIZ: \n");
            for (int x = 0; x < matrizOriginal.length; x++) {
                for (int y = 0; y < matrizOriginal.length; y++) {
                    if ( x ==1 && y ==0 ) {
                        System.out.print(" C =\t[ " + matrizOriginal[x][y] + " ]\t");
                    }else{
                        System.out.print("\t[ " + matrizOriginal[x][y] + " ]\t");
                    }
                }
                System.out.println();
            }

            System.out.print("\n Seleccione UNA FILA para sacar la Determinante: ");
            selecFilaAdj = sc.nextInt();

            // SI LA OPCION ES CORRECTA ROMPE EL BUCLE WHILE sino sigue 
            if ( (selecFilaAdj >= 1) && (selecFilaAdj <= matrizOriginal.length ) ) {
                sc.close();     // cierro el scanner pq sino me tira una advertencia
                selecFilaAdj--;     // resto 1 pq si ingresa 1, en realidad está eligiendo la fila 0, y así..
                break;
            }
        }
        
        int[]filaAdj = new int[matrizOriginal.length];
        System.out.println();
        
        for (int y=0; y < matrizOriginal.length; y++){
            // arreglo de la fila seleccionada para sacar el MC
            filaAdj[y] = matrizOriginal[selecFilaAdj][y];
        }

        //System.out.println("    [-1] [ 3] [ 5]\n C= [ 2] [ 1] [ 0]\n    [-9] [-8] [-4]");
        System.out.println( " |C| = " + Determinantes(matrizOriginal, filaAdj,selecFilaAdj) +"\n" );
    }



    // =====================================================================================

    public static int Determinantes(int [][]matrizMayor, int[] filaSelect, int subXAdj){
        // funcion para hacer las operaciones de determinante (2 x Adj21  +  3 x Adj22  +  1 x Adj23)
        
        int [] adjuntas = new int[filaSelect.length];

        for (int i=0; i < filaSelect.length; i++) {
            adjuntas[i] = menorComplen(matrizMayor, subXAdj, i);
        }
        int sumAdj=0;
        for (int i=0; i < adjuntas.length; i++) {
            // aca multiplica todos los elementos de la fila Adj por su menor complem
            sumAdj += (adjuntas[i] * filaSelect[i] );
        }

        return sumAdj;
    }


    // =====================================================================================

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

        for (int i : diagPrinc) {
            // multiplica todos los elementos de la diagonal Principal
            mult1 *= i;
        }
        for (int j : diagSec) {
            // multiplica todos los elementos de la diagonal Secundaria
            mult2 *= j;
        }

        int resultDiagonales = (mult1) - (mult2);
        //              (-1)^3 * MC
        double A = Math.pow( -1, ((subXAdj+1) + (subYAdj+1)) ) * resultDiagonales;

        // pasar double to int =>  (int) A;
        return (int) A;
    }

}

// hecho por Luis Rubin jeje