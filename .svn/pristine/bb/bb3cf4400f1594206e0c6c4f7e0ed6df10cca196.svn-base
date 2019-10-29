package de.uniwue.jpp.schafkopf.game.modes;

import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.deck.Deck;
import de.uniwue.jpp.schafkopf.deck.Suit;
import de.uniwue.jpp.schafkopf.deck.Value;
import de.uniwue.jpp.schafkopf.game.Game;
import de.uniwue.jpp.schafkopf.game.Player;
import de.uniwue.jpp.schafkopf.game.Trick;

import java.util.*;

public class SuitSolo implements GameMode {

    private Suit theSuit;
    private Deck theDeck = new Deck();

    public SuitSolo(Suit theSuit) {
        this.theSuit = theSuit;
//        ArrayList<Card> arrayList = theDeck.getTheDeck();
//        for (Card card : arrayList) {
//            if (card.suit().equals(theSuit)) card.setTrumpf(true);
//            if (card.value().getPower() == 5 || card.value().getPower() == 4) card.setTrumpf(true);
//        }
//        theDeck.setTheDeck(arrayList);
    }


    public Deck getCards() {
        return theDeck;
    }

    @Override
    public Comparator<Card> comparator() {
        Comparator<Card> comperator = new Comparator<Card>() {
            public int compare(Card o1, Card o2) {
                if (o1.value().getPower() == 5 && o2.value().getPower() == 5) { //if both are Ober
                    return o1.suit().compareTo(o2.suit());
                } else if (o1.value().getPower() == 5) return -1;      //if the first Ober
                else if (o2.value().getPower() == 5) return 1;    //if the second is Ober
                else if (o1.value().getPower() == 4 && o2.value().getPower() == 4) { //if both are Unter
                    return o1.suit().compareTo(o2.suit());
                } else if (o1.value().getPower() == 4) return -1;      //if the first Unter
                else if (o2.value().getPower() == 4) return 1;     //if the second is Unter
                else if (o1.suit().equals(theSuit) && o2.suit().equals(theSuit))
                    return o1.value().compareTo(o2.value()); //if both are Herz
                else if (o1.suit().equals(theSuit)) return -1;
                else if (o2.suit().equals(theSuit)) return 1;
                else if (o1.value().getPower() == o2.value().getPower()) {     //if both have the same value
                    return o1.suit().compareTo(o2.suit());
                } else {
                    return o1.value().compareTo(o2.value());
                }
            }
        };
        return comperator;
    }

    @Override
    public boolean isValidPlay(Trick trick, Card card, Collection<Card> hand) {
//        if (trick.lead().isPresent()) { // if somebody played a card
//            return GameMode.usualRules(trick, card, hand);
//        } else return true;                                               //if nobody played yet


        if (!trick.isEmpty()) {
            Card firstCard = trick.cards().get(0);
            if (isTrump(firstCard)) {            //if the first played card is a trumpf
                boolean hatTrumpfInHand = false;
                for (Card card1 : hand) {               //check if the player has a Trumpf in his hand
                    if (isTrump(card1))
                        hatTrumpfInHand = true;
                }
                if (hatTrumpfInHand && !(isTrump(card))) { //if he has Tumpf but didn't play it
                    return false;
                } else return true;        //if he doesn't have a trumpf
            } else {           //firstcard is no Trumpf
                boolean hasOfThisColor = false;
                for (Card card1 : hand) {
                    if (card1.suit().equals(firstCard.suit()) && !(isTrump(card1))) { //card has the same color and not a trumpf
                        hasOfThisColor = true;
                    }
                }
                if (hasOfThisColor && (!card.suit().equals(firstCard.suit()) || isTrump(card))) {//if he has from this color but didn't play
                    return false;
                } //he has from this color but didn't play it
                else return true;
            }
        } else return true;                       //if Trick is empty
    }

    @Override
    public Card best(Trick trick) {
//        return GameMode.usualBest(trick);
//        ArrayList<Card> result = new ArrayList<>();
//        for (Card card: trick.cards()){
//            result.add(card);
//        }
//        result.sort(comparator());
//        return result.get(0);


        boolean trumpfGespielt = false;
        for (Card card : trick.cards()) {
            if (card.value().equals(Value.ober()) || card.value().equals(Value.unter()) || card.suit().equals(theSuit))
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
        result.add(declaringPlayer);
        return result;
    }

    @Override
    public Collection<Player> winners(Map<Player, List<Trick>> tricks, Collection<Player> offensiveTeam) {

        //declearing the offensiveTeam
        Iterator<Player> iterator = offensiveTeam.iterator();
        Player off1 = iterator.next();

        //declearing the deffensiveTeam
        ArrayList<Player> deffensiveTeam = new ArrayList<>();
        for (Map.Entry<Player, List<Trick>> myMap : tricks.entrySet()) {
            if (!myMap.getKey().equals(off1)) deffensiveTeam.add(myMap.getKey());
        }
        //here fängt es an
        int off = 0;
        for (Map.Entry<Player, List<Trick>> myMap : tricks.entrySet()) {
            for (Trick trick : myMap.getValue()) {
                for (Card card : trick.cards()) {
                    if (myMap.getKey().equals(off1)) { //if the player is an offensive player
                        off += card.value().getAugen();
                    }
                }
            }
        }
        if (off <= 60) return deffensiveTeam;
        else return offensiveTeam;

    }

    @Override
    public boolean isValidChoice(Collection<Card> hand) {
        return true;
    }

    @Override
    public boolean isTrump(Card card) {

        if (card.value().getPower() == 5 || card.value().getPower() == 4 || card.suit().equals(theSuit)) {
            return true;
        } else {
            return false;
        }
    }

    public Suit getTheSuit() {
        return theSuit;
    }

    @Override
    public String toString() {
        return theSuit.toString() + "-Solo";
    }
}
