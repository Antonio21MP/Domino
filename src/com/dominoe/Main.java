package com.dominoe;

import com.dominoe.pieces.ArrayPieces;

/**
 *
 * @author kenystev
 */
public class Main {

    public static void main(String[] args) {
        DominoeGame dominoe = new DominoeGame(new MatrixBoard(),new TwoPlayers(),new ArrayPieces());
        dominoe.init();
        dominoe.play();
    }
    
}
