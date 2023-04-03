import java.util.Scanner;
import java.util.Random;

//Game class
class RoundGames{
	
	int inputFromSystem;
	int inputFromUser;
	int count=0;
	
	//Generating random number in default constructor
	RoundGames(){
		Random random=new Random();
		this.inputFromSystem=random.nextInt(100)+1;
	}
	
	//method to take user guesses
	public boolean takeUserInput() {
		if(count <10) {
			System.out.print(" guess the number :");
			this.inputFromUser=GuessTheNumber.takeIntegerInput(100);
			count++;
			return false;
		}
		else {
			System.out.println("oops  finised attempts ,better luck next time");
			return true;
		}
	}
	
	//method to check user guess status
	public boolean isCorrectGuess() {
		if(inputFromSystem==inputFromUser) {
			System.out.println("yeah we found : "+inputFromSystem+" in "+count+" guesses and");
			switch(count) {
			case 1:
				System.out.println("the points are 100");
				break;
			case 2:
				System.out.println( "the points are 90");
				break;
			case 3:
				System.out.println("the  points are 80");
				break;
			case 4:
				System.out.println(" the points are 70");
				break;
			case 5:
				System.out.println("the points are 60");
				break;
			case 6:
				System.out.println("the  points are 50");
				break;
			case 7:
				System.out.println("the points are 40");
				break;
			case 8:
				System.out.println(" the  points are 30");
				break;
			case 9:
				System.out.println(" the points are 20");
				break;
			case 10:
				System.out.println("the points are 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if(count < 10 && inputFromUser>inputFromSystem) {
			if(inputFromUser-inputFromSystem>10) {
				System.out.println("So High");
			}
			else {
				System.out.println("little High");
			}
		}
		else if(count<10 && inputFromUser<inputFromSystem) {
			if(inputFromSystem -inputFromUser >10) {
				System.out.println("too Low");
			}
			else {
				System.out.println(" Low");
			}
		}
		return false;
	}
}
 //main class
public class GuessTheNumber {
 
	public static int takeIntegerInput(int limit) {
		int inputs=0;
		boolean temp =false;
		
		while(!temp) {
			try {
				Scanner sc=new Scanner(System.in);
				inputs=sc.nextInt();
				temp=true;
				
				if(temp && inputs>limit ||inputs <1) {
					System.out.println("choose number between 1 to "+limit);
					temp=false;	
				}
				sc.close();
			}
			catch(Exception e) {
				System.out.println("Enter integer value only :");
				temp=false;
			}
		};
		return inputs;
	}
	public static void main(String[] args) {
		
 
		//input for start the game
		System.out.println("1.Let's start the game \n2.Exit");
		System.out.println("Choose a number :");
		int choice =takeIntegerInput(2);
		int nextRounds=1;
		int roundNo=0;
		
		if(choice ==1) {
			//to check next round is there or not
			
			while(nextRounds ==1) {
				//creating object of Game class
				RoundGames game=new RoundGames();
				boolean isMatches =false;
				boolean isLimitCrosses=false;
				System.out.println("\nRound "+ ++roundNo + "status ...");
				
				//to check correct guess and limit cross
				while(!isMatches && !isLimitCrosses){
					isLimitCrosses =game.takeUserInput();
					isMatches =game.isCorrectGuess();
					
				}
				//input for next round
				System.out.println("1.Next Round \n2.Exit");
				System.out.println("choose number: ");
				nextRounds= takeIntegerInput(2);
				if(nextRounds != 1) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}