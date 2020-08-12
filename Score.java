package main;

import org.javatuples.Pair;
import stdlib.StdOut;


public class Score {
	
	// pair object
	
	// read from file the values of the level (will use file)
	String levelExample;
	
	//array of pairs
	Pair scores[] = new Pair[20];
	
	// key value = levelNumer : <jNumber, kNumber> - ex. 1 : <3, -2>

	public Score() {
		// 40 random numbers in a row
		// will need to account for making some j numbers negative and some k numbers positive
		this.scores = new Pair[20];
		this.levelExample = "15223344551122334455112233445511223344551122334455";
	}

	public static void main(String[] args) {
		
		Score s = new Score();
		StdOut.println(s.levelExample);
		/*
		//Pair<Integer, Integer> pair = new Pair<Integer, Integer>(Integer.parseInt(s.levelExample.substring(0)), Integer.parseInt(s.levelExample.substring(1)));
		Integer x = Integer.parseInt(s.levelExample.substring(0, 1));
		Integer y = Integer.parseInt(s.levelExample.substring(1, 2));
		//StdOut.println(s.levelExample.substring(0, 1));
		//StdOut.println(s.levelExample.substring(1, 2));
		
		Pair<Integer, Integer> pair = new Pair<Integer, Integer>(x, y);
		//StdOut.println(pair.toString());
		
		s.scores[0] = pair;
		StdOut.println(pair.getValue(0).toString());
		StdOut.println(pair.getValue(1).toString());
		
		Integer j = Integer.parseInt(s.levelExample.substring(2, 3));
		Integer k = Integer.parseInt(s.levelExample.substring(3, 4));
		
		Pair<Integer, Integer> pair2 = new Pair<Integer, Integer>(j, k);
		
		s.scores[1] = pair2;
		StdOut.println(pair2.getValue(0).toString());
		StdOut.println(pair2.getValue(1).toString());
		
		StdOut.println(s.scores[0]);
		StdOut.println(s.scores[1]); */
		
		// WORKS - loops all scores from string into pairs and prints them 
		int j = 0;
		int k = 1;
		for(int i = 0; i < 20; i++) {
			Integer x = Integer.parseInt(s.levelExample.substring(j, k));
			Integer y = Integer.parseInt(s.levelExample.substring(j+1, k+1));
			s.scores[i] = new Pair<Integer, Integer>(x,y);
			StdOut.println(s.scores[i].toString());
			j++;
			k++;
		} 
	}

}
