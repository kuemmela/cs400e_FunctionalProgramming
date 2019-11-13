/*  SortStringsFunctional.java
 * 
 *  Author:  Andy Kuemmel
 *  Course:  CS400,  Fall 2018
 *  
 * 	This class demonstrates how the Functional Interface Comparator works 
 *  part 0:  sort words using Collections.sort() and the natural ordering
 *  part 1:  sort words using an external class that implements Comparator
 *  part 2:  sort words using an inner class
 *  part 3:  sort words using an anonymous inner class
 *  part 4:  sort words using a named lambda expression
 *  part 5:  sort words using an unnamed lambda expression expressed as behavior
 *  
 */


import java.util.ArrayList;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStringsFunctional {
	public static void main(String[] args) {
		// part 0...Collections.sort(someList<T implements Comparable>)
		// sorts based on the compareTo method of T
		List<String> words = Arrays.asList("buzz", "qat", "kazoo", "cookie");
		Collections.sort(words);
		System.out.println("sort based on natural ordering: " + words);
		//System.exit(0);
		// but what if we don't want to sort things based on their 'natural ordering' ?

		
	
		
		
		
		
		
		// part 1...write a separate class to compare by Scrabble score
		Comparator<String> scrabbleScore = new ScrabbleScoreComparator();
		System.out.println(scrabbleScore.compare("often", "dog")); // functional programming example
		Collections.sort(words, scrabbleScore);
		System.out.println("sort based on scrabbleScore : " + words);
		//System.exit(0);


		
		
		
		
//		// part 2...write an inner class to compare based on num vowels
		// VowelComparator is declared below this class as a static inner class
		Comparator<String> vowelScore = new VowelComparator();
		Collections.sort(words, vowelScore);
		System.out.println("sort based on vowelScore : " + words);
		//System.exit(0);


		
		
//		// part 3...write an anonymous inner class to compare by hashCode
//		// this class is not named so we declare its type as a superclass or interface
//		// even though interfaces don't have constructors, we use ()
		
		
		Comparator<String> hashCodeComparator = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.hashCode() - s2.hashCode();
			} // method	
		}// anonymous inner class
		;  // this ends the statement declaring hashCodeComparator above
		Collections.sort(words, hashCodeComparator);
		System.out.println("sort based on hashCode: " + words);
		//System.exit(0);

		
		// part 3b
		// its possible dump the anonymous inner class inside the method call
		// I think its bad bad bad style so I never do this
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.hashCode() - s2.hashCode();
			} // method	
		});
		
		System.out.println("sort based on hashCode: " + words);
		//System.exit(0);
		

//		// part 4...write an instance of Comparator as a lambda function 
//		// this works because Comparator is a "functional interface"
//		// that is....an interface that contains a single public method
//		// and acts as a function of inputs, not an action of an object
		Comparator<String> lambdaLength  = 
				(String s1, String s2) -> s1.length() - s2.length(); // declaring types is optional
		Collections.sort(words, lambdaLength);
		System.out.println("sort based on length: " + words);
		//System.exit(0);


		
//		// part 5....use the lambda function as a parameter to a method, to pass behavior, not data
//		// the compiler figures out the type based on the functional interface
		Collections.sort(words, (a, b) -> a.length() - b.length());
		System.out.println("sort based on length again: " + words);
		System.exit(0);


		// Next: read the Docs.....java.util.function has other pre-made Functional Interfaces
		

		// On Your Own: .......write your own Functional Interfaces
	}// main
	
	

	// because this class is accessed from a static method,
	// it is declared static
	static class VowelComparator implements Comparator<String> {
		// compares two Strings based on number of vowels
		// fewer number of vowels comes first
		@Override
		public int compare(String s1, String s2) {
			return numVowels(s1) - numVowels(s2);
		}

		private int numVowels(String s) { // no static methods in inner classes
			s = s.toLowerCase();
			int result = 0;
			for (int i = 0; i < s.length(); i++) {
				if ("aeiou".contains(s.substring(i, i + 1))) {
					result++;
				}
			}
			return result;
		}// numVowels
	}// VowelComparator

	
	
	
}// class
