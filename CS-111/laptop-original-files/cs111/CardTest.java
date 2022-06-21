import java.util.Arrays;

public class CardTest {

	public static void main(String[] args) {
		System.out.println(new Card(2, 3));
		System.out.println(new Card(2, 3).getRank());
		System.out.println(new Card(2, 3).getSuit());
		System.out.println(Arrays.toString(Card.allCards));
		
		
		
		
	}

}
