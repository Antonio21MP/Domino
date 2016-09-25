package com.dominoe.board;

import com.dominoe.pieces.Piece;
public class BoardLogic implements Board {
    List board;
    @Override
    public void init() {
        board = new List();   
    }

    @Override
    public void pushLeft(Piece selectedPiece) throws NotFoundPieceException{
            board.pushLeft(selectedPiece);
        
    }
    
    @Override
    public void pushRight(Piece selectedPiece) throws NotFoundPieceException {
            board.pushRight(selectedPiece);
        
    }
    
    
}
