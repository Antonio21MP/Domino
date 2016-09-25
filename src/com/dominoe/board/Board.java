package com.dominoe.board;

import com.dominoe.pieces.Piece;

public interface Board {

    public void init();

    public void pushLeft(Piece selectedPiece)throws NotFoundPieceException;

    public void pushRight(Piece selectedPiece) throws NotFoundPieceException;

        
    
}
