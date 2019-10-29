package de.uniwue.jpp.schafkopf.deck;

import java.util.Objects;

public class Value implements Comparable<Value> {

    private String darstellung;
    private int augen;
    private String wert;
    private int power;

    private Value(String help) {

        if (help.equals("a")) {
            this.darstellung = "A";
            this.augen = 11;
            this.wert = "Ass";
            this.power = 8;
        }
        else if (help.equals("k")) {
            this.darstellung = "K";
            this.augen = 4;
            this.wert = "König";
            this.power = 6;
        }
        else if (help.equals("o")) {
            this.darstellung = "O";
            this.augen = 3;
            this.wert = "Ober";
            this.power = 5;
        }
        else if (help.equals("u")) {
            this.darstellung = "U";
            this.augen = 2;
            this.wert = "Unter";
            this.power = 4;
        } else {
            this.darstellung = help;
            this.wert = help;
            if (help.equals("10")) {
                this.augen = 10;
                this.power = 7;
            } else {
                this.augen = 0;
                this.power = Integer.parseInt(help) - 6;
            }
        }
    }


    public static Value ace() {      //Erstellt den Wert Ass.
        return new Value("a");
    }

    public static Value king() {     //Erstellt den Wert König.
        return new Value("k");

    }

    public static Value ober() {     //Erstellt den Wert Ober.
        return new Value("o");

    }

    public static Value unter() {    //Erstellt den Wert Unter.
        return new Value("u");
    }

    public static Value basic(int value) {//Erstellt die Zahlenwerte 7 bis 10. Liegt value nicht in diesem Intervall, soll eine IllegalArgumentException geworfen werden.
        if (value < 7 || value > 10) throw new IllegalArgumentException();
        return new Value(Integer.toString(value));
    }

    public int points() {                           //Gibt die Augenzahl des jeweiligen Wertes zurück
        return this.augen;
    }

    public String getDarstellung() {
        return darstellung;
    }

    public int getAugen() {
        return augen;
    }

    public String getWert() {
        return wert;
    }

    public int getPower(){return power;}

    @Override
    public int compareTo(Value o) {
        if(this.getPower() > o.getPower()) return -1;
        else if(this.getPower() < o.getPower()) return 1;
        else{ return 0;}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return augen == value.augen &&
                power == value.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(augen, power);
    }

    @Override
    public String toString() {
        return darstellung;
    }
}
