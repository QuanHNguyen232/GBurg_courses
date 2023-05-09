import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TravelingSalesmanSolver {
	public static int ITERATIONS = 1000000;

	public static void solver() {
		State state = new TravelingSalesmanProblem();
		HillDescender searcher = new HillDescender(state, 0.2);
		
		State minState = searcher.search(ITERATIONS);
		TravelingSalesmanProblem resultState = (TravelingSalesmanProblem) minState;
		
		System.out.println(resultState);
	}

	public static void main(String[] args) {
		solver();
//		TravelingSalesmanProblem state = new TravelingSalesmanProblem();
//		state.city_path.set(0, 3);
//		state.city_path.set(1, 9);
//		state.city_path.set(2, 4);
//		state.city_path.set(3, 0);
//		state.city_path.set(4, 5);
//		state.city_path.set(5, 8);
//		state.city_path.set(6, 7);
//		state.city_path.set(7, 1);
//		state.city_path.set(8, 2);
//		state.city_path.set(9, 6);
//		
//		System.out.println(state);
//		state.step();
//		System.out.println(state);
//		state.undo();
//		System.out.println(state);
	}

	static class TravelingSalesmanProblem implements State {
		/*
		 * Representation: [city_1, city_2, city_3, ..., city_n]
		 */
		int num_vouchers;
		int num_cities;
		int[] lastSwap = {-1, -1};
		Random random = new Random();
		ArrayList<double[]> city_locs = new ArrayList<>();
		ArrayList<Integer> city_path = new ArrayList<>();

		public TravelingSalesmanProblem() {
			try {
				Scanner in = new Scanner(new File("/Accounts/turing/students/s24/nguyqu03/CS-371/Final/src/fvtsp-input.txt"));
				this.num_vouchers = in.nextInt();
				this.num_cities = in.nextInt();

				for (int i=0; i<num_cities; i++) {
					this.city_locs.add(new double[] {in.nextDouble(), in.nextDouble()});
					this.city_path.add(i);
				}
				
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void step() {
			int idx1 = random.nextInt(this.num_cities);
			int idx2 = random.nextInt(this.num_cities);
			while (idx2 == idx1) {
				idx2 = random.nextInt(this.num_cities);
			}
			// swap
			int tmp = this.city_path.get(idx1);
			this.city_path.set(idx1, this.city_path.get(idx2));
			this.city_path.set(idx2, tmp);
			// save indices			
			this.lastSwap[0] = idx1;
			this.lastSwap[1] = idx2;
		}

		@Override
		public void undo() {
			int idx1 = this.lastSwap[0];
			int idx2 = this.lastSwap[1];
			// swap
			int tmp = this.city_path.get(idx1);
			this.city_path.set(idx1, this.city_path.get(idx2));
			this.city_path.set(idx2, tmp);
		}
		
		@Override
		public double energy() {
			double energy = 0.0;
			ArrayList<Double> distances = new ArrayList<>();
			for (int i=0; i<this.num_cities; i++) {
				int city_1 = this.city_path.get(i);
				int city_2 = this.city_path.get((i+1)%num_cities);
				distances.add(this.distance(city_locs.get(city_1), city_locs.get(city_2)));
//				System.out.println(city_1 + " " + city_2 + " " + distances.get(distances.size()-1));
			}
			Collections.sort(distances, Collections.reverseOrder());
			for (int i=this.num_vouchers; i<distances.size(); i++) {
				energy += distances.get(i);
			}
			return energy;
		}
		
		public double energyNoVoucher() {
			double energy = 0.0;
			ArrayList<Double> distances = new ArrayList<>();
			for (int i=0; i<this.num_cities; i++) {
				int city_1 = this.city_path.get(i);
				int city_2 = this.city_path.get((i+1)%num_cities);
				distances.add(this.distance(city_locs.get(city_1), city_locs.get(city_2)));
//				System.out.println(city_1 + " " + city_2 + " " + distances.get(distances.size()-1));
			}
			for (int i=0; i<distances.size(); i++) {
				energy += distances.get(i);
			}
			return energy;
		}
		
		public Object clone() {
			try {
				TravelingSalesmanProblem copy = (TravelingSalesmanProblem) super.clone();
				copy.lastSwap = this.lastSwap.clone();
				copy.random = new Random();
				copy.city_locs = new ArrayList<>();
				for (double[] loc : this.city_locs) {
					copy.city_locs.add(loc.clone());
				}
				copy.city_path = new ArrayList<>();
				for (int i=0; i<num_cities; i++) {
					copy.city_path.add(this.city_path.get(i));
				}
				return copy;
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
		
		public double distance(double[] loc1, double[] loc2) {
			double x_dist = loc1[0] - loc2[0];
			double y_dist = loc1[1] - loc2[1];
			double dist = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));
			return dist;
		}
		
		public String getInfo() {
			StringBuilder sb = new StringBuilder();
			sb.append("num_vouchers = " + this.num_vouchers);
			sb.append("\n");
			for (int i=0; i<this.city_locs.size(); i++) {
				sb.append("city loc: " + Arrays.toString(this.city_locs.get(i)));
				if (i>0) {
					sb.append("\t energy = " + this.distance(this.city_locs.get(i-1), this.city_locs.get(i)));
				}
				sb.append("\n");
			}
			for (Integer city : this.city_path) {
				sb.append(city + "-");
			}
			sb.append("\nenergy = " + this.energy());
			return sb.toString();
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (Integer id : this.city_path) {
				sb.append(id + " ");
			}
			sb.append("]\t");
			sb.append("energy (voucher) = " + this.energy() + "\tenergy (no voucher) = " + this.energyNoVoucher());
			return sb.toString();
		}

	}

	public interface State extends Cloneable { 
		void step();
		void undo();
		double energy();
		Object clone();
	}// State

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
		}// search
		
	}// HillDescender
}// TravelingSalesmanProblem
