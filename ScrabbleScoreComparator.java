/*  ScrabbleSortComparator.java
 * 
 *  Author:  Andy Kuemmel
 *  Course:  CS400,  Fall 2018
 *  
 * 	This class demonstrates how the Functional Interface Comparator works 
 *  Sometimes a Functional Interface is complicated enough to be in its own class
 *  As an added benefit, this class can be easily re-used in other programs
 *  
 */


import java.util.Comparator;

public class ScrabbleScoreComparator implements Comparator<String> {
	/*
	 * compares two Strings based on their Scrabble Score
	 * the lower Scrabble score comes first
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * Usage in a client class
	 *   List<String> myList = ....;
	 *   Comparator<String> scrabbleScoreComparator = new ScrabbleScoreComparator();
	 *   Collections.sort(myList, scrabbleScoreComparator);
	 *   OR
	 *   int result = scrabbleScoreComparator(word1, word2);
	 */
	
	@Override
	public int compare(String s1, String s2) {
		return computeScrabbleScore(s1) - computeScrabbleScore(s2);
	}
	
	private int computeScrabbleScore(String s) {
		s = s.toLowerCase();
		int result = 0;
		for (int i=0; i < s.length(); i++) {
			if ("aeiounstlr".contains(s.substring(i, i+1))){
				result += 1;
			} else if ("dg".contains(s.substring(i, i+1))){
				result += 2;
			}else if ("bcmp".contains(s.substring(i, i+1))){
				result += 3;
			}else if ("fhvwy".contains(s.substring(i, i+1))){
				result += 4;
			}else if ("k".contains(s.substring(i, i+1))){
				result += 5;
			}else if ("jx".contains(s.substring(i, i+1))){
				result += 8;
			}else if ("qz".contains(s.substring(i, i+1))){
				result += 10;
			}
		}
		return result;
	}
}

