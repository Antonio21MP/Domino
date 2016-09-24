package com.dominoe.board;

import com.dominoe.Piece;

public class List {
    private Node root;
    private int size;
    public List(){
        root = null;
        size = 0; 
    }
    public boolean isEmpty(){
        return root ==  null;
    }
    public int getSize(){
        return size;
    }
    
    public Piece getLeftValue(){
        Piece value = getLastLeft(root);
        return value;
    }
    public Piece getRightValue(){
        Piece value = getLastRight(root);
        return value;
    }
    public Piece getLastLeft(Node root){
            if(root.getConnectionLeft()){
                if(root.getLeft() != null){
                        getLastLeft(root.getLeft());
                }else{
                    getLastRight(root);
                }
            }
        return root.getPiece();
    }
    
    public Piece getLastRight(Node root){
        if(root.getConnectionRight()){
                if(root.getRight() != null){
                        getLastRight(root.getRight());
                }else{
                    getLastLeft(root);
                }
            }
        return root.getPiece();
    }
    public void pushLeft(Piece piece, Node root) throws PiecesException{
        Node newNode = new Node();
        newNode.setPiece(piece);
        if(!root.getConnectionLeft()){
            if(root.getPiece().getFirstValue() == piece.getFirstValue()){
                newNode.changeConnectionLeft(true);
                root.setLeft(newNode);
            }
            else if(root.getPiece().getFirstValue() == piece.getSecondValue()){
                newNode.changeConnectionRight(true);
                root.setLeft(newNode);
            }
            else{
                throw new PiecesException(piece);
            }
        }
        else if(!root.getConnectionRight()){
            pushRight(piece, root.getLeft());
        }
        else{
                pushLeft(piece,root.getLeft());
            }
        
    }
    
    public void pushRight(Piece piece, Node root) throws PiecesException{
        Node newNode = new Node();
        newNode.setPiece(piece);
        
        if(!root.getConnectionRight()){
            if(root.getPiece().getSecondValue() == piece.getFirstValue()){
                newNode.changeConnectionLeft(true);
                root.setRight(newNode);
            }
            else if(root.getPiece().getSecondValue() == piece.getSecondValue()){
                newNode.changeConnectionRight(true);
                root.setRight(newNode);
            }
            else{
                throw new PiecesException(piece);
            }
        }
        else if(!root.getConnectionLeft()){
            pushLeft(piece, root.getLeft());
        }
        else{
                pushRight(piece,root.getRight());
            }
        
    }
}
