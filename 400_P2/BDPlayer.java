/**
 * placeholder for players
 * @author Huang Xiangyu
 *
 */
public class BDPlayer implements IPlayer{

	private String name;
	private String value;
	private String rating;
	
	/**
	 * constructor 
	 * @param inName player name
	 * @param inValue player market value
	 * @param inRating player rating
	 */
	public BDPlayer(String inName, String inValue, String inRating) {
		name = inName;
		value = inValue;
		rating = inRating;
	}
	
	/**
	 * get player name
	 * @return name player name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * get player market value
	 * @return value market value
	 */
	@Override
	public String getValue() {
		return value;
	}

	/**
	 * get player rating
	 * @return rating rating
	 */
	@Override
	public String getRating() {
		return rating;
	}

}
