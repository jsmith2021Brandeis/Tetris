package GUI;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**Name: Jacob Smith
 *Date:  Decemebr 26 2018
 *Assignment: Personal Study, this is the client class of my Tetris game
 *Bugs:None
 *Sources:
 * Notes: The clinet class doesn't need to knwo how to use the GUI!
 */
import PlayGame.Game;

public class GUIClient {
	public static void main(String[] args) throws InterruptedException {
		TetrisMainWindow window = new TetrisMainWindow();
		Interface display = new Interface(window);

		Game g = new Game(display);
		g.playGame();

	}

}
