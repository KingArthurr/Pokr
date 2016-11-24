package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import gamefiles.Card;

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
	
	public static ArrayList<Card> removeDupsCard(ArrayList<Card> list) {
		Set<Card> hs = new HashSet<>();
	    hs.addAll(list);
	    list.clear();
	    list.addAll(hs);
	    return list;
	}
}
