package main;

import stdlib.StdOut;
import java.util.Arrays;

public class Player {
	
	int starHealth;
	int heartHealth;
	int state;
	String response;
	boolean choice;
	String score;
	int level;

	public Player() {
		this.starHealth = 1;
		this.heartHealth = 5;
		this.state = 0;
		this.choice = false;
		this.response = "n";
		this.score = getCurrentScore();
		this.level = 1;
	}
	
	/*
	 * get current score (for testing, and displaying after each turn)
	 */
	public String getCurrentScore() {
		int s = this.starHealth;
		int h = this.heartHealth;
		int[] arr = new int[2];
		arr[0] = s; arr[1] = h;		
		String display = Arrays.toString(arr);	// need to format for display of game
		return  display;
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
		Player p = new Player();
		StdOut.println(p.getCurrentScore());

	}

}
