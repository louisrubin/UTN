#include <stdio.h>

/* 4.1: Diseñar un programa que permita generar un archivo de texto 
que permita cargar cinco nombres separados por punto. 
Mostrar el contenido del archivo un nombre abajo del otro. */

int main() {
	char nombre[50];
	int x;
	FILE * punt;		/* declaracion del puntero FILE */
	
	punt = fopen("cargarNombres.txt", "w");	/* crea y abre el archivo llamado "cargarNombres"  */
	
	if( ferror(punt) ) {
		/* verifica si hubo algun error en la apertura del archivo */
		printf("Error al abrir el archivo.\n");
		return 0;	/* termina el programa */
	}else printf("Abiendo archivo.\n");
	
	for(x=0; x<5; x++) {
		/* se ingresan los nombres y se escribe en el archivo */
		printf(" Ingrese un nombre: ");
		fgets(nombre,50,stdin);		/* obtiene el nombre ingresado */
		fputs(nombre,punt);	/* escribe en el archivo */
	}
	
	fclose(punt);	/* cierra el archivo. */
	printf("Archivo cerrado.");
	
	return 0;
}

