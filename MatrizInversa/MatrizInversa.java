package MatrizInversa;

public class MatrizInversa {
    
    public static void main(String[] args) {
        
        // INVOCANDO LAS CLASES DE OTROS ARCHIVO JAVA
        Menu menu = new Menu();

        int [][] matrizMayor;
        matrizMayor = menu.menuPrincipal();       // INVOCO LA FUNCION MENU PRINCIPAL

        int determ = Funciones.determinante(matrizMayor, 0);

        if (determ == 0) {
            System.out.println(" DETERMINANTE [ " + determ + " ]  =>  NO SE PUEDE OBTENER SU MATRIZ INVERSA.\n");
        } 
        else {
            // determinante != 0
            System.out.println(" |C| = " + determ);

            // MATRICES 
            int [][] matTrasp = Funciones.matrizTraspuesta(matrizMayor);
            int [][] matAdjs = new int[matrizMayor.length][matrizMayor.length];
            int [][] matrizInversa = new int [matrizMayor.length][matrizMayor.length];

            // AGREGO EL MC DE CADA ELEM A LA MATRIZ "matrizInversa"
            for (int i = 0; i < matrizMayor.length; i++) {
                for (int j = 0; j < matrizMayor.length; j++) {
                    matAdjs[i][j] = Funciones.menorComplementario(matTrasp, i, j);
                    matrizInversa[i][j] = matAdjs[i][j];   // esta matriz String se carga con el MC de cada elem anterior
                }
            }

            Funciones.imprimirMatInversa(matrizInversa, determ);  // imprime la matriz de tipo String

            System.out.println();
        }
    }
// - Rubín Azás Luis
}
