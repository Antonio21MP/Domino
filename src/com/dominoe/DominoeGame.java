package com.dominoe;

class DominoeGame {

    private Board board;
    private Players players;
    private Deck deck;

    public DominoeGame(Board board,Players players, Deck deck) {
        this.board = board;
        this.players = players;
        this.deck = deck;
    }
    
    void init() {
        board.init();
        players.init();
        deck.init();
        Turn turn = new Turn();
    }

    void play() {
        
    }
    
}
