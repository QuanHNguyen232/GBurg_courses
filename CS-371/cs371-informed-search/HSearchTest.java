
/**
 * HSearchTest - apply a search algorithm to a root search node
 *
 * @author Todd Neller
 * @version 1.1
 *

Copyright (C) 2006 Todd Neller

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

Information about the GNU General Public License is available online at:
  http://www.gnu.org/licenses/
To receive a copy of the GNU General Public License, write to the Free
Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
02111-1307, USA.

 */

public class HSearchTest {

	/**
	 * <code>main</code> - apply a search algorithm to a root search
	 * node
	 *
	 * @param args a <code>String[]</code> value */
	public static void main(String[] args){

		// Create the searcher object (uncomment desired code)

//		HSearcher searcher = new BestFirstSearcher(new UniformComparator());
//		HSearcher searcher = new BestFirstSearcher(new GreedyComparator());
		HSearcher searcher = new BestFirstSearcher(new AStarComparator());

		// Create the root search node

		HSearchNode root = new RomaniaNode();

		if (searcher.search(root)) {
			// successful search
			System.out.println("Goal node found in " + searcher.getNodeCount() 
					+ " nodes.");
			System.out.println("Goal path:");
			searcher.printGoalPath();
		} else {
			// unsuccessful search
			System.out.println("Goal node not found in " 
					+ searcher.getNodeCount() + " nodes.");
		}

	}

} // HSearchTest