package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLI implements UserInterface {
	
	
	Game game;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	//----------------
	
	public CLI (Game newGame){
		game = newGame;
	}
	
	
	
	private void prn(String arg){
		System.out.println(arg);
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
		prn("Please Enter a Player's name");
		return scn();
	}
	
	public boolean parseYesNo(String input){
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
			prn("               ");
			prn("                ");
			prn("                ");
			prn("                ");
			prn("          0     ");
			prn("         /|\\   ");
			prn("         / \\   ");
		                       
			break;             
		case 2:
			prn("               ");
			prn("                ");
			prn("          0     ");
			prn("         /|\\   ");
			prn("         / \\   ");
			prn("                ");
			prn("                ");
			
			break;
		case 3:
			prn("               ");
			prn("                ");
			prn("          0     ");
			prn("         /|\\   ");
			prn("         / \\   ");
			prn("       _______  ");
			prn("                ");
			
			
			break;
		case 4:
			prn("               ");
			prn("                ");
			prn("          0     ");
			prn("         /|\\   ");
			prn("         / \\   ");
			prn("|      _______  ");
			prn("|               ");
			
		break;
		case 5:
			prn("               ");
			prn("                ");
			prn("          0     ");
			prn("|        /|\\   ");
			prn("|        / \\   ");
			prn("|      _______  ");
			prn("|               ");
			
			break;
		case 6:
			prn("               ");
			prn("|               ");
			prn("|         0     ");
			prn("|        /|\\   ");
			prn("|        / \\   ");
			prn("|      _______  ");
			prn("|               ");
			
			break;
		case 7:
			prn(" _________     ");
			prn("|               ");
			prn("|         0     ");
			prn("|        /|\\   ");
			prn("|        / \\   ");
			prn("|      _______  ");
			prn("|               ");
			
		break;
		case 8:
			prn(" _________     ");
			prn("|         |     ");
			prn("|         0     ");
			prn("|        /|\\   ");
			prn("|        / \\   ");
			prn("|               ");
			prn("|               ");
		
		break;
		default:
			
		break;
		}
	}

	@Override
	public void status() {
		prn(game.getPlayer().getName()+" - "+game.getOpened());
		prn("Tried the letters: "+game.getGuessedLetters());
		drawHangman(game.getHangmanStage());
	}

	@Override
	public boolean continuePrompt() {
		prn("Would you like to Play the Game (Yes/No, defaults to No)?");
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
		prn("The letter you've put in was already used");
	}

	@Override
	public void winPrompt() {
		prn("Congratulations you have won!");
	}

	@Override
	public void losePrompt() {
		prn("Sorry you've lost!");
		prn("The word you were trying to guess was :"+game.getRightWord());
	}

	@Override
	public char guessPrompt() {
		prn("Please enter a letter, to be guessed. If multiple are entered the first will be considered");
		return getch();
	}



	@Override
	public void greet(Player player) {
		if(player.isNew()){
			prn("Welcome " +player.getName() );
		}else{
			prn("Hello, welcome back "+player.getName());
		}
	}

}
