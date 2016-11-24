package players;

import gamefiles.Card;

public class User {
	public String username;
	private Hand hand;
	
	public User(String username) {
		this.username = username;
		hand = new Hand();
	}
	
	
	public void giveCard(Card c) {
		hand.addCard(c);
	}
	
	public void removeCards() {
		hand.clear();
	}
}
