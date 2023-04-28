package MatrizInversa;

public class MatrizInversa {
    
    public static void main(String[] args) {
        
        // INVOCANDO LAS CLASES DE OTROS ARCHIVO JAVA
        Menu menu = new Menu();
        DeterminanteMatriz deterMatriz = new DeterminanteMatriz();

        int [][] matriz;
        matriz = menu.menuPrincipal();       // INVOCO LA FUNCION MENU PRINCIPAL
        int deter = deterMatriz.determinante(matriz, 0);
    
        System.out.println(" |C| = " + deter + "\n");
    }

}
