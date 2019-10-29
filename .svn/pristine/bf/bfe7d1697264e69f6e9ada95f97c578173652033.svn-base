package de.uniwue.jpp.schafkopf.game.modes;

import de.uniwue.jpp.schafkopf.agent.SimpleAIPlayer;
import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.deck.Deck;
import de.uniwue.jpp.schafkopf.deck.Suit;
import de.uniwue.jpp.schafkopf.deck.Value;
import de.uniwue.jpp.schafkopf.game.Player;
import de.uniwue.jpp.schafkopf.game.Trick;

import javax.swing.text.html.Option;
import java.time.chrono.IsoChronology;
import java.util.*;

public class Ramsch implements GameMode {
    Suit theSuit;
    private Deck theDeck = new Deck();

    public Ramsch() {
        this.theSuit = Suit.Herz;
//        ArrayList<Card> array = theDeck.getTheDeck();
//        for (Card card : array) {
//            if (card.value().getPower() == 5 || card.value().getPower() == 4 || card.suit() == Suit.Herz) {
//                card.setTrumpf(true);
//            }
//        }
//        theDeck.setTheDeck(array);
    }


    public Deck getCards() {
        return theDeck;
    }

    @Override
    public Comparator<Card> comparator() {
        Comparator<Card> comparator = new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                if (o1.value().getPower() == 5 && o2.value().getPower() == 5) { //if both are Ober
                    return o1.suit().compareTo(o2.suit());
                } else if (o1.value().getPower() == 5) return -1;      //if the first Ober
                else if (o2.value().getPower() == 5) return 1;    //if the second is Ober
                else if (o1.value().getPower() == 4 && o2.value().getPower() == 4) { //if both are Unter
                    return o1.suit().compareTo(o2.suit());
                } else if (o1.value().getPower() == 4) return -1;      //if the first Unter
                else if (o2.value().getPower() == 4) return 1;     //if the second is Unter
                else if (o1.suit().equals(Suit.Herz) && o2.suit().equals(Suit.Herz))
                    return o1.value().compareTo(o2.value()); //if both are Herz
                else if (o1.suit().equals(Suit.Herz)) return -1;
                else if (o2.suit().equals(Suit.Herz)) return 1;
                else if (o1.value().getPower() == o2.value().getPower()) {     //if both have the same value
                    return o1.suit().compareTo(o2.suit());
                } else {
                    return o1.value().compareTo(o2.value());
                }
            }
        };

        return comparator;
    }

    @Override
    public boolean isValidPlay(Trick trick, Card card, Collection<Card> hand) {
//        return GameMode.usualRules(trick, card, hand);

        if (!trick.isEmpty()) {
            Card firstCard = trick.cards().get(0);
//            if (firstCard.value().equals(Value.ober()) || firstCard.value().equals(Value.unter()) || firstCard.suit().equals(Suit.Herz)) {            //if the first played card is a trumpf
//                boolean hatTrumpfInHand = false;
//                for (Card card1 : hand) {               //check if the player has a Trumpf in his hand
//                    if (card1.value().equals(Value.ober()) || card1.value().equals(Value.unter()) || card1.suit().equals(Suit.Herz))
//                        hatTrumpfInHand = true;
//                }
//                if (hatTrumpfInHand && !(card.value().equals(Value.ober()) || card.value().equals(Value.unter()) || card.suit().equals(Suit.Herz))) {
//                    return false;
//                } //if he has Tumpf but didn't play it
//                else return true;
//            } else {
//                boolean hasOfThisColor = false;
//                for (Card card1 : hand) {
//                    if (card1.suit().equals(firstCard.suit()) && !(firstCard.value().equals(Value.ober()) || firstCard.value().equals(Value.unter()) || firstCard.suit().equals(Suit.Herz))) {  //card has the same color and not a trumpf
//                        hasOfThisColor = true;
//                    }
//                }
//                if (hasOfThisColor && (!card.suit().equals(firstCard.suit()) || card.value().equals(Value.ober()) || card.value().equals(Value.unter()) || card.suit().equals(Suit.Herz))) { //if he has from this color but didn't play it
//                    return false;
//                } else return true;
//            }
            boolean hatTrumpfInHand = false;
            for (Card card1 : hand) {               //check if the player has a Trumpf in his hand
                if (isTrump(card1))
                    hatTrumpfInHand = true;
            }

            boolean hasOfThisColor = false;
            for (Card card1 : hand) {
                if (card1.suit().equals(firstCard.suit()) && !(isTrump(card1))) {  //card has the same color and not a trumpf
                    hasOfThisColor = true;
                }
            }
            if (isTrump(firstCard)){
                if (hatTrumpfInHand && !isTrump(card)) return false;
                else return true;
            }
            else {
                if (hasOfThisColor && (!card.suit().equals(firstCard.suit()) || isTrump(card))) return false;
                else return true;
            }

        } else return true;                       //if Trick is empty
    }

    @Override
    public Card best(Trick trick) {
//        ArrayList<Card> preTrick = new ArrayList<>();
//        for (Card card : trick.cards()) preTrick.add(card);
//        Collections.sort(preTrick, comparator());
//            ArrayList<Card> result = new ArrayList<>();
//            for (Card card: trick.cards()){
//                result.add(card);
//            }
//            result.sort(comparator());
//            return result.get(0);
        boolean trumpfGespielt = false;
        for (Card card : trick.cards()) {
            if (isTrump(card))
                trumpfGespielt = true;
        }
        if (trumpfGespielt) {
            ArrayList<Card> result = new ArrayList<>();
            for (Card card1 : trick.cards()) {
                result.add(card1);
            }
            result.sort(comparator());
            return result.get(0);
        } else {
            Card starkest = trick.cards().get(0);
            Suit temp = starkest.suit();
            for (Card card : trick.cards()) {
                if (card.suit().equals(temp) && card.value().compareTo(starkest.value()) < 0)
                    starkest = card; //if the card is bigger than strongest card
            }
            return starkest;
        }

    }

    @Override
    public Collection<Player> offensiveTeam(Map<Player, Collection<Card>> startingHands, Player declaringPlayer) {
        ArrayList<Player> result = new ArrayList<>();
        return result;
    }

    @Override
    public Collection<Player> winners(Map<Player, List<Trick>> tricks, Collection<Player> offensiveTeam) {
//        Iterator<Player> iterator = offensiveTeam.iterator();
        Player winner = new SimpleAIPlayer("blank");
        int last = 120; //Augenanzahl der Gewinner
        int next = 0;  // Augenanzahl der geprüften Spieler
        for (Map.Entry<Player, List<Trick>> myMap : tricks.entrySet()) {
            for (Trick trick : myMap.getValue()) {
                for (Card card : trick.cards()) {
                    next += card.value().getAugen();
                }
            }
            if (next < last) {
                last = next;
                winner = myMap.getKey();
            }
            next = 0;
        }
        ArrayList<Player> result = new ArrayList<>();
        result.add(winner);
        return result;
    }

    @Override
    public boolean isValidChoice(Collection<Card> hand) {
        return true;
    }

    @Override
    public boolean isTrump(Card card) {

        if (card.value().getPower() == 5 || card.value().getPower() == 4 || card.suit() == Suit.Herz){
            return true;
        }
        else {return false;}
    }


    @Override
    public String toString() {
        return "Ramsch";
    }
}
