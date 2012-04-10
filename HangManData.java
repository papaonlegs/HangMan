/**
*This is my HangManData javadoc
*@Author Umar Farouk Umar
*@login ec09518
*@Version 1.0
*/

/**Input-Output : imported for getUserInput and gamecontinue*/
import java.io.*;

/**imported ArrayList and other methods*/
import java.util.*;
import java.lang.*;

public class HangManData{
	

	/** 
       * Declaring my Variables
       * @param dictionary The array list which my dictionary of words exist in.
       * @param mistakes The counter for the number of mistakes the user makes.
       * @param random The random number used to manipulate the dictionary
       * @param word The real word taken from the dictionary that the user is supposed to guess.
       * @param show The characters that the user has guessed correctly displayed on the screen.
       * @param f The wrong guesses the user has made.
       * @param extras A backup of what the it should print incase of an error (used mainly in the GUI part).
       */


	ArrayList<String> dictionary;
	int mistakes;
	int random;
	String word, show, f, extras;

	/** 
       * This method initialises the dictionary ArrayList and puts words inside it
       */

	public void dictionary(){
		dictionary = new ArrayList<String>();
		dictionary.add("Borrowing");
		dictionary.add("SPOKESWOMAN");
		dictionary.add("swifter");
		dictionary.add("mimetic");
		dictionary.add("boring");
		dictionary.add("MULTIlateral");
		dictionary.add("inexpressible");
		dictionary.add("learning");
		dictionary.add("acidIFY");
		dictionary.add("blue");
		dictionary.add("antidisestablishmentarianism");
		dictionary.add("upstaged");
		dictionary.add("immodestly");
		dictionary.add("trader");
		dictionary.add("victoriously");
		}
	
	/** 
       * This method picks a random word to use from the dictionary and then removes it
       * It returns word.
       * @param random is initialised and kept within the size of the dictionary.
       */

	public String picker(){

		/* Note: mistakes is initialised to zero here 
             * so every time this method is called it will go to 0.
             * random is kept within parameter using dictionary.size()
             * multiplied by Math.random(which gives a number between
             * 0 and 1).
             */

		mistakes=0;
		random = (int) (Math.random() * dictionary.size());
		word = dictionary.get(random);
		dictionary.remove(random);
		return word;
		}
	
	/** 
       * This method intialises _ to show.
       */

	public String display(){
		show = "";
		for(int i=0; i<word.length(); i++) show+='_';
		return show;
		}

	/** 
       * This method makes character arrays that is the same as the word
       * and shown characters.
       * It then checks the input as a character with the array
       * regardless of case.
       * It modifies @param show base on that and returns it
       */

	public String checkLetter(char c){
		char[] realLetters = new char[word.length()];
		char[] shownLetters = new char[word.length()];
		char[] realsLetters = new char[word.length()];
		String s="";
		boolean exists = false;		
		for(int i = 0; i < word.length(); i++){
			realLetters[i] = word.charAt(i);
			shownLetters[i] = show.charAt(i);
			realsLetters[i] = word.charAt(i);
			}
		for(int j = 0; j < word.length(); j++){
			if(Character.toLowerCase(realsLetters[j]) == Character.toLowerCase(c)){
				shownLetters[j] = realLetters[j];
				exists = true;
			    	}
			}
		for(int k=0; k < word.length(); k++ ) s += shownLetters[k];
		show = s;
		return show;
		}
	
	/** 
       * This method is the same as checkLetter (previous method)
       * except that this returns whether or not the character is in @param word or not.
       * @param exists: is a boolean variable telling whether the character exists or not
       */

	public boolean getExistance(char c){
		char[] realLetters = new char[word.length()];
		char[] shownLetters = new char[word.length()];
		String s="";
		boolean exists = false;		
		for(int i = 0; i < word.length(); i++){
			realLetters[i] = word.charAt(i);
			shownLetters[i] = show.charAt(i);
			}
		for(int j = 0; j < word.length(); j++){
			if(Character.toLowerCase(shownLetters[j]) == Character.toLowerCase(c)){
				shownLetters[j] = realLetters[j];
				exists = true;
			    	}
			}
		/* Note: if there are no brackets after a for 
             * loop it is only the the sentence that 
             * immediatly follows that is part of the loop 
             */
		for(int k=0; k < word.length(); k++ ) s += shownLetters[k];
		show = s;
		return exists;
		}
	/** 
       * This method checks whether the user has guessed the full word
       * or not
       */

	public boolean guessed(){
		return show.equalsIgnoreCase(word);
		}
	/** 
       * This method was copied from GameHelper.java and then edited
       * It will read the input from the command line
       * @param inputLine The input string checked for errors.
       */
	

	public String getUserInput(String prompt){
		String inputLine = null;
		System.out.print(prompt + " : ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0 )return null;
			/**This statement blanks it if more than 1 character is input*/
			else if (inputLine.length()>1){
				//System.out.println("Please enter one letter only");
				inputLine=" ";
				}
			/**This statement blanks it if anything but a leter is input*/
			if (inputLine.matches("[^a-zA-Z]") == true) inputLine=" ";
			}
 		catch (IOException e) {
			System.out.println("IOException: "+ e);
			}
		
		return inputLine;
		}

	/** 
       * This method was copied from GameHelper.java.
       * The name was changed from getUserInput
       * It will read the input from the command line.
       * @param inputLine The input string.
       */

	public String gamecontinue(String prompt){
		String inputLine = null;
		System.out.print(prompt + " : ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0 )return null;
			}
 		catch (IOException e) {
			System.out.println("IOException: "+ e);
			}
		return inputLine;
		}
	
	/** 
       * This method calls all the other methods created.
       * This is the heart of the game that does all the calculations.
       * It prints messages where failed, won or otherwise needed.
       */

	public void hang(){
		extras = " ";
		f =" ";
		/**!guessed means the word has not been guessed*/
		while (mistakes < 7 && !guessed()){
			System.out.println("Word: "+show);
			System.out.println("Misses: "+f);
			char c = getUserInput("Enter Guess").charAt(0);
			System.out.println();
			checkLetter(c);
			if(c==' '){System.out.println("Words only contain letters, no number or other characters."); extras ="Words only contain letters, no number or other characters.";}
			/**!getExistance means letter does not exist in the word*/
			if (!getExistance(c)){
				if(f.charAt(f.length()-1) == c){}
				else{
					f+=c;
					mistakes += 1 ;
					}
				}
			if (guessed()) System.out.println("Congratulations you win! You have guessed the word: "+word+" in "+mistakes+" guesses");
			}
           	if(mistakes ==7) System.out.println("You have run out of guesses. The word was: "+word);
		}

	}

