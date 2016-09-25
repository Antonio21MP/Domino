package com.dominoe.players;

import com.dominoe.pieces.Pieces;
import com.dominoe.players.Player;

public interface Players {

    public void init(Pieces pieces) throws Exception ;

    public int getSize();

    public Player getPlayer(int i) throws Exception ;
    
}
