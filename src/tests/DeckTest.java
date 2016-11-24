package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gamefiles.Deck;
import util.RemoveDup;

public class DeckTest {

	Deck deck;
	
	@Before
	public void setUp() throws Exception {
		deck = new Deck();
	}

	@Test
	public void testSetup() {
		assertEquals("Deck size is not 52", deck.getDeck().size(), 52);
		assertEquals("Duplicates in Deck", RemoveDup.removeDupsCard(deck.getDeck()).size(), 52);
	}
	
	@Test
	public void testShuffle() {
		String cards = deck.getDeck().toString();
		deck.shuffle();
		assertNotEquals("Cards not shuffled", cards, deck.getDeck().toString());
		assertEquals("Deck size is not 52", deck.getDeck().size(), 52);
		assertEquals("Duplicates in Deck", RemoveDup.removeDupsCard(deck.getDeck()).size(), 52);
	}
	
	@Test
	public void testDealCard() {
		assertFalse(deck.dealCard().equals(null));
		assertEquals(deck.getDeck().size(), 51);
	}
	
	@Test
	public void testDealCardEmpty() {
		for(int i = 0; i < 52; i++) {
			deck.dealCard();
		}
		assertTrue(deck.getDeck().isEmpty());
		assertFalse(deck.dealCard().equals(null));
		assertEquals(deck.getDeck().size(), 51);
	}
	
	@Test
	public void testReset() {
		String cards = deck.getDeck().toString();
		deck.reset();
		assertNotEquals("Deck not resetted", cards, deck.getDeck().toString());
		assertEquals("Deck size is not 52", deck.getDeck().size(), 52);
		assertEquals("Duplicates in Deck", RemoveDup.removeDupsCard(deck.getDeck()).size(), 52);
	}

	@Test
	public void testGetDeck() {
		assertNotEquals(deck.getDeck(), null);
		//TODO??
		assertEquals(deck.getDeck().size(), 52);
	}
}
