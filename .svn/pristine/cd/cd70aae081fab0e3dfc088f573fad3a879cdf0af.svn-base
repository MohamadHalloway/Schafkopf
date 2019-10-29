package de.uniwue.jpp.schafkopf.game;

import de.uniwue.jpp.schafkopf.deck.Card;

import java.util.*;

public class Trick {
    private static Card lastcard;
    private ArrayList<Card> stich = new ArrayList<>();

    public Trick(List<Card> playedCards, Card playedCard){
        stich.addAll(playedCards);
        stich.add(playedCard);
    }
    public Trick(){
    }

    public static Trick empty() {            //erstellt einen leeren Stich
        Trick trick = new Trick();
        return trick;
    }

    public Trick play(Card card) {
        if (this.stich.size() < 4) {
            return new Trick(cards(),card);
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean isEmpty() {
        if (this.getStich().size() == 0) return true;
        else {
            return false;
        }
    }

    public Optional<Card> lead() {
        if (isEmpty()) return Optional.empty();
        Optional<Card> card = Optional.ofNullable(stich.iterator().next());
        return card;

    }

    public List<Card> cards() {
        return Collections.unmodifiableList(this.stich);
    }

    public int points() {
//        if (stich.isEmpty()) return 0;
//        else {
        int result = 0;
        for (Card card : stich) {
            result += card.value().points();
        }
        return result;
    }



    public static Card getLastcard() {
        return lastcard;
    }

    public ArrayList<Card> getStich() {
        return stich;
    }
}
