package de.uniwue.jpp.schafkopf.agent;

import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.game.Contract;
import de.uniwue.jpp.schafkopf.game.Player;
import de.uniwue.jpp.schafkopf.game.Trick;
import de.uniwue.jpp.schafkopf.game.modes.GameMode;
import de.uniwue.jpp.schafkopf.game.modes.Ramsch;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleAIPlayer implements Player {
    String name;
    List<Card> hand;

    public SimpleAIPlayer(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public List<Card> hand() {
        return Collections.unmodifiableList(hand);
    }

    @Override
    public void receive(List<Card> hand) {
        this.hand = hand;
    }

    @Override
    public Card play(GameMode mode, Trick trick)    {
        ArrayList<Card> preHand = new ArrayList<>(hand());

        Collections.sort(preHand, mode.comparator()); //sorting the hand
        Card result = preHand.get(0);
        boolean breaked = false;
        for (Card card : preHand) {       //the result is the strongest valid play card
            if (mode.isValidPlay(trick, card, preHand)) {
                result = card;
//                breaked = true;
                break;
            }
        }
//        if(!breaked) throw new IllegalStateException();
        preHand.remove(result);
        this.receive(preHand);

        return result;
    }

    @Override
    public Contract declare(List<Contract> previous) {
        return Contract.pass();
    }

    @Override
    public String toString() {
        return name;
    }
}
