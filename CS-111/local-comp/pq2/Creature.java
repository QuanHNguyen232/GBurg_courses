
public class Creature {
	// fields
	private int power;
	private int toughness;
	
	// constructors
	public Creature(int power, int toughness) {
		this.power = power;
		this.toughness = toughness;
	}
	
	
	// methods
	public int getPower() {
		return this.power;
	}
	
	public int getToughness() {
		return this.toughness;
	}
	
	public boolean willSurviveFightWith(Creature other) {
		if (this.toughness > other.power) {
			return true;
		}
		else {
			return false;
		}
	}


	@Override
	public String toString() {
		return "Creature [power=" + power + ", toughness=" + toughness + "]";
	}
	
	
	
	
}
