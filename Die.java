import java.util.Random;

/**
 * This is the die class
 */
public class Die {
  private int value;
  private int mySides;
  private Random rand = new Random();

  public Die(int sides) {
    mySides = sides;
    roll();
  }

  public int getValue() {
    return value;
  }

  /**
   * This is the method which generates the number on the side of the die.
   */
  public void roll() {
    value = rand.nextInt(mySides) + 1;
  }
}