import javax.swing.JOptionPane;
import java.util.ArrayList;

public class MainCardWar{/*main class to run the Card War game */


    public static void main(String[] args){
        /* we now create and shuffle the full deck*/
        DeckOfCards fullDeck = new DeckOfCards();
        fullDeck.shuffle();

        /*now we create two empty deck for each player the deck into two players*/
        DeckOfCards player1 = new DeckOfCards(true);
        DeckOfCards player2 = new DeckOfCards(true);
        for (int i = 0; i < 52; i++) {/*split the the full deck to two player*/
            if (i % 2 == 0)
                player1.addToBottom(fullDeck.draw());
            else
                player2.addToBottom(fullDeck.draw());
        }

        int round = 1;/*to follow how many rounds are*/

        /*main game loop*/
        while (!player1.isEmpty() && !player2.isEmpty()){ /*until one of the player stay with no card's*/
            StringBuilder message = new StringBuilder("Round " + round++ + ":\n");

            ArrayList<Card> warPile = new ArrayList<>();/*Cards collected during round*/
            boolean war = false;/*this check if there is a war= tie*/

            while (true){   /*Play a single turn (or continue the war loop if needed) */
                if (player1.isEmpty() || player2.isEmpty()) break;

                Card p1Card = player1.draw();/*Player 1 draws a card*/
                Card p2Card = player2.draw();/*Player 2 draws a card*/
                warPile.add(p1Card);/*adding to the warPile*/
                warPile.add(p2Card);/*adding to the warPile*/

                message.append("Player 1 plays: ").append(p1Card.toString()).append(" (").append(p1Card.getValue()).append(")\n");
                message.append("Player 2 plays: ").append(p2Card.toString()).append(" (").append(p2Card.getValue()).append(")\n");

                /*Play by the rule that: who has the highest card win*/
                if (p1Card.getValue() > p2Card.getValue()) {
                    for (Card c : warPile) player1.addToBottom(c);/*going through each card that in the warPile*/
                    message.append("Player 1 wins this round!\n");
                    break;
                } else if (p2Card.getValue() > p1Card.getValue()) {
                    for (Card c : warPile) player2.addToBottom(c);
                    message.append("Player 2 wins this round!\n");
                    break;
                } else {
                    /* we now starting war, because they have same value*/
                    message.append("WAR!\n");
                    war = true; /*change the boolean to true*/

                    if (player1.size() < 4 || player2.size() < 4) {/*checking that both player has enough crad for war*/
                        message.append("One player doesn't have enough cards for war!\n");
                        break; /* one of the player doesnt have enough card for WAR*/
                    }

                    /* each player adds 3 more cards face down*/
                    for (int i = 0; i < 3; i++) {
                        warPile.add(player1.draw());
                        warPile.add(player2.draw());
                    }

                    /*continue the loop (next comparison)*/
                }
            }
            
            /* show how many cards each player has left after the round.*/
            message.append("\nCards left:\n");
            message.append("Player 1: ").append(player1.size()).append(" cards\n");
            message.append("Player 2: ").append(player2.size()).append(" cards\n");


            JOptionPane.showMessageDialog(null, message.toString());
        }

        /* game over, now there will be message that declare who won*/
        String result;
        if (player1.isEmpty())
            result = "Player 2 wins the game!";
        else
            result = "Player 1 wins the game!";

        JOptionPane.showMessageDialog(null, result);
    }
}
