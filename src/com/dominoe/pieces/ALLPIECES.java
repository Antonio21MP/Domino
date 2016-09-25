package com.dominoe.pieces;

enum ALLPIECES {
    ZERO(0,0),
    ZERO_ONE(0,1), ONE(1,1), 
    ZERO_TWO(0,2), ONE_TWO(1,2), TWO(2,2),
    ZERO_THREE(0,3), ONE_THREE(1,3), TWO_THREE(2,3), THREE(3,3),
    ZERO_FOUR(0,4), ONE_FOUR(1,4), TWO_FOUR(2,4), THREE_FOUR(3,4), FOUR(4,4),
    ZERO_FIVE(0,5), ONE_FIVE(1,5), TWO_FIVE(2,5), THREE_FIVE(3,5), FOUR_FIVE(4,5), FIVE(5,5),
    ZERO_SIX(0,6), ONE_SIX(1,6), TWO_SIX(2,6), THREE_SIX(3,6), FOUR_SIX(4,6), FIVE_SIX(5,6), SIX(6,6);
    
    ALLPIECES(int first, int second){
        this.firstValue = first;
        this.secondValue = second;
    }
    
    private int firstValue, secondValue;
    
    public int getFirstValue(){return firstValue;};
    public int getSecondValue(){return secondValue;};
}
