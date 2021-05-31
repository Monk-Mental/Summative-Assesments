package hangman;
/** hangman class
  * Desc: hangman word guessing game
  * @author arya peer
  * @version 12/02/2020
  */ 

//import scanner
import java.util.Scanner;


public class Hangman{
    //METHODS:
    
    /** numDashes Method
    * Desc: counts the number of dashes in a string and returns a number
    * @param str is the string you want to count the amount of dashes of
    * @return the num of dashes within the sentences
    */ 
    public static int numDashes(String str) { 
    //declare and initialize count variable
    int count = 0;

    // loops through string and counts the amount of underscores
    for(int i=0; i < str.length(); i++)
    {    if(str.charAt(i) == '_')
            count++;
    }
    //returns the amount of underscores
    return count;
    }
    
    /** gallows Method
    * Desc: prints out a specific ASCII art depending on the integer inputted
    * @param x is the integer inputted
    * @return an ASCII art  
    */ 
    public static String gallows(int x){
        //if a certain number is inputted output according ascii hangman
        if(x==0){
            return  " %%%%%\n %   %\n %\n %\n %\n %\n%%% ";
        }else if (x == 1){
            return " %%%%%\n %   %\n %   O\n %\n %\n %\n%%% ";
        }else if(x==2){
            return " %%%%%\n %   %\n %   O\n %   |\n %\n %\n%%% ";
        }else if(x==3){
            return " %%%%%\n %   %\n %   O\n % |_|\n %\n %\n%%% ";
        }else if(x==4){
            return  " %%%%%\n %   %\n %   O\n % |_|_|\n %\n %\n%%% ";
        }else if(x==5){
           return " %%%%%\n %   %\n %   O\n % |_|_|\n %   |\n %\n%%% ";
        }else if (x==6){
            return " %%%%%\n %   %\n %   O\n % |_|_|\n %  _|\n % |   \n%%% ";
        }else{
            return " %%%%%\n %   %\n %   O\n % |_|_|\n %  _|_\n % |   |\n%%% ";
        }
    }
    
    /** repetition Method
    * Desc: checks if there was a repetition of a specific character in a string and returns a boolean
    * @param str is the string inputted
    * @param characterInputted is the character that you want to check if it is present
    * @return whether this character is within the string
    */ 
    public static boolean repetition(String str, char characterInputted){
        //declare and initialize length of string variable
        int strLength = str.length();
        //declare and initialize repetetion variable as false
        boolean repetition = false;
        // if there is any character within the string that matches the character inputted it will return true
        for (int i = 0; i < strLength; i++) {
             if(str.charAt(i) == characterInputted)
                {
                    repetition = true;

             }
        }
        //return whether character was within the string (returns boolean)
        return repetition;
    }
    
    /** stringAdder method
    * Desc: adds the inputted character to the string chosen
    * @param str is the string you want to add the character to
    * @param characterInputted is the character you want to add to the string
    * @return the string with the character added at the end
    */ 
    public static String stringAdder(String str, char characterInputted){
        return (str + " " + characterInputted);
    }

    public static void main(String[] args) {
        //declare and initialize vars
        Scanner sc = new Scanner(System.in);
        String playAgain = "yes";
        String secretString;
        String formattedSecretString;
        int lengthOfString;
        int incorrectGuesses;
        String letterOrSentence;
        
     //do while loop for game that runs as long as the user wants
     do{
        //declare and initialize vars
        char guessedLetter;
        String guessedString;
        boolean correct = false;
        boolean repetition = false;
        incorrectGuesses = 0;
        String incorrectGuessesString = "";
        
        //ask for and get the secret word
        System.out.println("NEW GAME");
        System.out.println("input secret word or sentence (everything is converted to lowercase)");
        System.out.println("(MAKE SURE THERE ARE NO ADDITIONAL SPACES AT THE END OR START OF THE INPUT)");
        secretString = sc.nextLine();
        secretString = secretString.toLowerCase();
        //creates a formatted version of the secret string where all letters are underscores
        formattedSecretString= secretString.replaceAll("[a-zA-Z]", "_");
        lengthOfString = secretString.length();

        System.out.println("\n"+formattedSecretString);
        //while there are less than 8 incorrect guesses and the formatted string has some dashes in it the while loop will continue
        while((incorrectGuesses<7)&&(numDashes(formattedSecretString)>0)){
            //ask for and get whether the user would rather guess letters or guess the whole string
            System.out.println("\n"+"Enter 'l' (without a space at the end or start) if you want to guess letters or hit anything else and enter to guess the sentence");
            System.out.println("REMEMBER YOU ONLY GET ONE CHANCE AT GUESSING THE WHOLE SENTENCE!");
            letterOrSentence = sc.nextLine();
            letterOrSentence = letterOrSentence.toLowerCase();
            //if the user would rather guess letters
            if(letterOrSentence.equals("l")){
                //ask for and get a letter that the user is guessing
                System.out.println("\n\n"+"Guess a letter that is within the sentence:");  
                System.out.println("(MAKE SURE THERE ARE NO ADDITIONAL SPACES AT THE END OR START OF THE INPUT)");
                guessedLetter = sc.nextLine().charAt(0);
                guessedLetter = Character.toLowerCase(guessedLetter);
                //set that the letter is correct and not repeated to false
                correct = false;
                repetition = false;
                //for loop to check if the guessed letter is correct and if it has been guessed before(and has been proven to bee correct)
                for (int i = 0; i < lengthOfString; i++) {
                    //if the character has been already been guessed and is correct it sets repetition to true
                    if(formattedSecretString.charAt(i) == guessedLetter)
                    {
                        repetition = true;
                    }
                    //if the character is correct it puts the character at that position in the formatted string that has underscores
                    if(secretString.charAt(i) == guessedLetter)
                    {
                        formattedSecretString = formattedSecretString.substring(0, i)+guessedLetter+formattedSecretString.substring(i+1);
                        correct = true;
                    }
                }
                
                if ((correct == true)&&(repetition==false)){//if the letter is correct and it has not been asked before 
                    System.out.println("Good guess!");
                }else if (repetition == true){//if the letter is correct and it has been asked before it will tell you that it has been guessed before
                    System.out.println("You already guessed this!");
                }else if((correct == false)&&(repetition(incorrectGuessesString, guessedLetter)==true)){//else if this guess has been guessed before and is wrong 
                    System.out.println("Wrong and has been guessed before!");
                }else{//if the guess is wrong and has not been guessed before
                    System.out.println("Wrong!");
                    incorrectGuesses+=1;
                    incorrectGuessesString = stringAdder(incorrectGuessesString,guessedLetter);//adds the letter to the string
                }
                
            }else{//if they don't want to guess a word and want to guess a sentence
                //ask for and guess the sentence
                System.out.println("\nGuess the sentence! (MAKE SURE THERE ARE NO ADDITIONAL SPACES AT THE END OR START OF THE INPUT)");     
                System.out.println("MAKE SURE YOU INPUT ALL PUNCTUATION THAT THE SENTENCE COMES WITH!");    
                guessedString = sc.nextLine();
                guessedString = guessedString.toLowerCase();
                //if the guessed string is the same as the secret string
                if(guessedString.equals(secretString)){
                    //output htat they guessed the word
                    System.out.println("\nNICE YOU GUESSED THE WORD!");
                    //change the formatted version of the secret string to the secret string so we can exit the loop
                    formattedSecretString = secretString;
                }else{
                    //you only get one chance to guess the whole sentence
                    System.out.println("\nOOPS BETTER LUCK NEXT TIME!");
                    //adds the max amount of inccorect guesses to exit the loop
                    incorrectGuesses+=9;
                    
                }//end lesser else statement
                
            }//end greater else statement
            
            //output the formaatted secret string, the wrong letters that have been guessed and the hangman figure
            System.out.println("\n"+formattedSecretString);
            System.out.println("Wrong letters: " + incorrectGuessesString);
            System.out.println(gallows(incorrectGuesses));
        }//end while loop
    
        //if the number of dashes within the formatted string is not equal to 0, you lost 
        if(numDashes(formattedSecretString)==0){
            System.out.println("\nYou won");
        }else{
            System.out.println("\nYou lost, the word is:" + secretString);
        }
        
        //ask if they want to continue playing
        System.out.println("\nType 'yes' to proceed and anything else to end ");
        System.out.println("(MAKE SURE THERE ARE NO ADDITIONAL SPACES AT THE END OR START OF THE INPUT)");
        playAgain = sc.nextLine();
        playAgain = playAgain.toLowerCase();
    //while loop
    }while(playAgain.equals("yes"));
    
    
    }//end main
    
}//end public class


