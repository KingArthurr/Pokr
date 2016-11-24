package gamefiles;

import java.util.ArrayList;
import java.util.HashMap;

import players.User;
import util.HandTuple;

// Shouldn't this be in player since it's player specific?

public class Poker {	
	
	ArrayList<User> users;	
	ArrayList<Card> communitycards;
	Deck deck;
	
	public Poker() {
		users = new ArrayList<User>();
		deck = new Deck();
		startGame();
	}
	
	public void startGame() {
		
	}
	
	public void dealCards() {
		users.forEach(c -> {
			c.giveCard(deck.dealCard()); 
			c.giveCard(deck.dealCard());
			});
	}
	
	public void getCommunityCards(int amount) {
		for (int i = 0 ; i < amount; i++ ) {
			communitycards.add(deck.dealCard());
		}
	}

	public User tieResolution(HashMap<User, HandTuple<ArrayList<Card>, Integer>> hands){
		//Split the hashmap so we can work with it
		// We'll compare the hands and then ask which key fits the hand (find user by hand)
		ArrayList<User> usersTie = new ArrayList<User>(hands.keySet());
		ArrayList<HandTuple<ArrayList<Card>, Integer>> hand = new ArrayList<HandTuple<ArrayList<Card>, Integer>>(hands.values());
		int highCardVal;
		if(hands.keySet().size() == 1){
			return usersTie.get(0);
		}
		int rank = hands.get(0).showRank();
		switch(rank){
			case(1):
				highCardVal = hand.get(0).showSet().get(4).getValue().getValueInt();
				for(int i = 1; i < hand.size() - 1; i++){
					if(hand.get(i-1).showSet().get(4).getValue().getValueInt() < hand.get(i).showSet().get(4).getValue().getValueInt()){
						highCardVal = hand.get(i).showSet().get(4).getValue().getValueInt();
					}
				
				}
			case(2):
				
			case(3):
				
			case(4):
				
			case(5):
				
			case(6):
				
			case(7):
				
			case(8):
				
			case(9):		
		}
		User user = new User("Steen");
		return user;
	}

	

}
