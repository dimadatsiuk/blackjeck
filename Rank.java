public enum Rank {

    //TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, J, Q, K, A


    TWO(" 2"), 
    THREE(" 3"), 
    FOUR(" 4"), 
    FIVE(" 5"), 
    SIX(" 6"), 
    SEVEN(" 7"), 
    EIGHT(" 8"), 
    NINE(" 9"), 
    TEN("10"), 
    JACK(" J"), 
    QUEEN(" Q"), 
    KING(" K"), 
    ACE(" A");


    final String rankString;

    Rank (String rankString) {
        this.rankString = rankString;
    }

    @Override
    public String toString() {
        return String.valueOf(this.rankString);
    }


    /* final char symbol;

    Rank (char symbol) {
        this.symbol = symbol;
    }

    
    @Override
    public String toString() {
        return String.valueOf(this.symbol);
    } */


   
    
}
