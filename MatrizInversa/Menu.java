package MatrizInversa;
import java.util.Scanner;

public class Menu {
    // NO 'static' PORQUE TIRA WARNING: 'should be accessed in a static way' 
    // cuando lo invoco en otro archivo
    public int [][] menuPrincipal(){
        Funciones deterMat = new Funciones();
        Scanner sc = new Scanner(System.in);

        final int[][] matrizDefault = {   // declaramos la matriz por defecto y tamaño (3x3)
                                {7,-5,4},
                                {9,-1,0},
                                {2,3,1} 
                                }; 

        int [][] matrizReturn;    // matriz sin definir tamaño, solo inicializada

        System.out.println("\n PROGRAMA PARA OBTENER UNA MATRIZ INVERSA 3x3\n");

        int opc=0;
        while ( opc != 1 && opc != 2 && opc != 22 ) {
            // VALIDANDO OPCION INGRESADA
            System.out.print("  [1] -> CARGAR MATRIZ MANUALMENTE \n  [2] -> USAR UNA YA CARGADA\n      -> ");
            opc = sc.nextInt();
            System.out.println();
        }

        // VERIFICANDO OPCION
        if (opc == 1) {
            matrizReturn = new int[3][3];     // 3x3
            // CARGANDO LA MATRIZ
            matrizReturn = cargarMatriz(matrizReturn);

        } else if (opc == 2){
            matrizReturn = matrizDefault;     // la matriz a utilizar será la default
        } 
        else  {
            System.out.println(" MATRIZ 2x2");
            matrizReturn = new int[2][2];     // 2x2
            // CARGANDO LA MATRIZ
            matrizReturn = cargarMatriz(matrizReturn);
        }
        sc.close();     // cierro Scanner

        // IMPRIMIENDO LA MATRIZ DEFINIDA
        deterMat.imprimirMat(matrizReturn, "inicial", false);

        System.out.println();

        // RETORNA LA MATRIZ INGRESADA O UNA DEFAULT
        return matrizReturn;
    }


    public int[][] cargarMatriz(int[][] matParam) {
        // FUNCION PARA CARGA DE MATRIZ
        Scanner sc = new Scanner(System.in);

        System.out.println(" Ingrese los elementos de la matriz (todo de corrido) ");
            for (int x = 0; x < matParam.length; x++) {
                for (int y = 0; y < matParam.length; y++) {
                    System.out.print(" -> ");
                    matParam[x][y] = sc.nextInt();
                }
            } 
        sc.close();     // cierro Scanner
        return matParam;
    }

}
