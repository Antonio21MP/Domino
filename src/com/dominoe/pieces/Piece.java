/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.pieces;

/**
 *
 * @author kenystev
 */
public class Piece {

    private final int firstValue;
    private final int secondValue;

    Piece(int pieceIndex) {
        PIECES piece;
        piece = PIECES.values()[pieceIndex];
        firstValue = piece.getFirstValue();
        secondValue = piece.getSecondValue();
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }
    
}
