package game2;

import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math; 

public class Create {
	
	int numOfLevels;
	int numOfStoriesPerLevel;
	int maxDifficulty;
	private int[] scoreArrayYES;
	private int[] scoreArrayNO;

	public Create(int numOfLevels, int numOfStoriesPerLevel, int maxDifficulty) {
		this.numOfLevels = numOfLevels;
		this.numOfStoriesPerLevel = numOfStoriesPerLevel;	// must be under 1000! or ...?
		this.maxDifficulty = maxDifficulty; 
		this.scoreArrayYES = new int[numOfStoriesPerLevel];
		this.scoreArrayNO = new int[numOfStoriesPerLevel];
	}
	
	public void createScores(int storiesPerLevel, int maxDifficulty, int[] scoreArrayYES, int[] scoreArrayNO) {
		// some basic input check sort of for now
		boolean passedCheck = false;
		if(storiesPerLevel % maxDifficulty != 0) { System.out.println("Number of stories is NOT divisable by difficulty. Returning.");  return; }
		else if(storiesPerLevel % maxDifficulty == 0) { System.out.println("Number of stories is divisible by difficulty. Creating " + storiesPerLevel + " scores for this project into an array."); passedCheck = true;}
		
		System.out.println("Passed check = " + passedCheck);
		
		if(passedCheck) {
			int scoreGroups = storiesPerLevel / maxDifficulty;
			this.scoreArrayYES = new Random().ints(storiesPerLevel, -maxDifficulty, maxDifficulty).toArray();
			this.scoreArrayNO = new int[storiesPerLevel];
		
			System.out.println("Difficulty: " + maxDifficulty);
			System.out.println("Number of score groups: " + scoreGroups);
		
			// create a 0 or 1 to determine + or - in the loop (for scores of 0)
			int max = 1; 
			int min = 0; 
			int range = max - min + 1; 
			int scoreCountDiff = 1;
		
			for(int i = 0; i < scoreArrayYES.length; i = i + scoreGroups) {	
				//System.out.println("scoreCountDiff = " + scoreCountDiff);
				for(int j = i; j < i + scoreGroups; j++) {
					if(this.scoreArrayYES[j] < 0) {
						this.scoreArrayNO[j] = this.scoreArrayYES[j] + scoreCountDiff;
					}
					else if(this.scoreArrayYES[j] > 0) {
						this.scoreArrayNO[j] = this.scoreArrayYES[j] - scoreCountDiff;
					}
					else if(this.scoreArrayYES[j] == 0) {
						int rand = (int)(Math.random() * range) + min;
						//System.out.println("The random number between 1 and 2 using Math.random is: " + rand);
						if(rand == 0) {
							this.scoreArrayNO[j] = this.scoreArrayYES[j] - scoreCountDiff;
						}
						else if(rand == 1) {
							this.scoreArrayNO[j] = this.scoreArrayYES[j] + scoreCountDiff;
						}
					}
					System.out.println("scoreArrayYes[" + j + "] = " + this.scoreArrayYES[j]);
					System.out.println("scoreArrayNo[" + j + "] = " + this.scoreArrayNO[j]);
				}		
				scoreCountDiff++;
			}
		}
	}
	
	public void createFile(int level) {
		try {
			File myObj = new File("level" + level + ".txt");
		    if (myObj.createNewFile()) {
		    	System.out.println("File created: " + myObj.getName());
		    } 
		    else {
		    	System.out.println("File already exists.");
		    }
		} catch (IOException e) {
		    	System.out.println("An error occurred.");
		    	e.printStackTrace();
		    }
	}
	public void writeScoresToTextFile(int numOfStoriesPerLevel, int[] scoreArrayYES, int[] scoreArrayNO) {
		try {
			FileWriter myWriter = new FileWriter("level1.txt");	//will loop to accept level num and write & create scores at once
			for(int i = 1; i <= (numOfStoriesPerLevel * 2); i++) {
				if(i < 10) {
					myWriter.write(i + "y__ " + scoreArrayYES[i-1] + "\n");
					myWriter.write(i + "n__ " + scoreArrayNO[i-1] + "\n");	// NEED to clean this up with less repeating. 10 gets skipped. rewrite __ string each time?
					//System.out.println(i + " is " + scoreArrayYES[i] + " and " + scoreArrayNO[i]);
				}
				else if(i >= 10 && i < 100) {
					myWriter.write(i + "y_ " + scoreArrayYES[i-1] + "\n");	
					myWriter.write(i + "n_ " + scoreArrayNO[i-1] + "\n");	// out of bounds error still will trace later
					//System.out.println(i + " is " + scoreArrayYES[i] + " and " + scoreArrayNO[i]);
				}
				else if(i > 100) {
					//myWriter.write(i+1 + "y " + scoreArrayYES[i] + "\n");
					//myWriter.write(i+1 + "n " + scoreArrayNO[i] + "\n");
				}
			}
		    myWriter.close();
		    System.out.println("Successfully wrote to the file."); 
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public void writeStoryOutlineToTextFile() {
		
	}
	
	public static void main(String[] args) {
		// ask for number of levels (will be number of text files generated total), number of stories per level (must be divisible by 5), & max difficulty (the highest difference between yes & no scores for determining groups)
		Create c = new Create(1, 20, 5);
		c.createScores(c.numOfStoriesPerLevel, c.maxDifficulty, c.scoreArrayYES, c.scoreArrayNO);
		c.createFile(c.numOfLevels);	// will have to change to loop to create them all
		c.writeScoresToTextFile(c.numOfStoriesPerLevel, c.scoreArrayYES, c.scoreArrayNO);
	}
}
