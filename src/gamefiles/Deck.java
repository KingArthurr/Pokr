package gamefiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> deck = new ArrayList<Card>();
	Card[] cards;
	
	public Deck() {
		cards = new Card[52];
		deck = Arrays.asList(cards);
		shuffle();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void reset() {
		deck.clear();
		deck = Arrays.asList(cards);
		shuffle();
	}
	
	public Card dealCard() {
		Card card = deck.get((int) Math.random() * deck.size());
		deck.remove(card);
		return card;
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck.deck);
	}
}
