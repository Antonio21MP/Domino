/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.pieces;

import com.dominoe.players.SIDES;

/**
 *
 * @author kenystev
 */
public class Piece {

    private final int firstValue;
    private final int secondValue;
    private boolean firstValueConnected;
    private boolean secondValueConnected;

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
    
    public void setConnectedWith(SIDES side){
        if(side==SIDES.IZQUIERDA){
            firstValueConnected = true;
        }else if(side == SIDES.DERECHA){
            secondValueConnected = true;
        }
    }
    
    public int getFreeValue() {
        return (!firstValueConnected)?firstValue:secondValue;
    }

    @Override
    public String toString() {
        return "|"+firstValue+"-"+secondValue+"|";
    }
}
