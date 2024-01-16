package Vista;

import javax.swing.*;

public class Utils {
    public static String leerString (){
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del jugador");
        return nombre;
    }
}
