#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define TAM 4

/* RUBIN AZAS Miguel A. 29-06-23 - 08:00hs
Recuperatorio 3er Parcial 

Para la siguiente estructura de alumnos: Estructura { DNI – Apellido – Nombre – Nota }
Se pide:
1. Cargar los datos usando la sentencia WHILE. La dimensión del arreglo de estructura se
debe especificar usando DEFINE.Usar procedimiento.
2. Cargar los apellidos de los alumnos en una cadena, separando cada 
apellido por un punto. Usar la función strcat().
3. A partir de la cadena , listar los apellidos que comienzan con "ca" uno debajo de otro.
4. Mostrar por pantalla la longitud de la cadena. Usar la función predefinida de la librería string.h.
Consideración: Todas las variables y estructuras se definen en forma local (dentro de main).
*/

struct Alumno {
	int dni;
	char apellido[20], nombre[20];
	float nota;
} alumns[TAM];

void imprAlumsCA(char apellidos[TAM]) { 
	/* A partir de la cadena , listar los apellidos que comienzan 
	con la sílaba “ca” uno debajo de otro. */
	printf("\n");
	for(int x=0; x < strlen(apellidos); x++){
		if(  ( x==0 && tolower(apellidos[x]) == 'c' && tolower(apellidos[x+1] == 'a')) 
				|| ( tolower(apellidos[x])== 'c' && tolower(apellidos[x+1])== 'a' && apellidos[x-1] == '.' ) ) {
			
			while( apellidos[x] != '.' && apellidos[x] != '\0' ) {  
				printf("%c", apellidos[x] );
				x++;
			}	
			printf("\n");
		}
	}
}

void imprInforme(struct Alumno list[TAM], int cant){
	float p=0;
	printf("\n\t\tLISTADO DE ALUMNOS\n");
	printf(" DNI\t\tAPELLIDO\t\tNOMBRE\t\tNOTA\n");
	for(int x=0; x < cant; x++){
		printf(" %d\t%s\t\t\t%s\t\t%.1f\n", list[x].dni, list[x].nombre, list[x].apellido, list[x].nota );
		p += list[x].nota;
	}
	printf("\n Promedio de Nota: %.1f", p/cant);
}


int main() {
	int x=0, cant=0;
	char apellidos[255] ="";
	
	while(x<TAM){
		printf(" DNI: ");
		scanf("%d", &alumns[x].dni);
		printf(" Nombre: ");
		scanf("%s", &alumns[x].nombre);
		printf(" Apellido: ");
		scanf("%s", &alumns[x].apellido);
		printf(" Nota: ");
		scanf("%f", &alumns[x].nota);	
		printf("\n");
		cant++;
		x++;
	}
	x=0;
	while(x<cant){
		strcat(apellidos, alumns[x].apellido);
		if(x < cant-1) strcat(apellidos, ".");
		x++;
	}
	x=0;
	while(apellidos[x] != '\0'){
		printf("%c", apellidos[x]);
		x++;
	}
	printf(" \nLONGITUD DE LA CADENA: %d\n", strlen(apellidos));
	
	imprAlumsCA(apellidos);	/**/
	imprInforme(alumns, cant);
	
	return 0;
}

