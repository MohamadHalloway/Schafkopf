package de.uniwue.jpp.schafkopf.game.modes;

import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.deck.Deck;
import de.uniwue.jpp.schafkopf.game.Player;
import de.uniwue.jpp.schafkopf.game.Trick;

import java.util.*;

public class Tout implements GameMode{
    GameMode gameMode;

    public Tout(GameMode basis){
        this.gameMode = basis;
    }


//    public Deck getCards() {
//        return gameMode.
//    }

    @Override
    public Comparator<Card> comparator() {
        return gameMode.comparator();
    }

    @Override
    public boolean isValidPlay(Trick trick, Card card, Collection<Card> hand) {
        return gameMode.isValidPlay(trick, card, hand);
    }

    @Override
    public Card best(Trick trick) {
        return gameMode.best(trick);
    }

    @Override
    public Collection<Player> offensiveTeam(Map<Player, Collection<Card>> startingHands, Player declaringPlayer) {
        return gameMode.offensiveTeam(startingHands, declaringPlayer);
    }

    @Override
    public Collection<Player> winners(Map<Player, List<Trick>> tricks, Collection<Player> offensiveTeam) {
        //declearing the offensiveTeam
        Iterator<Player> iterator = offensiveTeam.iterator();
        Player off1 = iterator.next();
//        declaring the defensiveTeam
        ArrayList<Player> deffensiveTeam = new ArrayList<>();
        for (Map.Entry<Player, List<Trick>> myMap : tricks.entrySet()){
            if (!myMap.getKey().equals(off1)) deffensiveTeam.add(myMap.getKey());
        }
        for (Map.Entry<Player, List<Trick>> Map : tricks.entrySet()){
            if (!Map.getKey().equals(off1) && !Map.getValue().isEmpty()) return deffensiveTeam;  //if one of the defensivePlayers has min. one Trick
        }
//        if (deffensiveTeam.size() == 3) return offensiveTeam; //if  none of them has a trick
//        else return deffensiveTeam; //if min. one of them has trick that means the calling player didn't win
        return offensiveTeam;
    }

    @Override
    public boolean isValidChoice(Collection<Card> hand) {
        return gameMode.isValidChoice(hand);
    }

    @Override
    public boolean isTrump(Card card) {
        return gameMode.isTrump(card);
    }

    @Override
    public String toString() {
        return gameMode.toString() + " Tout";
    }
}
