package com.intern.numbergame;
import java.util.*;

public class Numbergame {
    public static void main(String[] args) {
    	//using scanner class to get the user input
        Scanner scan = new Scanner(System.in);
        //creating random object 
        Random number = new Random();
        int maxattempts = 10;
        int score = 0;

        //using do while loop 
        do {
            int randomNumber = number.nextInt(100) + 1;
            int attempts = 0;
            
            //printing the message to the user to enter their guess number
            System.out.println("Guess a number between 1 and 100:");

            while (attempts < maxattempts) {
                int userGuess = scan.nextInt();
                attempts++;

                //using if-else-if statement to find the whether the user input number and random matches
                //first if statement will print if the user guessed number = random number
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                   
                //else-if statement will print the result if the user input number is less than random number
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again.");
                }
                
                //else-if statement will print the result if the user input number is more than random number
                else {
                    System.out.println("Too high. Try again.");
                }
            }
            
            //this statement will print when the user completed the attempts given by the prorgammer 
            if (attempts == maxattempts) {
                System.out.println("Out of attempts. The correct number was: " + randomNumber);
            }

            //This message will be printed to know whether the user like to play the game again
            System.out.println("Do you want to play again? (yes/no)");
        } 
        while (scan.next().equalsIgnoreCase("yes"));
        
        //This statement will be printed to show score of the user based on the performance
        System.out.println("Your score: " + score);
    }
}
