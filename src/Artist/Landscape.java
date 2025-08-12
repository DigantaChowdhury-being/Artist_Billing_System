package Artist;

public class Landscape extends Artwork {
	protected String sceneryType;
	
	public Landscape(String id, String title, String artist, double basePrice, String sceneryType,double discount) {
		super(id, title, artist, basePrice,discount);
		// TODO Auto-generated constructor stub
		this.sceneryType = sceneryType;
	}
	
	public String toString() {
		return "Landscape "+super.toString() +", Scenery type : "+ sceneryType;
	}

}
