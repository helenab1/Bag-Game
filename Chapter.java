package main;

public class Chapter {

	int num;
	String choice;
	int input;
	
	// file input
	String Y, N, RespY, RespN, FSY, FSN, FPar;
	
	public Chapter() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * reads from the file at current chapter number and saves all to member variable
	 */
	public void readFileToVars() {
		
	}
	
	/*
	 * validates String input, return and re-loop if bad
	 */
	public boolean checkInput(String choice) {
		return false;
	}
	
	/*
	 * once choice is validated, this method gets the "Y" or "N" string and uses it to decide
	 * which area of the file to read (Y or N)
	 */
	public String getDecision(String choice) {
		return "";
	}
	
	/* 
	 * display response based on decision & final sentence
	 */
	public void displayConsequences() {
		// display RespY or RespN (if statements)
		// display FSY or FSN
	}
	
	public String createFinalParagraph(String x) {
		// keep concatenating responses onto final sentences
		return FPar;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
