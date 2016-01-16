package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

public interface UserInterface {

	String playerName();
	
	void status();
	
	boolean continuePrompt();
	
	char guessPrompt();
	
	void wrongGuess();
	
	void rightGuess();
	
	void repeatedGuess();
	
	void winPrompt();
	
	void losePrompt();

	void greet(Player player);
}
