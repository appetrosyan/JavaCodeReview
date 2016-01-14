package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

public interface UserInterface {

	public String playerName();
	
	public void status();
	
	public boolean continuePrompt();
	
	public char guessPrompt();
	
	public void wrongGuess();
	
	public void rightGuess();
	
	public void repeatedGuess();
	
	public void winPrompt();
	
	public void losePrompt();

	public void greet(Player player);
}
