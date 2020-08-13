package main;

import java.util.Arrays;

import org.javatuples.Pair;
import stdlib.StdOut;


public class Score {
	
	final int MAX = 40;
	final int LEVEL_MAX = 20;
	
	int yesPos, noPos;
	
	@SuppressWarnings("unchecked")
	Pair<Integer, Integer> levelScores[] = new Pair[LEVEL_MAX];	
	String allScores[] = new String[MAX];
	
	Pair<Integer, Integer> health  = new Pair<Integer, Integer>(0, 0);	// change value for actual game
	
	// for testing a score change
	boolean choice = true;
	int playerPos = 5;
	
	@SuppressWarnings("unchecked")
	public Score() {
		this.levelScores = new Pair[LEVEL_MAX];
		
		this.yesPos = 0;
		this.noPos = 1;
		
		// will read from file to Str array, testing for now
		this.allScores = new String[] { "-1", "5", "2", "-2", "-3", "3", "4", "-4", "-5", "5", "1", "-1", "-2", "2", "3", 
				"-3", "-4", "4", "5", "-5", "-1", "1", "2", "-2", "-3", "3", "4", "-4", "-5", "5", "1", "-1", "-2", "2", "3", 
				"-3", "4", "-4", "-5", "5", "1", "-1", "2", "-2", "3", "-3", "-4", "4", "5", "-5" };
		
	}
	
	public void readScores() {
		for(int i = 0; i < 20; i++) {
			Integer x = Integer.parseInt(allScores[yesPos]);
			Integer y = Integer.parseInt(allScores[noPos]);
			levelScores[i] = new Pair<Integer, Integer>(x,y);
			//StdOut.println(levelScores[i].toString()); // get rid of
			yesPos++;
			noPos++;
		} 
	}
	
	/*
	 * get current score (for testing, and displaying after each turn)
	 */
	public void updateScore(boolean choice, int playerPos) {
		if(choice == true) { health.add(levelScores[playerPos]); }
		if(choice == false) { 
			// how to minus - write a score class for adding and subtracting each? adding will be from tuple class and subtracting will be changing each element to negatives
		}
	}
	
	public void displayScore() {
		StdOut.println(health.toString());
	}

	public static void main(String[] args) {
		
		Score s = new Score();
		s.readScores();
		
		s.playerPos = 5;
		s.displayScore();
		s.updateScore(true, 5);
		s.displayScore();
		
	}

}
