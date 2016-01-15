package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.time.LocalDateTime;

public class SimpleScore implements Score {
	
	private int gamesWon;
	private int gamesLost;
	private LocalDateTime firstRegistered;
	
	public SimpleScore(){
		gamesWon = 0;
		gamesLost=0;
		firstRegistered =LocalDateTime.now(); 
	}
	
	public SimpleScore(String formatLine){
		String[] parts = new String[3];
		parts= formatLine.split(" ");
		gamesWon = Integer.parseInt(parts[0]);
		gamesLost = Integer.parseInt(parts[1]);
		firstRegistered = LocalDateTime.parse(parts[2]); 
	}

	@Override
	public int getGamesWon() {
		return gamesWon;
	}

	@Override
	public int getGamesLost() {
		
		return gamesLost;
	}

	private float computeRating(){
		return gamesWon *0.001f -0.0001f*gamesLost;
	}
	
	@Override
	public float getRating() {
		return computeRating();
	}

	@Override
	public int getGamesPlayed() {
		return gamesWon + gamesLost;
	}

	@Override
	public LocalDateTime getFirstRegistered() {
		return firstRegistered;
	}
	
	@Override
	public String toString(){
		return gamesWon+" "+gamesLost+" " +firstRegistered;
	}

	@Override
	public void win() {
	gamesWon++;	
	}

	@Override
	public void lose() {
	gamesLost++;	
	}

}
