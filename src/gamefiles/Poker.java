package gamefiles;

import java.util.ArrayList;

import players.Hand;
import util.HandTuple;

// Shouldn't this be in player since it's player specific?

public class Poker {

	private HandTuple<ArrayList<Card>, Integer> varName;
	private ArrayList<Card> varName2;
	
	
	public ArrayList<Card> findSet(Hand hand, Deck deck){
		// TODO: write implementation
		return varName2;
	}
	
	//TODO: use correct deck var
	public HandTuple<ArrayList<Card>, Integer> findRank(ArrayList<Card> varName2, Deck deck){
		
		
		
		return varName;
	}

}


/*
 * ===================================================================
 * 
 * 				Ranking in Poker
 * 
 * ===================================================================
 * 
 * You build a set of 5 cards, 2 of your own and 3 picked from the current deck.
 * TODO: how do you pick the 3 cards
 * 		 pick 3 cards from a set of 5 and you have 5!-2! options(??)
 * 		 
 * 
 * TODO: count ace as 1 as well as 14? (applies to straight)
 * 
 * 
 * Rank:    ||  				  Cards:						||				tie resolution				||		Hooman name
 * ==============================================================================================================================
 * 	1		||		5 sequential cards of the same suit			||		Highest card of the sequence		||	Straight flush
 *  2		||		4 same cards								||		Ranked first by set then by kicker	||  Four of a kind
 *  3		||		3 same cards with 2 different same cards	||		Ranked by triplet then by pair		||	Full house
 *  4		||		5 cards of the same suit					||		Highest card of the set				||	Flush
 *  5		||		5 sequential cards							||		Highest card of the set				||	Straight 
 *  6		||		3 same cards								||		Triplet, High-kicker, low kicker	||	Three of a Kind
 *  7		||		2 times 2 same cards						||		High pair, low pair, kicker			||	Two Pair
 *  8		||		2 same cards								||		pair, high kicker, mid kicker, 		||	Pair
 *  		||													||		low kicker							||
 *  9		||		High card									||		High card							||	High Card (lose guaranteed)
 * 
 * 
 * 
 * 
 */
