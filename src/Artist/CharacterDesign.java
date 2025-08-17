package Artist;
import Customer.*;
public class CharacterDesign extends Artwork{
	protected String characterType;
	public CharacterDesign(String id, String title, String artist, double basePrice, String characterType,double discount) {
		super(id, title, artist, basePrice,discount);
		// TODO Auto-generated constructor stub
		this.characterType = characterType;
		
		
	}
	
	public String toString() {
		return "CharacterDesign"+ super.toString()+"Character type: "+ characterType;
	}
}
