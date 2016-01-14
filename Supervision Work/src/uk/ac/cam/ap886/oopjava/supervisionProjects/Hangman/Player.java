package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

public interface Player {
	public String 	getName();
	public Score	getScore();
	public void win();
	public void lose();
	public void save();
	
	public boolean isNew();
}
