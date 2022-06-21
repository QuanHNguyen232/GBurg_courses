
public class DeckTest {

	public static void main(String[] args) {
		// Create a complete randomly shuffled deck of cards
		Deck deck = new Deck();
		// while the deck isn't empty, draw and print a card
		while (!deck.isEmpty()) {
			System.out.print(deck.draw() + " ");
		}
		System.out.println();


		// Create a specific  shuffled deck of cards (number 42)
		deck = new Deck(42);
		// while the deck isn't empty, draw and print a card
		while (!deck.isEmpty()) {
			System.out.print(deck.draw() + " ");
		}
		System.out.println();
		
		deck = new Deck(42);
		while (!deck.isEmpty()) {
			System.out.print(deck.draw() + " ");
		}
		System.out.println();
		
		
		// add method test
		for (Card c : Card.allCards) {
			deck.add(c);
		}
		while (!deck.isEmpty()) {
			System.out.print(deck.draw() + " ");
		}
		System.out.println();
		
		// toString() test 
		System.out.println(new Deck(42)); 
		
		
	}

}
