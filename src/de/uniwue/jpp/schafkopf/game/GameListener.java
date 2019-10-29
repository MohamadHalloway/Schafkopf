package de.uniwue.jpp.schafkopf.game;

import de.uniwue.jpp.schafkopf.deck.Card;

public interface GameListener {
    void cardPlayed(Card card, Player player);
    void trickTaken(Trick trick, Player player);
}
