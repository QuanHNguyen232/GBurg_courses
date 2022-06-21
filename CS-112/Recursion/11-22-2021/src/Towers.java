

public class Towers {

	public static void solveTowers(int n, int from, int to, int using){
		if(n == 0)
			return;

		//move a smaller tower to the temp post
		solveTowers(n-1, from, using, to);

		System.out.printf("Move a disk from tower %d to %d.\n", from, to);

		//move the smaller tower on the temp pots to the destination
		solveTowers(n-1, using, to, from);
	}

	public static void main(String[] args){
		solveTowers(3, 0, 1, 2);
	}

}