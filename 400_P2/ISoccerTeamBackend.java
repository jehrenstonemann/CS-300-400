// --== CS400 Project Two File Header ==--
// Name: Huang Xiangyu
// CSL Username: xiangyuh
// Email: xhuang438@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: 

import java.util.List;

/**
 * Instances of this interface implement the search, filter, add, and remove functionality
 * of the Soccer Team app using RBT.
 * 
 * @author Huang Xiangyu
 */
public interface ISoccerTeamBackend {
    
    /**
     * Adds a new player to the backend's database and is stored in
     * a RBT internally.
     * @param player the player to add
     */
    public void addPlayer(IPlayer player);
    
    /**
     * Returns the number of players stored in the backend's database.
     * @return the number of players
     */
    public int getNumberOfPlayers();

    /**
     * This method can be used to set a lower bound filter for the rating
     * contained in the search results. A player is only returned as
     * a result for a ListPlayers, it is also contains the string
     * lowerRating in the names of its player.
     * @param lowerRating an integer value 
     * 			representing the desired lower bound rating a user wants to filter
     */
    public void setRatingFilterLowerBound(String lowerRating);

    /**
     * This method can be used to set an upper bound filter for the rating
     * contained in the search results. A player is only returned as
     * a result for a ListPlayers, it is also contains the string
     * upperRating in the names of its player.
     * @param higherRating
     */
    public void setRatingFilterUpperBound(String higherRating);
    
    /**
     * Returns the integer used as the rating filter, null if no rating
     * filter is currently set.
     * @return the integer used as the rating filter, or null if none is set
     */
    public Integer getLowerBoundRatingFilter();
    
    /**
     * Returns the integer used as the upper bound rating filter, null if no rating
     * filter is currently set.
     * @return the integer used as the upper bound rating filter, or null if none is set
     */
    public Integer getUpperBoundRatingFilter();

    /**
     * Resets the lower bound rating filter to null (no filter).
     */
    public void resetLowerBoundRatingFilter();
    
    /**
     * Resets the upper bound rating filter to null (no filter).
     */
    public void resetUpperBoundRatingFilter();

    /**
     * This method can be used to set a lower bound filter for the market value
     * contained in the search results. A player is only returned as
     * a result for a ListPlayers, it is also contains the string
     * lowerMV in the names of its players.
     * @param lowerMV an integer value 
     * 			representing the desired lower bound market value a user wants to filter
     */
    public void setMarketValueLowerBoundFilter(String lowerMV);

    /**
     * This method can be used to set a upper bound filter for the market value
     * contained in the search results. A player is only returned as
     * a result for a ListPlayers, it is also contains the string
     * upperMV in the names of its players.
     * @param lowerMV an integer value 
     * 			representing the desired lower bound market value a user wants to filter
     */
    public void setMarketValueUpperBoundFilter(String upperMV);
    
    /**
     * Returns the integer used as the lower bound market value filter, null if no lower bound market value
     * filter is currently set.
     * @return the integer used as the lower bound market value filter, or null if none is set
     */
    public Integer getMarketValueLowerBoundFilter();

    /**
     * Returns the integer used as the upper bound market value filter, null if no upper bound market value
     * filter is currently set.
     * @return the integer used as the upper bound market value filter, or null if none is set
     */
    public Integer getMarketValueUpperBoundFilter();
    
    /**
     * Resets the lower bound market value filter to null (no filter).
     */
    public void resetLowerBoundMarketValueFilter();
    
    /**
     * Resets the upper bound market value filter to null (no filter).
     */
    public void resetUpperBoundMarketValueFilter();
    
    /**
     * List all the players that match both filters
     * @return list of players that match the set filters
     */
    public List<IPlayer> ListPlayers();
    
}