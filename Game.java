package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import stdlib.StdOut;

public class Game {
	
	Integer[] totalStories = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; 
	final int MAX = 10;
	int starHealth = 1;
	int heartHealth = 5;
	boolean currStatus = false;	// changes true after didYouLose() or didYouWin()
	
	// display image 
	// menu
	
	/*
	 * after game loop reads from Chapter file, update score
	 */
	public void updateScore(int starPoints, int heartPoints) {
		
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
		
		Game myGame = new Game();
        
        // shuffle Class!
        List<Integer> intList = Arrays.asList(myGame.totalStories);
		Collections.shuffle(intList);
		intList.toArray(myGame.totalStories);
		System.out.println(Arrays.toString(myGame.totalStories));
        
        // take first ten
		Integer[] currStories = new Integer[myGame.MAX];
		for(int i = 0; i < currStories.length; i++) { 
        	currStories[i] = myGame.totalStories[i];
		}
		System.out.println(Arrays.toString(currStories));
        
        
        /*
         * example game loop outline
         */
		// create Chapter item
        Chapter currChapter = new Chapter();	
        
        // game loop changes currChapter's num to next in array
        for(int i = 0; i < myGame.MAX; i++) {
        	currChapter.num = currStories[i];
        	StdOut.println(currChapter.num);
        	// all chapter methods
        	// Game updating score methods
        	
        	/*
        	 * loop will check if lost each time
        	if(didYouLose) {
        		youLost();
        	}
        	*/
        }       
        myGame.currStatus = youWin();
    }
}


