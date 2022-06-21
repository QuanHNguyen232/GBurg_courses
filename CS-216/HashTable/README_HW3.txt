Quan Nguyen

Questions:
	checkCompress?
	


Issues:
	- if add to 400 -> StackOverflowError (but add to small number -> eg:98, everything is find)
	- you when to checkExpand when add, but when resize, we add which result that it will automatically resize back
	myHashTable<Integer> hash1 = new myHashTable<Integer>();
		for (int i = 0; i < 100; i++) {
			hash1.add(i);			
		}
		// size now is 256 (100/128>0.75)
		hash1.resizeTable(128);
		// size now is 128, but in that method, it "add", so size will update back to 256
	// Solution: I suggest creating new ArrayList instead of new HashTable






