package players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gamefiles.Card;
import gamefiles.Deck;
import util.SortCards;
import util.HandTuple;
import util.RemoveDup;

//TODO: remove warning suppressor
@SuppressWarnings("unused")
public class PokerHand extends Hand{
	
	private HandTuple<ArrayList<Card>, Integer> result;
	private static final int LOWEST_RANK = 9;
	private ArrayList<ArrayList<Card>> res;
	
	/*
	 * Plan of Attack
	 * =========================
	 * 
	 */
	public ArrayList<ArrayList<Card>> getHandCombinations(Hand hand, ArrayList<Card> table){
		ArrayList<ArrayList<Card>> result = perm(table);
		result.forEach(c -> c.addAll(hand.handCopy()));
		ArrayList<ArrayList<Card>> result2 = new ArrayList<ArrayList<Card>>();
	    for (ArrayList<Card> r : result) {   
			  result2.add(SortCards.sortByValue(r));
	    }
		return result2;
	}
	
	public ArrayList<ArrayList<Card>> perm(ArrayList<Card> in){
	    ArrayList<ArrayList<Card>> result = new ArrayList<ArrayList<Card>>();
	    for(int i = 0; i < in.size(); i++){
	      for(int j = 1; j < in.size(); j++){
	        for(int k = 2; k < in.size(); k++){
	          ArrayList<Card> temp = new ArrayList<Card>();
	          if (i != j && j != k && k != i) {
	        	  temp.add(in.get(i));
		          temp.add(in.get(j));
		          temp.add(in.get(k));
		          result.add(temp);
	          }
	        }
	      }
	    }
	    ArrayList<ArrayList<Card>> result2 = new ArrayList<ArrayList<Card>>();
	    for (ArrayList<Card> r : result) {   
			  result2.add(SortCards.sortByValue(r));
	    }
	    result = RemoveDup.removeDupsArray(result2);
	    return result;
	  }
	
	public HandTuple<ArrayList<Card>, Integer> findRank(ArrayList<Card> set){
		//Sort set before ranking
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

	private boolean dualPair(ArrayList<Card> set) {
		Boolean res = false;
		if(pair(set)){
			for(int i = 2; i < set.size() - 1; i++)
				for(int j = 3; j < set.size() - 1; j++){
					if(set.get(i).getValue()==set.get(j).getValue()){
						return true;
					}
				}
			}
		return res;
	}

	private boolean fullHouse(ArrayList<Card> set) {
		Boolean res = false;
		if(pair(set)){
			for(int i = 2; i < set.size()-1; i++){
				for(int j = 3; i < set.size()-1; j++){
					if(set.get(i).getValue()==set.get(j).getValue() && set.get(i).getValue() == set.get(j+1).getValue()){
						return true;
					}
				}
			}
		}
		return res;
	}

	public Boolean setSameSuit(ArrayList<Card> set){
		Boolean res = false;
		// TODO: write implementation
		for(int i = 1; i < set.size()-1; i++){
			if(set.get(0).getSuit() == set.get(1).getSuit()){
				res = true;
			}
			else{
				return false;
			}
		}
		return res;
	}
	
	public Boolean setSequential(ArrayList<Card> set){
		Boolean res = false;
		for(int i = 0; i < set.size()-2; i++){
			if(set.get(i).getValue().getValueInt() == (set.get(i+1).getValue().getValueInt()-1)) {
				res = true;
			}
			else{
				return false;
			}
		}
		return res;
	}
	
	public Boolean pair(ArrayList<Card> set){
		Boolean res = false;
		for(int i = 0; i < set.size() - 1; i++)
			for(int j = 1; j < set.size() - 1; j++){
				if(set.get(i).getValue()==set.get(j).getValue()){
					return true;
				}
			}
		return res;
	}
	
	public Boolean triplet(ArrayList<Card> set){
		Boolean res = false;
		for(int i = 0; i < set.size() - 1; i++)
			for(int j = 1; j < set.size() - 2; j++){
				if(set.get(i).getValue()==set.get(j).getValue() && set.get(i).getValue() == set.get(j+1).getValue()){
					return true;
				}
			}
		return res;
	}
	
	public Boolean quad(ArrayList<Card> set){
		Boolean res = false;
		for(int i = 0; i < set.size() - 1; i++)
			for(int j = 1; j < set.size() - 3; j++){
				if(set.get(i).getValue()==set.get(j).getValue() && set.get(i).getValue() == set.get(j+1).getValue() && set.get(i).getValue() == set.get(j+2).getValue()){
					return true;
				}
			}
		return res;
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
