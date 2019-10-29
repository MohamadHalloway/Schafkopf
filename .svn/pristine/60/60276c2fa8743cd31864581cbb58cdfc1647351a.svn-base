package de.uniwue.jpp.schafkopf.game.modes;

import de.uniwue.jpp.schafkopf.Main;
import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.deck.Deck;
import de.uniwue.jpp.schafkopf.deck.Suit;
import de.uniwue.jpp.schafkopf.deck.Value;

import java.util.ArrayList;

public interface TrumpStrategy{


    boolean isTrump(Card card);

    static TrumpStrategy bySuit(Suit suit){
       return new SuitSolo(suit);
   }

    static TrumpStrategy byValue(Value value){
       return new ValueSolo(value);
    }


}
