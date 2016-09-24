/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe;

import com.dominoe.pieces.Piece;
import com.dominoe.players.Person;
import com.dominoe.players.Players;
import com.dominoe.players.Player;
import com.dominoe.players.PlayersCollection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rnexer
 */
public class Turn {
    ArrayList<Person> players;
    static int currentPlayerIndex;

    static Turn init(PlayersCollection players, Board board) throws Exception {
       Turn turn = new Turn();
       for(int i = 0; i < players.getSize(); i++) {
           turn.players.add((Person)players.getPlayer(i));
       }
       turn.setInitialPLayer();
       return turn;
    }
    
    public Turn(){
        
    }

    Player next() throws Exception {
        Player next;
        
        if (currentPlayerIndex == players.size()-1) {
            currentPlayerIndex = 0;
        } else {
            currentPlayerIndex++;
        }
        
        next = players.get(currentPlayerIndex);
        return next;
    }

    Player previousPlayer() throws Exception {
        if (currentPlayerIndex == 0) {
            return players.get(players.size()-1);
        }
        return players.get(currentPlayerIndex-1);
    }

    Player currentPlayer() throws Exception {
        return players.get(currentPlayerIndex);
    }
    
    void setInitialPLayer() {
        int highestSum = 0;
        
        for (int i = 0; i < players.size(); i++) {
            Piece currentHighest = players.get(i).pieces.getHighestPiece();
            int sum = currentHighest.getFirstValue() + currentHighest.getSecondValue();
            if (sum > highestSum) {
                highestSum = sum;
                currentPlayerIndex = i;
            }
        }
        
    }
    
}
