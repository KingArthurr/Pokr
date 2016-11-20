package util;

import java.util.ArrayList;

import gamefiles.Card;

public class HandTuple<set, rank> {
	public final ArrayList<Card> set;
	public final int rank;
	
	public HandTuple(ArrayList<Card> set, int rank){
		this.set = set;
		this.rank = rank;
	}
	
	public ArrayList<Card> showSet(){
		return set;
	}
	
	public int rank(){
		return rank;
	}
}
