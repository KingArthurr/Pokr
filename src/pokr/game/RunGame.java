package pokr.game;

import pokr.ui.pokrTUI;
import pokr.ui.pokrView;

public class RunGame {
	public static void main(String[] args) {
		Game game = new Game();
		pokrView ui = new pokrTUI(game); //TODO args
		
		game.addObserver(ui);
		
		ui.start();
	}
}
