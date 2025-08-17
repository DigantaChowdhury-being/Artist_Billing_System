package Artist;
import Customer.*;
public class Artwork implements Sellable{
    protected String id;
    protected String title;
    protected String artist;
    protected double basePrice;
    protected double discount;

    public Artwork(String id, String title, String artist, double basePrice, double discount) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.basePrice = basePrice;
        this.discount = discount;
    }
    
    public String getArtist() {
    	return artist;
    }
    public double getbasePrice() {
    	return basePrice;
    }
    public String getTitle() {
    	return title;
    }
    public String getId() {
        return id;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public String toString() {
        return "ID: " + id +"\n"+ "Title: " + title +"\n"+ "Artist: " + artist + "\n"+"Price: $" + basePrice +"\n"+ "Discount: " + discount+"\n"+"Final price :"+calculateFinalPrice()+"\n";
    }

	@Override
	public double calculateFinalPrice() {
		// TODO Auto-generated method stub
		double discountedPrice = basePrice - (basePrice * (discount / 100));
        return discountedPrice;
	}
}
