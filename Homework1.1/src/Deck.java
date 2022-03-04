import java.util.Random;

public class Deck {

	//numcards will tell how many cards in deck
	private int numCards;
	private Card[] myCards;

	public Deck() {
	}


	public Deck(boolean shuffle) {


		//52 cards in deck
		this.numCards = 52;
		this.myCards = new Card[this.numCards];

		//initializes card index
		int c = 0;
		//for each suit
		for(int s = 0; s < 4; s++) {
			//for each number
			for (int n = 1; n<= 13; n++) {
				//adds new card to deck
				this.myCards[c] = new Card(Suit.values()[s], n);
				c++;
			}
		}

		//tells whether to shuffle
		if(shuffle) {
			this.shuffle();
		}
	}

	//creates shuffle method
	public void shuffle() {

		// TODO Auto-generated method stub
		Random rng = new Random();

		Card temp;

		int t;
		for(int i = 0; i< this.numCards; i++) {
			//gets random card
			t = rng.nextInt(this.numCards);
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[t];
			this.myCards[t] = temp;
		}

	}
	//deals card on top
	public Card dealNextCard() {
		Card top = this.myCards[0];
		//shifts cards to the left by one
		for(int c=1; c < this.numCards; c++) {
			this.myCards[c-1] = this.myCards[c];
		}
		this.myCards[this.numCards-1] = null;

		this.numCards--;

		return top;
	}

	public void printDeck(int numToPrint) {
		for(int c = 0; c < numToPrint; c++) {
			System.out.printf("% 3d/%d %s\n", c+1, this.numCards, 
					this.myCards[c].toString());
		}
		System.out.printf("\t\t[%d other]\n", this.numCards-numToPrint);

	}
}

