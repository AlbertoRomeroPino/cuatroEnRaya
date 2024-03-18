package Vista;

import javax.swing.*;
import java.util.Scanner;

public class Utils {
    public static String leerString (){
         Scanner teclado = new Scanner(System.in);

         System.out.println("Introduce el nombre del jugador");
         return teclado.nextLine();
    }
}
