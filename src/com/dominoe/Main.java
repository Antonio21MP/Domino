package com.dominoe;

import com.dominoe.board.BoardLogic;
import com.dominoe.pieces.ArrayPieces;
import com.dominoe.players.Person;
import com.dominoe.players.Player;
import com.dominoe.players.PlayersCollection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kenystev
 */
public class Main {

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Person("Keny"));
        players.add(new Person("Josue"));
        DominoeGame dominoe = new DominoeGame(new BoardLogic(),new PlayersCollection(players),new ArrayPieces());
        try{
            dominoe.init();
            dominoe.play();
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
            e.printStackTrace();
        }
    }
    
}
