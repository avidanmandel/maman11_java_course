public class Card { /*class of card with fields: uit, rank, and value*/
	private String suit; /* ♣ ♦ ♥ ♠*/
	private String rank; /* "2","3",…,"10","J","Q","K","A"*/
	private int value; /* 2–14 (2=2,…,10=10,J=11,Q=12,K=13,A=14)*/

	public Card(String suit, String rank, int value) {
		this.suit = suit;
        this.rank = rank;
        this.value = value;		
	}
    public String getSuit(){ /*Returns the suit of the card*/
        return suit;
    }

    public String getRank(){/*Returns the rank of the card*/
        return rank;
    }

    public int getValue(){/*returns the value of the card*/
        return value;
    }

    public String toString(){ /*  Returns a string representation of the card, combining rank and suit*/
        return rank + suit;
    }
}    
	
