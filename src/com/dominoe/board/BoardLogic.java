package com.dominoe.board;

import com.dominoe.Board;
import com.dominoe.pieces.Piece;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BoardLogic implements Board {
    List board;
    @Override
    public void init() {
        board = new List();   
    }

    @Override
    public void pushLeft(Piece selectedPiece) {
        try {
            board.pushLeft(selectedPiece);
        } catch (NotFoundPieceException | rootIsNullException ex) {
            Logger.getLogger(BoardLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void pushRight(Piece selectedPiece) {
        try {
            board.pushRight(selectedPiece);
        } catch (NotFoundPieceException | rootIsNullException ex) {
            Logger.getLogger(BoardLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
