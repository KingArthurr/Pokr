package gamefiles;

import java.util.ArrayList;
import java.util.HashMap;

import players.User;
import util.HandTuple;

// Shouldn't this be in player since it's player specific?

public class Poker {	

	public User tieResolution(HashMap<User, HandTuple<ArrayList<Card>, Integer>> hands){
		ArrayList<User> users = new ArrayList<User>(hands.keySet());
		ArrayList<HandTuple<ArrayList<Card>, Integer>> hand = new ArrayList<HandTuple<ArrayList<Card>, Integer>>(hands.values());
		if(hands.keySet().size() == 1){
			return users.get(0);
		}
		int rank = hands.get(0).showRank();
		switch(rank){
			case(1):
				
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
