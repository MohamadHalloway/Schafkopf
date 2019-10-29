package de.uniwue.jpp.schafkopf.game;

import de.uniwue.jpp.schafkopf.agent.Agent;
import de.uniwue.jpp.schafkopf.agent.SimpleAIPlayer;
import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.game.modes.GameMode;

import java.util.*;

public class Game {

    List<Player> thePlayers;
    Player theDeclaringPlayer;
    List<GameListener> theListeners;
    GameMode theMode;
    Map<Player, List<Trick>> theTricks = new HashMap<>();

    public Game(List<Player> players, Player declaringPlayer, GameMode mode, List<GameListener> listeners) {
        if (players.size() < 4) throw new IllegalArgumentException();
        this.thePlayers = players;
        this.theDeclaringPlayer = declaringPlayer;
        this.theListeners = listeners;
        this.theMode = mode;

    }

    public Map<Player, List<Trick>> tricks() {
        return this.theTricks;
    }

    public Collection<Player> start() {

        //declaring startingHands to select the offensiveTeam afterwards &&  the playerTrick's map
        Map<Player, Collection<Card>> startingHands = new HashMap<>();
        List<Player> resultPlayers = new ArrayList<>();
        for (Player player : thePlayers) {
            startingHands.put(player, player.hand());
            theTricks.put(player, new ArrayList<>());
            resultPlayers.add(player);
        }
        Collection<Player> offensiveTeam = theMode.offensiveTeam(startingHands, theDeclaringPlayer);


        while (!resultPlayers.get(0).hand().isEmpty()) {
//           Trick trick = new Trick();
//           Player temp = new SimpleAIPlayer("temp");
//           for (Player player : thePlayers){
//
//               Card karte = player.play(this.theMode, trick);
//               List<Card> arraytrick = trick.cards();
//               Collections.sort(arraytrick, theMode.comparator());
//           }
//           theTricks.
            Trick trick = Trick.empty();
            Player trickWinner = resultPlayers.get(0);  //the player who takes the trick at the end

            //2:Nacheinander alle Spieler eine Karte spielen lassen
            for (Player player : resultPlayers) {
                List<Card> tempHand = new ArrayList<>(player.hand());
                Card playedCard = player.play(theMode, trick);
                if (theMode.isValidPlay(trick, playedCard, tempHand)) { //if the played card is valid
                    trick = trick.play(playedCard);                      //add the played card to the Trick

                    // überprüfen wer den Stich nach jedem Play() gewinnen wird
                    /*ArrayList<Card> sortedTrick = new ArrayList<>();
                    for (Card card : trick.cards()) {
                        sortedTrick.add(card);
                    }
                    Collections.sort(sortedTrick, theMode.comparator());*/
                    if (playedCard.equals(theMode.best(trick))) {
                        trickWinner = player;
                    }

                    for (GameListener gameListener : theListeners) {    //telling the Agents which card have been played
                        gameListener.cardPlayed(playedCard, player);
                    }

                } else {
                    System.out.println("Mode: " + theMode +", trick: " + trick.cards() + ", playersHand: " + player.hand() + " playedCard: " + playedCard + " is " + theMode.isValidPlay(trick, playedCard, player.hand()) );
                    throw new MisplayedException();
                }
            }
            //giving the player the Trick which he won
            for (Map.Entry<Player, List<Trick>> myMap : theTricks.entrySet()) {
                if (myMap.getKey().equals(trickWinner)) {
                    myMap.getValue().add(trick);
                }
            }
            //telling the Agents
            for (GameListener agent : theListeners) {
                agent.trickTaken(trick, trickWinner);
            }


//            this.theDeclaringPlayer = trickWinner;     //the trickWinner will start the next trick


            //reorganise the players arrayList to set the trickWinner player as the first element
            List<Player> tempPlayers = new ArrayList<>();
            for (int i = resultPlayers.indexOf(trickWinner); i < resultPlayers.indexOf(trickWinner) + 4; i++) {
                tempPlayers.add(resultPlayers.get(i % 4));
            }
            resultPlayers = tempPlayers;
        }
        return theMode.winners(theTricks, offensiveTeam);
    }


}
