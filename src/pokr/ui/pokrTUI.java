package pokr.ui;

import java.util.Observable;
import java.util.Scanner;

import pokr.game.Game;
import pokr.game.Game.Difficulty;
import pokr.util.Format;

public class pokrTUI implements pokrView {
	
	private Game game;

	private Scanner input = new Scanner(System.in);
	
	public pokrTUI(Game game) {
		this.game = game;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		addUsers();
		setDifficulty();
		game.addComputerPlayers();
		game.startGame();
	}
	
	private void addUsers() {
		Format.print("Hello and welcome to Pokr, a text based Texas Hold'em Poker Game.\nThis game is brought to you by KingArthur & MisterSteen.");
		//TODO multiplayer
		Format.print("Please enter a username:");
		boolean username = false;
		while (username==false) {
			String input = this.input.nextLine();
			if (input.trim().equals("") || input.isEmpty()) {
				Format.print("This username is not available.");
			} else {
				game.addPlayer(input);
				username = true;
			}
		}
	}
	
	private void setDifficulty() {
		boolean difficulty = false;
		Format.print("What kind of poker player are you?");
		while (difficulty==false) {
			Format.print("Please choose: Beginner, Adept, Professional, Legend");
			String input = this.input.nextLine().toLowerCase();
			Difficulty diff;
			switch (input){
			case "beginner": 
				difficulty = true;
				diff = Difficulty.BEGINNER;
				game.setDifficulty(diff);
				break;
			case "adept":
				difficulty = true;
				diff = Difficulty.ADEPT;
				game.setDifficulty(diff);
				break;
			case "professional":
				difficulty = true;
				diff = Difficulty.PROFESSIONAL;
				game.setDifficulty(diff);
				break;
			case "legend":
				difficulty = true;
				diff = Difficulty.LEGEND;
				game.setDifficulty(diff);
				break;
			}	
		}
	}

}
