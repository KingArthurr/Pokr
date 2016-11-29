package gamefiles;

import java.util.ArrayList;
import java.util.Collections;

import gamefiles.Card.Suit;
import gamefiles.Card.Value;

public class Deck {

	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		for (int i = 0; i < Suit.values().length; i++) {
			for (int j = 0; j < Value.values().length; j++) {
				Card card = new Card(Suit.values()[i], Value.values()[j]);
				deck.add(card);
			}
		}
		shuffle();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void reset() {
		deck.clear();
		for (int i = 0; i < Suit.values().length; i++) {
			for (int j = 0; j < Value.values().length; j++) {
				Card card = new Card(Suit.values()[i], Value.values()[j]);
				deck.add(card);
			}
		}
		shuffle();
	}
	
	public Card dealCard() {
		if (deck.isEmpty()) {
			reset();
		}
		Card card = deck.get(deck.size()-1);
		deck.remove(deck.size()-1);
		return card;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}
}
