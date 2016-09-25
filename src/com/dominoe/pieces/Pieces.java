/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.pieces;

/**
 *
 * @author Jose34mp
 */
public interface Pieces {

    public void init();

    public double getSize();

    public Piece pop(int randomPosition) throws Exception;

    public Piece popRandomPiece() throws Exception;
    
}

