package Model;

import java.util.Scanner;

public class Tablero {
    private String[][] tablero;

    public Tablero() {
        tablero = new String[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tablero[i][j] = "0";
            }
        }
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    /**
     * Coloca de abajo a arriba fichas que estan representadas por el numero de jugador
     *
     * @return Devuelve el tablero rellenado en cada ronda
     */
    public boolean colocarFicha(String ficha) {
        Scanner teclado = new Scanner(System.in);
        int ubicacion;
        int[] ultimaFichaInsertada = new int[2];
        System.out.println("Introduce la columna donde vas a poner la ficha");
        ubicacion = teclado.nextInt();
        boolean FichaInsertada = false;

        for (int i = tablero.length - 1; i >= 0 && !FichaInsertada; i--) {

            if (tablero[i][ubicacion].equals("0")) {
                tablero[i][ubicacion] = ficha;
                FichaInsertada = true;
                ultimaFichaInsertada[0] = i;
                ultimaFichaInsertada[1] = ubicacion;
            }
        }

        return comprobacionesDelGanador(ultimaFichaInsertada, ficha);
    }

    public boolean comprobacionesDelGanador(int[] ultimaFicha, String ficha) {
        boolean ganar = false;
        ganar = comprobacionVertical(ultimaFicha, ficha);
        if (!ganar) {
            ganar = comprobacionHorizontal(ultimaFicha, ficha);
        }
        if (!ganar) {
            ganar = comprobacionDiagonal(ultimaFicha, ficha);
        }

        return ganar;
    }

    public boolean comprobacionDiagonal(int[] ultimaFicha, String ficha) {
        boolean ganar = false;

        return ganar;
    }

    public boolean comprobacionVertical(int[] ultimaFicha, String ficha) {
        // Comprueba la columna: |
        boolean ganar = false;
        int contador = 0;
        for (int i = 0; i < 6 && !ganar; i++) {
            if (tablero[i][ultimaFicha[1]].equals(ficha)) {
                contador++;
            } else {
                contador = resetearContador();
            }

            if (contador == 4) {
                ganar = true;
            }
        }
        return ganar;
    }

    public boolean comprobacionHorizontal(int[] ultimaFicha, String ficha) {
        // Comprueba la filas --
        boolean ganar = false;
        int contador = 0;
        for (int i = 0; i < 7 && !ganar; i++) {
            if (tablero[ultimaFicha[0]][i].equals(ficha)) {
                contador++;
            } else {
                contador = resetearContador();
            }

            if (contador == 4) {
                ganar = true;
            }
        }
        return ganar;
    }

    public int resetearContador() {
        int contador = 0;
        return contador;
    }
}
