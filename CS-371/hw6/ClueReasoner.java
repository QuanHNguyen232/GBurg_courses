/**
 * ClueReasoner.java - project skeleton for a propositional reasoner
 * for the game of Clue.  Unimplemented portions have the comment "TO
 * BE IMPLEMENTED AS AN EXERCISE".  The reasoner does not include
 * knowledge of how many cards each player holds.  See
 * http://cs.gettysburg.edu/~tneller/nsf/clue/ for details.
 *
 * @author Todd Neller
 * @version 1.0
 *

Copyright (C) 2005 Todd Neller

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

import java.io.*;
import java.util.*;

public class ClueReasoner 
{
    private int numPlayers;
    private int playerNum;
    private int numCards;
    private SATSolver solver;    
    private String caseFile = "cf";
    private String[] players = {"sc", "mu", "wh", "gr", "pe", "pl"};
    private String[] suspects = {"mu", "pl", "gr", "pe", "sc", "wh"};
    private String[] weapons = {"kn", "ca", "re", "ro", "pi", "wr"};
    private String[] rooms = {"ha", "lo", "di", "ki", "ba", "co", "bi", "li", "st"};
    private String[] cards;

    public ClueReasoner()
    {
        numPlayers = players.length;

        // Initialize card info
        cards = new String[suspects.length + weapons.length + rooms.length];
        int i = 0;
        for (String card : suspects)
            cards[i++] = card;
        for (String card : weapons)
            cards[i++] = card;
        for (String card : rooms)
            cards[i++] = card;
        numCards = i;

        // Initialize solver
        solver = new SAT4JSolver();
        addInitialClauses();
    }

    private int getPlayerNum(String player)
    {
		if (player.equals(caseFile))
			return numPlayers;
		for (int i = 0; i < numPlayers; i++)
			if (player.equals(players[i])) 
				return i;
				
		System.out.println("Illegal player: " + player);
		return -1;
	}

    private int getCardNum(String card)
    {
		for (int i = 0; i < numCards; i++)
			if (card.equals(cards[i]))
				return i;
		System.out.println("Illegal card: " + card);
		return -1;
	}

    private int getPairNum(String player, String card)
    {
		return getPairNum(getPlayerNum(player), getCardNum(card));
	}

    private int getPairNum(int playerNum, int cardNum)
    {
		return playerNum * numCards + cardNum + 1;
	} 

    public void addInitialClauses() 
    {
        // TO BE IMPLEMENTED AS AN EXERCISE
        // Each card is in at least one place (including case file).
    	for (int c = 0; c < numCards; c++) {
			int[] clause = new int[numPlayers + 1];
			for (int p = 0; p <= numPlayers; p++) {
				clause[p] = getPairNum(p, c);
			}
			solver.addClause(clause);
		}
        
        // If a card is one place, it cannot be in another place.
        for (int c = 0; c < numCards; c++) {
            for (int p1 = 0; p1 < numPlayers; p1++) {
            	for (int p2 = p1+1; p2 <= numPlayers; p2++) {
            		int[] clause = {-getPairNum(p1, c), -getPairNum(p2, c)};
            		solver.addClause(clause);
            	}
            }
        }
        // At least one card of each category is in the case file.
        int[] suspect = new int[suspects.length];
		for (int s = 0; s < suspects.length; s++) {
			suspect[s] = getPairNum(caseFile, suspects[s]);
		}
		solver.addClause(suspect);
		
		int[] weap = new int[weapons.length];
		for (int w = 0; w < weapons.length; w++) {
			weap[w] = getPairNum(caseFile, weapons[w]);
		}
		solver.addClause(weap);


		int[] room = new int[rooms.length];
		for (int r = 0; r < rooms.length; r++) {
			room[r] = getPairNum(caseFile, rooms[r]);
		}
		solver.addClause(room);
		
        // No two cards in each category can both be in the case file.
		for (int w = 0; w < weapons.length; w++) {
			for (int e = w + 1; e < weapons.length; e++) {
				solver.addClause(new int[] {-getPairNum(caseFile, weapons[w]), -getPairNum(caseFile, weapons[e])});
			}
		}
		for (int w = 0; w < rooms.length; w++) {
			for (int r = w + 1; r < rooms.length; r++) {
				solver.addClause(new int[] {-getPairNum(caseFile, rooms[w]), -getPairNum(caseFile, rooms[r])});
			}
		}
		for (int w = 0; w < suspects.length; w++) {
			for (int s = w + 1; s < suspects.length; s++) {
				solver.addClause(new int[] {-getPairNum(caseFile, suspects[w]), -getPairNum(caseFile, suspects[s])});
			}
		}
    }
        
    public void hand(String player, String[] cards) 
    {
        playerNum = getPlayerNum(player);
        // TO BE IMPLEMENTED AS AN EXERCISE
        boolean[] playerHasCard = new boolean[numCards];
        for (String card : cards) {
        	playerHasCard[getCardNum(card)] = true;
        }
        for (int c=0; c<numCards; c++) {
        	solver.addClause(
        			playerHasCard[c] ? new int[] {getPairNum(playerNum, c)} : new int[] {-getPairNum(playerNum, c)}
        	);
        }
    }

    public void suggest(String suggester, String card1, String card2, 
                        String card3, String refuter, String cardShown) 
    {
        // TO BE IMPLEMENTED AS AN EXERCISE
    	if (refuter == null) {
			for (String p : players) {
				if (!p.equals(suggester)) {
					solver.addClause(new int[] { -getPairNum(p, card1) });
					solver.addClause(new int[] { -getPairNum(p, card2) });
					solver.addClause(new int[] { -getPairNum(p, card3) });
				}
			}
		}
    	else {
    		int suggesterPos = getPlayerNum(suggester);
    		int refuterPos = getPlayerNum(refuter);
    		int playerPos = (suggesterPos + 1) % numPlayers;
    		if (cardShown == null) {
    			while (playerPos != refuterPos) {
    				String player = players[playerPos];
    				solver.addClause(new int[] { -getPairNum(player, card1) });
    				solver.addClause(new int[] { -getPairNum(player, card2) });
    				solver.addClause(new int[] { -getPairNum(player, card3) });
    				playerPos = (playerPos + 1) % numPlayers;
    			}
    			// at least 1 out 3 cards belong to refuter
    			solver.addClause(new int[] { getPairNum(refuter, card1), getPairNum(refuter, card2), getPairNum(refuter, card3) });
    		}
    		else {
    			while (playerPos != refuterPos) {
    				String player = players[playerPos];
    				solver.addClause(new int[] { -getPairNum(player, card1) });
    				solver.addClause(new int[] { -getPairNum(player, card2) });
    				solver.addClause(new int[] { -getPairNum(player, card3) });
    				playerPos = (playerPos + 1) % numPlayers;
    			}
    			// add card to refuter
    			solver.addClause(new int[] { getPairNum(refuter, cardShown) });
    			// delete card from caseFile
    			solver.addClause(new int[] { -getPairNum(caseFile, cardShown) });
    		}
    	}
    }

    public void accuse(String accuser, String card1, String card2, 
                       String card3, boolean isCorrect)
    {
        // TO BE IMPLEMENTED AS AN EXERCISE
    	if (!isCorrect) { // at least 1 of the 3 card is not in caseFile
			int[] clause = {-getPairNum(caseFile, card1), -getPairNum(caseFile, card2), -getPairNum(caseFile, card3)};
			solver.addClause(clause);
		}
		else { // 3 cards are in the caseFile
			solver.addClause(new int[] {getPairNum(caseFile, card1)});
			solver.addClause(new int[] {getPairNum(caseFile, card2)});
			solver.addClause(new int[] {getPairNum(caseFile, card3)});
		}
    }

    public int query(String player, String card) 
    {
        return solver.testLiteral(getPairNum(player, card));
    }

    public String queryString(int returnCode) 
    {
        if (returnCode == SATSolver.TRUE)
            return "Y";
        else if (returnCode == SATSolver.FALSE)
            return "n";
        else
            return "-";
    }
        
    public void printNotepad() 
    {
        PrintStream out = System.out;
        for (String player : players)
            out.print("\t" + player);
        out.println("\t" + caseFile);
        for (String card : cards) {
            out.print(card + "\t");
            for (String player : players) 
                out.print(queryString(query(player, card)) + "\t");
            out.println(queryString(query(caseFile, card)));
        }
    }
        
    public static void main(String[] args) 
    {
        ClueReasoner cr = new ClueReasoner();
        String[] myCards = {"wh", "li", "st"};
        cr.hand("sc", myCards);
        cr.suggest("sc", "sc", "ro", "lo", "mu", "sc");
        cr.suggest("mu", "pe", "pi", "di", "pe", null);
        cr.suggest("wh", "mu", "re", "ba", "pe", null);
        cr.suggest("gr", "wh", "kn", "ba", "pl", null);
        cr.suggest("pe", "gr", "ca", "di", "wh", null);
        cr.suggest("pl", "wh", "wr", "st", "sc", "wh");
        cr.suggest("sc", "pl", "ro", "co", "mu", "pl");
        cr.suggest("mu", "pe", "ro", "ba", "wh", null);
        cr.suggest("wh", "mu", "ca", "st", "gr", null);
        cr.suggest("gr", "pe", "kn", "di", "pe", null);
        cr.suggest("pe", "mu", "pi", "di", "pl", null);
        cr.suggest("pl", "gr", "kn", "co", "wh", null);
        cr.suggest("sc", "pe", "kn", "lo", "mu", "lo");
        cr.suggest("mu", "pe", "kn", "di", "wh", null);
        cr.suggest("wh", "pe", "wr", "ha", "gr", null);
        cr.suggest("gr", "wh", "pi", "co", "pl", null);
        cr.suggest("pe", "sc", "pi", "ha", "mu", null);
        cr.suggest("pl", "pe", "pi", "ba", null, null);
        cr.suggest("sc", "wh", "pi", "ha", "pe", "ha");
        cr.suggest("wh", "pe", "pi", "ha", "pe", null);
        cr.suggest("pe", "pe", "pi", "ha", null, null);
        cr.suggest("sc", "gr", "pi", "st", "wh", "gr");
        cr.suggest("mu", "pe", "pi", "ba", "pl", null);
        cr.suggest("wh", "pe", "pi", "st", "sc", "st");
        cr.suggest("gr", "wh", "pi", "st", "sc", "wh");
        cr.suggest("pe", "wh", "pi", "st", "sc", "wh");
        cr.suggest("pl", "pe", "pi", "ki", "gr", null);
        cr.printNotepad();
        cr.accuse("sc", "pe", "pi", "bi", true);
    }           
}
