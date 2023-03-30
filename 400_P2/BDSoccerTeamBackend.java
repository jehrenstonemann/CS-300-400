import java.util.ArrayList;
import java.util.List;

/**
 * Backend classes that mainly contains filter and listplayers methods
 * @author Huang Xiangyu
 *
 */
public class BDSoccerTeamBackend implements ISoccerTeamBackend{
	private BDIterableRBTree dataBase;
	
	private Integer ratingFilterLB; // lower bound rating filter
	private Integer ratingFilterUB; // upper bound rating filter
	
	private Integer MVFilterLB; // lower bound market value (MV) filter
	private Integer MVFilterUB; // upper bound MV filter
	
	/**
	 * constructor
	 */
	public BDSoccerTeamBackend() { // initializes the fields to default values
		dataBase = new BDIterableRBTree();
	    ratingFilterLB = null;
	    ratingFilterUB = null;
	    MVFilterLB = null;
	    MVFilterUB = null;
	}
	
    /**
     * Adds a new player to the backend's database and is stored in
     * a RBT internally.
     * @param player the player to add
     */
	@Override
	public void addPlayer(IPlayer player) {
		//checked
		dataBase.insert(player);
	}

    /**
     * Returns the number of players stored in the backend's database.
     * @return the number of players
     */
	@Override
	public int getNumberOfPlayers() {
		//checked
		return dataBase.size();
	}
	
    /**
     * This method can be used to set a lower bound filter for the rating
     * contained in the search results. A player is only returned as
     * a result for a ListPlayers, it is also contains the string
     * lowerRating in the names of its player.
     * @param lowerRating an integer value 
     * 			representing the desired lower bound rating a user wants to filter
     */
	@Override
	public void setRatingFilterLowerBound(String lowerRating) {
		ratingFilterLB = Integer.parseInt(lowerRating);
	}
	
    /**
     * This method can be used to set an upper bound filter for the rating
     * contained in the search results. A player is only returned as
     * a result for a ListPlayers, it is also contains the string
     * upperRating in the names of its player.
     * @param higherRating an integer value 
     * 			representing the desired higher bound rating a user wants to filter
     */
	@Override
	public void setRatingFilterUpperBound(String higherRating) {
		ratingFilterUB = Integer.parseInt(higherRating);
		
	}
	
	/**
     * Returns the integer used as the rating filter, null if no rating
     * filter is currently set.
     * @return the integer used as the rating filter, or null if none is set
     */
	@Override
	public Integer getLowerBoundRatingFilter() {
		return ratingFilterLB;
	}
	
    /**
     * Returns the integer used as the upper bound rating filter, null if no rating
     * filter is currently set.
     * @return the integer used as the upper bound rating filter, or null if none is set
     */
	@Override
	public Integer getUpperBoundRatingFilter() {
		return ratingFilterUB;
	}
	
    /**
     * Resets the lower bound rating filter to null (no filter).
     */
	@Override
	public void resetLowerBoundRatingFilter() {
		ratingFilterLB = null;
	}
	
    /**
     * Resets the upper bound rating filter to null (no filter).
     */
	@Override
	public void resetUpperBoundRatingFilter() {
		ratingFilterUB = null;
	}
	
    /**
     * This method can be used to set a lower bound filter for the market value
     * contained in the search results. A player is only returned as
     * a result for a ListPlayers, it is also contains the string
     * lowerMV in the names of its players.
     * @param lowerMV an integer value 
     * 			representing the desired lower bound market value a user wants to filter
     */
	@Override
	public void setMarketValueLowerBoundFilter(String lowerMV) {
		MVFilterLB = Integer.parseInt(lowerMV);
		
	}
	
    /**
     * This method can be used to set a upper bound filter for the market value
     * contained in the search results. A player is only returned as
     * a result for a ListPlayers, it is also contains the string
     * upperMV in the names of its players.
     * @param lowerMV an integer value 
     * 			representing the desired lower bound market value a user wants to filter
     */
	@Override
	public void setMarketValueUpperBoundFilter(String upperMV) {
		MVFilterUB = Integer.parseInt(upperMV);
	}
	
    /**
     * Returns the integer used as the lower bound market value filter, null if no lower bound market value
     * filter is currently set.
     * @return the integer used as the lower bound market value filter, or null if none is set
     */
	@Override
	public Integer getMarketValueLowerBoundFilter() {
		return ratingFilterLB;
	}
	
    /**
     * Returns the integer used as the upper bound market value filter, null if no upper bound market value
     * filter is currently set.
     * @return the integer used as the upper bound market value filter, or null if none is set
     */
	@Override
	public Integer getMarketValueUpperBoundFilter() {
		return ratingFilterUB;
	}
	
    /**
     * Resets the lower bound market value filter to null (no filter).
     */
	@Override
	public void resetLowerBoundMarketValueFilter() {
		MVFilterLB = null;
	}
	
    /**
     * Resets the upper bound market value filter to null (no filter).
     */
	@Override
	public void resetUpperBoundMarketValueFilter() {
		MVFilterUB = null;
	}

    /**
     * List all the players that match both filters
     * @return list of players that match the set filters
     */
	@Override
	public List<IPlayer> ListPlayers() {
		List<IPlayer> retList = new ArrayList<IPlayer>();
		if(ratingFilterLB == null)
			ratingFilterLB = -9999999;
		if(ratingFilterUB== null)
			ratingFilterUB = 9999999;
		if(MVFilterLB== null)
			MVFilterLB = -9999999;
		if(MVFilterUB== null)
			MVFilterUB = 9999999;
		while(dataBase.hasNext()) {
			IPlayer nextPlayer = dataBase.next();
			if(Integer.parseInt(nextPlayer.getRating())>ratingFilterLB 
					&& Integer.parseInt(nextPlayer.getRating())<ratingFilterUB
					&& Integer.parseInt(nextPlayer.getValue())>MVFilterLB
					&& Integer.parseInt(nextPlayer.getValue())<MVFilterUB) //bound is not included
				retList.add(nextPlayer);
		}
		return retList;
	}	
}
