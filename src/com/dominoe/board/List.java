package com.dominoe.board;

import com.dominoe.Pieces;

public class List {
    private Node initialize;
    private int size;
    
    public List(){
        initialize = null;
        size = 0; 
    }
    public boolean isEmpty(){
        return initialize ==  null;
    }
    public int getSize(){
        return size;
    }
    public void pushPiece(Pieces value) throws com.dominoe.board.PiecesException{
        Node newNode = new Node();
        newNode.setValue(value);
        if(isEmpty()){
            initialize = newNode;
        }
        else if(initialize.getLeft().getValue().getFirstValue()==value.getFirstValue()){
            newNode.setLeft(initialize);
            initialize.setRight(newNode);
            initialize = newNode;
        }
        else if(initialize.getRight().getValue().getSecondValue()==value.getSecondValue()){
            newNode.setRight(initialize);
            initialize.setLeft(newNode);
            initialize = newNode;
        }
        else{
            throw new PiecesException(value);
        }   
        size++;
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
