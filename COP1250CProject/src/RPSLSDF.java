import java.util.*;

public class RPSLSDF {

	public static void main(String[] args) {
		// Creating variables
		String player1,player2,player3;//player's names
		// Asking user for players names
		player1=askName(1);
		player2=askName(2);
		player3=askName(3);
		
		int player1Wins=0,player2Wins=0,player3Wins=0;//resetting wins to zero
		Scanner input=new Scanner(System.in);
		int option;//used to receive the option chosen by the user
		/*
		 * Menu implemented in do-while loop 1pt
		 * 1) Rules
		 * 2) Play match
		 * 3) Show stats
		 * 4) Quit
		 * Enter option(1-4): ");
		 */
		do {
			showMenu();
			option=input.nextInt();
			while(option<1 || option>4) {
				System.out.println("invalid option, try again");
				showMenu();
				option=input.nextInt();
			}
			if(option==1) 
				showRules();
			else if(option==2) {
				int winner=playMatch(player1,player2,player3);
				if(winner==0) 
					player1Wins++;
				if(winner==1) 
					player2Wins++;
				if(winner==2) 
					player3Wins++;
			}
			else if(option==3) {
				showCurrentStats(player1,player2,player3,player1Wins,player2Wins,player3Wins);
			}
			else if(option==4) {
				System.out.println("Good bye");
			}
			else
				System.out.println("Invalid choice");
		}while(option!=4);
	}
	/**
	 * Ask user to enter computer player's name
	 * @param num is the player number, ex. 1 is player1
	 * @return input from the user
	 */
	public static String askName(int num) {
		//Write your code here	1pt	
	}
	/**
	 * Shows the rules of the Rock-paper-scissors-lizard-spock double fisting
	 */
	public static void showRules() {
		// Write your code here 1pt
	}
	/**
	 * Shows the number of wins of each player
	 * @param player1 player1's name
	 * @param player2 player2's name
	 * @param player3 player3's name
	 * @param player1Wins player1's number of wins
	 * @param player2Wins player2's number of wins
	 * @param player3Wins player3's number of wins
	 */
	public static void showCurrentStats(String player1,String player2,String player3,int player1Wins,int player2Wins,int player3Wins) {
		// Write your code here 1pt
	}
	/**
	 * Shows the menu option and prompts the user for an option
	 */
	public static void showMenu() {
		// Write your code here 1pt
	}
	
	/**
	 * Simulate the match. First, there is series of three person game until one
	 * player loses to both of its opponents. After, the two remaining players will play
	 * a series of games until one of them wins
	 * @param player1 player1's name
	 * @param player2 player2's name
	 * @param player3 player3's name
	 * @return the code of the match's winner(0:player1,1:player2,2:player3)
	 */
	public static int playMatch(String player1,String player2,String player3) {
		int loser=threeGames(player1,player2,player3);// three player play on elimination phase
		int result2P;// This variable stores the result of the final phase
		if(loser==0) {
			result2P=twoGames(player2,player3);
			// reports the result of the final round
			if(result2P==1) {
				System.out.println("Round Winner: "+player2);
				return 1;
			}
			else {
				System.out.println("Round Winner: "+player3);
				return 2;
			}
		}
		if(loser==1) {
			result2P=twoGames(player1,player3);
			// reports the result of the final round
			if(result2P==1) {
				System.out.println("Round Winner: "+player1);
				return 0;
			}
			else {
				System.out.println("Round Winner: "+player3);
				return 2;
			}
		}
		if(loser==2) {
			result2P=twoGames(player1,player2);
			// reports the result of the final round
			if(result2P==1) {
				System.out.println("Round Winner: "+player1);
				return 0;
			}
			else {
				System.out.println("Round Winner: "+player2);
				return 1;
			}
		}
		return -1;
	}
	/**
	 * Simulates the games between the two surviving players from elimination round
	 * until one of them wins
	 * @param player1 player1 name
	 * @param player2 player2 name
	 * @return the code for the winner(1:player1,-1:player2)
	 */
	public static int twoGames(String player1,String player2) {
		// Write your code here 1pt
	}
	
	
	
	/**
	 * Simulate multiple games with 3 players
	 * player1-player2
	 * player1-player3
	 * player2-player3
	 * returns the player that loses to both opponents 
	 * @param player1 player1 name
	 * @param player2 player2 name
	 * @param player3 player3 name
	 * @return return encode the player that lost to both opponent(0: player1,1:player2,2:player3)
	 */
	public static int threeGames(String player1,String player2,String player3) {
		int result,player1Score=0,player2Score=0,player3Score=0,gameTry=1;
		/*
		 *  Make a do-while loop that simulates battles until one playerXScore is 
		 *  -2 1pt
		 */
		
		if(player1Score==-2) {
			System.out.println(player1+ " eliminated");
			return 0;
		}
		else if(player2Score==-2) {
			System.out.println(player2+ " eliminated");
			return 1;
		}
		else if(player3Score==-2) {
			System.out.println(player3+ " eliminated");
			return 2;
		}
		else
			return -1;
	}
	/**
	 * Reports the result of a game
	 * @param result coded integer representing result(1: player1 wins,-1:player2 wins,0: draw)
	 * @param player1 player1 name
	 * @param player2 player2 name
	 */
	public static void reportGame(int result,String player1,String player2) {
	   // Write your code here 1pt
	}
	
	
	/**
	 * Simulates a single battle between 2 computer players
	 * @param player1 name of the computer player1
	 * @param player2 name of the computer player2
	 * @return coded result of the game(0: draw,1:player1 wins,-1:player2 wins)
	 */
	public static int oneGame(String player1,String player2) {
		System.out.println("Battle between "+player1+" and "+player2);
		return rpslsGame(rpslsMove(),rpslsMove());
	}
	/**
	 * Create a random move to simulate a computer player
	 * r: ROCK,p: PAPER,s: SCISSORS,l: LIZARD,k: SPOCK
	 * @return the character representing code of the move
	 */
	public static char rpslsMove() {
		// Write your code here 1pt
	}
	
	/**
	 * Calculate the result of a single game
	 * @param player1Move char initial of the player1 move
	 * @param player2Move char initial of the player2 move
	 * @return coded result of the game(0: draw,1:player1 wins,-1:player2 wins)
	 */
	public static int rpslsGame(char player1Move,char player2Move) {
		// Write your code here
	}
	/**
	 * This methods translate a game move from a single letter to word
	 * @param m represents the initial of the game move(except for spock that uses k) 
	 * @return the actual move in one word in all uppercase letters
	 */
	public static String char2StrMove(char m) {
		if(m=='r')
			return "ROCK";
		else if(m=='p')
			return "PAPER";
		else if(m=='s')
			return "SCISSORS";
		else if(m=='l')
			return "LIZARD";
		else if(m=='k')
			return "SPOCK";
		else
			return "INVALID";
	}
}

