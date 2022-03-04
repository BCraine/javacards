//couldn't figure out how to restart or kill the program when prompted
//at the end

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner ln = new Scanner(System.in);
		//Creates deck and tells it to shuffle
		Deck myDeck = new Deck(true);

		//Creates the player and dealer
		Player user = new Player("Player");
		Dealer dealer = new Dealer("Dealer");

		//Dealer alternates giving both player and them self a card
		user.addCard(myDeck.dealNextCard());
		dealer.addCard(myDeck.dealNextCard());
		user.addCard(myDeck.dealNextCard());
		dealer.addCard(myDeck.dealNextCard());

		//Shows the players hand but not the dealers
		System.out.println("Dealt cards\n");
		user.printHand(true);

		dealer.printHand(false);
		System.out.println("\n");


		boolean userDone = false;
		boolean dealerDone = false;
		//ans will be used for the player to input their decision
		String ans;
		String ans2;


		//Creates menu asking user to keep playing if they didn't bust
		while (!userDone || !dealerDone) {
			if (!userDone) {

				System.out.print("Enter 'H' to hit or 'S' to stay:");
				ans = ln.next();
				System.out.println();

				if (ans.compareToIgnoreCase("H") == 0) {
					userDone = !user.addCard(myDeck.dealNextCard());
					user.printHand(true);

				}else {
					userDone = true;
				}
			}
			//dealer must hit if their score is below 17
			if (!dealerDone) {
				if (dealer.getHandSum() < 17) {
					System.out.println("Dealer Hits\n");
					dealerDone = !dealer.addCard(myDeck.dealNextCard());
					dealer.printHand(false);
				}else {
					System.out.println("Dealer stays\n");
					dealerDone = true;
				}
			}

			System.out.println();
		}


		//prints both hands
		user.printHand(true);
		dealer.printHand(true);

		int userSum = user.getHandSum();
		int dealerSum = dealer.getHandSum();

		//determines who is the winner
		if (userSum > dealerSum && userSum <= 21 || dealerSum > 21) {
			System.out.println("You win!");
		}else {
			System.out.println("Dealer wins");
		}

		System.out.println("Would you like to play again? Type 'yes' or 'no'");
		ans2 = ln.next();
		if (ans2 == "no") {
			System.exit(1);
		}
		//closes scanner
		ln.close();
	}




}
