package main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import stdlib.StdIn;
import stdlib.StdOut;

public class Game {
	
	Integer[] totalStories = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; // can add as many stories as there are in your text file
	final int MAX = 10;	// stories that will be randomly read from master text file. can adjust to the ratio you need.
	boolean currStatus = false;	// changes true after didYouLose() or didYouWin()
	private Integer[] currStories;
	int currentStory = 1;
	int lineToRead = currentStory; // in readfile for testing now
	String finalParagraph = "";
	
	// display image 
	// menu
	
	/*
	 * shuffles totalStories and takes first 10 to get set of random, non-repeating numbers to read from
	 */
	public Integer[] getChapterList(Integer[] totalStories) {
		// shuffle Class!
        List<Integer> intList = Arrays.asList(this.totalStories);
		Collections.shuffle(intList);
		intList.toArray(this.totalStories);
		System.out.println(Arrays.toString(this.totalStories));
        
        // take first ten
		Integer[] currStories = new Integer[this.MAX];
		for(int i = 0; i < currStories.length; i++) { 
        	currStories[i] = this.totalStories[i];
		}
		System.out.println(Arrays.toString(currStories));	// for testing - delete
		return currStories;		
	}
	
	/*
	 * checks at end of turn if either health bar is < 0 or > 10, and if  you
	 * lost then it ends the game
	 */
	public static boolean didYouLose(int starHealth, int heartHealth) {
		// display final par.
		return false;
	}
	
	public void youLose() {
		//different situations of death to display after the final sentence (depending on level)
		StdOut.println("Thanks for playing!");
		//
	}
	
	public static boolean youWin() {		// made it through loop, so this doesn't need parameters
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
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\helen\\Desktop\\CSC 402 - Data Structures\\eclipse-workspace\\game\\src\\main\\test.txt";
		
		Game g = new Game();
		Player p = new Player();
		Score s = new Score();
		ReadFile r = new ReadFile(path);
		
		g.currStories = g.getChapterList(g.totalStories);
		
		//GAME LOOP - enclose in level loop
		for(int i = 0; i < g.MAX; i++) {
			r.currentStory = g.currStories[i];
			readFromFile(r);
			
			String response = StdIn.readString();
			StdOut.println(response);
			p.choice = p.getChoice(response);
			
			//function
			if(response.equals("y")) {
				p.choice = true;	
				r.state = 1;
				StdOut.println("State = " + r.state);
			}
			else if(response.contentEquals("n")) {
				p.choice = false;	
				r.state = 2;
				StdOut.println("State = " + r.state);
			}
			 
			StdOut.println(p.choice);	
			readFromFile(r);
			
			//final paragraph
			if(p.choice == true) {
				r.state = 3;
				g.finalParagraph = concatFinalParagraph(g.finalParagraph, r);
			}
			else if(p.choice == false) {
				r.state = 4;
				g.finalParagraph = concatFinalParagraph(g.finalParagraph, r);
			}
			
			// reset state
			r.state = 0;
			
			// update score
			p.score = p.getCurrentScore(p.choice);
			
			// display score
			StdOut.println(p.score);
			StdOut.println("\n");
			
			// check if either score is 0, then changes i to read final paragraph so game ends.
			if(p.didYouLose(p.starHealth, p.heartHealth) == true) {
				StdOut.println("YOU DIED!");
				i = g.MAX - 1;
			}
			
			if(i == (g.MAX-1)) {
				StdOut.println(g.finalParagraph);
			}
			
			// did you lose?
		}
		
		
	}
}


