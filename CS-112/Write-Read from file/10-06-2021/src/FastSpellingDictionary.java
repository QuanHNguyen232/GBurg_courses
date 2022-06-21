
public class FastSpellingDictionary extends SpellingDictionary1 {

	@Override
	public boolean lookup(String word){

		int first = 0;
		int last = words.size()-1;
		int mid = (last + first + 1)/2;

		while(first <= last){
			String w = words.get(mid);
			int diff = word.compareTo(w);
			if(diff == 0){
				return true;
			}
			else if(diff < 0){
				last = mid - 1;
			}
			else {
				first = mid + 1;
			}


			mid = (last + first + 1)/2;
		}
		return false;
	}
}
