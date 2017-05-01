package pokr.game;

import java.util.ArrayList;
import java.util.HashMap;

import pokr.player.HumanPlayer;
import pokr.util.HandTuple;
import pokr.util.RemoveDup;
import pokr.util.SortCards;

// Shouldn't this be in player since it's player specific?
//TODO redundant class?

public class Poker_Obsolete_ {	
	
	ArrayList<HumanPlayer> users;	
	ArrayList<Card> communitycards;
	Deck deck;
	
	public Poker_Obsolete_() {
		users = new ArrayList<HumanPlayer>();
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

	public ArrayList<HumanPlayer> tieResolution(HashMap<HumanPlayer, HandTuple<ArrayList<Card>, Integer>> hands){
		//Split the hashmap so we can work with it
		// We'll compare the hands and then ask which key fits the hand (find user by hand)
		ArrayList<HumanPlayer> usersTie = new ArrayList<HumanPlayer>(hands.keySet());
		ArrayList<HandTuple<ArrayList<Card>, Integer>> hand = new ArrayList<HandTuple<ArrayList<Card>, Integer>>(hands.values());
		ArrayList<HumanPlayer> winners = new ArrayList<HumanPlayer>();
		int highCardVal;
		ArrayList<Integer> highCardVals = new ArrayList<Integer>();
		int kicker;
		if(hands.keySet().size() == 1){
			winners.add(usersTie.get(0));
			return winners;
		}
		
		
		
		int rank = hands.get(0).showRank();
		switch(rank){
			case(1):
				//Rank 1 is straight flush, so we check based on high card
				highCardVal = hand.get(0).showSet().get(4).getValue().getValueInt();
				for(int i = 1; i < hand.size() - 1; i++){
					if(hand.get(i-1).showSet().get(4).getValue().getValueInt() < hand.get(i).showSet().get(4).getValue().getValueInt()){
						highCardVal = hand.get(i).showSet().get(4).getValue().getValueInt();
					}
				}
				for(int j = 0; j < hand.size() - 1; j++){
					if(hands.get(usersTie.get(j)).showSet().get(0).getValue().getValueInt()==(highCardVal)){
						winners.add(usersTie.get(j));
					}
				}
			case(2):
				//Rank 2 is a four of kind which is ranked first by it's set then by the kicker
				//Hand will look like this: <four of a kind>,<kicker> or <kicker>,<four of a kind>
				//Construct a list of Four of a kinds
				for(int i = 1; i < hand.size(); i++){
					if(hand.get(1).showSet().get(0)==hand.get(1).showSet().get(1)){
						highCardVals.add(hand.get(1).showSet().get(0).getValue().getValueInt());
					}
					else{
						highCardVals.add(hand.get(0).showSet().get(1).getValue().getValueInt());
					}
				}
				SortCards.sortByValueInt(highCardVals);
				//and now find the winner between those cards
			
			case(3):
				
			case(4):
				
			case(5):
				
			case(6):
				
			case(7):
				
			case(8):
				
			case(9):		
		}
		for(int i = 0; i<hand.size()-2; i++){
			for(int j = 1; j< hand.size()-1; j++){
				if(hand.get(i)==hand.get(j)){
					winners.add(usersTie.get(i));
					winners.add(usersTie.get(j));
				}
			}
		}
		RemoveDup.removeDupsUser(winners);
		return winners;
	}
}
