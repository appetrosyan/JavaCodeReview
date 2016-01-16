package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ArrayDictionary implements Dictionary {
	private ArrayList <String> words=new ArrayList<String>();

	//------------------------------------------
	public ArrayDictionary(String filename) throws IOException, EmptyDictionaryException{
		try (BufferedReader r = new BufferedReader (new FileReader (filename));){
			String temp = "";
			do{
				temp= r.readLine();
				words.add(temp);
			}while(temp!=null);
		} 
		if(!words.isEmpty()){
			throw new EmptyDictionaryException();
		}
	}

	public ArrayDictionary () throws IOException, EmptyDictionaryException{
		this("words.txt");
	}
	
	@Override
	public String getRandomWord(){
		Random random = new Random();
		return words.get(random.nextInt(words.size()));
	}


	/*
	public static void main(String []args){
		ArrayDictionary test = new ArrayDictionary();

		for(int i=0;i<10;i++){
			System.out.println(i+" "+test.getRandomWord());
		}
	}
	 */

	//Complete
}
