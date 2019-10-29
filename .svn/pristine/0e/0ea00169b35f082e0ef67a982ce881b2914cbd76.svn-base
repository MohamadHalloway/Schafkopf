package de.uniwue.jpp.schafkopf.game;

import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.game.modes.GameMode;

import java.util.Calendar;
import java.util.List;

public interface Player {
    String name();
    List<Card> hand();
    void receive(List<Card> hand);
    Card play(GameMode mode, Trick trick);
    Contract declare(List<Contract> previous);
}
