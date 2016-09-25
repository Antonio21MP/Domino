/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.board;

import com.dominoe.pieces.Piece;

/**
 *
 * @author kenystev
 */
public class BothSidesOfPieceAreAlreadyTaken extends Exception {

    public BothSidesOfPieceAreAlreadyTaken(Piece root) {
        super(root.toString());
    }
    
}
