package de.uniwue.jpp.schafkopf.game;

import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.deck.Deck;
import de.uniwue.jpp.schafkopf.deck.Suit;
import de.uniwue.jpp.schafkopf.deck.Value;
import de.uniwue.jpp.schafkopf.game.modes.*;

import java.util.Objects;

public class Contract implements Comparable<Contract> {

    private GameMode theMode;
    private int power;
    private String beschreibung;
    private Deck allCards;

    private Contract(char help) {
        switch (help) {
            case 'P':
                Ramsch result = new Ramsch();
                this.theMode = result;
                this.allCards = result.getCards();
                this.power = 0;
                this.beschreibung = "Pass";
                break;
            case 'W':
                ValueSolo result2 = new ValueSolo(Value.unter());
                this.theMode = result2;
                this.allCards = result2.getCards();
                this.power = 2;
                this.beschreibung = "Wenz";
                break;
            case 'w':
                Tout result3 = new Tout(new ValueSolo(Value.unter()));
                this.theMode = result3;
                this.allCards = new ValueSolo(Value.unter()).getCards();
                this.power = 4;
                this.beschreibung = "Wenz Tout";
        }
    }

    private Contract(char help, Suit suit) {
        switch (help) {
            case 'R':
                Calling result = new Calling(suit);
                this.allCards = result.getCards();
                this.theMode = result;
                this.power = 1;
                this.beschreibung = "Calling " + suit.toString();
                break;
            case 'S':
                SuitSolo result2 = new SuitSolo(suit);
                this.theMode = result2;
                this.allCards = result2.getCards();
                this.power = 3;
                this.beschreibung = theMode.toString();
                break;
            case 's':
                Tout result3 = new Tout(new SuitSolo(suit));
                this.theMode = result3;
                this.allCards = new SuitSolo(suit).getCards();
                this.power = 5;
                this.beschreibung = theMode.toString();
        }
    }

    public static Contract pass() {
        return new Contract('P');
    }

    public static Contract call(Suit suit) {
        return new Contract('R', suit);
    }

    public static Contract wenz(boolean tout) {
        if (tout) {
            return new Contract('w');
        } else return new Contract('W');
    }

    public static Contract solo(boolean tout, Suit suit) {
        if (tout) {
            return new Contract('s', suit);
        } else return new Contract('S', suit);
    }


    public GameMode mode(){
        return this.theMode;
    }

    public Deck getAllCards() {
        return allCards;
    }

    public void setAllCards(Deck allCards) {
        this.allCards = allCards;
    }

    @Override
    public String toString() {
        return beschreibung;
    }

    @Override
    public int compareTo(Contract o) {
        if (this.equals(o)) return 0;
        else if (this.power > o.power) return 1;
        else return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return power == contract.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(power);
    }
}
