package com.dominoe.board;

import com.dominoe.pieces.Piece;
import com.dominoe.players.SIDES;

public class Node {
    private Piece piece;
    private Node right;
    private Node left;
    private boolean connection_right;
    private boolean connection_left;
    
    
    public void Node(){
        this.piece = null;
        this.right = null;
        this.left = null;
        this.connection_right = false;
        this.connection_left = false;
               
    }
    
    public boolean getConnectionLeft(){
        return connection_left;
    }
    
    public boolean getConnectionRight(){
        return connection_right;
    }
    
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        changeConnectionRight(true);
    }
    
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        changeConnectionLeft(true);
    }
    public void changeConnectionLeft(boolean value){
        this.connection_left = value;
        piece.setConnectedWith(SIDES.IZQUIERDA);
    }
    public void changeConnectionRight(boolean value){
        this.connection_right = value;
        piece.setConnectedWith(SIDES.DERECHA);
    }

    @Override
    public String toString() {
        return piece+"";
    }
}
