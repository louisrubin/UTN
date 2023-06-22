#include <stdio.h>
#define ARCHIVO "cargarNombres.txt"

/* 4.1: Diseñar un programa que permita generar un archivo de texto 
que permita cargar cinco nombres separados por punto. 
Mostrar el contenido del archivo un nombre abajo del otro. */

int main() {
	FILE * punt;		/* declaracion del puntero FILE */
	char nombres[255];
	int x;

	punt = fopen(ARCHIVO, "w");	/* crea y abre el archivo llamado "cargarNombres"  */
	
	if( ferror(punt) ) {    /* verifica si hubo algun error en la apertura del archivo */
		printf("Error al abrir el archivo.\n");
		return 0;	        /* termina el programa */
	}
    	else printf("Abriendo archivo '%s'\n", ARCHIVO);
	
	printf("\n Ingrese 5 nombres separados por un punto\n");
	fgets(nombres,255,stdin);		/* almacena la cadena en la variable 'nombres' */
    	fputs(nombres,punt);	/* escribe en el archivo la cadena ingresada */

    	printf("\n");
	for(x=0; x<255; x++) { 		/* se imprime la cadena escrita en el archivo */
		if(nombres[x] == '.' || nombres[x] == ' ') printf("\n");
        	else printf("%c", nombres[x]);
	}
	fclose(punt);	/* cierra el archivo utilizando el puntero. */
	printf("\nArchivo cerrado.");
	return 0;
}
