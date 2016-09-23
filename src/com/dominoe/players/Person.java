/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.players;

import com.dominoe.players.pieces.PlayerPieces;
import com.dominoe.exceptions.InvalidPiecePosition;
import com.dominoe.Board;
import com.dominoe.pieces.Pieces;
import com.dominoe.pieces.Piece;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rnexer
 */
public class Person  implements Player{
    PlayerPieces pieces;
    private String name;
    Scanner scanner;
    
    public Person(String name){
        super();
        pieces = new PlayerPieces();
        this.name = name;
        scanner = new Scanner(System.in);
    }

    @Override
    public void selectPieces(Pieces deck) {
        for(int i = 0 ; i < 7; i++){
            Random rnd = new Random();
            int randomPosition = rnd.nextDouble()*deck.getSize();
            Piece randomPiece = deck.pop(randomPosition);
            pieces.push(randomPiece);
        }
    }

    @Override
    public boolean hasPieces() {
        return pieces.getSize() > 0;
    }

    @Override
    public void play(Board board, Pieces deck) throws Exception {
        int selectedOption;
        do{
            System.out.println("Ingrese la posicion de la pieza a colocar o -1 para tomar de las sobrantes: ");
            printMyPieces();
            selectedOption = scanner.nextInt();
            if(selectedOption < 0)
                takePieceFromRemainder(deck);
            else if(selectedOption < pieces.getSize()){
                Piece selected = pieces.pop(selectedOption);
                board.push(selected);
            }else{
                throw new InvalidPiecePosition();
            }
        }while(selectedOption < 0);
    }

    private void printMyPieces() {
        for (int i = 0; i < pieces.getSize(); i++) {
            Piece current = pieces.get(i);
            System.out.print(i + " - " + current.getFirstValue() + "|" + current.getSecondValue());
        }
    }

    private void takePieceFromRemainder(Pieces deck) {
        Piece fromRemainder = deck.popRandomPiece();
        pieces.push(fromRemainder);
    }
    
}
