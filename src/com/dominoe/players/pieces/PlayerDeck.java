/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.players.pieces;

import com.dominoe.pieces.Piece;
import java.util.ArrayList;

/**
 *
 * @author Jobarah
 */
public class PlayerDeck implements PlayerPieces {
    
    ArrayList<Piece> pieces;
    
    @Override
    public Piece get(int pos) {
        return pieces.get(pos);
    }

    @Override
    public int getSize() {
        return pieces.size();
    }

    @Override
    public Piece pop(int selectedOption) {
        Piece pop = pieces.get(selectedOption);
        pieces.remove(pop);
        return pop;
    }

    @Override
    public void push(Piece fromRemainder) {
        pieces.add(fromRemainder);
    }

    @Override
    public void init() {
        pieces = new ArrayList<>();
    }

    @Override
    public Piece popRandomPiece() {
       int randomNum = 0 + (int)(Math.random() * pieces.size()-1); 
       return pop(randomNum);
    }

    @Override
    public Piece getHighestPiece() {
        int currentLargest = -1;
        Piece highest = new Piece();
        for(Piece piece : pieces) {
            int firstValue = piece.getFirstValue();
            if (firstValue > currentLargest && (firstValue == piece.getSecondValue())) {
                currentLargest = firstValue;
                highest = piece;
            }
        }
        if (currentLargest == -1) {
            return null;
        }
        
        return highest;
    }
}
