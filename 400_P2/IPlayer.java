                                                 /**
 * This interface defines getter methods for each player's data attributes
 * and is implemented by classes that represent a player and its associated
 * data.
 */
public interface IPlayer {
  
  /**
   * Returns the name of the player.
   * @return name of the player
   */
  public String getName();
  
  /**
   * Returns the market value of the player.
   * @return market value of the player
   */
  public String getValue();
  
  /**
   * Returns the player rating of the player.
   * @return player rating of the player
   */
  public String getRating();
  
}



