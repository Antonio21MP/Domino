/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.board;

import com.dominoe.Piece;

/**
 *
 * @author Jose34mp
 */
class NotFoundException extends Exception {
    NotFoundException(Piece piece) {
        super(piece + " Not Found");
    }
    
}
