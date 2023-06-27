#include <stdio.h> 
#include <conio.h> 
#include <string.h> 
#define ARCH "clientes.dat" 
#define TAM 5
/*
Agregar al programa, mostrar el contenido del archivo cargado 
previamente mediante el  siguiente formato
*/
struct registro { 
	int cliente; 
	char nombre[20]; 
	float saldo; 
};
void imprDatos(struct registro reg){
	/* metodo para imprimir la info de un registro */
	printf(" Nro. Cliente: %d\n Nombre: %s\n Saldo: $%.1f \n", 
		   reg.cliente, reg.nombre, reg.saldo);
}
	
	int main() { 
		FILE *arch; 
		int x, p=0;	
		struct registro reg; 
		char seguir ='n'; 
		
		/* abre el archivo en modo ESCRITURA y verifica si se realizo con exito */
		if ( (arch = fopen(ARCH, "wb") ) == NULL) {
			printf(" No se pudo abrir el archivo en modo ESCRITURA.");
			return 1;
		}
		while(seguir =='n' && p < TAM){ 
			/* bloque para escribir clientes en el archivo */
			printf("\n Cliente %d", p+1); 
			reg.cliente = p+1; 
			printf("\n Ingrese el nombre: "); 
			scanf("%s", &reg.nombre); 
			printf(" Ingrese el saldo: $"); 
			scanf("%f", &reg.saldo); 
			fwrite( &reg, sizeof(struct registro), 1, arch); 	/* escribe los datos en el archivo */
			
			if(p != TAM-1) {
				printf("\n Desea terminar s/n: ");
				scanf("\n%c",&seguir);
			}		 
			p++;
		}	
		fclose(arch);       /* cierro el archivo en modo Escritura */
		
		/* abre el archivo en modo LECTURA y verifica si se realizo con exito */
		if ( (arch = fopen(ARCH, "rb") ) == NULL) {
			/* vuelvo a abrir el archivo pero ahora en modo READ/BINARY */
			printf(" No se pudo abrir el archivo en modo LECTURA.");
			return 1;
		}
		
		printf("\n");
		while( fread(&reg, sizeof(reg), 1, arch) == 1 ){	/* aca imprime las cadenas guardado en el archivo */
			printf("-------------------\n");
			imprDatos(reg);         /* procedimiento para imprimir los datos de un cliente */
		} printf("-------------------");
		
		fclose(arch);	/* cierro el archivo nuevamente */
		getch(); 
		return 0;
	} 
