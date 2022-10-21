/**
 * This is the class which has the behaviours which call players have
 * I made a CompPlayer and Player class because they are two different types of
 * users.
 * 
 */

public class Players {
  private int[] marbles;
  private int totalMarbles;

  public Players() {
    marbles = new int[20];
    totalMarbles = 10;
  }

  // Getter for returning the total Marbles
  public int getMarbles() {
    return totalMarbles;
  }

  /**
   * This method sets the first 10 objects in the array to be full
   * and the last 10 to be empty just to start off.
   */
  public void setMarbles() {
    for (int i = 0; i < totalMarbles; i++) {
      marbles[i] = 1;
    }
    for (int j = totalMarbles; j < marbles.length; j++) {
      marbles[j] = 0;
    }
  }

  // this method checks the array for computer
  public boolean checkArrayComp() {
    for (int i = 0; i < marbles.length; i++) {
      if (marbles[i] == 0) {
        return false;
      }
    }
    System.out.println("Computer Won");
    return true;
  }

  // this checks the array for user.
  public boolean checkArrayUser() {
    for (int i = 0; i < marbles.length; i++) {
      if (marbles[i] == 0) {
        return false;
      }
    }
    System.out.println("You Won");
    return true;
  }

  /**
   * this is the method which adds the number of marbles to Player
   * Computer or User.
   * 
   * @param add
   */
  public void addMarbles(int add) {
    for (int i = 0; i < marbles.length; i++) {
      if (marbles[i] == 0 && add != 0) {
        marbles[i] = 1;
        add--;
        totalMarbles++;
      }
    }
  }

  /**
   * This is the method which removes the number of marbles for the player
   * Computer or User.
   * 
   * @param rem
   */
  public void removeMarbles(int rem) {
    for (int i = 0; i < marbles.length; i++) {
      if (marbles[i] == 1 && rem != 0) {
        marbles[i] = 0;
        rem--;
        totalMarbles--;
      }
    }
  }
}
