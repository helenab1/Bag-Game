package main;

import stdlib.StdOut;
import java.util.Arrays;

public class Player {
	
	int starHealth, heartHealth;
	int state;
	String response;
	boolean choice, lose;
	String score;
	int level;

	public Player() {
		this.starHealth = 2;
		this.heartHealth = 5;
		this.state = 0;
		this.choice = false;
		this.lose = false;
		this.response = "n";
		this.score = getCurrentScore(choice);
		this.level = 1;
	}
	
	/*
	 * get current score (for testing, and displaying after each turn)
	 */
	public String getCurrentScore(boolean choice) {
		if(choice == true) {
			this.starHealth = this.starHealth + 1;
			this.heartHealth = this.heartHealth + 1;
		}
		else if(choice == false) {
			this.starHealth = this.starHealth - 1;
			this.heartHealth = this.heartHealth - 1;
		}
		
		//int s = this.starHealth;
		//int h = this.heartHealth;
		int[] arr = new int[2];
		arr[0] = this.starHealth; arr[1] = this.heartHealth;		
		String display = Arrays.toString(arr);	// need to format for display of game
		return  display;
	}
	
	/*
	 * checks at end of turn if either health bar is < 0 or > 10, and if  you
	 * lost then it ends the game
	 */
	public boolean didYouLose(int starHealth, int heartHealth) {
		if(starHealth <= 0 || heartHealth <= 0) {
			return true;
		}
		else if(starHealth >= 10 || heartHealth >= 10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// returns bool from player's String response to current story
	public boolean getChoice(String response) {
		boolean choice = false;
		if(response == "y") {
			choice = true;
		}
		return choice;
	}
	

	public static void main2(String[] args) {
		//Player p = new Player();
		//StdOut.println(p.getCurrentScore());

	}

}
