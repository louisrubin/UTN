# MatrizInversa

Programa en ejecución:

![Capture](https://user-images.githubusercontent.com/72027738/235542457-0955bc9b-a808-4b6b-b958-759e0fe9e907.PNG)

||||
| :---: | :---: | :---: |
| -1 | 3 | 5 |
| 2 | 1 | 0 |
| -9 | -8 | -4 |

###### El archivo ***Main*** es `MatrizInversa.java`
---
# ¿CÓMO SE OBTIENE UNA MATRIZ INVERSA?

1. Primero obtiene la Determinante de la matriz ingresada


![determinante](https://user-images.githubusercontent.com/72027738/235530230-d14148f9-17cb-4647-acd6-2d33c9ea17cb.png)
> En este ejemplo saqué la determinante seleccionando la 2da fila (1) porque hay un cero y así simplifico las ecuaciones, pero el programa siempre saca la determinante tomando la fila 1 (0). 

---
2. Luego verifica que la determinante **no** sea igual a `0`, de ser cero no se puede obtener la matriz inversa.


Verificación:
```java
int determinante = Funciones.determinante(matriz, 0); // llama a la función para obtener la determinante
if (determinante == 0) {
  System.out.println("No se puede obtener la matriz inversa.");
} else {
  ...
}
```

---
3. Realiza la ***traspuesta*** de la matriz para poder trabajar con ella

||||
| :---: | :---: | :---: |
| -1 | 2 | -9 |
| 3 | 1 | -8 |
| 5 | 0 | -4 |

> Matriz traspuesta: Las filas pasan a ser columnas y las columnas; filas

---
4. Obtiene la **Adjunta** de cada elemento de la matriz traspuesta

![adjunta](https://user-images.githubusercontent.com/72027738/235543569-cbfa0a0a-f152-47a7-a3db-c6b8d78f3107.png)

---
5. Obtenemos la Matriz Inversa (sin simplificar)

| Fórmula de Matriz inversa || Matriz Inversa |
| :---: | :---: | :---: |
| ![mat-inversa](https://user-images.githubusercontent.com/72027738/235538689-0b0567ef-c8b1-408a-9494-b067fbd903b3.png) | ![flecha](https://user-images.githubusercontent.com/72027738/235540334-c4807101-cb71-4988-9e99-5a954b9b37ef.png) | ![mat-inversa2](https://user-images.githubusercontent.com/72027738/235539323-dd823f0f-faf1-42f8-9a5b-7f1621eb2049.png) |
| Adjunta de la matriz C sobre Determinante | | Sin simplificar |
| | | |


---
6. Realiza la simplificación de fracciones e imprime finalmente la matriz inversa

![resultado](https://user-images.githubusercontent.com/72027738/235540652-6408e782-7ee6-4b1f-8271-38b2ce7fc8cb.png)

---
Función ***simpliFrac*** el cual retorna un *arreglo* de 2 elementos (numerador y denominador)

```java
public static int[] simpliFrac(int num1, int num2) {
    //  FUNCION PARA SIMPLIFICAR UNA FRACCION
    int menor = num1;
    int mayor = num2;
    int[] arrSimpl = { num1, num2 };    // array para cargar los valores simplificados (si no se puede simplf queda como está)
    if (num1 > num2) { 
        // OBTIENE EL NUMERO MENOR Y MAYOR PARA USAR EL MENOR EN EL for
        menor = num2;
        mayor = num1;
    }
    if (menor > 0) {
      //  RECORRE IZQUIERDA A DERECHA
      for (int i = menor; i >= 2; i--) {
          if ( (menor % i == 0) && (mayor % i == 0) ) {
              arrSimpl[0] = num1 / i;
              arrSimpl[1] = num2 / i;
              break;
          }
      }
    } else if (menor < 0) {
        //  RECORRE DERECHA A IZQUIERDA
        for (int i = menor; i <= -2; i++) {
            if ( (menor % i == 0) && (mayor % i == 0) ) {
                arrSimpl[0] = num1 / i;
                arrSimpl[1] = num2 / i;
                break;
            }
        }
    }
    return arrSimpl;    // arreglo de 2 elementos
}
```
22

---
###### Gracias por llegar hasta aquí, fue un reto para mí hacer este programa y me da satisfacción haberlo logrado jaja :)




