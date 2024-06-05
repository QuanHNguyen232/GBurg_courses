public class OptimalReplacement extends FIFOReplacement {

	public OptimalReplacement(int f, int[] r) {
		super(f, r);
	}

	@Override
	public String toString() {
		return "OptimalReplacement: frames: " + this.frames + ", faults: " + this.faults;
	}

	public int predict(int[] fr, int page, int idx) {
		int result = -1;
		int farthest = idx;

		for (int i = 0; i < this.frames; i++) {
			int j = idx;
			
			// Case there is page reference in the future
			while (j < this.requests.length && fr[i] != this.requests[j]) {
				j++;
			}
			
			if (j == this.requests.length) { // Case a page is not referenced in future
				return i;
			}
			else if (j > farthest) { // Case is the farthest reference
				farthest = j;
				result = i;
			}
		}

		if (result == -1) { // Case all of the frames are not referenced
			return 0;
		}
		return result;
	}

	@Override
	public String runSimulation() {
		int[] fr = new int[this.frames];
		int idx = 0;
		
		for (int i = 0; i < this.requests.length; i++) {
			int page = this.requests[i];
			
			// Case duplicate
			if (this.set.contains(page)) {
				continue;
			}
			
			// Case there is space available
			if (idx < this.frames) {
				fr[idx] = page;
				idx++;
			}
			// Case run out of space
			else {
				int replaceIdx = predict(fr, page, i + 1);
				this.set.remove(fr[replaceIdx]);
				fr[replaceIdx] = page;
			}
			
			this.faults++;
			this.set.add(page);
		}
		return this.toString();
	}
}
