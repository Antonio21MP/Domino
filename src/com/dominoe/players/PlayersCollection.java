/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.players;

import com.dominoe.exceptions.InvalidPlayerPositionException;
import com.dominoe.pieces.Pieces;
import java.util.List;

/**
 *
 * @author rnexer
 */
public class PlayersCollection implements Players {
    private List<Player> players;
    
    public PlayersCollection(List<Player> players){
        super();
        this.players = players;
    }

    @Override
    public void init(Pieces pieces) throws Exception {
        for(int i = 0; i < players.size(); i++)
            players.get(i).selectPieces(pieces);
    }

    @Override
    public int getSize() {
        return players.size();
    }

    @Override
    public Player getPlayer(int i) throws Exception {
        if(i >= players.size())
            throw new InvalidPlayerPositionException();
        else
            return players.get(i);
    }
    
}
