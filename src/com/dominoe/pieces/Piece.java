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
        ALLPIECES piece;
        piece = ALLPIECES.values()[pieceIndex];
        firstValue = piece.getFirstValue();
        secondValue = piece.getSecondValue();
    }
    
    public Piece() {
        firstValue = 0;
        secondValue = 0;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }
    
    public boolean equals(Piece p){
        return (firstValue == p.firstValue && secondValue == p.secondValue) 
                || (firstValue == p.secondValue && secondValue == p.firstValue);
    }

    @Override
    public String toString() {
        return "|"+firstValue+"-"+secondValue+"|";
    }
}
