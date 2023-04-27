#include <stdio.h>
#include <conio.h>

/*
	ALUMNO: Rubin Azas Miguel A.
	Comisión 1 - T.M.
	27/04/23

crear un programa que mustre el siguiente menu
	1- sumar 2 fracciones. 
	2- resta 2 fracciones. 
	3- multiplicar 2 fracciones
	4- dividir 2 fracciones. 
	5- salir
*/

/* FUNCIONES */

void imprimirFracciones(int numer1, int denom1, int numer2, int denom2, char C) {
	printf("\n %d\t %d\n---  %c\t---\n %d\t %d",numer1,numer2,C,denom1,denom2);
}
void imprUnaFrac(int numer, int denom){
	printf(" %d\n---\n %d",numer,denom);
}

	

void sumFrac(int numer1, int denom1, int numer2, int denom2){
	int res1, res2,sumas,multDenom;	
	
	res1 = numer1 * denom2;
	res2 = denom1 * numer2;
	sumas = res1 + res2;
	multDenom = denom1 * denom2;
	
	imprUnaFrac(sumas, multDenom);

}


void restaFrac(int numer1, int denom1, int numer2, int denom2){
	int numer2Neg = numer2 * (-1); /* niego el segundo numerador para así llamar la funcion de suma */
	
	sumFrac(numer1, denom1, numer2Neg, denom2);
}

void multFrac(int numer1, int denom1, int numer2, int denom2) {
	int res1 = numer1 * numer2;
	int res2 = denom1 * denom2;
	imprUnaFrac(res1, res2);
}

void divFrac(int numer1, int denom1, int numer2, int denom2){
	int numer = numer1 * denom2;
	int denom = denom1 * numer2;
	
	imprUnaFrac(numer, denom);
}

int main() {
	int opc,numer1,denom1,numer2,denom2;
	
	bool bucle = true;
	do{
		printf("\n [1] SUMAR FRACCIONES\n [2] RESTAR FRACCIONES\n [3] MULTIPLICAR FRACCIONES\n [4] DIVIDIR FRACCIONES\n [5] SALIR\n -> ");
		scanf("%d",&opc);
		
		if( opc >= 1 && opc <= 4) {
			bucle = false;
		} 
		else if(opc == 5){
			/*  si ingresa opcion 5 termina todo el programa*/
			return 0;
		}
	} while(bucle == true);
	
	printf("\n");
	
	printf(" Ingrese 1er NUMERADOR: ");
	scanf("%d", &numer1);
	printf(" Ingrese 1er DENOMINADOR: ");
	scanf("%d", &denom1);
	printf("\n Ingrese 2do NUMERADOR: ");
	scanf("%d",&numer2);
	printf(" Ingrese 2do DENOMINADOR: ");
	scanf("%d", &denom2);
	
	switch(opc){
		case 1:
			imprimirFracciones(numer1,denom1,numer2,denom2,'+');
			printf("\n\nResultado:\n\n");
			sumFrac(numer1, denom1, numer2, denom2);
			break;
		case 2:
			imprimirFracciones(numer1,denom1,numer2,denom2,'-');
			printf("\n\nResultado:\n\n");
			restaFrac(numer1, denom1, numer2, denom2);
			break;
			
		case 3:
			imprimirFracciones(numer1,denom1,numer2,denom2,'x');
			printf("\n\nResultado:\n\n");
			multFrac(numer1,denom1,numer2,denom2);
			break;
		case 4:
			imprimirFracciones(numer1,denom1,numer2,denom2,'%');
			printf("\n\nResultado:\n\n");
			divFrac(numer1,denom1,numer2,denom2);
			break;
	}
	
	return 0;
}

