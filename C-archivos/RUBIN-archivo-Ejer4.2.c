#include <stdio.h> 
#include <conio.h> 
#include <string.h> 
#define ARCH "clientes.dat" 
#define TAM 3
/*
Agregar al programa, mostrar el contenido del archivo cargado 
previamente mediante el  siguiente formato
*/

struct registro { 
	int cliente; 
	char nombre[20]; 
	float saldo; 
};

void imprDatos(struct registro *reg){
	/* metodo para imprimir la info de un registro */
	printf("\n");
	printf(" Nro. Cliente: %d\n Nombre: %s\n Saldo: $%.1f \n", 
			reg->cliente, reg->nombre, reg->saldo);
}
	
int main() { 
	FILE *arch; 
	int x,p=0;
	
	struct registro reg[TAM]; 
	char seguir='n'; 
	
	if ((arch=fopen(ARCH,"wb")) == NULL) 
		printf(" No se pudo abrir el archivo");
	
	while(seguir=='n' && p < TAM){ 
		printf("\n Cliente %d", p+1); 
		reg[p].cliente = p+1; 
		printf("\n Ingrese el nombre: "); 
		scanf("%s",&reg[p].nombre); 
		printf(" Ingrese el saldo: $"); 
		scanf("%f",&reg[p].saldo); 
		fwrite( &reg, sizeof(struct registro), 1, arch); 
		
		if(p != TAM-1) {
			printf("\n Desea terminar s/n: ");
			scanf("\n%c",&seguir);
		}		 
		p++;
	}	
	arch = fopen(ARCH, "rb"); /* apertura de archivo READ/BINARY */
	fread(&reg, sizeof(reg), p, arch);
	
	x=0;
	while(x < p){	/* imprimir todos los elementos del array */
		printf("-------------------");
		imprDatos(&reg[x]);
		x++;
	} printf("-------------------");
	
	fclose(arch);
	getch(); 
} 
