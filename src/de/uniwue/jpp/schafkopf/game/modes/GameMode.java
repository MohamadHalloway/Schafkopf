package de.uniwue.jpp.schafkopf.game.modes;

import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.deck.Deck;
import de.uniwue.jpp.schafkopf.deck.Suit;
import de.uniwue.jpp.schafkopf.game.Player;
import de.uniwue.jpp.schafkopf.game.Trick;

import java.util.*;

public interface GameMode extends TrumpStrategy {


    Comparator<Card> comparator();

    boolean isValidPlay(Trick trick, Card card, Collection<Card> hand);

    Card best(Trick trick);

    Collection<Player> offensiveTeam(Map<Player, Collection<Card>> startingHands, Player declaringPlayer);

    Collection<Player> winners(Map<Player, List<Trick>> tricks, Collection<Player> offensiveTeam);

    boolean isValidChoice(Collection<Card> hand);













    static int hasOfThisColor(Suit suit, Collection<Card> hand) {
        int count = 0;
        for (Card card : hand) {
            if (card.suit() == suit) count++;
        }
        return count;
    }

//     static boolean usualRules(Trick trick, Card card, Collection<Card> hand) {
//
//        if (trick.lead().isPresent()) {     // if somebody played a card
//
//            if (trick.cards().get(0).getTrumpf()) {         //if the first played card is a trumpf
//                if (card.getTrumpf()) return true;         //played a Trumpf
//                else {                                           //didn't play a Trumpf
//                    //looking if the player has a Trumpf in his hand
//                    boolean trumpfInTheHand = false;
//                    for (Card card1 : hand) {
//                        if (card1.getTrumpf()) trumpfInTheHand = true;
//                        break;
//                    }
//                    if (trumpfInTheHand == true) return false;   // if the player has Trumpf but didn't play it
//                    else {                                      //if he has no Trumpf
//                        return true;
//                    }
//                }
//            } else {                                                  //neither Trumpf nor the color of the called Ass
//                if (GameMode.hasOfThisColor(trick.cards().get(0).suit(), hand) > 0) { //if the player has this color in his hand
//                    if (trick.cards().get(0).suit() == card.suit()) return true; //did he put the right color?
//                    else return false;
//                } else return true;                                   //if the player has no card of the played color
//
//            }
//        } else return true;                       //if nobody played yet
//
//    }


//    static Card usualBest(Trick trick) {
//        if (trick.lead().isPresent()) {              //if the trick is not empty
//            Card strongest = trick.cards().get(0);
//            Suit firstSuit = trick.cards().get(0).suit();
//
//            for (Card card : trick.cards()) {
//                if (strongest.getTrumpf()) {               //if the strongest card is a Trumpf
//                    if (card.getTrumpf() && strongest.suit().compareTo(card.suit()) > 0)
//                        strongest = card;           //if this card is a Trumpf and stronger the strongest
//                } else {                          // if the strongest is not a Trumpf
//                    if (card.getTrumpf()) strongest = card;
//                    else {
//                        if (card.suit() == firstSuit && strongest.value().compareTo(card.value()) > 0) strongest = card;
//                    }
//                }
//            }
//            return strongest;
//        } else return null;
//    }

    static Collection<Player> usualWinners(Map<Player, List<Trick>> tricks, Collection<Player> offensiveTeam) {
        //declearing the offensiveTeam
        Iterator<Player> iterator = offensiveTeam.iterator();
        Player off1 = iterator.next();
        Player off2 = iterator.next();

        //declearing the deffensiveTeam
        ArrayList<Player> deffensiveTeam = new ArrayList<>();
        for (Map.Entry<Player, List<Trick>> myMap : tricks.entrySet()) {
            if (!myMap.getKey().equals(off1) && !myMap.getKey().equals(off2)) deffensiveTeam.add(myMap.getKey());
        }
        //here fängt es an
        int off = 0;
        for (Map.Entry<Player, List<Trick>> myMap : tricks.entrySet()) {
            for (Trick trick : myMap.getValue()) {
                for (Card card : trick.cards()) {
                    if (myMap.getKey().equals(off1) || myMap.getKey().equals(off2)) { //if the player is an offensive player
                        off += card.value().getAugen();
                    }
                }
            }
        }
        if (60 >= off) return deffensiveTeam;
        else return offensiveTeam;
    }

//    static Comparator<Card> usualComparator() {
//        Comparator<Card> comperator = new Comparator<>() {
//            public int compare(Card o1, Card o2) {
////                if (o1.value().getPower() == 5 && o2.value().getPower() == 5) { //if both are Ober
////                    return o1.suit().compareTo(o2.suit());
////                } else if (o1.value().getPower() == 5) return -1;      //if the first Ober
////                else if (o2.value().getPower() == 5) return 1;    //if the second is Ober
////                else if (o1.value().getPower() == 4 && o2.value().getPower() == 4) { //if both are Unter
////                    return o1.suit().compareTo(o2.suit());
////                } else if (o1.value().getPower() == 4) return -1;      //if the first Unter
////                else if (o2.value().getPower() == 4) return 1;     //if the second is Unter
////                else if (o1.suit().equals(Suit.Herz) && o2.suit().equals(Suit.Herz))
////                    return o1.value().compareTo(o2.value()); //if both are Herz
////                else if (o1.suit().equals(Suit.Herz)) return -1;
////                else if (o2.suit().equals(Suit.Herz)) return 1;
////                else if (o1.value().getPower() == o2.value().getPower()) {     //if both have the same value
////                    return o1.suit().compareTo(o2.suit());
////                } else {
////                    return o1.value().compareTo(o2.value());
////                }
//                if (o1.getTrumpf() && o2.getTrumpf()) { //if both are Trumpf
//                    if (o1.value().equals(o2.value())) {
//                        return o1.suit().compareTo(o2.suit());
//                    } else return o1.value().compareTo(o2.value());
////                    if (o1.suit().equals(o2.suit())) {
////                        return o1.value().compareTo(o2.value());
////                    } else return o1.suit().compareTo(o2.suit());
////                    return o1.suit().compareTo(o2.suit());
//                } else if (o1.getTrumpf() || o2.getTrumpf()) { //if JUST one of them is Trumpf
//                    if (o1.getTrumpf()) return -1;
//                    else return 1;
//                } else {                              // if none of both cards is Trumpf
//                    if (o1.value().equals(o2.value())) {
//                        return o1.suit().compareTo(o2.suit());
//                    } else return o1.value().compareTo(o2.value());
////                    if (o1.suit().equals(o2.suit())) {
////                        return o1.value().compareTo(o2.value());
////                    } else return o1.suit().compareTo(o2.suit());
//                }
//            }
//        };
//        return comperator;
//    }

}
