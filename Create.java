package game2;

import java.util.Random;
import java.util.stream.IntStream;

public class Create {
	
	final int MAX = 20;

	public Create() {
		// TODO Auto-generated constructor stub
	}
	
	public void createScores() {
		final int MAX = 20;
		// some basic input check sort of for now
		if(MAX % 5 != 0) { System.out.println("Not divisable by 5."); }
		else if(MAX % 5 == 0) { System.out.println("Divisible by 5. Creating " + MAX + " scores for this project into an array."); }
		
		// create array that's a double size of MAX
		final int LEVEL_MAX = MAX * 2;
		Integer[] scoreArrayYES = new Integer[MAX];
		Integer[] scoreArrayNO = new Integer[MAX];
		
		// can start with only distance betweens of one
		int MAX_DIFF = 5;
		int scoreGroups = MAX / 5;
		
		System.out.println("Difficulty: " + MAX_DIFF);
		System.out.println("Number of score groups: " + scoreGroups);
		
		Random random = new Random();
		//IntStream ints = random.ints(scoreGroups, -MAX_DIFF, MAX_DIFF);	// create four integers between -5 and 5
		//ints.forEach(System.out::println);
		
		int[] array = new Random().ints(scoreGroups, -MAX_DIFF, MAX_DIFF).toArray();
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		
	
		
		for(int i = 0; i < MAX_DIFF; i++) {
			for(int j = 1; j <= scoreGroups; j++) {
				// for each pair of 4
				// difficulty is increased (j) before the next one. difficulty = distance between
				
			}
		}
	}
	
	public static void main(String[] args) {
		Create c = new Create();
		c.createScores();
	}
}
