/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.board;

import com.dominoe.Pieces;

/**
 *
 * @author Jose34mp
 */
class PiecesException extends Exception {
    PiecesException(Pieces value) {
        super(value + " Not Found");
    }
    
}
