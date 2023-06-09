#include <stdio.h>
#include <string.h>
#include <iostream>
/* 09/06/23 - RUBIN AZAS Miguel A.
Ejercicio N° 4:
Crear una función que reciba una cadena y una letra, y devuelva la cantidad de veces
que dicha letra aparece en la cadena.
*/

int cantVeces(char cad[50], char let){
	int x=0, cont =0;
	while (x < 50){
		if(cad[x] == let){
			cont++;
		}
		x++;
	}
	return cont;
}

int main() {
	char cad[50]="", let;
	
	printf(" Ingrese una cadena: ");
	scanf("%s", &cad);
	printf(" Letra a buscar: ");
	scanf("%s", &let);
	
	printf("\n La letra '%c' aparece %d veces.", let, cantVeces(cad, let) );
	getchar();
	return 0;
}

