package pokr.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import pokr.player.ComputerPlayer;
import pokr.player.HumanPlayer;
import pokr.player.Player;

public class Game extends Observable {
	
	public enum Difficulty {
		BEGINNER(1), ADEPT(2), PROFESSIONAL(3), LEGEND(4);
		private int difficulty;
		
		Difficulty(int diff) {
			this.difficulty = diff;
		}
		
		public int getDifficulty() {
			return difficulty;
		}
	}

	private static final int maxplayers = 5;
	private Deck deck;
	private Difficulty difficulty;
	private List<Player> players = new ArrayList<Player>();
	
	public Game() {
		deck = new Deck();
	}
	
	public void startGame() {
		deck.reset();
		players.forEach(c -> {c.removeCards();});
		this.deal();
		
		boolean won = false;
		while(!won) {
			players.forEach(c -> {
				boolean movemade = false;
				while(!movemade) {
					String move = c.determineMove();
					switch(move.split("",2)[0].toLowerCase()) {
						case "fold": //TODO fold
							movemade = fold(move);
							break;
						case "raise": //TODO raise
							movemade = raise(move);
							break;
						case "call": //TODO call
							movemade = call(move);
							break;
						case "check": //TODO check
							movemade = check(move);
							break;
						default: 
							setChanged();
							notifyObservers("inputerror fold raise call check");
							break;
					}
				}
			});
		}
	}
	
	private boolean check(String move) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean call(String move) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean raise(String move) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean fold(String move) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addPlayer(String username) {
		players.add(new HumanPlayer(username));
	}
	
	public void setDifficulty(Difficulty diff) {
		this.difficulty = diff;
	}
	
	public void addComputerPlayers() {
		while(players.size() < maxplayers) {
			players.add(new ComputerPlayer(new String("Player " + players.size()), this.difficulty));
		}
	}
	
	//TODO check order
	private void deal() {
		for (Player u: players) {
			for(int i=0; i<3; i++){
				u.giveCard(deck.dealCard());
			}	
		}
		for (Player u: players) {
			u.giveCard(deck.dealCard());
		}
		for (Player u: players) {
			u.giveCard(deck.dealCard());
		}
	}
	
}
