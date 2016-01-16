package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SimplePlayer implements Player {

	private boolean isNew=false;
	private String name;
	private Score mScore;
	private final String DEFAULT_PATH="players.txt";

	//--------------------------------------------
	
	public SimplePlayer (String nName){
		if(!this.loadFromFile( DEFAULT_PATH,nName)){
		isNew=true;
		name = nName;
		mScore = new SimpleScore();
		}
		
	}
	
	public void writeToFile(){
		writeToFile (DEFAULT_PATH);
	}

	public void writeToFile(String fileName){
		try (FileWriter w = new FileWriter (fileName);){
			w.write(name+"\n");
			w.flush();
			w.write(mScore.toString());
			w.flush();
		} catch (IOException e) {
			e.printStackTrace();//Shouldn't happen
		}

	}
	
	public boolean loadFromFile(String fileName, String playerName){
		try(BufferedReader br = new BufferedReader (new FileReader(fileName))){
			String temp= " ";
			while (null!=temp){
				temp = br.readLine();
				if(temp!=null && temp.equals(playerName))
				{
					name = temp;
					temp = br.readLine();
					if(temp!=null){
					mScore = new SimpleScore (temp);
					}else{mScore = new SimpleScore();}
					return true;
				}
			}
			return false;
		} catch (FileNotFoundException e) {
			File file = new File (DEFAULT_PATH);
			//Try to create the Default File, just in case
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public String getName(){
		return name;
	}

	@Override
	public Score getScore() {
		return mScore;
	}
	
	

	@Override
	public void win() {
		mScore.win();
	}

	@Override
	public void lose() {	
		mScore.lose();
	}

	@Override
	public void save() {
		writeToFile(DEFAULT_PATH);	
	}
	
	@Override
	public boolean isNew() {
		return isNew;
	}

}
