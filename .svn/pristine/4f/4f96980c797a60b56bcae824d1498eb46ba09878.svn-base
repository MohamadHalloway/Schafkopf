package de.uniwue.jpp.schafkopf.deck;

import java.util.*;
import java.util.function.Consumer;

public class Deck implements Iterable<Card> {

    private ArrayList<Card> TheDeck = new ArrayList<>();


    public Deck() {
        Suit[] suits = Suit.values();
        for (Suit suit : suits) {
            Card card = new Card(suit, Value.ace());
            TheDeck.add(card);
            Card card2 = new Card(suit, Value.king());
            TheDeck.add(card2);
            Card card3 = new Card(suit, Value.ober());
            TheDeck.add(card3);
            Card card4 = new Card(suit, Value.unter());
            TheDeck.add(card4);
            for (int i = 10; i > 6; i--) {
                Card card5 = new Card(suit, Value.basic(i));
                TheDeck.add(card5);
            }
        }
    }

    public ArrayList<Card> getTheDeck() {
        return TheDeck;
    }

    @Override
    public Iterator<Card> iterator() {
        Collections.shuffle(TheDeck);
        Iterator<Card> iterator = TheDeck.iterator();
        return iterator;
    }

    public void setTheDeck(ArrayList<Card> theDeck) {
        this.TheDeck = theDeck;
    }
    //    @Override
//    public void forEach(Consumer<? super Card> action) {
//
//    }

//    @Override
//    public Spliterator<Card> spliterator() {
//        return null;
//    }
}
