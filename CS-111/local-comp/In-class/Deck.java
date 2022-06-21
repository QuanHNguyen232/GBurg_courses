import java.util.Collections;
import java.util.Random;
import java.util.Stack;

/**
 * A representation of a deck of a standard (French) cards, initially shuffled
 * @author Hoang Quan
 *
 */
public class Deck {

	// fields

	/**
	 * stack of cards in the deck
	 */
	private Stack<Card> stack = new Stack<>();


	// methods

	//	public Deck() {
	//		for (Card c : Card.allCards) {
	//			stack.push(c);
	//		}
	//		Collections.shuffle(stack);	// what is Collections ?
	//	}

	//	public Deck() {
	//		this((int) (Integer.MAX_VALUE * Math.random()));
	//	}

	/**
	 * Create a compete, shuffled standard deck of cards 
	 */
	public Deck() {
		init(new Random());
	}


	//	public Deck(int seed) {
	//		Random random = new Random(seed);
	//		for (Card c : Card.allCards) {
	//			stack.push(c);
	//		}
	//		Collections.shuffle(stack, random);
	//	}

	/**
	 * Create a compete, shuffled standard deck of cards using the given random number seed
	 * @param seed given random number seed
	 */
	public Deck(int seed) {
		init(new Random(seed));
	}


	/**
	 * Create a complete deck of Cards shuffled according to the given Random object
	 * @param random Random object usde for shuffling the deck
	 */
	private void init(Random random) {
		for (Card c : Card.allCards) {
			stack.push(c);
		}
		Collections.shuffle(stack, random);	
	}


	/**
	 * Return whether or not the deck is empty of cards
	 * @return whether or not the deck is empty of cards
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}


	/**
	 * Remove and return the top card of the deck
	 * @return the top card of the deck
	 */
	public Card draw() {
		return stack.pop();
	}


	/**
	 * Add the given card to the top of the deck
	 * @param card the given card to add to the top of the deck
	 */
	public void add(Card card) {
		stack.push(card);
	}


	/**
	 * Return a comma-separated list of Card two-character representations bound by square braces  
	 */
	@Override
	public String toString() {
		return stack.toString();
	}




}
