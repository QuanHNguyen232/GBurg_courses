import java.util.Scanner;


public class ReplacementAlgorithms {

	public static void helper(int frames, int[] requests) {
		
		if (frames == 0) {
			for (int i = 1; i <= 7; i++) {
				System.out.println(new FIFOReplacement(i, requests).runSimulation());
			}
			System.out.println("-----------------");
			for (int i = 1; i <= 7; i++) {
				System.out.println(new LRUReplacement(i, requests).runSimulation());
			}
			System.out.println("-----------------");
			for (int i = 1; i <= 7; i++) {
				System.out.println(new OptimalReplacement(i, requests).runSimulation());
			}
		}
		else {
			System.out.println(new FIFOReplacement(frames, requests).runSimulation());
			System.out.println("-----------------");
			System.out.println(new LRUReplacement(frames, requests).runSimulation());
			System.out.println("-----------------");
			System.out.println(new OptimalReplacement(frames, requests).runSimulation());
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Number of frames between 1 and 7 (0 to run all): ");
		int frames = in.nextInt();

		System.out.print("Number of page requests to simulate between 1 and 100: ");
		int numRequests = in.nextInt();

		System.out.print("Requests: ");
		in.nextLine();
		
		System.out.println();
		int[] requests = new int[numRequests];
		
		for (int i = 0; i < numRequests; i++) {
			requests[i] = in.nextInt();
		}
		
		helper(frames, requests);
		in.close();
	}
	
	/*
	 * No of frames: 0
	 * No of requests: 100
	 * request list:
		4 4 6 3 3 4 5 8 6 8 2 8 1 7 1 3 8 9 3 8 8 6 5 2 9 7 2 9 0 3 7 6 1 1 2 5 9 1 5 3 2 0 3 5 8 8 1 5 5 1 4 7 8 1 7 4 4 7 0 7 1 6 9 8 5 3 7 2 8 2 3 2 8 8 2 6 5 5 4 7 4 9 0 3 3 9 0 5 9 9 9 3 0 5 2 0 7 1 4 2
	 */
}
