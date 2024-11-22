/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juego;

/**
 *
 * @author becer
 */
class TreasureGame {
     private int[][] map; 
    private int playerX, playerY; 
    private int treasuresFound; 
    private int score; 
    private int totalTreasures; 

    public TreasureGame(int rows, int cols) {
        map = new int[rows][cols];
        playerX = 0; // Posición inicial 
        playerY = 0; 
        treasuresFound = 0; 
        score = 0; 
        generateMap(); 
    }

    // Generamos el mapa y se puede cambiar los porcentajes 
    private void generateMap() {
        totalTreasures = 0; 
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                double random = Math.random();
                if (random < 0.2) {
                    map[i][j] = 1; // Tesoro (20% probabilidad)
                    totalTreasures++;
                } else if (random < 0.3) {
                    map[i][j] = -1; // Trampa (10% probabilidad)
                } else {
                    map[i][j] = 0; // Celda vacía (70% probabilidad)
                }
            }
        }
    }
//movimiento podemos hacer 4 botones que se pueden ir presionando
    public void movePlayer(String direction) {
        switch (direction.toUpperCase()) {
            case "UP":
                if (playerX > 0) playerX--;
                break;
            case "DOWN":
                if (playerX < map.length - 1) playerX++;
                break;
            case "LEFT":
                if (playerY > 0) playerY--;
                break;
            case "RIGHT":
                if (playerY < map[0].length - 1) playerY++;
                break;
            default:
                System.out.println("Dirección inválida. Usa UP, DOWN, LEFT o RIGHT.");
                return;
        }
        checkCell();
    }

    // verificacion de celda con recursividad
    private void checkCell() {
        exploreAdjacentCells(playerX, playerY, 0); // Inicia la exploración desde la posición actual

        displayMap();

        if (treasuresFound == totalTreasures) {
            System.out.println("¡Ganaste! Encontraste todos los tesoros.");
            System.exit(0); 
        }
    }

    private void exploreAdjacentCells(int x, int y, int depth) {
       
        if (depth > 1) {
            return; // No explorar más allá de la profundidad máxima
        }

        //mira si esta fuera del map
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return;
        }

        // Verificamo si la celda ya fue visitada
        if (map[x][y] == -2) {
            return; 
        }

      //procesamos la celda actual
        if (map[x][y] == 1) { 
            treasuresFound++;
            score += 10;
            map[x][y] = -2; 
            System.out.println("¡Encontraste un tesoro!");
        } else if (map[x][y] == -1) { 
            score -= 5;
            map[x][y] = -2; 
            System.out.println("¡Pisé una trampa! Puntos perdidos.");
        } else if (map[x][y] == 0) { 
            map[x][y] = -2; 

            exploreAdjacentCells(x - 1, y, depth + 1); 
            exploreAdjacentCells(x + 1, y, depth + 1); 
            exploreAdjacentCells(x, y - 1, depth + 1); 
            exploreAdjacentCells(x, y + 1, depth + 1); 
        }
    }

    // Muestra el mapa del juego
    public void displayMap() {
        System.out.println("Mapa del juego:");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print("P "); 
                } else if (map[i][j] == -2) {
                    System.out.print(". "); 
                } else {
                    System.out.print("? "); 
                }
            }
            System.out.println();
        }
        System.out.println("Tesoros encontrados: " + treasuresFound + "/" + totalTreasures);
        System.out.println("Puntaje: " + score);
    }
}

