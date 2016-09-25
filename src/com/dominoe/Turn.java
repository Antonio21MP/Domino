/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe;

import com.dominoe.pieces.Piece;
import com.dominoe.players.Person;
import com.dominoe.board.Board;
import com.dominoe.players.Players;
import com.dominoe.players.Player;
import com.dominoe.players.PlayersCollection;
import java.util.ArrayList;

/**
 *
 * @author rnexer
 */
public class Turn {
    ArrayList<Person> players;
    static int currentPlayerIndex = -1;

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
        int currentLargest = -1;
        
        for (int i = 0; i < players.size(); i++) {
            Piece currentHighest = players.get(i).pieces.getHighestPiece();
            int firstValue = currentHighest.getFirstValue();
            if (firstValue > currentLargest && (firstValue == currentHighest.getSecondValue())) {
                currentLargest = firstValue;
                currentPlayerIndex = i;
            }
        }
        if (currentPlayerIndex == -1) {
            setRandomPlayer();
        }
        
    }

    private void setRandomPlayer() {
        int randomNum = 0 + (int)(Math.random() * players.size()-1);
        currentPlayerIndex = randomNum;
    }
}
