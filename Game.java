import java.util.*;
import java.io.*;

//Driver
/**
 * This is the class which will run the entire program
 * This will then be called into the Main class with the object creation
 * of "Game".
 * 
 */

public class Game {
  Marbles ruler = new Marbles();
  CompPlayer computer = new CompPlayer();
  Player player = new Player();
  Die die = new Die(6);
  int playerMarbles = 10;
  int compMarbles = 10;

  /**
   * This is the playGame class, which will play the game
   * In this, we will set the marbles for each player and
   * it will throw and Interrupted Exception because we want
   * to mimic the behavior of a computer stalling for a while and executing
   * rather than instantly.y
   * 
   * @throws InterruptedException
   */
  public void playGame() throws InterruptedException {
    Scanner console = new Scanner(System.in);
    System.out.println("Would you like to play a game? type yes or no");
    String input = console.nextLine();
    int turns = 1;
    player.setMarbles();
    computer.setMarbles();
    if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
      while ((!player.checkArrayUser() || !computer.checkArrayComp())) {
        System.out.println("TURN " + turns);
        yesGameForUser();
        // This buffers the program by 1000 milliseconds
        Thread.sleep(1000);
        System.out.println("Computer will now guess...");
        // This buffers the program by 1000 milliseconds
        Thread.sleep(1000);
        yesGameForComp();
        turns++;
      }
    } else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
      System.out.println("ok maybe another time");
    } else {
      System.out.println("bad input");
      System.exit(0);
    }
  }

  /**
   * This checks for t
   * 
   * @param number
   * @return 2 or 1
   */

  public int checkNum(int number) {
    if (number % 2 == 0) {
      return 1;
    }
    return 2;
  }

  /**
   * This is the method we call when the user inputs yes
   * this runs it so the user guesses the amount of marbles
   * it rolls a die, and if its even and the user guesses even,
   * they gain marbles, else they lose.
   */
  public void yesGameForUser() {
    System.out.println("1: Even, 2: Odd");
    Scanner console = new Scanner(System.in);
    int input = console.nextInt();
    die.roll();
    int number = die.getValue();
    while (input != 1 && input != 2) {
      System.out.println("Try again");
      input = console.nextInt();
    }
    if (checkNum(number) == input) {
      System.out.println("You guessed correctly");
      ruler.addMarblesUser(player, computer, number);
      System.out.println("Added " + number + " marbles to your collection");
      System.out.println("You have " + player.getMarbles() + " marbles");
      System.out.println("Computer has " + computer.getMarbles() + " marbles");
    } else if (checkNum(number) != input) {
      System.out.println("incorrect guess. penalty : " + number + " marbles");
      ruler.addMarblesComp(computer, player, number);
      System.out.println("You have " + player.getMarbles() + " marbles");
      System.out.println("Computer has " + computer.getMarbles() + " marbles");
    }
    System.out.println();
    if (player.checkArrayUser() || computer.checkArrayComp()) {
      System.out.println("Thanks for playing!");
      System.exit(0);
    }
  }

  /**
   * If the user says yes when asked if they want to play a game,
   * this is the code that runs for the computer. There is a random
   * number generator for the computer which guesses even or odd.
   * Each of these methods prints how many marbles each player has
   * after it is done executing.
   */
  public void yesGameForComp() {
    System.out.println();
    System.out.println("1: Even, 2: Odd");
    Random random = new Random();
    int compInput = random.nextInt(2) + 1;
    die.roll();
    int number = die.getValue();
    if (checkNum(number) == compInput) {
      System.out.println("Computer guessed correctly");
      ruler.addMarblesComp(computer, player, number);
      System.out.println("Added " + number + " marbles to computer");
      System.out.println("Computer has " + computer.getMarbles() + " marbles");
      System.out.println("You have " + player.getMarbles() + " marbles");
    } else if (checkNum(number) != compInput) {
      System.out.println("incorrect guess. penalty : " + number + " marbles");
      ruler.addMarblesUser(player, computer, number);
      System.out.println("Computer has " + computer.getMarbles() + " marbles");
      System.out.println("You have " + player.getMarbles() + " marbles");
    }
    System.out.println();
    if (player.checkArrayUser() || computer.checkArrayComp()) {
      System.out.println("Thanks for playing!");
      System.exit(0);
    }
  }
}