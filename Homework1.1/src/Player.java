
public class Player {

	//gives name to player
	private String name;
	//hand can be up to 10 cards
	private Card[] hand = new Card[10];

	private int numCards;

	public Player(String aName) {

		this.name = aName;
		this.emptyHand();
	}

	//creates emptyhand method
	public void emptyHand() {


		for (int c = 0; c < 10; c++) {
			this.hand[c] = null;
		}
		this.numCards = 0;

	}

	//creates error and closes if player tries to have more than 10 cards
	public boolean addCard(Card aCard) {
		if (this.numCards == 10) {
			System.err.printf("%s' Cannot add any more cards\n", this.name);
			System.exit(1);
		}
		this.hand[this.numCards] = aCard;
		this.numCards++;

		return (this.getHandSum() <= 21);

	}

	// creates counter to get values and deals with aces as well
	public int getHandSum() {

		int handSum = 0;
		int cardNum;
		int numAces = 0;

		for (int c = 0; c < this.numCards; c++) {
			cardNum = this.hand[c].getNumber();

			if (cardNum ==1) {
				numAces++;
				handSum+= 11;
			} else if (cardNum >10) {
				handSum += 10;
			} else {
				handSum += cardNum;
			}
		}

		//acts to turn aces to value 1 instead of 11 if over 21
		while (handSum > 21 && numAces >0) {
			handSum -= 10;
			numAces--;

		}
		return handSum;
	}

	public void printHand(boolean showFirstCard) {
		System.out.printf("%s's cards:\n", this.name);
		for(int c = 0; c< this.numCards; c++) {
			if(c==0 && !showFirstCard) {
				//will show hidden on one of dealers cards
				System.out.println("  [hidden]");
			}else {
				System.out.printf("%s\n", this.hand[c].toString());


			}
		}
	}
}
