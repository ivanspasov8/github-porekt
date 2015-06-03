package bullscows;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ca {

	public ca() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the game of BULLS and COWS."); 
	    System.out.println("The objective in this game is for you to guess a 4-digit number.");  
	    System.out.println("The computer responds with how close your guess is to the target ");        
	    System.out.println("BULLS = # common digits with exact matches and" );
	    System.out.println("COWS  = # common digits in wrong position.");

	    Random gen= new Random();
	    int guess;
	    int target= 0;
	    while(produceRandomTarget(target= (gen.nextInt(9000) + 1000)));
	    String targetStr = target +"";
	    boolean guessed = false;
	    Scanner input = new Scanner(System.in);
	    int guesses = 0;
	    do{
	        int bulls = 0;
	        int cows = 0;
	        System.out.print("Guess a 4-digit number with no duplicate digits: ");      

	        try{	
	            guess = input.nextInt();
	            if(produceRandomTarget(guess) || guess < 1000) continue;
	        }catch(InputMismatchException e){
	            do {
	                while (!input.hasNextInt()) {
	                    System.out.println("Your guess should not contain non-digits");
	                    input.next();
	                }
	                while (!input.hasNextInt()) {
	                    System.out.println("Your guess should not contain repeating digits");
	                    input.next(); 
	                }
	                while (!input.hasNextInt()) {
	                    System.out.println("Your guess should contain 4 symbols (digits)");
	                    input.next(); 
	                }
	                guess = input.nextInt();
	            } while (guess <= 0);
	                continue;
	        }
	        guesses++;
	        String guessStr = guess + "a";
	        for(int i= 0;i < 4;i++){
	            if(guessStr.charAt(i) == targetStr.charAt(i)){
	                bulls++;
	            }else if(targetStr.contains(guessStr.charAt(i)+"")){
	                cows++;
	            }
	        }
	        if(bulls == 4){
	            guessed = true;
	        }else{
	            System.out.println(cows+" Cows and "+bulls+" Bulls.");
	        }
	    }while(!guessed);
	    System.out.println("Congratulations; You Won!!");
	    while (guess != target && guesses < 10);

	    if(!guessed){
	        System.out.println("Congratulations; You Won!!"); 
	    }else{

	            System.out.println("Sorry; You ran out of guesses!!");
	        System.out.println("The correct answer was: " + target);
	    }
	}

	public static boolean produceRandomTarget(int num){
	    boolean[] digs = new boolean[10];
	    while(num > 0){
	        if(digs[num%10]) return true;
	        digs[num%10] = true;
	        num/= 10;
	    }
	    return false;
	    }
	}