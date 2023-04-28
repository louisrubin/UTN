package MatrizInversa;
import java.util.Scanner;

public class Menu {
    // NO 'static' PORQUE TIRA WARNING: 'should be accessed in a static way' 
    // cuando lo invoco en otro archivo
    public int [][] menuPrincipal(){
        Scanner sc = new Scanner(System.in);

        final int[][] matrizDefault = {   // declaramos la matriz por defecto y tamaño (3x3)
                                {2,0,3},
                                {-1,3,5},
                                {-2,1,4} 
                                }; 

        final int [][] matrizReturn;    // matriz sin definir tamaño, solo inicializada

        System.out.println("\n PROGRAMA PARA OBTENER UNA MATRIZ INVERSA 3x3\n");

        int opc=0;
        while (opc != 1 && opc != 2) {
            // VALIDANDO OPCION INGRESADA
            System.out.print("  [1] -> Cargar matriz manualmente \n  [2] -> Usar una por defecto\n      -> ");
            opc = sc.nextInt();
            System.out.println();
        }

        // VERIFICANDO OPCION
        if (opc == 1) {
            matrizReturn = new int[3][3];     // 3x3
            // CARGANDO LA MATRIZ
            System.out.println(" Ingrese los elementos de la matriz (todo de corrido) ");
            for (int x = 0; x < matrizReturn.length; x++) {
                for (int y = 0; y < matrizReturn.length; y++) {
                    System.out.print(" -> ");
                    matrizReturn[x][y] = sc.nextInt();
                }
            } 

        } else  {    // opc == 2
            matrizReturn = matrizDefault;     // la matriz a utilizar será la default
        }

        // IMPRIMIENDO LA MATRIZ DEFINIDA
        System.out.println("\n IMPRIMIENDO LA MATRIZ: \n");
        for (int x = 0; x < matrizReturn.length; x++) {
            for (int y = 0; y < matrizReturn.length; y++) {
                if ( x ==1 && y ==0 ) {
                    System.out.print(" C =\t[ " + matrizReturn[x][y] + " ]\t");
                }else{
                    System.out.print("\t[ " + matrizReturn[x][y] + " ]\t");
                }
            }
            System.out.println();
        }

        sc.close();     // cierro Scanner
        System.out.println();

        // RETORNA LA MATRIZ INGRESADA O UNA DEFAULT
        return matrizReturn;
    }

}
