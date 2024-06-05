import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class LRUReplacement extends FIFOReplacement {

	public LRUReplacement(int f, int[] r) {
		super(f, r);
	}

	@Override
	public String toString() {
		return "LRUReplacement: frames: " + this.frames + ", faults: " + this.faults;
	}

	@Override
	public String runSimulation() {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < requests.length; i++) {
			int page = requests[i];

			//if duplicate, update index of page in frames
			if (this.set.contains(page)) {
				map.put(page, i); 
				continue;
			}

			//if no space available
			if (this.set.size() >= frames) { 
				int lru = Integer.MAX_VALUE;
				int val = Integer.MIN_VALUE;

				ArrayList<Integer> arr = new ArrayList<>(this.set);
				for (int tmp : arr) {
					int idx = map.get(tmp);
					if (idx < lru) { 
						lru = idx; 
						val = tmp; 
					}
				}

				this.set.remove(val); 
				map.remove(val); 
			}

			this.faults++; 
			this.set.add(page); 
			map.put(page, i); 
		}
		return this.toString();
	}
}

