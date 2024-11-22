
package com.mycompany.juego;

import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        
        GUI2 frame = new GUI2();
        frame.setVisible(true);
       
        
        System.out.println("Hello World!");
        
        Scanner scanner = new Scanner(System.in);
        TreasureGame game = new TreasureGame(5, 5); // Mapa de 5x5
        game.displayMap();

        while (true) {
            System.out.println("¿Hacia dónde quieres moverte? (UP, DOWN, LEFT, RIGHT):");
            String direction = scanner.nextLine();
            game.movePlayer(direction);
        }
    }
}
//palabras de ladino