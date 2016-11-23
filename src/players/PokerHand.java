package players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gamefiles.Card;
import gamefiles.Deck;
import util.SortCards;
import util.RemoveDup;

//TODO: remove warning suppressor
@SuppressWarnings("unused")
public class PokerHand extends Hand{
	
	
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
	    result = RemoveDup.removeDups(result2);
	    return result;
	  }
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		PokerHand hand = new PokerHand();
		hand.addCard(deck.dealCard());
		hand.addCard(deck.dealCard());
		ArrayList<Card> table = new ArrayList<Card>();
		table.add(deck.dealCard());
		table.add(deck.dealCard());
		table.add(deck.dealCard());
		table.add(deck.dealCard());
		table.add(deck.dealCard());
		System.out.println(table);
		System.out.println(hand.getHandCombinations(hand, table).size());
		for (ArrayList<Card> list : hand.getHandCombinations(hand, table)) {
			System.out.println(list);
		}
	}
		

}
