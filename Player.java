package main;

import stdlib.StdOut;
import java.util.Arrays;

public class Player {
	
	int starHealth;
	int heartHealth;
	int state;
	boolean choice;

	public Player() {
		// TODO Auto-generated constructor stub
		this.starHealth = 1;
		this.heartHealth = 5;
		this.state = 0;
		this.choice = false;
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

	public static void main2(String[] args) {
		// TODO Auto-generated method stub
		Player p = new Player();
		StdOut.println(p.getCurrentScore());

	}

}
