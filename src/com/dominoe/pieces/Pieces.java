package com.dominoe.pieces;


public interface Pieces{

    public void init();
    
    public Piece pop(int selectedOption);

    public void push(Piece fromRemainder);
    
    public int getSize();
    
    public Piece popRandom();
}
