import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

public class SetCollectionSolver {
	public static int ITERATIONS = 1000000; 	
	
	public static boolean[] solve(int numItems, BitSet[] lots, double[] costs) {
		// if all lots don't have all items
		BitSet set = new BitSet();
		for (int i=0; i < lots.length; i++) set.or(lots[i]);
		if (set.cardinality() < numItems) return new boolean[lots.length];
		
		// else search
		State state = new SetCollectionProblem(numItems, lots, costs);
		HillDescender searcher = new HillDescender(state, 0.2);
		
		State minState = searcher.search(ITERATIONS);
		SetCollectionProblem resultState = (SetCollectionProblem) minState;
		return resultState.isBuy;
	}
	
//	public static void main(String[] args) {
//		int numItems = 3;
//		double[] costs = new double[4];
//		costs[0] = 10; costs[1] = 20; costs[2] = 50; costs[3] = 30; 
//		BitSet[] lots = new BitSet[costs.length];
//		for (int i=0; i<lots.length; i++) lots[i] = new BitSet();
//		lots[0].set(0, 2);
//		lots[1].set(1, 3);
//		lots[2].set(0, 3);
//		lots[3].set(0); lots[3].set(2);
//		
//		SetCollectionProblem node = new SetCollectionProblem(numItems, lots, costs);
//		
////		for (int i=0; i<node.costs.length; i++) System.out.print(node.costs[i] + " ");
////		System.out.println();
////		for (int i=0; i<node.lots.length; i++) System.out.print(node.lots[i] + " ");
////		System.out.println();
//		
//		// printing result				
//		boolean[] result = solve(numItems, lots, costs);
//		for (int i=0; i<result.length; i++) System.out.print(result[i] ? "Y " : "n ");
//		
//		System.out.println();
//	}
	
	static class SetCollectionProblem implements State {
		boolean[] isBuy;
		int numItems;
		BitSet[] lots;
		double[] costs;
		Random random = new Random();
		int lastIdx;
		
		public SetCollectionProblem(int numItems, BitSet[] lots, double[] costs) {
			this.numItems = numItems;
			this.costs = costs;
			this.lots = lots;
			this.isBuy = new boolean[lots.length];
			for (int i=0; i<isBuy.length; i++) this.isBuy[i] = true;
		}
		
		@Override
		public void step() {
			lastIdx = random.nextInt(lots.length);
			isBuy[lastIdx] = !isBuy[lastIdx];
			while (true) {	// continue until all items are selected
				undo();
				lastIdx = random.nextInt(lots.length);
				isBuy[lastIdx] = !isBuy[lastIdx];
				if (this.hasAllItems(this.isBuy)) break;
			}
		}

		@Override
		public void undo() {
			isBuy[lastIdx] = !isBuy[lastIdx];
		}

		@Override
		public double energy() {
			double energy = 0;
			for (int i = 0; i < isBuy.length; i++) {
				if (isBuy[i]) {
					energy += costs[i];
				}
			}
			return energy;
		}
		
		public boolean hasAllItems(boolean[] isBuy) { 
			BitSet set = new BitSet();
			for (int i=0; i < isBuy.length; i++) {
				if (isBuy[i]) {
					set.or(lots[i]);
				}
			}
			return (set.cardinality() == numItems) ? true : false;
		}
		
		public Object clone() {
			try {
				SetCollectionProblem copy = (SetCollectionProblem) super.clone();
				copy.isBuy = this.isBuy.clone();
				copy.costs = this.costs.clone();
				copy.lots = new BitSet[this.lots.length];
				for (int i=0; i<this.lots.length; i++) copy.lots[i] = (BitSet) this.lots[i].clone();
				return copy;
			}
			catch (CloneNotSupportedException e) {
				System.out.println(e);
			}
			return null;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("isBuy: ");
			for (int i = 0; i < isBuy.length; i++) sb.append(isBuy[i] ? "Y " : "N ");
			return sb.toString();
		}
		
	}
	
	public interface State extends Cloneable { 
	    void step();
	    void undo();
	    double energy();
	    Object clone();
	}
	
	static class HillDescender {
		State state;
		double energy;
		State minState;
		double minEnergy;
		double acceptRate = 0;
		
		public HillDescender(State initState) {
			state = initState;
			energy = initState.energy();
			minState = (State) state.clone();
			minEnergy = energy;
		}
		
		public HillDescender(State initState, double acceptRate) {
			this(initState);
			this.acceptRate = acceptRate;
		}
		
		public State search(int iterations) {
			Random random = new Random();
			for (int i=0; i<iterations; i++) {
				state.step();
				double nextEnergy = state.energy();
				if (nextEnergy <= energy || random.nextDouble() < acceptRate) {
					energy = nextEnergy;
					if (nextEnergy < minEnergy) {
						minState = (State) state.clone();
						minEnergy = nextEnergy;
					}
				}
				else {
					state.undo();
				}
			}
			return minState;
		}	
	}
}

