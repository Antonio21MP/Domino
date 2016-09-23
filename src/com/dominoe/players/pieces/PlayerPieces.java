/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.players.pieces;

import com.dominoe.pieces.Piece;

public interface PlayerPieces {
    
    public Piece get(int pos);

    public int getSize();

    public Piece pop(int selectedOption);

    public void push(Piece fromRemainder);
    
}
