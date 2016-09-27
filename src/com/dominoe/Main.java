package com.dominoe;

import com.dominoe.board.ConsoleBoard;
import com.dominoe.pieces.ArrayPieces;
import com.dominoe.players.ConsolePlayer;
import com.dominoe.players.Player;
import com.dominoe.players.PlayersCollection;
import com.dominoe.players.pieces.PlayerDeck;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kenystev
 */
public class Main {

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new ConsolePlayer("Keny",new PlayerDeck()));
        players.add(new ConsolePlayer("Josue",new PlayerDeck()));
        DominoGame dominoe = new DominoGame(new ConsoleBoard(),new PlayersCollection(players),new ArrayPieces());
        try{
            dominoe.init();
            dominoe.play();
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
            
        }
    }
    
}
