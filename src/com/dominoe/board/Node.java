package com.dominoe.board;

import com.dominoe.Pieces;

public class Node {
    private Pieces value;
    private Node right;
    private Node left;
    
    public void Node(){
        this.value = null;
        this.right = null;
        this.left = null;
    }
    
    public Pieces getValue() {
        return value;
    }

    public void setValue(Pieces value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
