package com.dominoe.pieces;


public interface Pieces{

    public void init();
    
    public Piece pop(int selectedOption) throws Exception;
    
    public int getSize();
    
    public Piece popRandomPiece() throws Exception;
}
