package main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import stdlib.StdIn;
import stdlib.StdOut;

public class Game {
	
	final int MAX_STORIES = 20;
	final int MAX_READ_STORIES = 10;	// stories that will be randomly read from master text file. can adjust to the ratio you need.
	final int MAX_LEVELS = 3; // testing with low number. can adjust to whatever I end up wanting for the first game.
	
	Integer[] totalStories = new Integer[20];
	boolean currStatus = false;	
	private Integer[] currStories;
	int currentStory = 1;
	int lineToRead = currentStory; // in readfile for testing now
	String finalParagraph = "";
	boolean youLost = false;
	
	public static boolean playingGame = false;
	
	public static void mainMenu() {	
		int x = 0;
		boolean returned = false;
		while(x == 0) {
			if(returned == true) { StdOut.println("\n"); }
			StdOut.println("MAIN MENU: 1) PLAY 2) INSTRUCTIONS 3) QUIT");
			x = StdIn.readInt();
			if(x == 1) { playGame(); x = 0; }
			else if(x == 2) { StdOut.println("You will be faced with choices throughout your journey. Type 'y' or 'Y' for yes, 'n' or 'N' for no, then type enter."
					+ "\nYou are trying to survive while keeping a fine balance of MORALE and physical HEALTH. Too high of health or morale and your companions may start to... resent you."
					+ "\nToo low of health and morale and you are at the mercy of your own mind and body's weaknesses. Good luck!");
					returned = true;
					x = 0; }
			else if(x == 3) { System.exit(0); }
			else { x = 0; }
		}
	}
	
	public static void displayImage() {
		StdOut.println("The ASCII image for the level should be displayed here.");
	}
	
	public void initializeStoryArray() {
		for(int i = 1; i <= MAX_STORIES; i++) {
			this.totalStories[i-1] = i;
		}
	}
	/*
	 * shuffles totalStories and takes first 10 to get set of random, non-repeating numbers to read from
	 */
	public Integer[] getChapterList(Integer[] totalStories) {
        List<Integer> intList = Arrays.asList(this.totalStories);
		Collections.shuffle(intList);
		intList.toArray(this.totalStories);
		System.out.println(Arrays.toString(this.totalStories));
        
		Integer[] currStories = new Integer[this.MAX_READ_STORIES];
		for(int i = 0; i < currStories.length; i++) { 
        	currStories[i] = this.totalStories[i];
		}
		System.out.println(Arrays.toString(currStories));	// for testing - delete
		return currStories;		
	}
	
	/* 
	 * do not delete these 2 - update when you have multiple levels
	 */
	public void youLose() {
		//different situations of death to display after the final sentence (depending on level)
		StdOut.println("Thanks for playing!");
		//
	}
	
	public static boolean youWin() {		
		// display final par.
		// win level and onto the next
		return true;
	}
	
	public static void readFromFile(ReadFile r) {
		try {
			String lineToRead = r.OpenFile();
			StdOut.println(lineToRead) ;
		}
		catch (IOException e) {
			StdOut.println("didn't work");
		}
	}
	
	
	public static String concatFinalParagraph(String finalParagraph, ReadFile r) {
		String toConcat = " ";
		try {
			toConcat = r.OpenFile();
		} catch (IOException e) {
			StdOut.println("final paragraph did not read String");
		}
		finalParagraph = finalParagraph + " " + toConcat;
		return finalParagraph;
	}
	
	public static void validateInput(String response) {
		boolean checkInput = false;
		if(response.contentEquals("Y") || response.contentEquals("N")) { checkInput = true;	}
		
		while(!checkInput) {
			StdOut.println("Invalid input. Try again.");
			response = StdIn.readString();
			response = response.toUpperCase();
			if(response.contentEquals("Y") || response.contentEquals("N")) { checkInput = true;	}
		}
	}
	
	public static void determinePlayerChoice(String response, ReadFile r, Score s) {
		if(response.contentEquals("Y")) {
			s.playerChoice = true;	
			r.state = 1;
		}
		else if(response.contentEquals("N")) {
			s.playerChoice = false;	
			r.state = 2;
		}
		else {
			s.playerChoice = false;	
			r.state = 2;
		}
	}
	
	public static void determineFinalParagraphs(boolean playerChoice, ReadFile r, Game g) {
		if(playerChoice == true) {
			r.state = 3;
			g.finalParagraph = concatFinalParagraph(g.finalParagraph, r);
		}
		else if(playerChoice == false) {
			r.state = 4;
			g.finalParagraph = concatFinalParagraph(g.finalParagraph, r);
		}
	}
	
	public static void playGame() {
		Game g = new Game();
		g.initializeStoryArray();
	
		// easier to test when I can make it through a level
		for(int i = 1; i <= 1; i++) {	
			displayImage();
			
			StdOut.println("You're in the main game loop now.");
			String level = ("level" + i);	
			String path = "C:\\Users\\helen\\Desktop\\CSC 402 - Data Structures\\eclipse-workspace\\game\\src\\main\\" + level  + "_stories.txt";
			String pathScores = "C:\\Users\\helen\\Desktop\\CSC 402 - Data Structures\\eclipse-workspace\\game\\src\\main\\" + level + "_scores.txt";
		
			Score s = new Score();
			ReadFile r = new ReadFile(path);
		
			g.currStories = g.getChapterList(g.totalStories);
			
			ReadFile r2 = new ReadFile(pathScores);
			s.initializeScores(r2);
			s.readScores();
			
		
			// level loop
			for(int j = 0; j < g.MAX_READ_STORIES; j++) {
				r.currentStory = g.currStories[j];
				readFromFile(r);
			
				String response = StdIn.readString();
				response = response.toUpperCase();
				validateInput(response);
				
				s.playerChoice = s.getChoice(response);
			
				determinePlayerChoice(response, r, s);		 
				
				readFromFile(r);
			
				determineFinalParagraphs(s.playerChoice, r, g);
			
				// reset state for next loop
				r.state = 0;
			
				// update score
				s.health = s.updateScore(s.playerChoice, j);
				
				// display score
				StdOut.println(s.displayScore());
			
				// check if either score is 0, then changes i to read final paragraph so game ends.
				if(s.determineLoss(s.health) == true) {
					StdOut.println("YOU DIED!"); // change to the specifics (for type of death and level) outlined in determineLoss function
					j = g.MAX_READ_STORIES-1;
				}
			
				// removes from loop if you lose. once enclosed in level loop, also needs to account for level
				if(j == (g.MAX_READ_STORIES-1)) {
					StdOut.println(g.finalParagraph);
					g.youLost = true;
				} 
			}	
			
			// you lost in inner loop, so do not move on to next level
			if(g.youLost == true) {
				g.youLose();
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		while(!playingGame) {
			mainMenu();
		}
	}
}


