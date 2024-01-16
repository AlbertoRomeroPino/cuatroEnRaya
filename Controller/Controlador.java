package Controller;


import Model.Jugador;
import Model.Tablero;
import Vista.Menu;

public class Controlador {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;


    public void Inicio() {
        tablero = new Tablero();
        jugador1 = new Jugador(Menu.leerNombres(), "X");
        Menu.imprimirNombreFicha(jugador1.getFicha(), jugador1.getJugador());
        jugador2 = new Jugador(Menu.leerNombres(), "Z");
        Menu.imprimirNombreFicha(jugador2.getFicha(), jugador2.getJugador());


    }

    public void Start() {
        boolean ganar = false;
        int contador = 1;
        while(!ganar) {

            Menu.imprimirTurnos(jugador1, tablero);
            ganar = tablero.colocarFicha(jugador1.getFicha());
            contador++;
            if (!ganar) {
                Menu.imprimirTurnos(jugador2, tablero);
                ganar = tablero.colocarFicha(jugador2.getFicha());
                contador--;
            }
        }
        Menu.imprimirTablero(tablero);
        if (contador == 1){
            Menu.imprimirGanador(jugador2.getJugador());
        }else {
            Menu.imprimirGanador(jugador1.getJugador());
        }

    }


}
