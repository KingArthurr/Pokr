package pokr.util;

import java.util.ArrayList;

import pokr.game.Card;

public class HandTuple<set, rank> {
	public ArrayList<Card> set;
	public int rank;
	
	public HandTuple(ArrayList<Card> set, int rank){
		this.set = set;
		this.rank = rank;
	}
	
	public ArrayList<Card> showSet(){
		return set;
	}
	
	public int showRank(){
		return rank;
	}
	
	public void setRank(int newRank){
		this.rank = newRank;
	}
}
