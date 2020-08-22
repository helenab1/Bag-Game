package game2;

import java.util.Random;
import java.lang.Math; 

public class Create {
	
	int numOfLevels;
	int numOfStoriesPerLevel;
	int maxDifficulty;

	public Create(int numOfLevels, int numOfStoriesPerLevel, int maxDifficulty) {
		this.numOfLevels = 6;
		this.numOfStoriesPerLevel = 20;
		this.maxDifficulty = 5; 
	}
	
	public void gatherUserInput() {
		//get num of levels & stories per level
	}
	
	public void createScores(int storiesPerLevel, int maxDifficulty) {
		// some basic input check sort of for now
		boolean passedCheck = false;
		if(storiesPerLevel % 5 != 0) { System.out.println("Not divisable by 5. Returning.");  return; }
		else if(storiesPerLevel % 5 == 0) { System.out.println("Divisible by 5. Creating " + storiesPerLevel + " scores for this project into an array."); passedCheck = true;}
		
		System.out.println("Passed check = " + passedCheck);
		
		//only do all this if number given passed the divisible by 5 test
		if(passedCheck) {
			// compute max difference between yes and no options
			//int MAX_DIFF = 5;
			int scoreGroups = storiesPerLevel / 5;
			int[] scoreArrayYES = new Random().ints(storiesPerLevel, -maxDifficulty, maxDifficulty).toArray();
			int[] scoreArrayNO = new int[storiesPerLevel];
		
			System.out.println("Difficulty: " + maxDifficulty);
			System.out.println("Number of score groups: " + scoreGroups);
		
			// create a 0 or 1 to determine + or - in the loop
			int max = 1; 
			int min = 0; 
			int range = max - min + 1; 
			int scoreCountDiff = 1;
		
			for(int i = 0; i < scoreArrayYES.length; i = i + scoreGroups) {
				System.out.println("scoreCountDiff = " + scoreCountDiff);
				for(int j = 0; j < scoreGroups; j++) {
					int rand = (int)(Math.random() * range) + min;
					System.out.println("The random number between 1 and 2 using Math.random is: " + rand);
					if(rand == 0) {
						//System.out.println("Did i get here");
						scoreArrayNO[j] = scoreArrayYES[j] - scoreCountDiff;
					}
					else if(rand == 1) {
						scoreArrayNO[j] = scoreArrayYES[j] + scoreCountDiff;
					}
					System.out.println("scoreArrayYes[" + j + "] = " + scoreArrayYES[j]);
					System.out.println("scoreArrayNo[" + j + "] = " + scoreArrayNO[j]);
				}		
				scoreCountDiff++;
			}
		}
	}
	
	public void writeScoresToTextFile() {
		
	}
	
	public void writeStoryOutlineToTextFile() {
		
	}
	
	public static void main(String[] args) {
		// ask for number of levels (will be number of text files generated total), number of stories per level (must be divisible by 5), & max difficulty (the highest difference between yes & no scores for determining groups)
		Create c = new Create(2, 25, 5);
		c.createScores(c.numOfStoriesPerLevel, c.maxDifficulty);
	}
}
