package gamefiles;

import java.util.ArrayList;
import java.util.HashMap;

import players.User;
import util.HandTuple;

// Shouldn't this be in player since it's player specific?

public class Poker {

	private HandTuple<ArrayList<Card>, Integer> result;
	private static final int LOWEST_RANK = 9;
	
	public HandTuple<ArrayList<Card>, Integer> findRank(ArrayList<Card> set){
		result.setRank(LOWEST_RANK);
		if(setSameSuit(set)){
			if(setSequential(set)){
				result.setRank(1);
				return result;
			}
			result.setRank(4);
			return result;
		}
		else if(setSequential(set)){
			result.setRank(5);
			return result;
		}
		else if(pair(set)){
			if(triplet(set)){
				if(quad(set)){
					result.setRank(2);
					return result;
				}
				else if(fullHouse(set)){
					result.setRank(3);
					return result;
				}
				result.setRank(6);
				return result;
			}
			else if(fullHouse(set)){
				result.setRank(3);
				return result;
			}
			else if(dualPair(set)){
				result.setRank(7);
				return result;
			}
			result.setRank(8);
			return result;
		}
		return result;
	}

	private boolean dualPair(ArrayList<Card> set2) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean fullHouse(ArrayList<Card> set2) {
		// TODO Auto-generated method stub
		return false;
	}

	public Boolean setSameSuit(ArrayList<Card> set){
		Boolean res = false;
		// TODO: write implementation
		if(set.get(0).getSuit() == set.get(1).getSuit()){
			res = true;
		}
		return res;
	}
	
	public Boolean setSequential(ArrayList<Card> set){
		Boolean res = false;
		// TODO: write implementation
		return res;
	}
	
	public Boolean pair(ArrayList<Card> set){
		Boolean res = false;
		// TODO: write implementation
		return res;
	}
	
	public Boolean triplet(ArrayList<Card> set){
		Boolean res = false;
		// TODO: write implementation
		return res;
	}
	
	public Boolean quad(ArrayList<Card> set){
		Boolean res = false;
		// TODO: write implementation
		return res;
	}
	
	
	
	public User tieResolution(HashMap<User, ArrayList<Card>> hands){
		
		User user = new User("Steen");
		return user;
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
