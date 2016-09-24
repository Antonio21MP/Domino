/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe;

import com.dominoe.board.Board;
import com.dominoe.players.Players;
import com.dominoe.players.Player;
import com.dominoe.players.PlayersCollection;

/**
 *
 * @author rnexer
 */
public class Turn {
    Players players;
    int currentPlayerIndex;

    static Turn init(Players players, Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Turn(){
        
    }

    Player next() throws Exception {
        Player next;
        
        if (currentPlayerIndex == players.getSize()-1) {
            currentPlayerIndex = 0;
        } else {
            currentPlayerIndex++;
        }
        
        next = players.getPlayer(currentPlayerIndex);
        
        return next;
    }

    Player previousPlayer() throws Exception {
        Player previous;
        
        if (currentPlayerIndex == 0) {
            currentPlayerIndex = players.getSize()-1;
        } else {
            currentPlayerIndex--;
        }
        
        previous = players.getPlayer(currentPlayerIndex);
        
        return previous;
    }

    Player currentPlayer() throws Exception {
        return players.getPlayer(currentPlayerIndex);
    }
    
}
