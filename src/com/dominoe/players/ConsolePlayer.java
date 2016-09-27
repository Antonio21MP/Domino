/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominoe.players;

import com.dominoe.exceptions.PlaySurrenderedException;
import com.dominoe.exceptions.PassPlayerException;
import com.dominoe.players.pieces.PlayerPieces;
import com.dominoe.exceptions.InvalidPiecePositionException;
import com.dominoe.board.Board;
import com.dominoe.pieces.Pieces;
import com.dominoe.pieces.Piece;
import java.util.Scanner;

/**
 *
 * @author rnexer
 */
public class ConsolePlayer  implements Player {
    public PlayerPieces pieces;
    private String name;
    Scanner scanner;
    
    public ConsolePlayer(String name, PlayerPieces playerDeck){
        super();
        pieces = playerDeck;
        pieces.init();
        this.name = name;
        scanner = new Scanner(System.in);
    }

    @Override
    public void selectPieces(Pieces deck) throws Exception {
        for(int i = 0 ; i < 7; i++){
            Piece randomPiece = deck.popRandomPiece();
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
            System.out.println("Turno de: "+name);
            System.out.println("Ingrese la posicion de la pieza a colocar \n(-1 para tomar de las sobrantes) \n(-2 para pasar)\n(-3 salir): ");
            printMyPieces();
            System.out.print("escoja: ");
            selectedOption = scanner.nextInt();
            if(selectedOption < 0){
                if(selectedOption==-2 && deck.getSize()<=0)
                    throw new PassPlayerException();
                takePieceFromRemainder(deck);
                if(selectedOption==-3)
                    throw new PlaySurrenderedException(name);
            }else if(selectedOption < pieces.getSize()){
                Piece selectedPiece = pieces.get(selectedOption);
                SIDES side = selectSide();
                if(side == SIDES.IZQUIERDA){
                    board.pushLeft(selectedPiece);
                }else{
                    board.pushRight(selectedPiece);
                }
                pieces.pop(selectedOption);
                
            }else{
                throw new InvalidPiecePositionException();
            }
            
        }while(selectedOption < 0);
    }

    private void printMyPieces() {
        for (int i = 0; i < pieces.getSize(); i++) {
            Piece current = pieces.get(i);
            System.out.println(i + " - " + current);
        }
    }

    private void takePieceFromRemainder(Pieces deck) throws Exception{
        Piece fromRemainder = deck.popRandomPiece();
        pieces.push(fromRemainder);
    }
    
    private SIDES selectSide()throws Exception{
        int selection;
        do{
            System.out.println("Seleccione lado a colocar la pieza: ");
            System.out.println("0- Izquierda");
            System.out.println("1- Derecha");
            selection = scanner.nextInt();
        }while(selection < 0 || selection > 1);
        return selection == 0 ? SIDES.IZQUIERDA : SIDES.DERECHA;
    }

    @Override
    public Piece getHighestPiece() {
        return pieces.getHighestPiece();
    }

    @Override
    public String toString() {
        return name;
    }
}
