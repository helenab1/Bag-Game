package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import stdlib.StdOut;

public class Game {
	
	public Integer[] totalStories = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; 
	public final int MAX = 10;
	
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
        }
	}

}
