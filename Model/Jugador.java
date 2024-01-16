package Model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Jugador {
    private String Jugador;
    private String Ficha;

    public Jugador(String[] nombre, String ficha) {
        this.Jugador = Arrays.toString(nombre);
        this.Ficha = ficha;
    }

    public String getJugador() {
        return Jugador;
    }

    public void setJugador(String jugador) {
        this.Jugador = jugador;
    }

    public String getFicha() {
        return Ficha;
    }

    public void setFicha(String ficha) {
        this.Ficha = ficha;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(Jugador, jugador.Jugador) && Objects.equals(Ficha, jugador.Ficha);
    }


}
