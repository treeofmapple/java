package main;

import javax.swing.SwingUtilities;

import mapGen.WorldGen;
import screen.GameUI;

public class Main {
    public static void main(String[] args) {
        WorldGen worldGen = new WorldGen();
        char[][] map = worldGen.getMap();

        SwingUtilities.invokeLater(() -> {
            GameUI gameUI = new GameUI(map);
            gameUI.setVisible(true);
        });
    }
}