import java.util.Scanner;

public class Prompter {
  private Game game;
  
  public Prompter(Game game) {
   this.game = game; 
  }
  
  public boolean promptForGuess() {
    Scanner scanner = new Scanner(System.in);
    boolean isHit = false;
    boolean isAcceptable = false;
    
    do {
      System.out.print("Enter a letter:  ");
      String guessInput = scanner.nextLine();
      char guess = guessInput.charAt(0);
      
      try {
        isHit = game.applyGuess(guess);
        isAcceptable = true;
      } catch(IllegalArgumentException iae) {
       System.out.printf("%s.  Please try again. %n", iae.getMessage()); 
      }
    } while(! isAcceptable);
      return isHit;
  }
  
  public void displayProgress() {
   System.out.printf("You have %d tries left to solve:  %s%n", game.getRemainingTries(), game.getCurrentProgress()); 
  }
  
  public void displayOutcome() {
   if (game.isWon()) {
    System.out.println("Congratlations! You Won!");
   } else {
       System.out.printf("Bummer the word was %s", "treehouse");
   }
  }
}