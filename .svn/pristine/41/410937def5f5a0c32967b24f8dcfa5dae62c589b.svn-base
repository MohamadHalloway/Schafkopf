package de.uniwue.jpp.schafkopf.game.modes;

import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.deck.Deck;
import de.uniwue.jpp.schafkopf.deck.Suit;
import de.uniwue.jpp.schafkopf.deck.Value;
import de.uniwue.jpp.schafkopf.game.Player;
import de.uniwue.jpp.schafkopf.game.Trick;

import java.util.*;

public class ValueSolo implements GameMode {

    private Value value;
    private Deck theDeck = new Deck();

    public ValueSolo(Value value) {
        this.value = value;
//        ArrayList<Card> arrayList = theDeck.getTheDeck();
//        for (Card card : arrayList) {
//            if (card.value().equals(value)) {
//                card.setTrumpf(true);
//            }
//        }
//        theDeck.setTheDeck(arrayList);
    }


    public Deck getCards() {
        return theDeck;
    }

    @Override
    public Comparator<Card> comparator() {
//        Comparator<Card> comparator = new Comparator<Card>() {
//            @Override
//            public int compare(Card o1, Card o2) {
//                if (o1.getTrumpf() && o2.getTrumpf()) {      //if both are Trumpf
//                    return o1.suit().compareTo(o2.suit());
//                } else if (o1.getTrumpf() || o2.getTrumpf()) { //if JUST one of them is Trumpf
//                    if (o1.getTrumpf()) return -1;
//                    else return 1;
//                } else {                              // if none of both cards is Trumpf
//                    if (o1.value().equals(o2.value())) {
//                        return o1.suit().compareTo(o2.suit());
//                    } else return o1.value().compareTo(o2.value());
//                }
//            }
//        };

        Comparator<Card> comparator = new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                if (o1.value().equals(value) && o2.value().equals(value)) {  //wenn beide Trumpf
                    return o1.suit().compareTo(o2.suit());
                } else if (o1.value().equals(value) || o2.value().equals(value)) {
                    if (o1.value().equals(value)) return -1;
                    else return 1;
                } else {
                    if (o1.value().equals(o2.value())) {           //wenn beide den gleichen Wert haben
                        return o1.suit().compareTo(o2.suit());
                    } else return o1.value().compareTo(o2.value());
                }
            }
        };
        return comparator;
    }

    @Override
    public boolean isValidPlay(Trick trick, Card card, Collection<Card> hand) {
//        if (trick.lead().isPresent()) { // if somebody played a card
//            return GameMode.usualRules(trick, card, hand);
//        } else return true;                                               //if nobody played yet


        if (!trick.isEmpty()) {
            Card firstCard = trick.cards().get(0);
            if (firstCard.value().equals(value)) {            //if the first played card is a trumpf
                boolean hatTrumpfInHand = false;
                for (Card card1 : hand) {               //check if the player has a Trumpf in his hand
                    if (card1.value().equals(value)) hatTrumpfInHand = true;
                }
                if (hatTrumpfInHand && !card.value().equals(value)) {   //if he has Tumpf but didn't play it
                    return false;
                } else return true;
            } else {
                boolean hasOfThisColor = false;
                for (Card card1 : hand) {
                    if (card1.suit().equals(firstCard.suit()) && !card1.value().equals(value)) { //card has the same color and not a trumpf
                        hasOfThisColor = true;
                    }
                }
                if (hasOfThisColor && (!card.suit().equals(firstCard.suit()) || card.value().equals(value))) { //if he has validcard but played trumpf or another color
                    return false;
                } //he has from this color but didn't play it
                else return true;
            }
        } else return true;                       //if Trick is empty
    }

    @Override
    public Card best(Trick trick) {
//        return GameMode.usualBest(trick);
        //looking if someone played a Trumpf
        boolean trumpfGespielt = false;
        for (Card card : trick.cards()) {
            if (card.value().equals(value)) trumpfGespielt = true;
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

        if (card.value().equals(value)) {
            return true;
        } else return false;
    }


    @Override
    public String toString() {
        return value.getDarstellung() + "-Solo";
    }
}
