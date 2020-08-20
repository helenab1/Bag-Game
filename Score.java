package main;

import java.io.IOException;

import org.javatuples.Pair;
import stdlib.StdOut;


public class Score {
	
	boolean playerChoice = false;
	
	final int MAX = 40;
	final int LEVEL_MAX = 20;
	
	int yesPos, noPos;
	
	@SuppressWarnings("unchecked")
	Pair<Integer, Integer> levelScores[] = new Pair[LEVEL_MAX];	
	String allScores[] = new String[MAX];
	
	Pair<Integer, Integer> health  = new Pair<Integer, Integer>(5, 5);	// change value for actual game
	
	// for testing a score change
	boolean choice = true;
	int playerPos = 5;
	

	ReadFile file = new ReadFile(null);
	
	@SuppressWarnings("unchecked")
	public Score() {
		this.levelScores = new Pair[LEVEL_MAX];
		
		this.yesPos = 0;
		this.noPos = 1;
		
		/*will read from file to Str array, testing for now
		this.allScores = new String[] { "-1", "5", "2", "-2", "-3", "3", "4", "-4", "-5", "5", "1", "-1", "-2", "2", "3", 
				"-3", "-4", "4", "5", "-5", "-1", "1", "2", "-2", "-3", "3", "4", "-4", "-5", "5", "1", "-1", "-2", "2", "3", 
				"-3", "4", "-4", "-5", "5", "1", "-1", "2", "-2", "3", "-3", "-4", "4", "5", "-5" };		 */
		//this.allScores = new String[MAX];
	}
	
	// initialize scores into String array
	public void initializeScores(ReadFile file) {
		try {
			this.allScores = file.OpenFileScores();
		}
		catch (IOException e) {
			StdOut.println("didn't work");
		}
	}
	
	// reads all scores for the level from string
	public void readScores() {
		for(int i = 0; i < levelScores.length; i++) {
			Integer x = Integer.parseInt(this.allScores[i * 2]);
			Integer y = Integer.parseInt(this.allScores[i * 2 + 1]);
			this.levelScores[i] = new Pair<Integer, Integer>(x,y); 
		} 
	}
	
	public boolean getChoice(String response) {
		boolean choice = false;
		if(response == "y") {
			choice = true;
		}
		return choice;
	}
	
	public Pair<Integer, Integer> updateScore(boolean choice, int playerPos) {
		if(choice == true) { 
			int x = health.getValue0() + levelScores[playerPos].getValue0();
			int y = health.getValue1() + levelScores[playerPos].getValue1();
			health  = new Pair<Integer, Integer>(x, y);			
		}	

		if(choice == false) { 
			int x = health.getValue0() - levelScores[playerPos].getValue0();
			int y = health.getValue1() - levelScores[playerPos].getValue1();
			health  = new Pair<Integer, Integer>(x, y);	
		}
		
		return health;
	}
	
	public String displayScore() {
		int moraleHealth = health.getValue0();
		int physHealth = health.getValue1();
		//StdOut.println("morale: " + moraleHealth);
		//StdOut.println("physical: " + physHealth);
		
		String str1 = "";
		String str2 = "";
		
		for(int i = 0; i < moraleHealth; i++) { str1 = str1.concat("*"); }
		for(int i = 0; i < physHealth; i++) { str2 = str2.concat("*"); }
		
		String display = "MORALE: " + str1 + "\n" + "HEALTH: " + str2;
		return display;
	}

	// may want to change to < 0 and > 10
	public boolean determineLoss(Pair<Integer, Integer> health) {
		if(health.getValue0() <= 0) {
			//display sentence for losing by too little morale for level
			return true;
		}
		else if(health.getValue0() >= 10) {
			//display sentence for losing by too much morale for level
			return true;
		}
		else if(health.getValue1() <= 0) {
			//display sentence for losing by too little health for level
			return true;
		}
		else if(health.getValue1() >= 10) {
			//display sentence for losing by too much health for level
			return true;
		}		
		return false;
	}
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\helen\\Desktop\\CSC 402 - Data Structures\\eclipse-workspace\\game\\src\\main\\level1_scores.txt";
		ReadFile r = new ReadFile(path);
		
		Score s = new Score();
		
		s.initializeScores(r);
		s.readScores();
		
		for(int i = 0; i < s.allScores.length; i++) {
			StdOut.println(s.allScores[i]);	// is initializing perfectly into all scores 
		}
		
		
		for(int i = 0; i < 20; i++) {
			StdOut.println(s.levelScores[i].toString());	// logic error?
		}
		/*
	
		s.readScores();
		
		s.playerPos = 5;
		StdOut.println("Position 5 is: " + s.levelScores[5].toString());
		
		s.updateScore(true, 5);
		
		s.displayScore();*/
		
	
	}

}
