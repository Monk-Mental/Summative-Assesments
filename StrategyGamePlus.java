/** StrategyGamePlus class
  * Desc: Strategy game with rocks
  * @author arya peer
  * @version 11/05/2020
  */ 
//import scanner and random number generator
import java.util.Scanner;
import java.util.Random;

public class StrategyGamePlus {


    public static void main(String[] args) {

        //import scanner
        Scanner keyboard = new Scanner (System.in);
        // variable declaration
        int number, userInput, attempts;
        final int NEW_GAME = 1;
        final int EXIT = 2;
        final int NEW_PLAYER = 3;
        final int RANDOM_ROOF = 4;
        final int RANDOM_FLOOR = 2;
        final int STONES_ROOF = 30;
        final int STONES_FLOOR = 10;
        
        int bestScore = 0;
        int rounds = 0;
        int removalLimit=0;
        int stonesAmount =0;
        int proceed = NEW_PLAYER;
        int removalAmount =0;
        int whoIsFirst =0;
        boolean validInput;
        String bestPlayer = "Computer";
        String player = "";
        String player2 = "";

        
        // main loop that starts the game over
        do {
            // intro for new players
            int j= 0;
            
            if (proceed==NEW_PLAYER){
                System.out.print("\n" + "Enter player 1 name: ");
                player = keyboard.nextLine();
                System.out.print("\n" + "Enter player 2 name: ");
                player2 = keyboard.nextLine();
                System.out.println(player+" and " + player2 +" welcome to my game!");
            }
 
            //intro
            System.out.println("Let the game begin!" + "\n");
            System.out.println("How many rounds do you both want to play?");
            rounds = keyboard.nextInt();
            
            //ensures the number is valid
            if((rounds<2)||(rounds>5)){
                do{
                    System.out.println("\n"+"please input a number of rounds between 2 and 5");
                    rounds = keyboard.nextInt();
                }while((rounds<2)||(rounds>5));
            }
            //sets the users points to 0
            int playerOnePoints=0;
            int playerTwoPoints=0;
            
            
            //for loop based on rounds that the players want to play
            for (int i=0; i<rounds; i++){
               removalLimit = (int)  RANDOM_FLOOR + (int)(Math.random() * ((RANDOM_ROOF - RANDOM_FLOOR) + 1));

               stonesAmount = STONES_FLOOR + (int)(Math.random() * ((STONES_ROOF - STONES_FLOOR) + 1));
               
               System.out.println("enter a positive integer if player one is going first");
               
               whoIsFirst=keyboard.nextInt();
               
               if(whoIsFirst>0){
                j=0;
               }else{
                j=1;
               }
               
               //do while game loop that revolves around asking user for input and checking if its appropriate input
                do{
                     System.out.println("\n"+"round " + (i+1));
                     
                     j++;

    
                    if((j%2)==1){
                        
                        System.out.println("the amount of stones is:" +stonesAmount+", "+player+  " please input the amount of rocks you want removed, the max amount you can remove is:"+removalLimit);

                        removalAmount = keyboard.nextInt();
                        
                        if((removalAmount>removalLimit)||(removalAmount<=0)){
                            do{
                                System.out.println(" Please input an amount below the limit The max amount of stones you can remove is:"+removalLimit);
                                removalAmount = keyboard.nextInt();
                            }while(removalAmount>removalLimit);
                        }
                        
                        
                        
                        if((stonesAmount-removalAmount) <= 0){
                            playerTwoPoints +=1;
                            System.out.println("\n"+"Player Two won round:"+1);
                            System.out.println(player+" has " + playerOnePoints);
                            System.out.println(player2+" has " + playerTwoPoints);
                        }
                        stonesAmount= stonesAmount-removalAmount;
                        
                    }else{
                        
                     
                        System.out.println("the amount of stones is:" +stonesAmount+", "+player2+  " please input the amount of rocks you want removed. The max amount of stones you can remove is:"+removalLimit);
                        removalAmount = keyboard.nextInt();
                        
                         if((removalAmount>removalLimit)||(removalAmount<=0)){
                            do{
                                 System.out.println(" Please input an amount below the limit The max amount of stones you can remove is:"+removalLimit);
                                removalAmount = keyboard.nextInt();
                            }while(removalAmount>removalLimit);
                        }
                        if((stonesAmount-removalAmount) <=0){
                            playerOnePoints +=1;
                            System.out.println("\n"+"Player one won round:"+i);
                            System.out.println(player+" has " + playerOnePoints);
                            System.out.println(player2+" has " + playerTwoPoints);
                        }
                        stonesAmount= stonesAmount-removalAmount;
                        
                    }

                } while(stonesAmount>0);

                
            }
            

          
            //Checks final decision of the user and outputs scores
            validInput = false;
            do{
                if((playerOnePoints>bestScore)&&(playerOnePoints>playerTwoPoints)){
                    bestScore=playerOnePoints;
                    bestPlayer=player;
                    System.out.println("\n"+player+" has the best score of: "+ playerOnePoints );
                }else if((playerTwoPoints>bestScore)&&(playerTwoPoints>playerOnePoints)){
                   bestScore=playerTwoPoints;
                   bestPlayer = player2;
                   System.out.println("\n"+player2+" has the best score of: " +  playerTwoPoints);
                }else if((playerOnePoints == playerTwoPoints)&&(playerTwoPoints>bestScore)){
                   bestPlayer = player2 + " and "+ player;
                   System.out.println("\n"+player2+" and " + player+ "had equal scores of"+ playerTwoPoints);
                }else{
                    System.out.println(bestPlayer+" has the best score of: " +  bestScore);
                }
                System.out.println("\n" + "Another game? [1 for YES / 2 for NO / 3 for new players]");
                proceed = keyboard.nextInt();
                keyboard.nextLine();
                if (proceed==NEW_GAME || proceed==EXIT || proceed==NEW_PLAYER){
                    validInput = true;
                }
                else{
                    System.out.println("This is not a valid input!");
                }
            } while (! validInput);
        } while (proceed==NEW_GAME || proceed==NEW_PLAYER);
        
        //ending if they decide to exit
        System.out.println("\n" + "Thank you for playing Guess My Number game!");
        keyboard.close();
        
    }
}