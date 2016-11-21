package players;

import java.util.ArrayList;

import gamefiles.Card;
import gamefiles.Deck;
import gamefiles.Poker;

public class User {
	public String username;
	public static ArrayList<Card> set;
	private Hand hand;
	
	public User(String username) {
		this.username = username;
		hand = new Hand();
	}
	
	public ArrayList<Card> findSet(Deck deck){
		// TODO: write implementation use hand
		return set;
	}
}
