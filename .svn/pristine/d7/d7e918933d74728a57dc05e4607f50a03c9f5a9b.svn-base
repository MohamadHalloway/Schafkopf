package de.uniwue.jpp.schafkopf.deck;

import java.util.Objects;

public class Card {
    private Suit suit;
    private Value value;


    public Card(Suit suit, Value value) {
        this.value = value;
        this.suit = suit;
    }

    /*---------------------------------------------------------------------------------------------------------*/
    //Getters and Setters


    public Suit suit() {
        return this.suit;

    }

    public Value value() {
        return this.value;
    }

    /*---------------------------------------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return suit.name().substring(0, 1) + value.getDarstellung();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && value.getPower() == card.value.getPower();
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value.getWert());
    }

//    public int strongest(Card card){
//        if (this.getTrumpf() && card.getTrumpf()) { //if both are Trumpf
//            if (this.value().equals(card.value())) {
//                return this.suit().compareTo(card.suit());
//            } else return this.value().compareTo(card.value());
////                    if (o1.suit().equals(o2.suit())) {
////                        return o1.value().compareTo(o2.value());
////                    } else return o1.suit().compareTo(o2.suit());
////                    return o1.suit().compareTo(o2.suit());
//        } else if (this.getTrumpf() || card.getTrumpf()) { //if JUST one of them is Trumpf
//            if (this.getTrumpf()) return -1;
//            else return 1;
//        } else {                              // if none of both cards is Trumpf
//            if (this.value().equals(card.value())) {
//                return this.suit().compareTo(card.suit());
//            } else return this.value().compareTo(card.value());
////                    if (o1.suit().equals(o2.suit())) {
////                        return o1.value().compareTo(o2.value());
////                    } else return o1.suit().compareTo(o2.suit());
//        }
//    }
}
