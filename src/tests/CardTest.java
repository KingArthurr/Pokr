package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gamefiles.Card;
import gamefiles.Card.Suit;
import gamefiles.Card.Value;

public class CardTest {

	Card card;
	
	@Before
	public void setUp() throws Exception {
		card = new Card(Suit.CLUBS, Value.EIGHT);
	}

	@Test
	public void testGetSuit() {
		assertEquals(card.getSuit(), Suit.CLUBS);
	}
	
	public void testGetValue() {
		assertEquals(card.getValue(), Value.EIGHT);
	}

	public void testToString() {
		assertEquals(card.toString(), new String("[" + card.getSuit() + "," + card.getValue() + "]"));
	}
}
