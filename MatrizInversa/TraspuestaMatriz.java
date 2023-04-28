package MatrizInversa;

public class TraspuestaMatriz {
    // clase con las funciones para sacar la traspuesta de una matriz
    
    public static void imprimirMat(int[][] MatOrig) {
        // funcion que imprime una matriz cualquiera
        for (int i = 0; i < MatOrig.length; i++) {
            for (int j = 0; j < MatOrig.length; j++) {
                System.out.print(MatOrig[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static int[][] Traspuesta(int[][] MatrizOriginal) {
        // funcion que hace la traspuesta de una matriz
        int[][] matrizReturn = new int[MatrizOriginal.length][MatrizOriginal.length];

        for (int i = 0; i < MatrizOriginal.length; i++) {
            for (int j = 0; j < MatrizOriginal.length; j++) {
                matrizReturn[j][i] = MatrizOriginal[i][j];
            }
        }
        return matrizReturn;
    }
}