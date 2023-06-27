#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define ARCH "alumnos.bin"
#define TAM 5

/* PROGRAMA DE CARGA DE ALUMNOS EN EL ARCHIVO 'alumnos.bin' */

struct Alumno {
	/* estructura general de cualquier alumno */
	int dni;
	char apellido[20], nombre[20];
	float nota;
};

int main() {
	FILE *arch;
	struct Alumno alumns;
	
	arch = fopen(ARCH, "wb");
	int p=0;
	char seg = 'n';	
	
	do {
		printf("\n Ingrese DNI: ");
		scanf("%d",&alumns.dni); 
		printf(" Ingrese nombre: "); 
		scanf("%s",&alumns.nombre); 
		printf(" Ingrese apellido: "); 
		scanf("%s",&alumns.apellido); 
		printf(" Ingrese nota: ");
		scanf("%f",&alumns.nota); 
		fwrite( &alumns, sizeof(alumns), 1, arch); /* function para escribir en el archivo */
		
		p++;		
		if(p < TAM-1) {
			printf("\n Desea terminar s/n: ");
			scanf("\n%c",&seg);
		}
	}while(seg=='n' && p < TAM);
	
	fclose(arch);
	printf("\n Archivo cerrado.");
	return 0;
}
