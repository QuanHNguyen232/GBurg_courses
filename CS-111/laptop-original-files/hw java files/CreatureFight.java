import java.util.Arrays;
import java.util.Random;

public class CreatureFight {
	public static boolean[] result = new boolean[2];
	
	// constructor
	public CreatureFight() {		
	}
	
	// methods
	public static boolean[] fight(Creature c0, Creature c1) {
//		result[0] = c0.willSurviveFightWith(c1) ? true : false;
//		result[1] = c1.willSurviveFightWith(c0) ? true : false;
		result[0] = c0.willSurviveFightWith(c1);
		result[1] = c1.willSurviveFightWith(c0);
//		return result;
		return new boolean[] {c0.willSurviveFightWith(c1), c1.willSurviveFightWith(c0)};
	}
	
	
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			Creature c0 = new Creature(random.nextInt(3) + 1, random.nextInt(3) + 1);
			Creature c1 = new Creature(random.nextInt(3) + 1, random.nextInt(3) + 1);
			System.out.printf("%s vs. %s: %s\n", c0, c1, Arrays.toString(CreatureFight.fight(c0, c1)));
		}
	}

}
