package com.dominoe.board;

import com.dominoe.exceptions.RootIsNullException;
import com.dominoe.exceptions.PieceNotMatchWithAnySideException;
import com.dominoe.pieces.Piece;
public class BoardLogic implements Board {
    List board;
    @Override
    public void init() {
        board = new List();   
    }

    @Override
    public void pushLeft(Piece selectedPiece) throws Exception{
            board.pushLeft(selectedPiece);        
    }
    
    @Override
    public void pushRight(Piece selectedPiece) throws Exception {
            board.pushRight(selectedPiece);
        
    }

    @Override
    public void printBorad() {
        try{
            Piece left = board.getLeftValue();
            Piece right = board.getRightValue();

            System.out.println("Left: "+left);
            System.out.println("Right: "+right);
        }catch(RootIsNullException e){
            System.out.println("|NaN-NaN|");
        }
        
    }
}
