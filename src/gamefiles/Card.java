package gamefiles;

//TODO: remove the suppressor
@SuppressWarnings("unused")
public class Card {
	public Value value;
	public Suit suit;
	
	// Char codes for the 4 suits
	public final static char SPADES = 'S';       
	public final static char HEARTS = 'H';
	public final static char DIAMONDS = 'D';
	public final static char CLUBS = 'C';
    
    // Convenient arrays for translations
	private static final char[] SUIT_CODES = {'S', 'H', 'D', 'C'};
    private static final String[] SUIT_STRINGS = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private static final String[] RANK_STRINGS = {"2", "3", "4", "5", "6", "7",
    	    "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    
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
    
    
    
    
    
    
    
    
    
}
