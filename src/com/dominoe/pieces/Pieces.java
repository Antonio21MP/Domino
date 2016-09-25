/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.pieces;



public interface Pieces{

    public void init();
    
    public Piece pop(int selectedOption) throws Exception;
    
    public int getSize();
    
    public Piece popRandomPiece() throws Exception;
}