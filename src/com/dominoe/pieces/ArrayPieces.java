package com.dominoe.pieces;

import com.dominoe.exceptions.NoMorePiecesException;
import com.dominoe.exceptions.PieceAlreadyTakenException;
import java.util.Random;

public class ArrayPieces implements Pieces{

    private Piece[] remainderPieces;
    private int size;
    
    @Override
    public void init() {
        size=28;
        remainderPieces = new Piece[size];
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
        return new Piece(random.nextInt(28));
    }

    private boolean contains(Piece piece) {
        for (Piece p : remainderPieces) {
            if(p != null && p.equals(piece))
                return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Piece pop(int index) throws Exception{
        Piece piece = remainderPieces[index];
        remainderPieces[index] = null;
        if (piece==null) {
            throw new PieceAlreadyTakenException(index);
        }
        size--;
        return piece;
    }

    @Override
    public Piece popRandomPiece() throws Exception{
        if(size>0)
            return pop(size-1);
        throw new NoMorePiecesException();
    }
    
}
