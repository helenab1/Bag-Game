package main;

public class State {

	public static int state = 0;
	
	/*
	 * State 0: Read the story.
	 * State 1: Read yes response. State = State + 1
	 * State 2: Read no response. State = State + 2
	 * State 3: Store yes final sentence. State = State + 2
	 * State 4: Store no final sentence. State = State + 2
	 */

}
