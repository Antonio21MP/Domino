package com.dominoe.board;

import com.dominoe.exceptions.PieceNotFoundException;
import com.dominoe.exceptions.RootIsNullException;
import com.dominoe.pieces.Piece;

public class List {
    private Node root;
    private int size;
    public List(){
        root = null;
     
    }
    private boolean isEmpty(){
        return root ==  null;
    }
    private void initRoot(Piece piece){
        Node newNode = new Node();
        newNode.setPiece(piece);
        root = newNode;
    }
    public Piece getLeftValue() throws RootIsNullException{
        if(!isEmpty()){
            Piece value = getLastLeft(root);
            return value;
        }
        throw new RootIsNullException();
    }
    public Piece getRightValue() throws RootIsNullException{
        if(!isEmpty()){
            Piece value = getLastRight(root);
            return value;
        }
        throw new RootIsNullException();
    }
    private Piece getLastLeft(Node root){
            if(root.getConnectionLeft()){
                if(root.getLeft() != null){
                        getLastLeft(root.getLeft());
                }
                /*else{
                   Piece temp = getLastRight(root);
                   return temp;
                }*/
            }
        return root.getPiece();
    }
    
    private Piece getLastRight(Node root){
        if(root.getConnectionRight()){
                if(root.getRight() != null){
                        getLastRight(root.getRight());
                }
                /*else{
                    Piece temp =getLastLeft(root);
                    return temp;
                }*/
            }
        return root.getPiece();
    }
    public void pushLeft(Piece piece) throws PieceNotFoundException{
        if(!isEmpty()){
            addLeft(piece, root);
        }else{
            initRoot(piece);
        }
    }
    public void pushRight(Piece piece) throws PieceNotFoundException{
      if(!isEmpty()){
            addRight(piece, root);
        }else{
          initRoot(piece);
      }
    }
    
    private void addLeft(Piece piece, Node root) throws PieceNotFoundException{
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
                throw new PieceNotFoundException(piece);
            }
        }
        else if(root.getLeft()!=null){
                addLeft(piece,root.getLeft());
                }
        else{
            addRight(piece, root);
        }
        
    }
    
    private void addRight(Piece piece, Node root) throws PieceNotFoundException{
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
                throw new PieceNotFoundException(piece);
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
