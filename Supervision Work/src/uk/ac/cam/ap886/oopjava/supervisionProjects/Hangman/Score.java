package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.time.LocalDateTime;

public interface Score {
	
	public int getGamesWon();
	public int getGamesLost();
	public float getRating();
	public int getGamesPlayed();
	public LocalDateTime getFirstRegistered();
	public void win();
	public void lose();
	

}
