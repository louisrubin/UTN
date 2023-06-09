#include <stdio.h>
#include <string.h>
#include <iostream>

/* 08/06/23 - RUBIN AZAS Miguel A.
Ejercicio N ° 3:
? Escribe un programa que pida tres cadenas al usuario y muestre su longitud (número
de letras). Mostrar el contenido de las cadenas de menor a mayor longitud.
*/

void imprCadena(char cadena[50]) {
	/* metodo para imprimir una cadena */
	int x = 0;
	printf("\n");
	while (x < 50){
		printf("%c", cadena[x]);
		x++;
		if(cadena[x] == '\0') return;
	}
}

int cantLetras(char cad[50]){
	int x = 0, cant=0;
	while (x < 50){
		if( isalpha(cad[x]) ) cant++;
		if(cad[x] == '\0') return cant;
		x++;
	}
	return cant;
}
	
	
void menToMay(char cad1[50], char cad2[50], char cad3[50]) {
	int x = 0;
	char aux[50], mayor[50], medio[50] , menor[50];
	strcpy(mayor, cad1);
	strcpy(medio, cad2);
	strcpy(menor, cad3);
	
	while (x<2){
		/* ordena por longitud de LETRAS de cada cadena (verifica 2 veces) */
		if ( cantLetras(mayor) < cantLetras(medio) ){
			strcpy(aux,medio);
			strcpy(medio,mayor);
			strcpy(mayor,aux);
		}
		if( cantLetras(medio) < cantLetras(menor) ){
			strcpy(aux,menor);
			strcpy(menor,medio);
			strcpy(medio,aux);
		}
		
		if( cantLetras(menor) > cantLetras(mayor) ){
		strcpy(aux,mayor);
		strcpy(mayor,menor);
		strcpy(menor,aux);
		}
		
		x++;
	}
	
	imprCadena(menor);
	imprCadena(medio);
	imprCadena(mayor);	
}


int main() {
	char cad1[50], cad2[50], cad3[50];
	
	printf(" Ingrese cadena 1: ");
	scanf("%s", &cad1);
	printf(" Longitud (LETRAS): %d", cantLetras(cad1));
	
	printf("\n\n Ingrese cadena 2: ");
	scanf("%s", &cad2);
	printf(" Longitud (LETRAS): %d", cantLetras(cad2));
	
	printf("\n\n Ingrese cadena 3: ");
	scanf("%s", &cad3);
	printf(" Longitud (LETRAS): %d\n\n", cantLetras(cad3));
	
	printf("-------------------------\n");
	printf(" MENOR A MAYOR LONGITUD (DE LETRAS)\n");
	menToMay(cad1,cad2,cad3);
	
	getchar();
	return 0;
}

