package com.dominoe;

/**
 *
 * @author kenystev
 */
public class Main {

    public static void main(String[] args) {
        DominoeGame dominoe = new DominoeGame(new MatrixBoard());
        dominoe.init();
        dominoe.play();
    }
    
}
