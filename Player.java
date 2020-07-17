package main;

import stdlib.StdOut;
import java.util.Arrays;

public class Player {
	
	int starHealth;
	int heartHealth;
	//public static int state = 1;

	public Player() {
		// TODO Auto-generated constructor stub
		this.starHealth = 1;
		this.heartHealth = 5;
	}
	
	/*
	 * get current score (for testing, and displaying after each turn)
	 */
	public String getCurrentScore() {
		int s = this.starHealth;
		int h = this.heartHealth;
		int[] arr = new int[2];
		arr[0] = s; arr[1] = h;		
		String display = Arrays.toString(arr);	// format for display of game
		return  display;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p = new Player();
		StdOut.println(p.getCurrentScore());

	}

}
