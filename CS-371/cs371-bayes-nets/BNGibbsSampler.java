import java.util.ArrayList;
import java.util.Random;

/**
 * An implementation of the Gibbs Sampling Stochastic Simulation method for estimating Bayesian Network probabilities with/without evidence.
 * <b>You should only modify the simulate method.</b>
 * Algorithm from Section 4.4.3 of Pearl, Judea. "Probabilistic Reasoning in Intelligent Systems"
 */

public class BNGibbsSampler {
	/** iteration frequency of progress reports */
	public static int reportFrequency = 200000;
	/** total iterations; each non-evidence variable is updated in each iteration */
	public static int iterations = 1000000;

	/**
	 * Initialize parameters, parse input, display BN information, and perform Gibbs sampling. <b>You should not modify this method</b>
	 * @param args an array of command-line arguments
	 * @throws ParseException standard input does not match grammar for Bayesian network specification. (See assignment documentation for BNF grammar.)
	 */
	public static void main(java.lang.String[] args) throws ParseException {
		// Initialize iterations and update frequency
		if (args.length > 0) {
			iterations = Integer.parseInt(args[0]);
			reportFrequency = (args.length > 1) ? Integer.parseInt(args[1]) : iterations;
		}

		// Read in belief net specification from System.in
		new BNParse(System.in).parseInput();
		BNNode.printBN();

		// Do stochastic simulation.
		simulate();
	}

	/**
	 * Perform Stochastic Simulation as described in Section 4.4.3 of Pearl, Judea. "Probabilistic Reasoning in Intelligent Systems".
	 * The enclosed file pearl.out shows the output format given the input:
	 *   java BNGibbsSampler 1000000 200000 &lt; sample.in &gt; sample.out
	 * <b>This is the only method you should modify.</b>
	 */
	public static void simulate() {

		// ***INSERT YOUR CODE HERE***
		// Build a list of nonEvidence nodes
		ArrayList<BNNode> nonEvidenceNodes = new ArrayList<>();
		for (BNNode node : BNNode.nodes) {
			if (!node.isEvidence) {
				nonEvidenceNodes.add(node);
			}
		}
		
		// Randomly assign them
		Random random = new Random();
		for (BNNode node : nonEvidenceNodes) {
			node.value = random.nextBoolean();
		}
		
		// Initialize statistics
		int numNENs = nonEvidenceNodes.size();
		int[] trueCounts = new int[numNENs];
		double[] totalCPs = new double[numNENs];
		
		// For each iteration
		for (int i=0; i<iterations; i++) {
			// loop through each nonEvidence node and update
			// For each nonEvidence node,
			for (int j=0; j<numNENs; j++) {
				// set node to true ...
				BNNode node = nonEvidenceNodes.get(j);
				node.value = true;
				// ... compute the CPT entry (without normalizing constant)
				double trueCP = node.cptLookup();
				// ... and for each child ...
				for (int k=0; k<node.children.length; k++) {
					// ... multiply this by the child CPT entry
					// (or 1 - that if the child is false)
					trueCP *= (node.children[k].value) ? node.children[k].cptLookup() : (1 - node.children[k].cptLookup());
				}
				
				// set node to false ...
				node.value = false;
				// ... compute the CPT entry (without normalizing constant)
				double falseCP = 1 - node.cptLookup();
				// ... and for each child ...
				for (int k=0; k<node.children.length; k++) {
					// ... multiply this by the child CPT entry
					// (or 1 - that if the child is false)
					falseCP *= (node.children[k].value) ? node.children[k].cptLookup() : (1 - node.children[k].cptLookup());
				}
				// compute the normalization to get the probabilityof being true ...
				trueCP = trueCP / (trueCP + falseCP);
				falseCP = 1 - trueCP;
				// ... add this to the conditional probability total for the
				totalCPs[j] += trueCP;
				// ... pick a new random value for the node accord to this probability
				node.value = random.nextDouble() < trueCP;
				// ... and tally the assignment if it's true
				if (node.value) {
					trueCounts[j]++;
				}
			}
			// report with a given frequency
			if ((i + 1) % reportFrequency == 0 || i == iterations - 1) {
				System.out.println("\t\t\t\t\t\t");
				System.out.printf("After iteration %d:\n", i+1);
				System.out.println("Variable, Avg. Cond. Prob., Fraction True");
				for (int j=0; j<numNENs; j++) {
					BNNode node = nonEvidenceNodes.get(j);
					System.out.printf("%s, %f, %f\n", node.name, totalCPs[j]/(i+1), (double) trueCounts[j]/(i+1));
				}
			}
		}
		
	}
}


