package com.dominoe.pieces;

import java.util.Random;

public class ArrayPieces implements Pieces{

    private Piece[] remainderPieces;
    
    @Override
    public void init() {
        remainderPieces = new Piece[28];
        fillRandom();
    }

    private void fillRandom() {
        Random random = new Random();
        for (int i = 0; i < remainderPieces.length;) {
            Piece piece = getRandomPiece(random);
            if(contains(piece)) continue;
            remainderPieces[i++] = piece;
        }
    }

    private Piece getRandomPiece(Random random) {
        return new Piece(random.nextInt(29));
    }

    private boolean contains(Piece piece) {
        for (Piece p : remainderPieces) {
            if(p != null && p.equals(piece))
                return true;
        }
        return false;
    }
    
}
