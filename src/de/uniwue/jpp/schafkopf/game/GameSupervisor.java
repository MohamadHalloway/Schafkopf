package de.uniwue.jpp.schafkopf.game;

import de.uniwue.jpp.schafkopf.agent.Agent;
import de.uniwue.jpp.schafkopf.agent.ConsoleAgent;
import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.deck.Deck;
import de.uniwue.jpp.schafkopf.game.modes.Ramsch;

import java.util.*;

public class GameSupervisor {

    private List<Player> players;
    private List<Agent> agents;
    private Deck allCards = new Deck();

    public GameSupervisor(List<Player> players, List<Agent> agents) {
        if (players.size() < 4) throw new IllegalArgumentException();
        this.players = players;
        this.agents = agents;
    }

    public void setAllCards(Deck allCards) {
        this.allCards = allCards;
    }

    public void loop() {
        Iterator<Card> iterator = allCards.iterator();
        //1: declaring the hands of the players
        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();
        List<Card> player3 = new ArrayList<>();
        List<Card> player4 = new ArrayList<>();
        //Karten verteilen
        while (iterator.hasNext()) {
            player1.add(iterator.next());
            player2.add(iterator.next());
            player3.add(iterator.next());
            player4.add(iterator.next());
        }

        //giving the hands to each player
        players.get(0).receive(player1);
        players.get(1).receive(player2);
        players.get(2).receive(player3);
        players.get(3).receive(player4);

//        for (Player player: players){
//            if (player.name().equals("Thomas")) System.out.println("Your hand: " + player.hand());
//        }

        //2: was die Spieler ansagen wollen
        List<Contract> contracts = new ArrayList<>();
        Contract höhest = Contract.pass();
        Player declaringPlayer = players.get(0);

        for (Player player : players) {
            Contract decision = player.declare(contracts);      //each player declares what he wants and the next get what the others already declared
            if (!decision.mode().isValidChoice(player.hand())) {
                System.out.println(decision.mode() + "----" + player.hand());
                throw new MisplayedException();
            }

            if (decision.compareTo(höhest) > 0) {//searching the highest Contract
                höhest = decision;
                declaringPlayer = player;
            }
            contracts.add(decision);
            for (Agent agent : agents) {             //telling the Agents
                agent.contractDeclared(player, decision);
            }

        }

        //telling the Agents who at the end decided the GameMode
        for (Agent agent : agents) {
            agent.gameModeDetermined(declaringPlayer, höhest);
        }

        //updating the Deck
//        setAllCards(höhest.getAllCards());
//        allCards.setTheDeck(höhest.getAllCards().getTheDeck());


        //declaring the game
        //firstly reorganise the players arrayList to set the declaring player as the first element
//        List<Player> resultPlayers = new ArrayList<>();
//        for (int i = players.indexOf(declaringPlayer); i < players.indexOf(declaringPlayer) + 4; i++) {
//            resultPlayers.add(players.get(i % 4));
//        }


        Game theGame = new Game(players, declaringPlayer, höhest.mode(), new ArrayList<>(agents));

        Collection<Player> gameWinners = theGame.start();           //starting the Game

        //calculating the points of the winner's tricks
        int points = 0;
        for (Map.Entry<Player, List<Trick>> myMap : theGame.tricks().entrySet()) { //for each player in the tricksMap
            for (Player player : gameWinners) {
                if (player.equals(myMap.getKey())) {        //if player is a winner
                    for (Trick trick : myMap.getValue()) {
                        points += trick.points();
                    }
                }
            }
        }

        //telling the Agents who won the Game
        for (Agent agent : agents) {
            agent.winnerDetermined(gameWinners, points);

        }
        System.out.println("Gamemode is: " + höhest.mode());

        for (Agent agent : agents) {
            if (agent.continueGame()) {
                List<Player> afterAGame = new ArrayList<>();
//                int q = (players.indexOf(0) + 1) % 4;
                for (int j =  1; j < 5; j++) {
                    afterAGame.add(players.get(j % 4));
                }
                this.players = afterAGame;
                loop();
            }
        }
    }
}
