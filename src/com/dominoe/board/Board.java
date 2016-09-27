package com.dominoe.board;

import com.dominoe.exceptions.PieceNotMatchWithAnySideException;
import com.dominoe.pieces.Piece;

public interface Board {

    public void init();

    public void pushLeft(Piece selectedPiece)throws Exception;

    public void pushRight(Piece selectedPiece) throws Exception;

    public void printBoard();
}
