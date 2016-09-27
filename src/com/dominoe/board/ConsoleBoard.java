package com.dominoe.board;

import com.dominoe.exceptions.RootIsNullException;
import com.dominoe.exceptions.PieceNotMatchWithAnySideException;
import com.dominoe.pieces.Piece;
public class ConsoleBoard implements Board {
    ConnectedPieces board;
    @Override
    public void init() {
        board = new ConnectedPieces();   
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
    public void printBoard() {
        try{
            board.printInOrder();
            
            Piece left = board.getLeftValue();
            Piece right = board.getRightValue();

            System.out.print("\nLeft: "+left.getFreeValue());
            System.out.println(" Right: "+right.getFreeValue());
        }catch(RootIsNullException e){
            System.out.println("|NaN-NaN|");
        }
        
    }
}
