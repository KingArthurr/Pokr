package pokr.player;

import java.util.List;

import pokr.game.Card;

public abstract class Player {

	public abstract String determineMove();
	
	private String username;
	private Hand hand;
	
	public Player(String username) {
		this.username = username;
		this.hand = new Hand();
	}
	
	public void giveCard(Card c) {
		hand.addCard(c);
	}
	
	public void removeCards() {
		hand.clear();
	}
	
	public void removeCard(Card card) {
		hand.removeCard(card);
	}
	
	public List<Card> getCards() {
		return hand.handCopy();
	}
	
	public String getUsername() {
		return username;
	}
}
