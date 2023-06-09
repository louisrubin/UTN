#include <stdio.h>
#include <string.h>
/*	08/06/23 - RUBIN AZAS Miguel A.

Ejercicio N° 2: Realizar el ejercicio usando las funciones
? Ingresar dos cadenas llamadas C1 y C2.
? Mostrar el contenido de C1 y C2.
? Indicar cuál es la cadena más larga.
? Comparar ambas cadenas
? Concatenar una cadena a la cadena más corta.
*/

void imprCadena(char cadena[50]) {
	/* metodo para imprimir una cadena */
	int x = 0;	
	while (x < 50){
		printf("%c", cadena[x]);
		x++;
		if(cadena[x] == '\0') return;
	}
}

void comparar(char cad1 [50], char cad2[50]){
	/* método que compara 2 cadenas lexicográficamente e imprime cual es mayor */
	printf("\n\n---------%d---------\n", strcmp(cad1, cad2));
	
	if( strcmp(cad1, cad2) == 0 ){
		printf("\n Ambas cadenas son iguales.");
	} else if(strcmp(cad1, cad2) < 0 ){
		imprCadena(cad1);
		printf("\n Es mayor");
	} else {					/* == 1 */
		imprCadena(cad2);
		printf("\n Es mayor");
	}
}

int cadMasLarga(char cad1[50], char cad2[50]) {
	int tam1, tam2;	
	tam1 = strlen(cad1);
	tam2 = strlen(cad2);
	
	if(tam1 > tam2) {
		printf("\n\n >> La cadena más larga es: "); 
		imprCadena(cad1);
		return 2;
	}
	if(tam2 > tam1) {
		printf("\n\n >> La cadena más larga es: ");
		imprCadena(cad2);
		return 1;
	}
	if(tam2 == tam1) {
		printf("\n\n >> Ambas cadenas tienen misma longitud. <<");
		return 3;
	}
	return 0;
}

int main() {
	char C1[50], C2[50], C3[50]=".MENOR.", menor[50]="";
	int tam1, tam2, masLarg;
	
	printf(" Ingrese cadena 1: ");
	scanf("%s", &C1);
	printf(" Ingrese cadena 2: ");
	scanf("%s", &C2);
	
	printf("\n -- IMPRIMIENDO CADENA 1 --\n");
	imprCadena(C1);
	printf("\n -- IMPRIMIENDO CADENA 2 --\n");
	imprCadena(C2);
	
	masLarg = cadMasLarga(C1, C2);
	if(masLarg == 1) strcat(menor, C1);
	if(masLarg == 2) strcat(menor, C2);;
	
	comparar(C1, C2); /* método de comparación */
	
	if (masLarg != 3){
		printf("\n\n MAS CORTO CONCATENADO: ");
		strcat(menor, C3);
		imprCadena(menor);
	} else {
		printf("\n\n >> Ambas cadenas tienen misma longitud. <<");
	}
	
	getchar();
	return 0;
}

