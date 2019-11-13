import java.util.Arrays;
import java.util.Scanner;

public class ValueGeneratorLambda {
	
	interface ValueGenerator {	// inner interface ??
	    int getNextValue(int prev);
	}

	static int [] getSequence(ValueGenerator vg, int v0, int n) {
	    int [] sequence = new int [ n ] ;
	    sequence[0] = v0;
	    for (int i=1; i < sequence.length; i++){
	        sequence[i] = vg.getNextValue(sequence[i-1]);
	    } 
	    return sequence;
	}
	
	public static void main(String[] args) {
		int [] s1 = getSequence( (int prev) -> prev + 1, 100, 3 ); // 100, 101, 102
		System.out.println(Arrays.toString(s1));
		
		
	}

}
