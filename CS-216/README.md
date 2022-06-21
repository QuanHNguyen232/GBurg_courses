# CS216 Spring 2022

Instructor: Prof. Daniel White

Textbook:
- [Data Structures and Algorithms by Barnett and Del Tongo](https://www.dbooks.org/data-structures-and-algorithms-5591691121/)
- Algorithms by Dasgupta, Papadimitriou, and Vazirani


#### HWs comment
1. [HW1: Linked lists](#HW1-Linked-lists)
2. [HW2: Priority queue and binary search tree](#HW2-Priority-queue-and-binary-search-tree)
3. [HW3: Hash tables](#HW3-Hash-tables)
4. [HW4: AVL trees](#HW4-AVL-trees)
5. [HW5: Graph theory](#HW5-Graph-theory)
6. [HW6: Graph code](#HW6-Graph-code)
7. [HW7: Graph paths](#HW7-Graph-paths)
8. [HW8: Weighted graphs](#HW8-Weighted-graphs)


## HW1: Linked lists
TOTAL: 96 / 100

( 10 / 10 ) Style and readability:
- satisfactory

( 10 / 10 ) Java Doc:
- satisfactory

( 28 / 30 ) JUnit testing:
- Careful: the search and traverse methods only make use of forward pointers. When testing things like insert and remove, you’ll want to verify in some way that backward pointers have been correctly bound.

( 10 / 10 ) Group coding:
- satisfactory

( 38 / 40 ) Solo coding:
- Note that you’re essentially doubling the time complexity of the remove methods by using the search helper method. This does not affect things through a big-O lens, but is a bit inefficient. Of course, sometimes inefficiencies are acceptable if they bring simplicity, but I would argue that your code is no simpler than our approach from class.


## HW2: Priority queue and binary search tree
TOTAL: 93 / 100

( 9 / 10 ) Style and readability:
- Please add commentary, for example, in badWeightBalance. It’s difficult to understand what you’re doing without some explanation.

( 8 / 10 ) Java Doc:
- Make sure to include Java Doc above the class headers so that a description for each class is given after documentary is compiled.
- I know these nodes are kind of boring, but the public methods should technically have Java Doc commentary.

( 28 / 30 ) JUnit testing:
- Failed assertion in testInsert_DeleteMin().
- A robust test for changeKey (after checking out-of-bounds-index) is to populate a large priority queue and pick many many elements to change at random with changeKey. Then call deleteMin() until queue is empty. If changeKey maintained min-heap property, then the sequences of values from calling deleteMin() will be non-decreasing. Conversely, it is likely that the sequence will not be non-decreasing if changeKey fails to maintain min-heap property.
- The test for checkWeightBalance should check beyond the case where the tree has one node. Also, an empty treee is balanced vacuously.
- In your badWeightBalance check, you actually use checkWeightBalance in a larger setting, OK.

( 10 / 10 ) Group coding
- satisfactory

( 38 / 40 ) Solo coding
- Keep in mind that having a public getHead method in BST is a bad idea if pushing our implementation out for more public use. OK temporarily for testing though.
- Please remove printing from non-test class methods.
- Your badWeightBalance is difficult to parse completely, but it appears you’re doing the correct recursive operations. Consider adding commentary.
- If you want to talk about your concerns with the remove method (as stated in README.txt), please stop by office hours and we can analyze.


## HW3: Hash tables
TOTAL: 96 / 100

( 10 / 10 ) Style and readability:
- satisfactory

( 10 / 10 ) Java Doc:
- Add javadoc commentary for the class itself.

( 26 / 30 ) JUnit testing:
- Note that your test of maxdepth and avgdepth are very specific to the hash function in your implementation of the hash table. They will not correctly test for an arbitrary hash function.
- The real test of the resize method should occur when it is naturally called by the add and delete methods. In other words, run a test where you add many elements into your hash table, then check that a resize occurred correctly and naturally. Then delete many elements and also verify the same for a compression.

( 10 / 10 ) Group coding:
- satisfactory

( 40 / 40 ) Solo coding:
- satisfactory


## HW4: AVL trees
TOTAL: 100 / 100

Great job!

( 10 / 10 ) Style and readability:
- satisfactory

( 10 / 10 ) Java Doc:
- satisfactory

( 30 / 30 ) JUnit testing:
- great

( 10 / 10 ) Group coding:
- satisfactory

( 40 / 40 ) Solo coding:
- satisfactory


## HW5: Graph theory
TOTAL: 90 / 100

( 10 / 10 ) Exercise 3.1

( 10 / 10 ) Exercise 3.2

( 8/ 10 ) Exercise 3.3:
- The topological ordering from dfs is given by descending post values.

( 10 / 10 ) Exercise 3.4 (part ii checked for completion)

( 10 / 10 ) Exercise 3.5

( 10 / 10 ) Exercise 3.10

( 5 / 10 ) Exercise 3.11:
- Your algorithm I think returns True on the undirected graph u – v. There’s a short solution to this problem: remove(e) from graph and run explore from u. There a cycle containing e if and only if v is visited.


## HW6: Graph code
TOTAL: 100 / 100

( 10 / 10 ) Style and readability:
- satisfactory

( 10 / 10 ) Java Doc:
- satisfactory

( 30 / 30 ) JUnit testing:
- satisfactory

( 10 / 10 ) Group coding:
- satisfactory

( 40 / 40 ) Solo coding:
- Your metagraph method looks good by a read-through. Can you detail any issues? This is why the README.txt file is important


## HW7: Graph paths
Graded by completion

## HW8: Weighted graphs
Graded by completion
