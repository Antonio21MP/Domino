/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.exceptions;

import com.dominoe.pieces.Piece;

/**
 *
 * @author Jose34mp
 */
public class PieceNotMatchWithAnySideException extends Exception {
    public PieceNotMatchWithAnySideException(Piece piece) {
        super(piece + " Not Found");
    }
    
}
