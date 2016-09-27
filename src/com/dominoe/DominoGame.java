package com.dominoe;

import com.dominoe.board.Board;
import com.dominoe.exceptions.PassPlayerException;
import com.dominoe.exceptions.PieceNotMatchWithAnySideException;
import com.dominoe.exceptions.PlaySurrenderedException;
import com.dominoe.players.Players;
import com.dominoe.pieces.Pieces;
import java.util.InputMismatchException;

class DominoGame {

    private Board board;
    private Players players;
    private Pieces pieces;
    private Turn turn;

    public DominoGame(Board board, Players players, Pieces pieces) {
        this.board = board;
        this.players = players;
        this.pieces = pieces;
    }
    
    void init() throws Exception{
        board.init();
        pieces.init();
        players.init(pieces);
        turn = Turn.init(players, board);
    }

    void play() throws Exception {
        String lastMessage=" won";
        String player="";
        do{
            try {
                board.printBoard();
                turn.currentPlayer().play(board, pieces);
                turn.next();
            }catch(InputMismatchException e){
                System.out.println("Entrada erronea");
            }catch(PieceNotMatchWithAnySideException e){
                System.out.println("La pieza no encaja por ningun lado");
            }catch(PassPlayerException e){
                turn.next();
            }catch(PlaySurrenderedException e){
                lastMessage = " has surrendered";
                player=turn.currentPlayer().toString();
                break;
            }
            player=turn.previousPlayer().toString();
        }while(turn.previousPlayer().hasPieces());
        System.out.println("player: "+player+lastMessage);
    }
    
}
