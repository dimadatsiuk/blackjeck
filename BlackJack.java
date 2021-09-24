import java.util.Scanner;


//import java.util.*;
 
class BlackJack {

    public static void main(String[] args) {
        
        System.out.println("Welcome to BlackJack");

        //create playing deck

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        //create a deck for the player

        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        //System.out.println(playerDeck);




        double playerMoney = 100.00;

        Scanner userInput = new Scanner(System.in);

        //game loop

        while(playerMoney > 0) {
            //take the players bet
            System.out.println("You have $" +playerMoney + ", how much would you like to bet?");

            double playerBet = userInput.nextDouble();
            if (playerBet > playerMoney) {
                System.out.println("You cannot bet more than you have, please leave");
                break;
            }

            boolean endRound = false;

            //start dealind
            //player gets 2 cards
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            //dealer gets two cards
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while(true) {
                //players hand
                System.out.println("Your hand: " + playerDeck.toString());
                System.out.println("Your hand is valued at: " + playerDeck.cardsValue());

                //dealer hand
                System.out.println("Dealers hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");
                //System.out.println("Dealers hand is valued at: " + dealerDeck.cardsValue());

                //what does the player want to do?
                System.out.println("Would you like to (1) Hit or (2) Stand?");
                int response = userInput.nextInt();

                //they hit
                if(response == 1) {
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
                    //Bust if > 21
                    if(playerDeck.cardsValue() > 21) {
                        System.out.println("Bust. Currently valued at: " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }
                if(response == 2) {
                    break;
                }
            }

            //reveal dealer cards
            System.out.println("Dealer Cards: " + dealerDeck.toString());
            //see if dealer has more points than player

            if((dealerDeck.cardsValue() > playerDeck.cardsValue())&& endRound==false) {
                System.out.println("Dealer beats you");
                playerMoney -= playerBet;
                endRound = true;
            }

            // dealer draws at 16, stand 17
            while((dealerDeck.cardsValue() < 17) && endRound == false) {
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
            }

            //display total value for dealer
            System.out.println("Dealer's hand is valued at: " + dealerDeck.cardsValue());
            //determine if dealer busted
            if((dealerDeck.cardsValue() > 21) && endRound == false) {
                System.out.println("Dealer busts. You win!");
                playerMoney += playerBet;
                endRound = true;
            }

            //determine if push
            if((playerDeck.cardsValue()==dealerDeck.cardsValue()) && endRound==false) {
                System.out.println("Push");
                endRound = true;
            }

            if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
                System.out.println("You win the hand!");
                playerMoney += playerBet;
                endRound = true;
            } else if (endRound == false){
                System.out.println("You lose the hand");
                playerMoney -= playerBet;

            }


            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);

            System.out.println("End of hand");


        }
        System.out.println("Game over. you're out of money");
        userInput.close();




    }





    
}


