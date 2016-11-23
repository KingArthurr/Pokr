package players;

import java.util.ArrayList;
import java.util.List;

import gamefiles.Card;

public class Hand {
	private List<Card> hand;
	
	public Hand(){
		hand = new ArrayList<Card>();
	}
	
	public void clear(){
		hand.clear();
	}
	
	public void addCard(Card c){
		hand.add(c);
	}
	
	public void removeCard(Card c){
		hand.remove(c);
	}
	
	public void removeCard(int pos){
		hand.remove(pos);
	}
	
	public int getCardCount(){
		return hand.size();
	}
	
	public Card getCard(int pos){
		if(hand.get(pos)==null){
			return null;
		}
		else{
			return hand.get(pos);
		}
	}
	
	public ArrayList<Card> handCopy(){
		ArrayList<Card> copy = new ArrayList<Card>(hand);
		return copy;
	}
	
	public String toString(){
		return hand.toString();
	}
	
	
	
	
	
	
	
}
