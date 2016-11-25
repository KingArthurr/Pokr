package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import gamefiles.Card;


public class SortCards {

	public SortCards() {
		
	}
	
	   /**
	    * Sorts the hand by grouping the cards from the same suit together
	    * in increasing order of their values
	    */
	   public static ArrayList<Card> sortBySuit(ArrayList<Card> hand) {
		   //First sort by value
		   Collections.sort(hand, new Comparator<Card>() {
			   public int compare(Card o1, Card o2) {
				   return Integer.compare(o1.getValue().getValueInt(), o2.getValue().getValueInt());
			   }
		   });
		   // then sort by suit
		   Collections.sort(hand, new Comparator<Card>() {
			   public int compare(Card o1, Card o2) {
				   return o2.getSuit().compareTo(o1.getSuit());
			   }
		   });   
		   return hand;
	   }

	      
	   /**
	    * Sorts the hand by grouping cards with the same values together
	    */
	   public static ArrayList<Card> sortByValue(ArrayList<Card> hand ) {
		   //First sort by suit
		   Collections.sort(hand, new Comparator<Card>() {
			   public int compare(Card o1, Card o2) {
				   return o2.getSuit().compareTo(o1.getSuit());
			   }
		   });
		   // then sort by value
		   Collections.sort(hand, new Comparator<Card>() {
			   public int compare(Card o1, Card o2) {
				   return Integer.compare(o1.getValue().getValueInt(), o2.getValue().getValueInt());
			   }
		   });
		   
		   return hand;
	   }
	   
	   //Sorts in increasing order
	   public static ArrayList<Integer> sortByValueInt(ArrayList<Integer> list){
		   Collections.sort(list, new Comparator<Integer>() {
			   public int compare(Integer o1, Integer o2) {
				   return Integer.compare(o1, o2);
			   }
		   });
		   return list;
	   }
	   
}
