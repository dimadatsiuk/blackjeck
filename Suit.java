public enum Suit {

    /* HEART,
    DIAMOND,
    CLUB,
    SPADE; */



    HEART('♥'),
    DIAMOND('♦'),
    CLUB('♣'),
    SPADE('♠');
 
    final char symbol;
 
    Suit(char symbol) {
        this.symbol = symbol;
    }
 
    @Override
    public String toString() {
        return String.valueOf(this.symbol);
    }
}