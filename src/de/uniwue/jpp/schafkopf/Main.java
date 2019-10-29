package de.uniwue.jpp.schafkopf;

import de.uniwue.jpp.schafkopf.agent.ConsoleAgent;
import de.uniwue.jpp.schafkopf.agent.SimpleAIPlayer;
import de.uniwue.jpp.schafkopf.deck.Card;
import de.uniwue.jpp.schafkopf.deck.Deck;
import de.uniwue.jpp.schafkopf.deck.Suit;
import de.uniwue.jpp.schafkopf.deck.Value;
import de.uniwue.jpp.schafkopf.game.Contract;
import de.uniwue.jpp.schafkopf.game.GameSupervisor;
import de.uniwue.jpp.schafkopf.game.Player;
import de.uniwue.jpp.schafkopf.game.Trick;
import de.uniwue.jpp.schafkopf.game.modes.GameMode;
import de.uniwue.jpp.schafkopf.game.modes.Tout;
import de.uniwue.jpp.schafkopf.game.modes.ValueSolo;

import java.io.Console;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SelectableChannel;
import java.sql.SQLOutput;
import java.time.chrono.HijrahEra;
import java.util.*;

import static java.util.Collections.singletonList;

public class Main {
    public static void main(String[] args) {
        ConsoleAgent agent = new ConsoleAgent("Mohamad", System.out, System.in);
        GameSupervisor supervisor = new GameSupervisor(
                asList(agent,
                        new SimpleAIPlayer("Jens"),
                        new SimpleAIPlayer("Lena"),
                        new SimpleAIPlayer("Sandra")),
                singletonList(agent));
        supervisor.loop();


//        Trick trick = new Trick();
//        trick.play(new Card(Suit.Eichel, Value.ace()));
//        trick.play(new Card(Suit.Herz,Value.king()));
//        trick.play(new Card(Suit.Schellen,Value.basic(9)));
//        trick.play(new Card(Suit.Eichel, Value.basic(10)));


//        Deck deck = new Deck();
//        Player Mohamad1 = new Player();
//        Player Adel1 = new Player();
//        Player Anas1 = new Player();
//        Player Obada1 = new Player();
//        ArrayList<Card> Mohamad = new ArrayList<>();
//        ArrayList<Card> Adel = new ArrayList<>();
//        ArrayList<Card> Anas = new ArrayList<>();
//        ArrayList<Card> Obada = new ArrayList<>();
//        Trick stich = new Trick();
//        Trick stich2 = new Trick();
//        Trick stich3 = new Trick();
//        Trick stich4 = new Trick();
//        Trick stich5 = new Trick();
//        Trick stich6 = new Trick();
//        Trick stich7 = new Trick();
//        Trick stich8 = new Trick();
//
////
//        Iterator<Card> iterator = deck.iterator();
//        int count = 1;
//        while (iterator.hasNext() && count <= 4-1){
//            stich.play(iterator.next());
//            count++;
//        }
//        while (iterator.hasNext() && count <= 8-2){
//            stich2.play(iterator.next());
//            count++;
//        }
//        while (iterator.hasNext() && count <= 12-3){
//            stich3.play(iterator.next());
//            count++;
//        }
//        while (iterator.hasNext() && count <= 16-4){
//            stich4.play(iterator.next());
//            count++;
//        }
//        while (iterator.hasNext() && count <= 20-5){
//            stich5.play(iterator.next());
//            count++;
//        }
//        while (iterator.hasNext() && count <= 24-6){
//            stich6.play(iterator.next());
//            count++;
//        }
//        while (iterator.hasNext() && count <= 28-7){
//            stich7.play(iterator.next());
//            count++;
//        }
//        while (iterator.hasNext() && count <= 32-8){
//            stich8.play(iterator.next());
//            count++;
//        }
//        while (iterator.hasNext()){
//            Mohamad.add(iterator.next());
//        }
//        System.out.println(Mohamad);
//
//        int a = stich.cards().size();
//        int b = stich2.cards().size();
//        int c = stich3.cards().size();
//        int d = stich4.cards().size();
//        int e = stich5.cards().size();
//        int f = stich6.cards().size();
//        int g = stich7.cards().size();
//        int h = stich8.cards().size();
//
//        Contract contract = Contract.solo(false, Suit.Schellen);
//        deck.setTheDeck(contract.getAllCards().getTheDeck());
//        Collections.sort(deck.getTheDeck(), contract.mode().comparator());
//        System.out.println(deck.getTheDeck());
//
//
//        System.out.println(stich.cards());
//        System.out.println("Best card in this Trick: " + contract.mode().best(stich));
//        System.out.println("Mohamad played: " + Mohamad.get(0));
//        System.out.println(contract.mode().isValidPlay(stich, Mohamad.get(0),Mohamad));
//        //----------------------------------------------
//        System.out.println(stich2.cards());
//        System.out.println("Best card in this Trick: " + contract.mode().best(stich2));
//        System.out.println("Mohamad played: " + Mohamad.get(1));
//        System.out.println(contract.mode().isValidPlay(stich2, Mohamad.get(1),Mohamad));
//        //----------------------------------------------
//        System.out.println(stich3.cards());
//        System.out.println("Best card in this Trick: " + contract.mode().best(stich3));
//        System.out.println("Mohamad played: " + Mohamad.get(2));
//        System.out.println(contract.mode().isValidPlay(stich3, Mohamad.get(2),Mohamad));
//        //------------------------------------------------
//        System.out.println(stich4.cards());
//        System.out.println("Best card in this Trick: " + contract.mode().best(stich4));
//        System.out.println("Mohamad played: " + Mohamad.get(3));
//        System.out.println(contract.mode().isValidPlay(stich4, Mohamad.get(3),Mohamad));
//        //-------------------------------------------------
//        System.out.println(stich5.cards());
//        System.out.println("Best card in this Trick: " + contract.mode().best(stich5));
//        System.out.println("Mohamad played: " + Mohamad.get(4));
//        System.out.println(contract.mode().isValidPlay(stich5, Mohamad.get(4),Mohamad));
//        //---------------------------------------------------
//        System.out.println(stich6.cards());
//        System.out.println("Best card in this Trick: " + contract.mode().best(stich6));
//        System.out.println("Mohamad played: " + Mohamad.get(5));
//        System.out.println(contract.mode().isValidPlay(stich6, Mohamad.get(5),Mohamad));
//        //----------------------------------------------------
//        System.out.println(stich7.cards());
//        System.out.println(contract.mode().best(stich7));
//        System.out.println("Mohamad played: " + Mohamad.get(6));
//        System.out.println(contract.mode().isValidPlay(stich7, Mohamad.get(6),Mohamad));
//        //---------------------------------------------------
//        System.out.println(stich8.cards());
//        System.out.println("Best card in this Trick: " + contract.mode().best(stich8));
//        System.out.println("Mohamad played: " + Mohamad.get(7));
//        System.out.println(contract.mode().isValidPlay(stich8, Mohamad.get(7),Mohamad));

        //Trick: E9 played: EU Hand EU,SU,E8,GO Calling-Eichel


//        Trick trick1 = Trick.empty();
//        Contract contract = Contract.call(Suit.Eichel);
//        Contract contract2 = Contract.call(Suit.Gras);
//        trick1 = trick1.play(new Card(Suit.Gras,Value.basic(8)));
//        trick1 = trick1.play(new Card(Suit.Schellen,Value.unter()));
//        ArrayList<Card> temp = new ArrayList<>();
//        temp.add(new Card(Suit.Gras,Value.unter()));
//        temp.add(new Card(Suit.Herz,Value.king()));
//        temp.add(new Card(Suit.Eichel,Value.basic(10)));
//        temp.add(new Card(Suit.Eichel,Value.ace()));
//        temp.add(new Card(Suit.Eichel,Value.basic(8)));
//        temp.add(new Card(Suit.Eichel,Value.basic(7)));
//        temp.add(new Card(Suit.Herz,Value.unter()));
//        temp.add(new Card(Suit.Herz,Value.ace()));
//
//        ArrayList<Card> temp2 = new ArrayList<>();
//        temp2.add(new Card(Suit.Eichel,Value.ober()));
//        temp2.add(new Card(Suit.Gras,Value.basic(9)));
//        temp2.add(new Card(Suit.Gras,Value.ace()));
//        temp2.add(new Card(Suit.Herz,Value.unter()));
//        temp2.add(new Card(Suit.Gras,Value.basic(7)));
//        temp2.add(new Card(Suit.Schellen,Value.basic(9)));
//        temp2.add(new Card(Suit.Herz,Value.basic(8)));
//        temp2.add(new Card(Suit.Gras,Value.basic(8)));


//        System.out.println(contract.mode().isValidPlay(trick1, temp.get(0), temp));
//        System.out.println(temp);
//        System.out.println(contract.mode().isValidChoice(temp));
//        System.out.println(temp2);
//        System.out.println(contract2.mode().isValidChoice(temp2));


//        while (iterator.hasNext()) {
////            if (iterator.next().equals(new Card(Suit.Schellen,Value.ace())))Mohamad.add(iterator.next());
//            Mohamad.add(iterator.next());
//            Adel.add(iterator.next());
//            Anas.add(iterator.next());
//            Obada.add(iterator.next());
//        }
//        SuitSolo schellen = new SuitSolo(Suit.Schellen);
//        Contract gameMode = Contract.solo(false, Suit.Schellen);
//        deck.setTheDeck(gameMode.getAllCards().getTheDeck());
//        ValueSolo acht = new ValueSolo(Value.basic(8));
//        System.out.println("The Deck in ValueSolo: ");
//        System.out.println("The Deck in SuitSolo: ");
//        Collections.sort(deck.getTheDeck(),schellen.comparator());
//        Collections.sort(deck.getTheDeck(), gameMode.mode().comparator());
//        System.out.println(deck.getTheDeck().toString());
//        System.out.println("The Ass is: " + schellen.getAss());
//        System.out.println("Is Schellen a valid choice? " + gameMode.mode().isValidChoice(Mohamad));


//        System.out.print("The Hand of Mohamad: ");
//        System.out.println(Mohamad.toString());
//        System.out.print("The Hand of Adel: ");
//        System.out.println(Adel.toString());
//        System.out.print("The Hand of Anas: ");
//        System.out.println(Anas.toString());
//        System.out.print("The Hand of Obada: ");
//        System.out.println(Obada.toString());
//        System.out.println("Stich 1:");
//        PrintDeck(stich.getStich());
//        System.out.println(schellen.isValidPlay(stich, Mohamad.get(2),Mohamad));
//        System.out.println(schellen.best(stich));
//        System.out.println("Stich 2:");
//        PrintDeck(stich2.getStich());
//        System.out.println(schellen.best(stich2));
//        System.out.println("Stich 3:");
//        PrintDeck(stich2.getStich());
//        System.out.println(schellen.best(stich3));
//        System.out.println("Stich 4:");
//        PrintDeck(stich2.getStich());
//        System.out.println(schellen.best(stich4));
//        System.out.println("Stich 5:");
//        PrintDeck(stich2.getStich());
//        System.out.println(schellen.best(stich5));
//        System.out.println("Stich 6:");
//        PrintDeck(stich2.getStich());
//        System.out.println(schellen.best(stich6));
//        System.out.println("Stich 7:");
//        PrintDeck(stich2.getStich());
//        System.out.println(schellen.best(stich7));
//        System.out.println("Stich 8:");
//        PrintDeck(stich2.getStich());
//        System.out.println(schellen.best(stich8));
//        Deck theDeck = new Deck();
//        ArrayList<Card> deck= theDeck.getTheDeck();
//        Contract ramsch = Contract.pass();
//        Contract SchellenSolo = Contract.solo(false, Suit.Schellen);
//        Contract wenz = Contract.wenz(false);
//        Contract ruf = Contract.call(Suit.Schellen);
//        Collections.sort(deck,ramsch.mode().comparator());
//        System.out.println("Deck when Ramsch:" + deck);
//        Collections.sort(deck,SchellenSolo.mode().comparator());
//        System.out.println("Deck when SchellenSolo:" + deck);
//        Collections.sort(deck,wenz.mode().comparator());
//        System.out.println("Deck when Wenz:" + deck);
//        Collections.sort(deck,ruf.mode().comparator());
//        System.out.println("Deck when Ruf:" + deck);
    }

    private static List<Player> asList(ConsoleAgent agent, SimpleAIPlayer jens, SimpleAIPlayer lena, SimpleAIPlayer sandra) {
        List<Player> result = new ArrayList<>();
        result.add(agent);
        result.add(jens);
        result.add(lena);
        result.add(sandra);
        return result;
    }

    static void PrintDeck(ArrayList<Card> deck) {
        System.out.print("[");
        for (Card card : deck) {
            System.out.print(card.toString() + " , ");
        }
        System.out.print("]");
    }

}

