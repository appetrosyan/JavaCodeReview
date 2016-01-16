package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.io.*;
import static java.lang.System.out;

public class CLI implements UserInterface {
	
	
	private Game game;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	//----------------
	
	public CLI (Game newGame){
		game = newGame;
	}
	
	private String scn(){
		try {
			return br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private char getch(){
		try{
			return br.readLine().charAt(0);
		}catch(IOException e){
			e.printStackTrace();
			return '\0';
		}
	}

	@Override
	public String playerName() {
		out.println("Please Enter a Player's name");
		return scn();
	}
	
	private boolean parseYesNo(String input){
		input=input.toLowerCase();
		switch (input){
		case "yes":
		case "y":
		case "u":
		case "t":
			return true;
		default :
			return false;
		}
	}
	
	private void drawHangman(int stage){
		switch(stage){
		case 1:
			out.println("               "
			+"                "
			+"                "
			+"                "
			+"          0     "
			+"         /|\\   "
			+"         / \\   ");
		                       
			break;             
		case 2:
			out.println("               "
			+"                " 
			+"          0     " 
			+"         /|\\   " 
			+"         / \\   " 
			+"                " 
			+"                ");
			
			break;
		case 3:
			out.println("               " 
			+"                " 
			+"          0     " 
			+"         /|\\   " 
			+"         / \\   " 
			+"       _______  " 
			+"                ");
			
			
			break;
		case 4:
			out.println("               " 
			+"                " 
			+"          0     " 
			+"         /|\\   " 
			+"         / \\   " 
			+"|      _______  " 
			+"|               ");
			
		break;
		case 5:
			out.println("               " 
			+"                " 
			+"          0     " 
			+"|        /|\\   " 
			+"|        / \\   " 
			+"|      _______  " 
			+"|               ");
			
			break;
		case 6:
			out.println("               " 
			+"|               " 
			+"|         0     " 
			+"|        /|\\   " 
			+"|        / \\   " 
			+"|      _______  " 
			+"|               ");
			
			break;
		case 7:
			out.println(" _________     " 
			+"|               "
			+"|         0     "
			+"|        /|\\   "
			+"|        / \\   "
			+"|      _______  "
			+"|               ");
			
		break;
		case 8:
			out.println(" _________     "
			+"|         |     "
			+"|         0     "
			+"|        /|\\   "
			+"|        / \\   "
			+"|               "
			+"|               ");
		
		break;
		default:
			
		break;
		}
	}

	@Override
	public void status() {
		out.println(game.getPlayer().getName()+" - "+game.getOpened());
		out.println("Tried the letters: "+game.getGuessedLetters());
		drawHangman(game.getHangmanStage());
	}

	@Override
	public boolean continuePrompt() {
		out.println("Would you like to Play the Game (Yes/No, defaults to No)?");
		return parseYesNo(scn());
	}

	@Override
	public void wrongGuess() {
		//Stub for GUI
	}

	@Override
	public void rightGuess() {
		//Stub for GUI

	}

	@Override
	public void repeatedGuess() {
		out.println("The letter you've put in was already used");
	}

	@Override
	public void winPrompt() {
		out.println("Congratulations you have won!");
	}

	@Override
	public void losePrompt() {
		out.println("Sorry you've lost!");
		out.println("The word you were trying to guess was :"+game.getRightWord());
	}

	@Override
	public char guessPrompt() {
		out.println("Please enter a letter, to be guessed. If multiple are entered the first will be considered");
		return getch();
	}



	@Override
	public void greet(Player player) {
		if(player.isNew()){
			out.println("Welcome " +player.getName() );
		}else{
			out.println("Hello, welcome back "+player.getName());
		}
	}

}
