package com.dominoe.board;

import com.dominoe.exceptions.BothSidesOfPieceAreAlreadyTaken;
import com.dominoe.exceptions.PieceNotMatchWithAnySideException;
import com.dominoe.exceptions.RootIsNullException;
import com.dominoe.pieces.Piece;
import com.dominoe.players.SIDES;

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
            return getLastLeft(root);
        }
        throw new RootIsNullException();
    }
    public Piece getRightValue() throws RootIsNullException{
        if(!isEmpty()){
            return getLastRight(root);
        }
        throw new RootIsNullException();
    }
    private Piece getLastLeft(Node root){
        if(root.getLeft() != null){
            return getLastLeft(root.getLeft());
        }
        return root.getPiece();
    }
    
    private Piece getLastRight(Node root){
        if(root.getRight() != null){
                return getLastRight(root.getRight());
        }
        return root.getPiece();
    }
    public void pushLeft(Piece piece) throws PieceNotMatchWithAnySideException, BothSidesOfPieceAreAlreadyTaken{
        if(!isEmpty()){
            addLeft(piece, root);
        }else{
            initRoot(piece);
        }
    }
    public void pushRight(Piece piece) throws PieceNotMatchWithAnySideException, BothSidesOfPieceAreAlreadyTaken{
      if(!isEmpty()){
            addRight(piece, root);
        }else{
          initRoot(piece);
      }
    }
    
    private void addLeft(Piece piece, Node root) throws PieceNotMatchWithAnySideException, BothSidesOfPieceAreAlreadyTaken{
        Node newNode = new Node();
        newNode.setPiece(piece);
        
        if(root.getLeft() != null){
            addLeft(piece, root.getLeft());
        }else{
            checkSideOfPieceToConnect(root,newNode,SIDES.IZQUIERDA);
        }
    }
    
    private void addRight(Piece piece, Node root) throws PieceNotMatchWithAnySideException, BothSidesOfPieceAreAlreadyTaken{
        Node newNode = new Node();
        newNode.setPiece(piece);
        
        if(root.getRight() != null){
            addRight(piece, root.getRight());
        }else{
            checkSideOfPieceToConnect(root, newNode,SIDES.DERECHA);
        }
    }

    private void checkSideOfPieceToConnect(Node root, Node newNode, SIDES sideNode) throws PieceNotMatchWithAnySideException, BothSidesOfPieceAreAlreadyTaken {
        
        if(!root.getConnectionLeft()){
            checkNewPieceSideToConnect(root,newNode,SIDES.IZQUIERDA,sideNode);
        }else if(!root.getConnectionRight()){
            checkNewPieceSideToConnect(root,newNode,SIDES.DERECHA,sideNode);
        }else{
            throw new BothSidesOfPieceAreAlreadyTaken(root.getPiece());
        }
    }

    private void checkNewPieceSideToConnect(Node root, Node newNode, SIDES side, SIDES sideNode) throws PieceNotMatchWithAnySideException {
        Piece pieceNode = root.getPiece();
        Piece piece = newNode.getPiece();
        
        int valueSideFor = (side==SIDES.IZQUIERDA)?pieceNode.getFirstValue():pieceNode.getSecondValue();
        
        if(valueSideFor == piece.getFirstValue()){
            newNode.changeConnectionLeft(true);
        }else if(valueSideFor == piece.getSecondValue()){
            newNode.changeConnectionRight(true);
        }
        
        if(newNode.getConnectionLeft() || newNode.getConnectionRight()){
            if(sideNode==SIDES.IZQUIERDA){
                root.setLeft(newNode);
            }else{
                root.setRight(newNode);
            }
        }else{
            throw new PieceNotMatchWithAnySideException(newNode);
        }
    }
}
