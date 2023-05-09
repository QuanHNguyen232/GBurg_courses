import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class DistantSamplerState implements State {
	
	public double[][] data;
	public int numSamples;
	public int[] selectedSampleIdx;
	Random rand;
	public int[] lastSwap = {-1, -1};
	
	public DistantSamplerState(double[][] data, int numSamples) {
		this.numSamples = numSamples;
		this.selectedSampleIdx = new int[data.length];
		this.data = new double[data.length][data[0].length];
		rand = new Random();
		// deep clone
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[0].length; c++) {
				this.data[r][c] = data[r][c];
			}
			selectedSampleIdx[r] = r;
		}
	}
	
	public int[] getSampleIndices() {
		int[] tmp = Arrays.copyOfRange(selectedSampleIdx, 0, numSamples);
		Arrays.sort(tmp);
		return tmp;
	}
	
	@Override
	public void step() {		
		//no data just indices
		int selectIdx = rand.nextInt(this.numSamples);	// select the first m samples
		int remainIdx = rand.nextInt(data.length - this.numSamples) + this.numSamples;	// select the rest n - m samples 

		int tmp = selectedSampleIdx[selectIdx];
		selectedSampleIdx[selectIdx] = selectedSampleIdx[remainIdx];
		selectedSampleIdx[remainIdx] = tmp;
		
		lastSwap[0] = selectIdx;
		lastSwap[1] = remainIdx;
	}
	
	@Override
	public void undo() {
		int selectIdx = lastSwap[0];
		int remainIdx = lastSwap[1];
		
		int tmp = selectedSampleIdx[selectIdx];
		selectedSampleIdx[selectIdx] = selectedSampleIdx[remainIdx];
		selectedSampleIdx[remainIdx] = tmp;
	}
	
	@Override
	public double energy() {
		double energy = 0;
		for (int idx1 = 0; idx1 < numSamples - 1; idx1++) {
			double[] pt1 = this.data[selectedSampleIdx[idx1]];
			
			for (int idx2 = idx1 + 1; idx2 < numSamples; idx2++) {
				double[] pt2 = this.data[selectedSampleIdx[idx2]];
				
				double local_energy = 0;
				for (int dim = 0; dim < pt1.length; dim++) {
					local_energy += Math.pow(pt1[dim] - pt2[dim], 2);
				}
				energy += 1/(Math.sqrt(local_energy));
			}
		}
		return energy;
	}
	
	@Override
	public Object clone() {
		try {
			DistantSamplerState copy = (DistantSamplerState) super.clone();
			copy.selectedSampleIdx = this.selectedSampleIdx.clone();
			copy.lastSwap = this.lastSwap.clone();
			copy.data = new double[this.data.length][this.data[0].length];
			for (int r = 0; r < this.data.length; r++) {
				for (int c = 0; c < this.data[0].length; c++) {
					copy.data[r][c] = this.data[r][c];
				}
			}
			return copy;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(Arrays.toString(Arrays.copyOfRange(selectedSampleIdx, 0, numSamples)));
//		sb.append(Arrays.toString(Arrays.copyOfRange(selectedSampleIdx, this.numSamples, data.length)));
		
		return sb.toString();
	}
	
//	public static void main(String[] args) {
//		double[][] data = {
//				{0, 2},
//				{1, 2},
//				{2, 2},
//				{3, 2},
//				{4, 2},
//				{5, 2},
//				{6, 2},
//				{7, 2},
//				{8, 2},
//				{9, 2}
//		};
//		DistantSamplerState state = new DistantSamplerState(data, 4);
//		
//		State minState = new SimulatedAnnealer(state, 10000, .99999).search(1000);
//		
//		System.out.println(state);
//	}

}
