/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.players.pieces;

import com.dominoe.pieces.Piece;
import com.dominoe.pieces.Pieces;
import java.util.ArrayList;

/**
 *
 * @author Jobarah
 */
public class PlayerDeck implements PlayerPieces, Pieces {
    
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
        Piece pop = pieces.get(pieces.size()-1);
        pieces.remove(pop);
        return pop;
    }

    @Override
    public void push(Piece fromRemainder) {
        pieces.add(fromRemainder);
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
