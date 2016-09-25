package com.dominoe;

import com.dominoe.board.Board;
import com.dominoe.players.Players;
import com.dominoe.pieces.Pieces;

class DominoeGame {

    private Board board;
    private Players players;
    private Pieces pieces;
    private Turn turn;

    public DominoeGame(Board board, Players players, Pieces pieces) {
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
        do{
            try {
                board.printBorad();
                turn.currentPlayer().play(board, pieces);
                turn.next();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }while(turn.previousPlayer().hasPieces());
    }
    
}
