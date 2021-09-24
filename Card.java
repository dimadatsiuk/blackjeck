public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return this.rank.toString() + " " + this.suit.toString();
    }

    public Rank getRank() {
        return this.rank;

    }

    
}
