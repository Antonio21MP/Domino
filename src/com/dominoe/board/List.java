package com.dominoe.board;

import com.dominoe.pieces.Piece;

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
    
    public Piece getLeftValue() throws rootIsNullException{
        if(isEmpty()){
            Piece value = getLastLeft(root);
            return value;
        }
        throw new rootIsNullException();
    }
    public Piece getRightValue() throws rootIsNullException{
        if(isEmpty()){
            Piece value = getLastRight(root);
            return value;
        }
        throw new rootIsNullException();
    }
    public Piece getLastLeft(Node root){
            if(root.getConnectionLeft()){
                if(root.getLeft() != null){
                        getLastLeft(root.getLeft());
                }else{
                   Piece temp = getLastRight(root);
                   return temp;
                }
            }
        return root.getPiece();
    }
    
    public Piece getLastRight(Node root){
        if(root.getConnectionRight()){
                if(root.getRight() != null){
                        getLastRight(root.getRight());
                }else{
                    Piece temp =getLastLeft(root);
                    return temp;
                }
            }
        return root.getPiece();
    }
    public void pushLeft(Piece piece) throws NotFoundPieceException, rootIsNullException{
        if(isEmpty()){
            addLeft(piece, root);
        }
        throw new rootIsNullException();
    }
    public void pushRight(Piece piece) throws NotFoundPieceException, rootIsNullException{
      if(isEmpty()){
            addRight(piece, root);
        }
        throw new rootIsNullException();
    }
    
    public void addLeft(Piece piece, Node root) throws NotFoundPieceException{
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
                throw new NotFoundPieceException(piece);
            }
        }
        else if(root.getLeft()!=null){
                addLeft(piece,root.getLeft());
                }
        else{
            addRight(piece, root);
        }
        
    }
    
    public void addRight(Piece piece, Node root) throws NotFoundPieceException{
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
                throw new NotFoundPieceException(piece);
            }
        }
        else if(root.getRight()!=null){
                addRight(piece,root.getRight());
                }
        else{
            addLeft(piece, root);
        }
        
    }
}
