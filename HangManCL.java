/**
*This is my HangManCL javadoc
*@Author Umar Farouk Umar
*@login ec09518
*@Version 1.0
*/

/**Input-Output : imported for getUserInput and gamecontinue*/
import java.io.*;

/**imported ArrayList and other methods*/
import java.util.*;
import java.lang.*;

public class HangManCL{
	
	/**
       * Main now creates another program man
       * that uses HanManData's methods.
       * @param args This program does not use this parameter, only int.
       * @param q Is used in order to print out 'No more words in dictionary'
       */

	public static void main(String[] args){

	    /* Note: Program gives you a warm welcome.
             * Necessary methods from HangManData are initailised.
             */		
		int q=0;
		System.out.println("Welcome to Hangman");
		System.out.println();
		HangManData man = new HangManData();
		man.dictionary();
		man.picker();
		man.display();
		man.hang();
		System.out.println();
		String decision = man.gamecontinue("Would you like to play again? ('yes' to continue)");
		 /* Note: A loop is created so the user can keep on playing if he keeps on inputing yes.
                  * Same methods are called in the loop except for the dictionary.
                  */	
		while((decision.compareToIgnoreCase("yes")) == 0 && q==0){
			if(man.dictionary.size() !=0){
				System.out.println();
				man.picker();
				man.display();
				man.hang();
				System.out.println();
				decision = man.gamecontinue("Would you like to play again? ('yes' to continue)");
				}
			else{
				q++;
				System.out.println("No more words in dictionary");
				}
			}
		System.out.println("Program by Umar Farouk. ec09518@eecs.qmul.ac.uk");
		
		}
	
	}
