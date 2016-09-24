package com.dominoe;

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
    
    void init() {
        board.init();
        players.init(pieces);
        pieces.init();
        turn = Turn.init(players, board);
    }

    void play() throws Exception {
        do{
            turn.currentPlayer().play(board, pieces);
            turn.next();
        }while(turn.previousPlayer().hasPieces());
    }
    
}
