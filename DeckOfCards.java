import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {/*Class that represents a deck of cards*/
    private ArrayList<Card> cards;/*list of cards*/

    public DeckOfCards(){    /*creates a full deck*/
        cards = new ArrayList<>();/*Initialize the cards list*/
        String[] suits = {"♣","♦","♥","♠"};/*Define the 4 suits*/
        
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};  /*Define the 13 ranks*/
        for (String s : suits){ /*Loop through each suit and each rank to create all 52 cards*/
            for (int i = 0; i < ranks.length; i++){
                cards.add(new Card(s, ranks[i], i + 2));
            }
        }
    }

    public DeckOfCards(boolean empty){   /*Builds an empty deck (next to the players' distribution)*/
        cards = new ArrayList<>();
    }

    public void shuffle(){   /*Shuffle the cards*/
        Collections.shuffle(cards);
    }

    public Card draw(){   /*Returns and removes a card from the deck*/
        return cards.remove(0);
    }

    public void addToBottom(Card card){   /* adds a card to the bottom of the deck -(end of the list)*/
        cards.add(card);
    }

    public boolean isEmpty() {/*Returns true if the deck is empty (no cards left), false else*/
        return cards.isEmpty();
    }

    public int size(){/*Returns the number of cards currently in the deck*/
        return cards.size();
    }
}
