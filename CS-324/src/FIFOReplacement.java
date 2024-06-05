import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FIFOReplacement {
	public int frames; // number of frames
	public int[] requests; // array of pages
	public int faults; // number of faults
	public HashSet<Integer> set; // set to check if hit or fault
	
	public FIFOReplacement(int f, int[] r) {
		this.frames = f;
		this.requests = r;
		this.set = new HashSet<>(f);
	}
	
	@Override
	public String toString() {
		return "FIFOReplacement: frames: " + this.frames + ", faults: " + this.faults;
	}
	
	public String runSimulation() {
		Queue<Integer> queue = new LinkedList<>();
		
		for (int page : this.requests) {
			// Case duplicate
			if (this.set.contains(page)) {
				continue;
			}
			
			// Case out of space
			if (this.set.size() >= frames) {
				this.set.remove(queue.poll());
			}
			
			queue.add(page);
			this.set.add(page);
			this.faults++;
		}
		return this.toString();
	}
}
