#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define ARCH "alumnos.bin"
#define TAM 5

/* PROGRAMA QUE LEE LOS ALUMNOS REGISTRADOS EN EL ARCHIVO 'alumnos.bin' */

struct Alumno {
	/* estructura general de cualquier alumno */
	int dni;
	char apellido[20], nombre[20];
	float nota;
};

struct Detalles {
	/* estructura de todos los detalles finales */
	int cantAlumns, cantAlumAprob, cantAlumDesap;
	float promNotaAlumn;
	float porcAlumAprob, porcAlumDesap;
	struct Alumno alumnNotaAlta, alumnNotaBaja;
} details;

void sumarInfo(struct Alumno alumn){
	/* metodo que se encarga cargar infos a partir de un alumno */
	
	if(alumn.nota > details.alumnNotaAlta.nota){
		details.alumnNotaAlta = alumn;
	}
	if(alumn.nota < details.alumnNotaBaja.nota){
		details.alumnNotaBaja = alumn;
	}
	if (alumn.nota >= 6) details.cantAlumAprob++;
	if (alumn.nota < 6) details.cantAlumDesap++;
}

void imprTodaInfo(){
	/* metodo para imprimir toda la info final */
	printf("\n TOTAL ALUMNOS: %d", details.cantAlumns);
	printf("\n ALUMNO CON MAYOR NOTA: [ %d, '%s %s', (%.1f) ] ",
			details.alumnNotaAlta.dni,
			details.alumnNotaAlta.nombre,
			details.alumnNotaAlta.apellido,
			details.alumnNotaAlta.nota
		);	
	printf("\n ALUMNO CON MENOR NOTA: [ %d, '%s %s', (%.1f) ] ",
			details.alumnNotaBaja.dni,
			details.alumnNotaBaja.nombre,
			   details.alumnNotaBaja.apellido,
			   details.alumnNotaBaja.nota
		);
	printf("\n PROMEDIO NOTA DE ALUMNOS: %.1f", details.promNotaAlumn);
	printf("\n CANTIDAD DE ALUMNOS APROBADOS: %d",details.cantAlumAprob);
	printf("\n CANTIDAD DE ALUMNOS DESAPROBADOS: %d", details.cantAlumDesap);
	printf("\n PORC. ALUMNOS APROBADOS: %.0f%%", details.porcAlumAprob);
	printf("\n PORC. ALUMNOS DESAPROBADOS: %.0f%%", details.porcAlumDesap);
}
		
int main() {
	FILE *arch;
	struct Alumno alumns;
	float sumaNota=0;
	
	details.cantAlumns=0; 			/* asignando valores iniciales */
	details.cantAlumAprob=0; 		/* para compararlo después */
	details.cantAlumDesap=0;
	details.alumnNotaAlta.nota = 0;	
	details.alumnNotaBaja.nota = 10.1;	

	arch = fopen(ARCH, "rb");

	if ( arch == NULL ){
		printf(" No se pudo abrir el archivo %s\n",ARCH);
		return 1;
	}
	printf("-----------------------------------------------------------------\n");
	printf(" DNI\t\tNOMBRE\t\tAPELLIDO\t\tNOTA\n");
	printf("-----------------------------------------------------------------\n");

	while( fread( &alumns, sizeof(alumns), 1, arch ) == 1 ){
		printf(" %d\t%-15s\t%-15s\t\t%.1f\n", alumns.dni, alumns.nombre, alumns.apellido, alumns.nota);
		sumaNota += alumns.nota;

		sumarInfo(alumns);

		details.cantAlumns++;	/* aumenta la cant de alums del STRUCT 'DETALLES' */
	}
	printf("-----------------------------------------------------------------\n");

	fclose(arch);	/* cierro el archivo */
	
	/* obtiene los promedios y porcentajes */
	details.promNotaAlumn = sumaNota / details.cantAlumns;
	details.porcAlumAprob = (100 * details.cantAlumAprob ) / details.cantAlumns;
	details.porcAlumDesap = (100 * details.cantAlumDesap ) / details.cantAlumns;
	
	imprTodaInfo();	/* procedimiento para imprimir toda la info detallada*/
	return 0;
}
