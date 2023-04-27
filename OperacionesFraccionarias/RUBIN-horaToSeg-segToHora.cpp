#include <stdio.h>
#include <conio.h>

/*

Escribe un programa principal con un menu donde se pueda eleegir la opcion 
de convertir a segundos, convertir a horas, minutos y segundos o salir del programa
Escribir 2 funciones que permitan calcular.
- cantidad de segundos en un tiempo dado en horas, minutos y segundos
- cantidad de horas, min y seg de un tiempo dado en segundos.

*/

int hrToSeg(int hr, int min, int seg){
	int horas = hr * 3600;
	int mins = min * 60;
	return horas + mins + seg;
}

void segToHr(int seguns){
	int segs = seguns;
	int horas = (segs / 60 / 60);
	int mins;
	segs -= horas*60*60;

	mins = (segs / 60);
	segs -= mins*60;

	printf("%d:%d:%d",horas,mins, segs);
}

int main() {
	
	segToHr(3800);
	
	getch();
	return 0;
}

