package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

public class EmptyDictionaryException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyDictionaryException(){
		super("The Dictionary is empty.");
	}
	
	public EmptyDictionaryException(String filename){
		super ("The Dictionary at "+filename+" is empty");
	}
}
