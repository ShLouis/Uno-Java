package fr.ynov.uno.main;

import fr.ynov.uno.game.Game;
import fr.ynov.uno.game.gui.Gui;

import java.util.ArrayList;
/** Main Class
 * Starts the application
 * */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();

    }
}
