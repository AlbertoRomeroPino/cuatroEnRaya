package Testeo;

import java.util.Scanner;

public class OrdenCaida_Victoria {
    public static void main(String[] args) {
        String[][] tablero = new String[6][7];      //Crear el tablero 6*7
        String[] jugadorFicha = {"X", "S"};              //Ficha de los jugadores
        boolean ganador = false;                    //comprobar si se gana
        asignarValor(tablero);                      //Todo el tablero se pone a 0
        int[] ultimaFichaIntroducida;
        int jugador = 0;

        for (int i = 0; !ganador; i++) {

            imprimirTurnos(jugador);
            ultimaFichaIntroducida = colocarFicha(tablero, jugadorFicha[0]);
            imprimeMatrizEnteros(tablero);
            ganador = comprobadorFila(ultimaFichaIntroducida, jugadorFicha[0], tablero);

            if (!ganador) {
                jugador++;
                imprimirTurnos(jugador);
                ultimaFichaIntroducida = colocarFicha(tablero, jugadorFicha[1]);
                imprimeMatrizEnteros(tablero);
                ganador = comprobadorFila(ultimaFichaIntroducida, jugadorFicha[1], tablero);
            }
            if (!ganador) {
                jugador--;
            }
        }


        System.out.println("You Win Player " + (jugador+1));
    }

    /**
     * @param ultimaFicha la parte de 0 es la fila y la 1 es la columna
     * @param jugador     es el tipo de ficha que a colocado en el turno
     * @param tablero     se comprueba la ubicación de la ultima ficha insertada
     * @return devuelve si gana algun jugador o no
     */
    public static boolean comprobadorFila(int[] ultimaFicha, String jugador, String[][] tablero) {
        boolean ganar = false;
        int contador = 0;

        // Comprueba la columna |
        for (int i = 0; i < 6 && !ganar; i++) {
            if (tablero [i][ultimaFicha[1]].equals(jugador)){
                contador++;
            }else {
                contador=0;
            }

            if (contador == 4) {
                ganar = true;
            }
        }
        
        for (int i = 0; i < 7 && !ganar; i++) {

        }

        return ganar;
    }

    /**
     * Pone todo el tablero en vez de a null a 0
     *
     * @param tablero se le pasa el tablero que vas a rellenar
     */
    public static void asignarValor(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = "0";
            }
        }
    }

    /**
     * Coloca de abajo a arriba fichas que estan representadas por el numero de jugador
     *
     * @param tablero es donde se ponen las fichas que es una matriz
     * @param jugador es el que identifica si pone la ficha 1 o la ficha 2
     * @return Devuelve el tablero rellenado en cada ronda
     */
    public static int[] colocarFicha(String[][] tablero, String jugador) {
        Scanner teclado = new Scanner(System.in);
        int ubicacion;
        int[] ultimaFichaInsertada = new int[2];
        System.out.println("Introduce la columna donde vas a poner la ficha");
        ubicacion = teclado.nextInt();
        boolean FichaInsertada = false;

        for (int i = tablero.length - 1; i >= 0 && !FichaInsertada; i--) {

            if (tablero[i][ubicacion].equals("0")) {
                tablero[i][ubicacion] = jugador;
                FichaInsertada = true;
                ultimaFichaInsertada[0] = i;
                ultimaFichaInsertada[1] = ubicacion;
            }
        }

        return ultimaFichaInsertada;
    }


    /**
     * Imprime todo lo que se encuentre dentro de la matriz
     *
     * @param matriz se le tiene que pasar una matriz ("Una matriz es un array dentro de otro array")
     */
    public static void imprimeMatrizEnteros(String[][] matriz) {
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

    public static void imprimirTurnos(int jugador) {
        System.out.println("Tu turno jugador " + (jugador + 1));
    }
}
