package com.dominoe.board;

import com.dominoe.Board;
import com.dominoe.Piece;
public class BoardLogic implements Board {
    List board;
    @Override
    public void init() {
        board = new List();
    }
}
