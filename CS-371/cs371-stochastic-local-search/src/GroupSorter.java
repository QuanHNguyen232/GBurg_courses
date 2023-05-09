import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GroupSorter implements State {

	Random random = new Random();
	public int[] groups;
	public static int[][] prefs;
	public double energy;
	
	public int numPeople, numGroups;
	public int swapI, swapJ;
	
	public GroupSorter() {
		
		File file = new File("/Accounts/turing/students/s24/nguyqu03/CS371/cs371-stochastic-local-search/src/group-input.txt");
		try {
			Scanner scanner = new Scanner(file);
			numPeople = scanner.nextInt();
			numGroups = scanner.nextInt();
			prefs = new int[numPeople][numPeople];
			for(int i = 0; i < numPeople; i++) {
				for (int j = 0; j < numPeople; j++) {
					prefs[i][j] = scanner.nextInt();
				}
			}
			for (int[] row : prefs) {
				System.out.println(Arrays.toString(row));
			}
			groups = new int[numPeople];
			for(int i = 0; i < numPeople; i++) {
				groups[i] = i;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void step() {
		// get 2 indices to swap
		swapI = random.nextInt(numPeople);
		swapJ = random.nextInt(numPeople);
		while (swapI % numGroups == swapJ % numGroups) {
			swapJ = random.nextInt(numPeople);
		}
		
		// swap
		int tmp = groups[swapI];
		groups[swapI] = groups[swapJ];
		groups[swapJ] = tmp;
	}
	@Override
	public void undo() {
		int tmp = groups[swapI];
		groups[swapI] = groups[swapJ];
		groups[swapJ] = tmp;
	}
	@Override
	public double energy() {
		double energy = 0;
		for (int g = 0; g < numGroups; g++) {
			for (int i = g; i < numPeople; i += numGroups) {
				int currPerson = groups[i];
				for (int j=i; j<numPeople; j+= numGroups) {
					int otherPerson = groups[j];
					energy -= (this.prefs[currPerson][otherPerson] + this.prefs[otherPerson][currPerson]);
 				}
			}
		}

		return energy;
	}
	
	@Override
	public Object clone() {
		try {
			GroupSorter copy = (GroupSorter) super.clone();
			copy.groups = this.groups.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int g = 0; g < numGroups; g++) {
			for (int i = g; i < numPeople; i += numGroups) {
				sb.append(groups[i] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
