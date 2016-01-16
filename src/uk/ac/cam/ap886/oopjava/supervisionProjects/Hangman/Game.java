package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
	protected 	Dictionary 	dictionary;		
	protected 	Player 		player;		  	
	protected 	char[] 		wordToBeGuessed;			
	protected	ArrayList 	<Character> 	guessedLetters;
	protected	char[] 		openedWord;		
	protected	ArrayList	<Character>		wrongLetters;
	protected 	UserInterface ui;			
	protected 	final int 	TOTAL_GUESSES=9;
	protected 	int 		currentGuesses;


	public Game(){
		try {
			dictionary = new ArrayDictionary ("words.txt");
		} catch (IOException e) {
			System.err.println("An Input/Output error has occurred");
			e.printStackTrace();
		}catch (EmptyDictionaryException e){
			System.err.println("For some reason no dictionary was found");
			e.printStackTrace();
		}
		ui = new GUIMainWindow(this);
		player = new SimplePlayer(ui.playerName());
		player.save();
		ui.greet(player);
		reset();
	}

	public void reset(){
		wordToBeGuessed = dictionary.getRandomWord().toCharArray();
		openedWord= new char[wordToBeGuessed.length];
		for(int i=0;i<wordToBeGuessed.length;i++)
			openedWord[i]='_';
		currentGuesses = TOTAL_GUESSES;
		guessedLetters =new ArrayList<Character>();	
		wrongLetters =new ArrayList<Character>();
	}

	public String getOpened(){
		return new String(openedWord);
	}

	public Player getPlayer(){
		return player;
	}

	public ArrayList <Character> getGuessedLetters(){
		return wrongLetters;
	}


	protected boolean hasWon(){
		return wordToBeGuessed.equals(openedWord);
	}

	public int getHangmanStage(){
		return TOTAL_GUESSES-currentGuesses;
	}

	public int attempt(char letter){
		boolean found=false;
		if(letter ==0){
			return -1;
		}
		for(char l:guessedLetters){
			if (l==letter){
				return -1;
			}
		}
		guessedLetters.add(letter);
		for(int i=0; i<wordToBeGuessed.length;i++){
			if(letter == wordToBeGuessed[i]){
				found=true;
				openedWord[i]=letter;
			}
		}

		if(found){return 1;}
		else{
			currentGuesses--;
			wrongLetters.add(letter);
			return 0;
		}
	}

	protected boolean isGameOver(){
		return hasWon()||currentGuesses<=0;
	}
	
	public String getRightWord(){
		return new String(wordToBeGuessed);
	}

	public static void main(String[] args){

		Game current = new Game();
		while(current.ui.continuePrompt()){
			while(!current.isGameOver()){
				current.ui.status();
				int userInput =current.attempt(current.ui.guessPrompt());
				if(userInput==0){
					current.ui.wrongGuess();
				}else if(userInput>0){
					current.ui.rightGuess();
				}else{
					current.ui.repeatedGuess();
				}
			}if(current.hasWon()){
				current.ui.winPrompt();
				current.player.win();
			}else{
				current.ui.losePrompt();
				current.player.lose();
			}

		}
	}
}
