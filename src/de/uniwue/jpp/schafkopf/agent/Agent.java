package de.uniwue.jpp.schafkopf.agent;

import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.game.Contract;
import de.uniwue.jpp.schafkopf.game.GameListener;
import de.uniwue.jpp.schafkopf.game.Player;
import de.uniwue.jpp.schafkopf.game.Trick;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Agent extends GameListener {

    void contractDeclared(Player byPlayer, Contract contract);

    void gameModeDetermined(Player byPlayer, Contract contract);

    void winnerDetermined(Collection<Player> winners, int points);

    boolean continueGame();

}
