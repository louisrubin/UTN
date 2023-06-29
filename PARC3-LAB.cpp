#include <stdio.h>
#include <ctype.h>
#include <string.h>
#define TAM 5
/*
Para la siguiente estructura de alumnos: Estructura {DNI – Apellido – Nombre – Nota }
Se pide:
1. Cargar los datos usando la sentencia WHILE. La dimensión del arreglo de estructura se
debe especificar usando DEFINE.Usar procedimiento.
2. Cargar los apellidos de los alumnos en una cadena, separando cada 
apellido por un punto. Usar la función strcpy().
3. A partir de la cadena , listar los apellidos que comienzan con 
la vocal “e” uno debajo de otro.
4. Mostrar por pantalla la longitud de la cadena. Usar la función predefinida de la librería string.h.
Consideración: Todas las variables y estructuras se definen en forma local (dentro de main).
*/
typedef struct Alumno Alumno;

struct Alumno {
	int dni, cant;
	char apellido[20], nombre[20];
	float nota;
};

void cargAlum(Alumno list[TAM]){
	int x=0;
	char s='n';
	list[0].cant = 0;	/* contador de alumnos en posicion 0 de la lista */
	while( s=='n' && x < TAM){
		printf(" Ingrese DNI: ");
		scanf("%d", &list[x].dni);
		printf(" Ingrese nombre: ");
		scanf("%s", &list[x].nombre);
		printf(" Ingrese apellido: ");
		scanf("%s", &list[x].apellido);
		do {
			printf(" Ingrese nota: ");	/* verifica que la nota sea entre 0 y 10 */
			scanf("%f", &list[x].nota);
		} while( list[x].nota < 0 || list[x].nota > 10);
		
		if(x < TAM-1) {
			printf("\n Desea terminar s/n: ");
			scanf("\n%c",&s);
		}
		list[0].cant++;
		x++;
	}
}

void impAlums(Alumno list[TAM]){
	int x = 0;
	while( x < list[0].cant ){
		printf("\n\n [%d] %s %s (%.1f)", list[x].dni, list[x].nombre, list[x].apellido, list[x].nota);
		x++;
	}	
}
	
void imprAlumsE(char apellidos[TAM]) { 
	/* A partir de la cadena , listar los apellidos que comienzan 
	con la vocal “e” uno debajo de otro. */
	int x;	
	printf("\n\n");
	for(x=0; x < strlen(apellidos); x++){
		if(  ( x==0 && tolower(apellidos[x]) == 'e' ) || ( tolower(apellidos[x])== 'e' && apellidos[x-1] == '.' ) ) {
			
			while( apellidos[x] != '.' && apellidos[x] != '\0' ) {  
				printf("%c", apellidos[x] );
				x++;
			}	
			printf("\n");
		}
	}
}

int main() {
	int x;
	char apellidos[255] = "";
	Alumno alumns[TAM];
	cargAlum(alumns);
	
	for(x=0; x < alumns[0].cant; x++){
		/* Cargar apellidos en una cadena, separando por un punto */
		strcat(apellidos, alumns[x].apellido);
		if(x < alumns[0].cant - 1) strcat(apellidos, ".");		
	}	
	printf("\n");
	for(x=0; x < strlen(apellidos); x++){
		printf("%c", apellidos[x]);
	}
	
	imprAlumsE(apellidos);
	return 0;
}
