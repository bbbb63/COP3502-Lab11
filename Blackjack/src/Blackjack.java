import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        boolean opFour = true;                                    // declare variable for menu option 4 as termination condition.
        int     menuOption = 0;                                   // declare variable for menu options.
        float   percentWin;                                       // declare variable for win rate percentage.
        int     totalGame = 1;                                    // declare variable for game counter.
        int     playerCard = 0, playerHand = 0, dealerHand = 0;   // declare variable for card values.
        int     playerWin = 0, dealerWin = 0, tie = 0;            // declare variable for game results.

        Scanner input = new Scanner(System.in);                   // to use scanner.
        P1Random rng = new P1Random();                            // to use P1Random for random number generation.

        playerCard = rng.nextInt(13) + 1;                   // deal initial card.
        playerHand = playerHand + playerCard;                     // calculate card value on hand.
        System.out.println("START GAME #" + totalGame);           // print 1st round of game.
        System.out.println("Your card is a " + playerCard + "!"); // print value of card dealt.
        System.out.println("Your hand is: " + playerHand);        // print value of card on hand.

        while (opFour) {                                          // while loop for running the game, stop until...
                                                                  // option 4 is chosen from input.
            System.out.println("1. Get another card");            // line 24-28 to print menu options.
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
            menuOption = input.nextInt();                         // take one integer input.

            if (menuOption == 4) {                                // check if option 4 is chosen, if so, stop the game.
                opFour = false;
                break;
            }
            else if (menuOption == 2) {                              // check if option 2 is chosen, if so, deal card to...
                                                                     // the dealer and then compare who wins the game.
                dealerHand = rng.nextInt(11) + 16;             // deal card to dealer.
                System.out.println("Dealer's hand: " + dealerHand);  // print value of card from dealer.
                System.out.println("Your hand is: " + playerHand);   // print value of card on player's hand.
                if ((dealerHand == 21) || ((dealerHand < 21) && (dealerHand > playerHand))) {  // line 42-45, checks if dealer has 21, then wins the game...
                    System.out.println("Dealer wins!");                                        // record the results, reset hand value, start new game.
                    totalGame++;
                    dealerWin++;
                    playerHand = 0;
                    System.out.println("START GAME #" + totalGame);
                } else if ((dealerHand > 21) || (dealerHand < playerHand)) {  // line 46-51, checks if dealer exceeds 21, then loses the game...
                    System.out.println("You win!");                           // record the results, reset hand value, start new game.
                    totalGame++;
                    playerWin++;
                    playerHand = 0;
                    System.out.println("START GAME #" + totalGame);
                } else if (dealerHand == playerHand) {                        // line 52-57, checks if it is a tie, then no one wins...
                    System.out.println("It's a tie! No one wins!");           // record the results, reset hand value, start new game.
                    totalGame++;
                    tie++;
                    playerHand = 0;
                    System.out.println("START GAME #" + totalGame);
                }
            }
            else if (menuOption == 3) {                                               // check if option 3 is chosen, if so, show statistics.
                System.out.println("Number of Player wins: " + playerWin);            // print number of wins of player.
                System.out.println("Number of Dealer wins: " + dealerWin);            // print number of wins of dealer.
                System.out.println("Number of tie games: " + tie);                    // print number of ties games.
                totalGame = totalGame - 1;                                            // calculate total game played.
                System.out.println("Total # of games played is: " + totalGame);       // print total number of games played.
                percentWin = (float)((playerWin*100)/totalGame);                      // calculate win rate percentage of player.
                System.out.println("Percentage of Player wins: " + percentWin + "%"); // print win rate percentage of player.
                continue;
            }
            else if (menuOption == 1) {                         // check if option 1 is chosen, if so, keep playing the game.

            }
            else {                                             // check if option input is valid, if not, output error message.
                System.out.println("Invalid input!");
                System.out.println("Please enter an integer value between 1 and 4.");
                continue;
            }

            while ((playerHand != 21) || playerHand < 21){                    // condition to keep playing the game, non 21 and player not exceed 21.

                playerCard = rng.nextInt(13) + 1;                       // if keep playing, player gets a card.

                if (playerCard == 1){                                         // if the card is 1, print Ace and add value of 1 to hand.
                    playerHand = playerHand + 1;
                    System.out.println("Your card is a ACE!");
                    System.out.println("Your hand is: " + playerHand);
                }
                else if (playerCard == 11){                                   // if the card is 11, print Jack and add value of 10 to hand.
                    playerHand = playerHand + 10;
                    System.out.println("Your card is a JACK!");
                    System.out.println("Your hand is: " + playerHand);
                }
                else if (playerCard == 12){                                   // if the card is 12, print Queen and add value of 10 to hand.
                    playerHand = playerHand + 10;
                    System.out.println("Your card is a QUEEN!");
                    System.out.println("Your hand is: " + playerHand);
                }
                else if (playerCard == 13){                                   // if the card is 13, print King and add value of 10 to hand.
                    playerHand = playerHand + 10;
                    System.out.println("Your card is a KING!");
                    System.out.println("Your hand is: " + playerHand);
                }
                else {
                    playerHand = playerHand + playerCard;                    // for other values of card, print the value and add that value to hand.
                    System.out.println("Your card is a " + playerCard + "!");
                    System.out.println("Your hand is: " + playerHand);
                }

                if (playerHand == 21){                                       // check if player gets 21, then wins the game, record the result...
                    System.out.println("BLACKJACK! You win!");               // reset hand value, start new game.
                    playerHand = 0;
                    totalGame++;
                    playerWin++;
                    System.out.println("START GAME #" + totalGame);
                    continue;
                }
                else if (playerHand > 21){                                   // check if player exceeds 21, then loses the game, record the result...
                    System.out.println("You exceeded 21! You lose.");        // reset hand value, start new game.
                    playerHand = 0;
                    totalGame++;
                    dealerWin++;
                    System.out.println("START GAME #" + totalGame);
                    continue;
                }
                break;
            }
        }
    }
}