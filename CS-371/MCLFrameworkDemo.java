import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MCLFrameworkDemo {
	public static int LINE_WIDTH = 80;
	public static Random random = new Random();
	public static double sensorVariance = 0.01;
	public static double proportionalMotionVariance = 0.01;
	public static boolean verbose = true;
	
	public static void main(String[] args) {
		// Simulation of MCL with random left-right movement in the range [0, 1), Gaussian measurement error (distance to 0), and Gaussian motion error.
		
		// Initial actual pose
		double actual = Math.random();
		
		// Initial pose hypotheses population
		final int M = 100;
		ArrayList<Double> x = new ArrayList<Double>();
		for (int i = 0; i < M; i++)
			x.add(Math.random());
		showPopulation(x, actual);
		
		final int TIME_STEPS = 50; // just for demo purposes
		for (int t = 0; t < TIME_STEPS; t++) {
			// make up simulated motion command u, measurement reading z
			double u = (Math.random() - .5) / 5;
			// keep in bounds
			while (actual + u >= 1.0 || actual + u < 0.0)
				u = (Math.random() - .5) / 10;

			double newActual = sample_motion_model(u, actual);
			double newSensorMeasurement = sample_sensor_model(newActual);
			
			// MCL iteration

			class PoseWeightPair { // just what the name says it is
				double pose;
				double weight;
				public PoseWeightPair(double pose, double weight) {
					this.pose = pose;
					this.weight = weight;
				}
				public String toString() {
					return String.format("(%g, %g)", pose, weight);
				}
			}
			
			// Algorithm MCL line 2:
			ArrayList<PoseWeightPair> poseWeightPairs = new ArrayList<PoseWeightPair>(); // X-bar sub t
			ArrayList<Double> newX = new ArrayList<Double>(); // X sub t
			
			// Algorithm MCL line 3:
			for (int m = 0; m < M; m++) {
				// sample hypothesis pose forward
				double pose = x.get(m);
				// Algorithm MCL line 4:
				double newPose = sample_motion_model(u, pose);
				// Algorithm MCL line 5:
				double weight = measurement_model(newSensorMeasurement, newPose);  // map is just [0, 1] interval space for movement, sensing distance from 0
				// Algorithm MCL line 6:
				poseWeightPairs.add(new PoseWeightPair(newPose, weight));
			}
//			System.out.println(poseWeightPairs);
			
			// Compute probabilities (proportional to weights) and cumulative distribution function for sampling of next pose population
			// NOTE: This is the heart of weighted resampling that is _not_ given in the text pseudocode.
			// - first sum weights
			double weightSum = 0;
			for (int m = 0; m < M; m++)
				weightSum += poseWeightPairs.get(m).weight;
			// - next compute probabilities for each of the new population candidates to be sampled (i.e. PDF = probability density function)
			double[] probabilities = new double[M];
			for (int m = 0; m < M; m++)
				probabilities[m] = poseWeightPairs.get(m).weight / weightSum;
//			System.out.println(Arrays.toString(probabilities));
			// - next compute cumulative distribution function (CDF), the probability of sampling item <= m.
			double[] cdf = new double[M];
			double sum = 0;
			for (int m = 0; m < M; m++) {
				sum += probabilities[m];
				cdf[m] = sum;
			}
			cdf[M - 1] = 1.0; // last is always 1.0 regardless of floating point errors
			
			// Back to text MCL Algorithm resampling (drawing) portion of pseudocode
			// Algorithm MCL line 8:
			for (int m = 0; m < M; m++) {
				// Algorithm MCL line 9 _in greater detail_:
				double p = Math.random(); // sample in [0, 1)
				// now use CDF to determine which index is being sampled:
				int index = 0;
				while (p >= cdf[index])
					index++;
				// Note: The first index where p < cdf[index] is the one we sample.  
				//   We could find this index more efficiently with a binary search
				//   but I wanted to keep this bit as simple to understand as possible.
				
				// Algorithm MCL line 10:
				newX.add(poseWeightPairs.get(index).pose);
			}
			
			// Get ready for next iteration:
			x = newX;
			actual = newActual;
			showPopulation(x, actual);
		}
		
	}
	
	// Note: Each showPopulation call creates an output line with "|" showing the actual [0, 1) position of the robot,
	// "?" showing the mean hypothesis pose (possibly occluded by "|"),  
	// and "*" showing the presence of one or more hypothesis poses (i.e. particles, states).
	public static void showPopulation(ArrayList<Double> x, double actual) {
		char[] intervalChars = new char[LINE_WIDTH];
		Arrays.fill(intervalChars, ' ');
		double poseSum = 0;
		for (double pose : x) {
			intervalChars[(int) Math.floor(pose * LINE_WIDTH)] = '*';
			poseSum += pose;
		}
		intervalChars[(int) Math.floor(poseSum / x.size() * LINE_WIDTH)] = '?';
		intervalChars[(int) Math.floor(actual * LINE_WIDTH)] = '|';
		System.out.println(new String(intervalChars));
	}
	
	public static double sample_motion_model(double u, double x) {
		double newX = x + u + sample_normal_distribution(Math.abs(u * proportionalMotionVariance)); // making variance proportional to magnitude of motion command
		return Math.max(0, Math.min(.99999, newX));  // bound between 0 and <1 for this example simulation
	}
	
	// see text Table 5.4
	public static double sample_normal_distribution(double variance) { 
		double sum = 0;
		for (int i = 0; i < 12; i++)
			sum += (2.0 * Math.random()) - 1.0;
		return Math.sqrt(variance) * sum / 2.0;
	}
	
	public static double sample_sensor_model(double pose) {
		// ideal sensor will return pose (distance to right of 0), but we'll model Gaussian noise (could have more components as in class)
		return pose + sample_normal_distribution(sensorVariance);
	}
	
	public static double measurement_model(double z, double x) { // map in this case is [0, 1] allowable poses
		// Gaussian (i.e. normal) error, see https://en.wikipedia.org/wiki/Normal_distribution
		// same as p_hit in Figure 6.2(a), but without bounds. Table 5.2
		double diff = z - x;
		return (1.0 / Math.sqrt(2 * Math.PI * sensorVariance)) * Math.exp(- (diff * diff) / (2 * sensorVariance));
	}
}
