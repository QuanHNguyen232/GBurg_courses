/**
 * SAT4JSolver.java - a simple Java interface to the SAT4J SAT solver.
 * See http://cs.gettysburg.edu/~tneller/nsf/clue/ for details.
 *
 * @author Todd Neller
 * @version 1.0
 *

Copyright (C) 2015 Todd Neller

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

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;

public class SAT4JSolver extends SATSolver
{
	ISolver solver = SolverFactory.newMiniLearning();
	int maxVar;

	public SAT4JSolver() {
		this(147); // The total number of (card, location) pairs that constitute all atomic sentences for the ClueReasoner
	}

	public SAT4JSolver(int maxvar) {
		this.maxVar = maxvar;
	}

	public int testLiteral(int literal) {
		int result = UNKNOWN;
		solver = SolverFactory.newMiniLearning();
		solver.newVar(maxVar);
		try {
			for (int[] clause : clauses)
				solver.addClause(new VecInt(clause));
		} catch (ContradictionException e1) {
			return FALSE;
		}
		try {
			IVecInt assumption = new VecInt();
			assumption.push(literal);
			if (!solver.isSatisfiable(assumption))
				result = FALSE;
			else {
				assumption.clear();
				assumption.push(-literal);
				if (!solver.isSatisfiable(assumption))
					result = TRUE;
			}
		} catch (TimeoutException e) {
			// unable to solve the problem in reasonable time
		}
		return result;
	}       

	@Override
	public boolean makeQuery() {
		solver = SolverFactory.newMiniLearning();
		solver.newVar(maxVar);
		try {
			for (int[] clause : clauses)
				solver.addClause(new VecInt(clause));
			for (int[] clause : queryClauses)
				solver.addClause(new VecInt(clause));
		} catch (ContradictionException e1) {
			return false;
		}
		try {
			return solver.isSatisfiable() ? true : false;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public static void main(String[] args) 
	{
		// Liar and truth-teller example test code:
		final int A = 1, B = 2, C = 3;
		int[][] clauses = {{-A, -B}, {B, A}, {-B, -C}, {C, B}, {-C, -A}, {-C, -B}, {A, B, C}};
		SAT4JSolver s = new SAT4JSolver(3);
		for (int i = 0; i < clauses.length; i++)
			s.addClause(clauses[i]);
		System.out.println("Knowledge base is satisfiable: " + s.makeQuery());
		System.out.print("Is Cal a truth-teller? ");
		int result = s.testLiteral(C);
		if (result == FALSE)
			System.out.println("No.");
		else if (result == TRUE)
			System.out.println("Yes.");
		else
			System.out.println("Unknown."); 
		
		// Our exercises from videos
		clauses = new int[][] {{-A, -C}, {C, A}, {-B, A}, {-B, C}, {-C, B}};
		s.clearClauses();
		s.clearQueryClauses();
		for (int i = 0; i < clauses.length; i++)
			s.addClause(clauses[i]);
		System.out.println("\nVideo sample:");
		System.out.println("Knowledge base is satisfiable: " + s.makeQuery());
		String[] names = {"", "Amy", "Bob", "Cal"};
		for (int i=1; i<=3; i++) {
			System.out.printf("Is %s a truth-teller? ", names[i]);
			result = s.testLiteral(i);
			if (result == FALSE)
				System.out.println("No.");
			else if (result == TRUE)
				System.out.println("Yes.");
			else
				System.out.println("Unknown.");
		}
		
	}
}