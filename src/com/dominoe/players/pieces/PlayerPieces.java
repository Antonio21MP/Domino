/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.players.pieces;

import com.dominoe.pieces.Piece;
import com.dominoe.pieces.Pieces;

public interface PlayerPieces extends Pieces{
    
    public Piece get(int pos);

    public int getSize();
    
    public Piece getHighestPiece();
    
    public void push(Piece fromRemainder);
    
}
