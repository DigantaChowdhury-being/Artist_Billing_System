package Artist;

public class Portrait extends Artwork{
	protected String Subjectname;
	public Portrait(String id, String title, String artist, double basePrice, String Subjectname,double discount) {
		super(id, title, artist, basePrice,discount);
		// TODO Auto-generated constructor stub
		this.Subjectname = Subjectname;
		
	}
	
	public String toString() {
		return "Protrait" + super.toString()+ ", Subject name : "+ Subjectname; 
	}

}
