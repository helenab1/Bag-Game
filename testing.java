package main;

import stdlib.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class testing {

	public testing() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// testing reading to files with random access
		RandomAccessFile file = new RandomAccessFile("lvl1.txt", "rw");
		file.seek(10);
		long position = file.getFilePointer();
		int aByte = file.read();
		
		StdOut.println(position);
		
	}

}
