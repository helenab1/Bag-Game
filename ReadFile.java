package main;

import stdlib.*;

import java.io.IOException; 
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
	// testing variables
	int currentStory = 0;
	int lineToRead = currentStory;
	
	// current state of game (affects file read level)
	public static int state = State.state;
	
	// test array list of shuffled ints between 1 & 20
	Integer[] totalStories = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
	
	private String path;
	
	public ReadFile(String file_path) {
		path = file_path;
	}
	
	/*
	 * opens file, gets number of lines, when it hits the correct line (& current state) reads the line and returns the line as String
	 */
	public String OpenFile() throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		int numberOfLines = readLines();
		String textData = null;
		int i;

		for (i=0; i < numberOfLines; i++) {	// reads just the line specified here
			if(i == totalStories[currentStory]) {
				if(state == 0) {
					textData = textReader.readLine();
				}
			}
		}
		
		textReader.close( );
		//state++;
		return textData;
	}
	
	/*
	 * readLines() finds the max amount of lines in the text file to read from
	 */
	int readLines() throws IOException {
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		String aLine;
		int numberOfLines = 0;
		
		while ((aLine = bf.readLine()) != null) {
			numberOfLines++;
		}
		
		bf.close();
		
		return numberOfLines;
	}
	
	public static void main(String[] args) throws IOException {
		
		String file_name = "C:\\Users\\helen\\Desktop\\CSC 402 - Data Structures\\eclipse-workspace\\game\\src\\main\\test.txt";
		
		try {
			ReadFile file = new ReadFile(file_name);
			String lineToRead = file.OpenFile();
			StdOut.println(lineToRead) ;
		}
		catch (IOException e) {
			StdOut.println("didn't work");
		}	
		
		StdOut.println(state);
	}
	


}
