/**
 * In this class, we are taking in the player objects and
 * we are adding or removing marbles.
 * 
 */
public class Marbles {
  /**
   * This is the method which will add marbles to the computer object
   * and remove marbles from the player (user).
   * 
   * @param computer
   * @param player
   * @param add
   */
  public void addMarblesComp(CompPlayer computer, Player player, int add) {
    computer.addMarbles(add);
    player.removeMarbles(add);
  }

  /**
   * This is the method which will add marbles to the player object
   * and remove marbles from the computer object.
   * 
   * @param player
   * @param computer
   * @param add
   */
  public void addMarblesUser(Player player, CompPlayer computer, int add) {
    player.addMarbles(add);
    computer.removeMarbles(add);
  }
}
