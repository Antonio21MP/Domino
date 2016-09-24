package com.dominoe.board;

import com.dominoe.Board;
import com.dominoe.Pieces;
public class BoardLogic implements Board {
    List board;
    
    @Override
    public void init() {
        board = new List();
    }
    public void push(Pieces value) throws PiecesException{
        board.pushPiece(value);
    }
}
