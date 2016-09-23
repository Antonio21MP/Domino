package com.dominoe.players;

import com.dominoe.Pieces;
import com.dominoe.players.Player;

public interface Players {

    public void init(Pieces pieces);

    public int getSize();

    public Player getPlayer(int i) throws Exception ;
    
}
