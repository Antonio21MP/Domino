package com.dominoe.pieces;

public interface Pieces {

    public void init();

    public double getSize();

    public Piece pop(int randomPosition) throws Exception;
    
}
