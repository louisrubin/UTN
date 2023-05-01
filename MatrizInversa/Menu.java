package MatrizInversa;
import java.util.Scanner;

public class Menu {
    // NO 'static' PORQUE TIRA WARNING: 'should be accessed in a static way' 
    // cuando lo invoco en otro archivo
    public int [][] menuPrincipal(){
        Scanner sc = new Scanner(System.in);

        final int[][] matrizDefault = {   // declaramos la matriz por defecto y tamaño (3x3)
                                {-1,3,5},
                                {2,1,0},
                                {-9,-8,-4} 
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
            matrizReturn = Funciones.cargarMatriz(matrizReturn);

        } else if (opc == 2){
            matrizReturn = matrizDefault;     // la matriz a utilizar será la default
        } 
        else  {
            System.out.println(" MATRIZ 2x2");
            matrizReturn = new int[2][2];     // 2x2
            // CARGANDO LA MATRIZ
            matrizReturn = Funciones.cargarMatriz(matrizReturn);
        }
        sc.close();     // cierro Scanner

        // IMPRIMIENDO LA MATRIZ DEFINIDA
        Funciones.imprimirMat(matrizReturn, "inicial", false);

        System.out.println();

        // RETORNA LA MATRIZ INGRESADA O UNA DEFAULT
        return matrizReturn;
    }



}
