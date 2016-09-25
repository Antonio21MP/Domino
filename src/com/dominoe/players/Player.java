/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.players;

import com.dominoe.board.Board;
import com.dominoe.pieces.*;

import com.dominoe.pieces.Pieces;

/**
 *
 * @author rnexer
 */
public interface Player {

    public void selectPieces(Pieces deck) throws Exception;

    public boolean hasPieces();

    public void play(Board board, Pieces deck) throws Exception ;
    
    public Piece getHighest();
    
}
