#include <stdio.h>
#include <string.h>
/* 08/06/23 - RUBIN AZAS Miguel A.

Ejercicio N° 1:
En una cadena de 20 caracteres, cargar dos nombres separados por puntos. Usar la función strlen
para saber la cantidad de caracteres que tiene la cadena y completar el resto con el caracter “a.” */


void imprCadena(char cadena[20]) {
	/* metodo para imprimir una cadena de 20 caracteres como maximo */
	int x = 0;
	while (x<20){
		printf("%c", cadena[x]);
		x++;
		if(cadena[x] == '\0') return;
	}
}


int main() {
	char cadena[20] = "";	/* limpio la cadena */
	char nomb[10], apell[10];
	int tam;
	
	printf(" Ingrese su nombre (max. 10): ");
	scanf("%s", &nomb);
	printf(" Ingrese su apellido (max. 10): ");
	scanf("%s", &apell);
	
	strcat(cadena,nomb);
	strcat(cadena, ".");	/* concateno el string "." */
	strcat(cadena,apell);
	
	tam = strlen(cadena);	/* tamaño de la cadena con el punto incluido */
	while(tam < 20){
		strcat(cadena, "a.");		
	}
	
	imprCadena(cadena);	
	
	getchar();
	return 0;
}

