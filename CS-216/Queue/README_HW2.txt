Name: Quan Nguyen

Issues:
- Queue
	+ ChangeKey works, but I haven't included all cases yet (it can have NullPointException)
	+JUnit: I still cannot find a good way to test all parts of ChangeKey

- BSTree
	+ Your code in Remove (case: 1 CHILD -> LEFT -> ROOT): I think it should be this.head = node_to_replace instead of this.head.setLeft() since we assign '=' in the Insert(), not setLeft/Right. It also causes after remove, the head.getData() is still the old one
	+ In Remove(), there are too many cases, I am not sure if I covered all

*Here were what I remembered 10 minutes before submitting. I will discuss it with you later when I have more questions

