package de.uniwue.jpp.schafkopf.game.modes;

import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.deck.Deck;
import de.uniwue.jpp.schafkopf.deck.Suit;
import de.uniwue.jpp.schafkopf.deck.Value;
import de.uniwue.jpp.schafkopf.game.Game;
import de.uniwue.jpp.schafkopf.game.Player;
import de.uniwue.jpp.schafkopf.game.Trick;

import java.util.*;

public class Calling implements GameMode {
    private Card Ass;
    private Deck theDeck = new Deck();

    public Calling(Suit suit) {
        if (suit.equals(Suit.Herz)) throw new IllegalArgumentException();
        this.Ass = new Card(suit, Value.ace());
//        ArrayList<Card> array = theDeck.getTheDeck();
//        for (Card card : array) {
//            if (card.value().getPower() == 5 || card.value().getPower() == 4 || card.suit() == Suit.Herz) {
//                card.setTrumpf(true);
//            }
//        }
//        theDeck.setTheDeck(array);
    }

    public Card getAss() {
        return Ass;
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
        List<Card> tempHand = new ArrayList<>(hand);
        if (!trick.isEmpty()) { // if somebody played a card
            Card firstCard = trick.cards().get(0);
//            //lets check if the person have the Ass of the asked color and count how many of this color he has
//            boolean hasTheAss = false;
//            int count = 0;
//            for (Card card1 : hand) {
//                if (card1.equals(Ass)) hasTheAss = true;
//                if (card1.suit() == Ass.suit() && isTrump(card1) == false && !card1.equals(Ass)) count++;
//            }
//
//            if (hasTheAss) { //if he has the Ass and must play it
//
//                if (count < 3) {                                 //if the player has less than 3 cards of the same color
//
//                    if (card.equals(Ass)) return true;
//                    else return false;
//                } else return true;
//                //finished the Ass-Problem
//
//            } else if (firstCard.value().equals(Value.ober()) || firstCard.value().equals(Value.unter()) || firstCard.suit().equals(Suit.Herz)) {            //if the first played card is a trumpf
//                boolean hatTrumpfInHand = false;
//                for (Card card1 : hand) {               //check if the player has a Trumpf in his hand
//                    if (card1.value().equals(Value.ober()) || card1.value().equals(Value.unter()) || card1.suit().equals(Suit.Herz))
//                        hatTrumpfInHand = true;
//                }
//                if (hatTrumpfInHand && !(card.value().equals(Value.ober()) || card.value().equals(Value.unter()) || card.suit().equals(Suit.Herz))) {//if he has Tumpf but didn't play it
//                    return false;
//                } else return true;
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
//
//            }
            boolean hasTheAss = false;
            int count = 0;
            for (Card card1 : hand) {
                if (card1.equals(Ass)) hasTheAss = true;
                if (card1.suit() == Ass.suit() && isTrump(card1) == false && !card1.equals(Ass)) count++;
            }
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
            if (isTrump(firstCard)) {
//                if (hatTrumpfInHand && !isTrump(card)) return false;
//                else {
//                    if (card.equals(Ass)) return false;
//                    else return true;
//                }
                if (isTrump(card)) return true;
                else if (!hatTrumpfInHand && !card.equals(Ass)) return true;
                else if (hand.size() == 1) return true; //if he doesn't have a choice but to play the Ass
                else return false;
            } else {          //firstCard is   NOT    a Trumpf
                if (firstCard.suit().equals(Ass.suit())&& hasTheAss && count < 3 && !card.equals(Ass)) return false;        //assColor played and he has the Ass but didn't play it
                else if (hasOfThisColor && (!card.suit().equals(firstCard.suit()) || isTrump(card))) return false;
                else if (!hasOfThisColor && card.equals(Ass) && hand.size() > 1) return false;
                else return true;
            }
        } else {    //if Trick is empty
            return true;
        }
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

        //looking if someone played a Trumpf
        boolean trumpfGespielt = false;
        for (Card card : trick.cards()) {
            if (card.value().equals(Value.ober()) || card.value().equals(Value.unter()) || card.suit().equals(Suit.Herz))
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
    public Collection<Player> offensiveTeam(Map<Player, Collection<Card>> startingHands, Player
            declaringPlayer) {
        ArrayList<Player> res = new ArrayList<>();
        res.add(declaringPlayer);
        for (Map.Entry<Player, Collection<Card>> myMap : startingHands.entrySet()) {
            if (!declaringPlayer.equals(myMap.getKey())) { //just to skip the declaringPlayer
                for (Card card : myMap.getValue()) {  //for every card in the players hand
                    if (card.equals(Ass)) res.add(myMap.getKey()); //add the player who has the Ass to the list
                }
            }
        }
        return res;
    }

    @Override
    public Collection<Player> winners(Map<Player, List<Trick>> tricks, Collection<Player> offensiveTeam) {
        return GameMode.usualWinners(tricks, offensiveTeam);
    }

    @Override
    public boolean isValidChoice(Collection<Card> hand) {
        boolean a = true;   //has the Ass in the Hand
        boolean b = false; //has min. one card from this color
        int count = 0; //number of the cards if this color
        boolean c = false;
        for (Card card : hand) {     //checking if the player has the Ass in the hand
            if (Ass.equals(card)) {
                a = false;
                break;
            }

        }
        for (Card card2 : hand) {        // checking if the player has min. one card of this color in his hand
            if (Ass.suit().equals(card2.suit()) && card2.value().getPower() != 4 && card2.value().getPower() != 5) { //Unter and Ober are also not allowed
                b = true;
            }
        }

        return a && b;
    }

    @Override
    public boolean isTrump(Card card) {
        if (card.value().getPower() == 5 || card.value().getPower() == 4 || card.suit() == Suit.Herz) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "Calling " + Ass;
    }


}
