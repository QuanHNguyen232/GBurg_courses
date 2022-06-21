import java.util.Random;

public class RandomFun {

	public static void main(String[] args) {
		System.out.println(Math.random());	// random double in range [0.0, 1.0)
		
		// How to create a random number with a given range from a min value to a max value
		int min = 1;
		int max = 6;
		int numValues = max - min + 1;
		System.out.println(numValues * Math.random());	// [0.0, numValues)
		System.out.println((int) (numValues * Math.random()));	// {0, ..., numValues - 1}
		System.out.println(min + (int) (numValues * Math.random()));
		// {min, ..., min + numValues - 1}
		// = {min, ..., min + (max - min + 1) - 1}
		// = {min, ..., max}
		
		
		// Java's Random class
		Random random = new Random();
		System.out.println(random.nextDouble());
		System.out.println(random.nextInt());
		System.out.println(min + random.nextInt(numValues));
		System.out.println(random.nextGaussian());
		// Also nextBoolean(), nextFloat(), nextLong()
		
		
		
		// Pseudorandom number generator (PRNG)
		// Starting with an initial "seed" number,
		// sequentially puts the number through a lot of numeric blender to generate a next internal number such that:
		// - internal numbers can be used to produce generated random numbers,
		// - sequences of generated numbers tend to be different from  each other,
		// - statistical tests cannot differentiate them from truly random,
		// - attackers cannot to practically deduce the past, present, or future inner state of the PRNG.
		
		random = new Random(42);
		System.out.println(1 + random.nextInt(6));
		System.out.println(1 + random.nextInt(6));
		random.setSeed(42);
		System.out.println(1 + random.nextInt(6));
		System.out.println(1 + random.nextInt(6));

		
	}

}
