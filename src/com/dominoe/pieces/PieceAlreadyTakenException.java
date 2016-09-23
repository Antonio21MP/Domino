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
class PieceAlreadyTakenException extends Exception {

    PieceAlreadyTakenException(int index) {
        super("Piece in index: "+index+" already taken");
    }
    
}
