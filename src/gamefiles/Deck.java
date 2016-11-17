package gamefiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gamefiles.Card.Suit;
import gamefiles.Card.Value;

public class Deck {

	List<Card> deck = new ArrayList<Card>();
	
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
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}
}
