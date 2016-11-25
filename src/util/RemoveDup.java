package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import gamefiles.Card;
import players.User;

public class RemoveDup {

	public RemoveDup() {
		
	}
	
	public static ArrayList<ArrayList<Card>> removeDups(ArrayList<ArrayList<Card>> list) {
	    Set<ArrayList<Card>> hs = new HashSet<>();
	    hs.addAll(list);
	    list.clear();
	    list.addAll(hs);
	    return list;
	}
	
	public static ArrayList<User> removeDupsUser(ArrayList<User> list){
		Set<User> hs = new HashSet<>();
	    hs.addAll(list);
	    list.clear();
	    list.addAll(hs);
	    return list;
	}
}
