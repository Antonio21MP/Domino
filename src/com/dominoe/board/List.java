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
    public void pushPiece(Piece piece) throws Exception{
        Node newNode = new Node();
        newNode.setPiece(piece);
        if(isEmpty()){
            root = newNode;
        }
        else{
            throw new PiecesException(piece);
        }   
        size++;
        }    
    public void addLeft(Piece piece, Node root){
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
                addLeft(piece,root.getLeft());
            }
        }
        else if(!root.getConnectionRight()){
            addRight(piece, root.getLeft());
        }
        else{
                addLeft(piece,root.getLeft());
            }
        
    }
    
    public void addRight(Piece piece, Node root){
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
                addRight(piece,root.getRight());
            }
        }
        else if(!root.getConnectionLeft()){
            addRight(piece, root.getLeft());
        }
        else{
                addRight(piece,root.getRight());
            }
        
    }
    
//    public void search(Pieces valor){
//        if (initialize != null){
//            Node temp = initialize;
//            int cont = 0;
//            while (temp != null){
//                if (temp.getValue()== valor ){
//                    cont++;
//                    temp = temp.getRight();
//                }
//            }
//        }
//    }    
}
