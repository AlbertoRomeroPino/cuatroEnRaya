package Vista;

import Model.Jugador;
import Model.Tablero;

public class Menu {
    /**
     * Pide el nombre del usuario para la partida
     * @return devuelve lo introducido por teclado
     */
    public static String[] leerNombres() {
        String nombre;
        nombre = Utils.leerString();
        return new String[]{nombre};
    }

    /**
     * Imprime el nombre del usuario y la ficha que te a tocado
     * @param ficha Ficha aleatoria que se pase
     * @param arg nombre del jugador
     */
    public static void imprimirNombreFicha(String ficha, String arg) {
        System.out.println(arg + " es " + ficha);
    }

    /**
     * Controla las pautas de la partidas es decir cada turno de cada jugador
     * @param jugador nombre del jugador que le toca
     * @param tablero como va la partida
     */
    public static void imprimirTurnos(Jugador jugador, Tablero tablero) {
        System.out.println(jugador.getJugador() + "es su turno. Donde desea colocar");
        imprimirTablero(tablero);

    }

    /**
     * Imprime todo el tablero para que se pueda ver como va la partida
     * @param tablero se le pasa el tablero que va a ser visto
     */
    public static void imprimirTablero(Tablero tablero){
        for (int i = 0; i<6; i++){
            for (int j = 0; j<7; j++){
                System.out.print(tablero.getTablero()[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public static void imprimirGanador(String jugador){
        System.out.println("El jugador que a ganado la partida es: " + jugador);
    }
}
