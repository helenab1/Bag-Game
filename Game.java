package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import stdlib.StdOut;

public class Game {
	
	Integer[] totalStories = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; 
	final int MAX = 10;
	boolean currStatus = false;	// changes true after didYouLose() or didYouWin()
	private Integer[] currStories;
	
	// private class?
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
		System.out.println(Arrays.toString(currStories));
		return currStories;		
	}
	
	/*
	 * after game loop reads from Chapter file, update score
	 */
	public void updateScore(int s, int h) {
		
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
		StdOut.println("Thanks for playing!");
		//
	}
	
	public static boolean youWin() {		// made it through loop, so this doesn't need parameters
		// display final par.
		return true;
	}
	
	
	
	public static void main(String[] args) {
		
		Game g = new Game();
		g.currStories = g.getChapterList(g.totalStories);
		
		// create Chapter item
        Chapter currChapter = new Chapter();	
    
        /*
         * example game loop outline
         */
        
        // game loop changes currChapter's num to next in array
        for(int i = 0; i < g.MAX; i++) {
        	currChapter.num = g.currStories[i];
        	
        	// all chapter methods
        	// score is returned at end
        	// added to Player object
        	// then checked against Game's loss and win
        	
        	/*
        	 * loop will check if lost each time
        	if(didYouLose) {
        		youLost();
        	}
        	*/
        }       
        g.currStatus = youWin();
    }
}


