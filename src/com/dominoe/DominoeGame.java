package com.dominoe;

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
        players.init();
        pieces.init();
        for(int i = 0; i < players.getSize(); i++)
            players.getPlayer(i).selectPieces(pieces);
        turn = Turn.init(players);
    }

    void play() {
        do{
            turn.currentPlayer().play(board, pieces);
            turn.next();
        }while(turn.previousPlayer().hasPieces());
    }
    
}
