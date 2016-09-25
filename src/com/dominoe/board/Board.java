package com.dominoe.board;

import com.dominoe.exceptions.PieceNotFoundException;
import com.dominoe.pieces.Piece;

public interface Board {

    public void init();

    public void pushLeft(Piece selectedPiece)throws PieceNotFoundException;

    public void pushRight(Piece selectedPiece) throws PieceNotFoundException;

    public void printBorad();
}
