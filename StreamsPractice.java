import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class StreamsPractice {
		
	public static void main(String[] args) throws IOException {
		
	List<String> words = Arrays.asList("the", "Quick", "Brown", "the", "THE",
 "fox", "jumped", "jUmped", "over", "the", "lAzy", "dog");
	
	// collector is a list
//	List<String> result = words.stream()
//				.map(thing -> thing.toLowerCase())
//				.sorted()
//				.distinct()
//				.filter(word -> word.length() > 3) // keep
//				//.limit(2)
//				.collect(Collectors.toList());
//	System.out.println(result);
	

	// collector is a for/each iterator
//	words.stream()	
//			.map(x ->x.toLowerCase())
//			.distinct()
//			.filter(n -> n.contains("e"))
//			.forEach(thing -> {
//					for (int i=0; i < thing.length(); i++){ 
//						if (thing.charAt(i)=='e') System.out.print("e ");
//						else System.out.print("_ ");
//					}// for
//					System.out.println();
//				}
//			);//forEach collector

	 
	 // collector is a Long

//	long counter = words.stream()	
//				.map(x ->x.toLowerCase())
//				.filter(x -> x.contains("o"))
//				.count();
//	 System.out.println(counter + " items contain o");


	 
	 List<Student> students = Arrays.asList(
			 new Student("Stevie", 	10, Level.K12),
			 new Student("Meghan", 	21, Level.UNDERGRAD),
			 new Student("Josh", 	18, Level.UNDERGRAD),
			 new Student("Pratham", 25, Level.GRADUATE),
			 new Student("Alice", 	28, Level.CAPSTONE),
			 new Student("Sam", 	12, Level.K12),
			 new Student("Andy", 	25, Level.GRADUATE),
			 new Student("Sam", 	12, Level.K12)	// duplicate
			 );
	 
	 // make 3 different streams, with different collectors	
	 
	 
	 // 1.) A list of the ages, with no duplicates
	 
//	 List<Integer> distinctAges = students.stream()
//			 .map(Student::getAge)
//			 //.distinct()
//			 .sorted()
//			 .collect(Collectors.toList());
//	 System.out.println(distinctAges);

//	 // 2.) count how many students are less than 20, no duplicates
//	 long count = students.stream()
//		
//			 .filter(s -> s.getAge() < 20)
//			 .distinct()
//			 .count();
//	 System.out.println(count + " students with age < 20");
	 
	 // 3.) use Collectors to group students by Level
	 Map <Level, List<Student>> stuGroupings = students.stream()
			 .collect(Collectors.groupingBy(s -> s.getLevel()));
	 System.out.println(stuGroupings);
	 

	 // final example.....turn a file into a stream
	 
	 String fileName = "StreamsPractice.java";
	 String targetWord = "filter";
	 
//	 long countWord = Files.lines(Paths.get(fileName))
//			 	.map(String::trim)
//			 	.map(String::toLowerCase)
//			 	.filter(line -> line.contains(targetWord))
//			 	.count();
//	 System.out.println(countWord + " lines contain the word " + targetWord);
	    
//	 long countNonEmpty = Files.lines(Paths.get(fileName))
//			 	.map(String::trim)
//			 	.filter(line -> line.length() != 0)
//			 	.count();
//	 System.out.println(countNonEmpty + " lines that are not empty");
	 

	}// main

	enum Level {K12, UNDERGRAD, CAPSTONE, GRADUATE};
	static class Student {
		private String name;
		private int age;
		private Level level;
		
		Student(String name, int age, Level level){
			this.name = name;
			this.age = age;
			this.level = level;
		}
		public String getName() { return name;}
		public int getAge() { return age;}
		public Level getLevel() { return level;}
		public String toString() { return this.name + "-" + this.age + "-" + this.level;}
		public boolean equals(Student other) {
			return (this.getName().equals(other.getName())) &&
					(this.getAge() == other.getAge() )&&
					(this.getLevel().equals(other.getLevel()));
		}
	}


}

