package Testeo;

import java.util.Scanner;

public class OrdenDeCaida {

    public static void main(String[] args) {
        int[][] tablero = new int[6][7]; // maximo fila maximo 5 columna 6 contando el 0
        int[] jugador = {1, 2};             //Ficha de los jugadores
        for (int i = 0; i < 10; i++) {
            tablero = colocarFicha(tablero, jugador[0]);

            imprimeMatrizEnteros(tablero);
            tablero = colocarFicha(tablero, jugador[1]);

            imprimeMatrizEnteros(tablero);
        }
    }

    /**
     * Coloca de abajo a arriba fichas que estan representadas por el numero de jugador
     *
     * @param tablero es donde se ponen las fichas que es una matriz
     * @param jugador es el que identifica si pone la ficha 1 o la ficha 2
     * @return Devuelve el tablero rellenado en cada ronda
     */
    public static int[][] colocarFicha(int[][] tablero, int jugador) {
        Scanner teclado = new Scanner(System.in);
        int ubicacion;
        System.out.println("Introduce la columna donde vas a poner la ficha");
        ubicacion = teclado.nextInt();
        boolean comprobacion = true;

        for (int i = tablero.length - 1; i >= 0 && comprobacion; i--) {

            if (tablero[i][ubicacion] == 0) {
                tablero[i][ubicacion] = jugador;
                comprobacion = false;

            }
        }
        return tablero;
    }

    /**
     * Imprime todo lo que se encuentre dentro de la matriz
     *
     * @param matriz se le tiene que pasar una matriz ("Una matriz es un array dentro de otro array")
     */
    public static void imprimeMatrizEnteros(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
                if (j != matriz[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}