/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.exceptions;

/**
 *
 * @author kenystev
 */
public class PieceAlreadyTakenException extends Exception {

    public PieceAlreadyTakenException(int index) {
        super("Piece in index: "+index+" already taken");
    }
    
}
