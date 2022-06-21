
/**
 * Card - representing standard (French) playing cards (without Jokers)
 * Rank values are 0-based and correspond to the characters of the same index in String "A23456789TJQK"
 * Suit values are 0-based and correspond to the characters of the same index in String "CHSD" (after the CHaSeD suit ordering convention)
 * @author Hoang Quan
 *
 */
public class Card {	// Alt + Shift + J for Javadoc comment
	// 1. define fields (what does the object know about itself?)
	
	
	// fields
	
	/**
	 * Rank character from low (A = Ace) to high (K = King)
	 */
	public static final String RANK_CHARS = "A23456789TJQK";
	
	/**
	 * Suit character representing (C)lubs, (H)earts, (S)pades, and (D)iamonds, respectively
	 */
	public static final String SUIT_CHARS = "CHSD";
	
	/**
	 * An array of all cards (except Jokers) in a standard 52-card French deck
	 */
	public static Card[] allCards;	// to create new array??? why different syntax
	
	/**
	 * 0-based value corresponding to the index of String "A23456789TJQK"
	 */
	private int rank;
	
	/**
	 * 0-based value corresponding to the index of String "CHSD"
	 */
	private int suit;
	
	
	// methods
	
	static {	// static initializer - initializes class static fields
		allCards = new Card[RANK_CHARS.length() * SUIT_CHARS.length()];
		int i = 0;
		for (int suit = 0; suit < SUIT_CHARS.length(); suit++) {
			for (int rank = 0; rank < RANK_CHARS.length(); rank++) {
				allCards[i++] = new Card(rank, suit);
			}
		}
	}
	
	/**
	 * construct a card with a given 0-based rank and suit values
	 * @param rank given 0-based rank
	 * @param suit given 0-based suit
	 */
	public Card(int rank, int suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}


	/**
	 * Return the rank index according to the rank character String "A23456789TJQK"
	 * @return the rank index according to the rank character String "A23456789TJQK"
	 */
	public int getRank() {
		return rank;
	}

	
	/**
	 * Return the suit index according to the suit character String "CHSD"
	 * @return the suit index according to the suit character String "CHSD"
	 */
	public int getSuit() {
		return suit;
	}

	/* (non-Javadoc)
	 * @see java.langObject#toString()
	 */
	/**
	 * Two-character representation of the card rank and suit
	 */
	@Override
	public String toString() {
		return "" + RANK_CHARS.charAt(rank) + SUIT_CHARS.charAt(suit);
	}

	
	
	
	
	
	
}
