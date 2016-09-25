package com.dominoe.board;

import com.dominoe.exceptions.RootIsNullException;
import com.dominoe.exceptions.PieceNotFoundException;
import com.dominoe.pieces.Piece;
public class BoardLogic implements Board {
    List board;
    @Override
    public void init() {
        board = new List();   
    }

    @Override
    public void pushLeft(Piece selectedPiece) throws PieceNotFoundException{
            board.pushLeft(selectedPiece);
        
    }
    
    @Override
    public void pushRight(Piece selectedPiece) throws PieceNotFoundException {
            board.pushRight(selectedPiece);
        
    }

    @Override
    public void printBorad() {
        try{
            Piece left = board.getLeftValue();
            Piece right = board.getRightValue();

            System.out.println("Left: "+left.getFirstValue()+"|"+left.getSecondValue());
            System.out.println("Right: "+right.getFirstValue()+"|"+right.getSecondValue());
        }catch(RootIsNullException e){
            System.out.println("NaN|NaN");
        }
        
    }
}
