package pokr.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import pokr.game.Card;
import pokr.player.HumanPlayer;

public class RemoveDup {

	public RemoveDup() {
		
	}
	
	public static ArrayList<ArrayList<Card>> removeDupsArray(ArrayList<ArrayList<Card>> list) {
	    Set<ArrayList<Card>> hs = new HashSet<>();
	    hs.addAll(list);
	    list.clear();
	    list.addAll(hs);
	    return list;
	}
	

	public static ArrayList<HumanPlayer> removeDupsUser(ArrayList<HumanPlayer> list){
		Set<HumanPlayer> hs = new HashSet<>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		return list;
	}

	public static ArrayList<Card> removeDupsCard(ArrayList<Card> list) {
		Set<Card> hs = new HashSet<>();
	    hs.addAll(list);
	    list.clear();
	    list.addAll(hs);
	    return list;
	}
	
	public static Boolean containsDups(ArrayList<Integer> list){
		for(int i = 1; i< list.size()-1; i++){
			if(list.get(i-1)==list.get(i)){
				return true;
			}
		}
		return false;
	}
}
