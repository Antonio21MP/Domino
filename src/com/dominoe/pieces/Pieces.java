package com.dominoe.pieces;

public interface Pieces {

    public void init();

    public double getSize();

    public Piece pop(int randomPosition) throws Exception;

    public Piece popRandomPiece() throws Exception;
    
}
