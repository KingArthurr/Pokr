package gamefiles;

public class Card {
    
    public enum Suit {
    	SPADES(1), HEARTS(2), DIAMONDS(3), CLUBS(4); 
    	public int suit;
    	
    	Suit(int suit){
    		this.suit = suit;
    	}
    }
    
    public enum Value {
    	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14); 
    	public int value;
    	
    	Value(int value){
    		this.value = value;
    	}
    }
    
	public Value value;
	public Suit suit;
    
    public Card(Suit suit, Value value){
    	this.value = value;
    	this.suit = suit;
    }
    
    public Suit getSuit(){
    	return suit;
    }
    
    public Value getValue(){
    	return value;
    }

    public String toString() {
    	return "[" + suit.name() + "," + value.name() + "]";
    }

}
