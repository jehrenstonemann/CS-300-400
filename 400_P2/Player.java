/**
 * This class represent a player and its associated data.
 */
public class Player implements IPlayer{
  
  private String name;
  private String value;
  private String rating;
  
  /**
   * Returns the name of the player.
   * @return name of the player
   */
  @Override
  public String getName() {
    return name;
  }
  
  /**
   * Returns the market value of the player.
   * @return market value of the player
   */
  @Override
  public String getValue() {
   return value; 
  }
  
  /**
   * Returns the player rating of the player.
   * @return player rating of the player
   */
  @Override
  public String getRating() {
    return rating;
  }  /**
   * Changes the name of the player.
   * @param new name of the player
   */
  public void setName(String newName) {
    name = newName;
  }
  
  /**
   * Changes the market value of the player.
   * @param new market value of the player
   */
  public void setValue(String newValue) {
    value = newValue;
  }
  
  /**
   * Changes the player rating of the player.
   * @param new player rating of the player
   */
  public void setRating(String newRating) {
    rating = newRating;
  }
  
  
}
