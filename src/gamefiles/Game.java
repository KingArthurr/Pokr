package gamefiles;

import players.User;

public class Game {

	Deck deck;
	User user;
	
	public Game(String username) {
		deck = new Deck();
		user = new User(username);
	}
}
