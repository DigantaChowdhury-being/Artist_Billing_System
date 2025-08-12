package Artist;

import java.util.ArrayList;
import java.util.Scanner;

public class ArtMannager {
    ArrayList<Artwork> artworks = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public void addArtwork() {
    	System.out.println("Enter Artwork type (landscape or portrait or character):");
    	String type = sc.nextLine().toLowerCase();
    	
    	System.out.println("Artwork Name : ");
    	String title = sc.nextLine();
    	System.out.print("Artwork ID: ");
    	String id = sc.nextLine();
    	System.out.println("Artist name : ");
    	String artist = sc.nextLine();
    	System.out.println("Price of the artwork : ");
    	double price = sc.nextDouble();
    	sc.nextLine();
    	System.out.println("Available discount on percentage: ");
    	double discount = sc.nextDouble();
    	sc.nextLine();
    	
    	switch(type) {
    		case "landscape":
    			System.out.print("Scenery type of the landscape: ");
    			String scenery = sc.nextLine();
    			artworks.add(new Landscape(id,title,artist,price,scenery,discount));
    			break;
    		case "portrait":
    			System.out.println("Subject of the portrait: ");
    			String subject = sc.nextLine();
    			artworks.add(new Portrait(id,title,artist,price,subject,discount));
    			break;
    		case "character":
    			System.out.print("Type of the character: ");
    			String charactertype = sc.nextLine();
    			artworks.add(new CharacterDesign(id,title,artist,price,charactertype,discount));
    			break;
    		default:
    			System.out.println("\n-----Error. Artwork type not in inventory.-----\n");
    	}
    	System.out.println("\n-----Artwork added successfully.-----\n");
    }
    
    public void updateArtwork() {
    	System.out.print("Enter artwork ID to update.");
    	String id = sc.nextLine();
    	for(Artwork a : artworks) {
    		
    		if(a.getId().equals(id)) {
    			System.out.print("Enter new title: ");
    			a.title = sc.nextLine();
    			System.out.println("Enter new artist name: ");
    			a.artist = sc.nextLine();
    			System.out.println("Enter new price: ");
    			a.basePrice = sc.nextDouble();
    			sc.nextLine();
    			System.out.println("\n-----Artwork information updated successfully.-----\n");
    			return;
    		}
    		
    	}
    	System.out.println("\n-----Artwork not found.-----\n");
    	
    }
    
    
    public void deleteArtwork() {
    	System.out.println("Enter artwork ID to delete: ");
    	String id = sc.nextLine();
    	
    	Artwork remove = null;
    	
    	for(Artwork a : artworks) {
    		if(a.getId().equals(id)) {
    			remove = a;
    			break;
    		}
    	}
    	if(remove != null) {
    		artworks.remove(remove);
    		System.out.println("\n-----Artwork removed.-----\n");
    	}
    	else {
    		System.out.println("\n-----Artwork not found.-----\n");
    	}
    }
    
    public void listArtworks() {
    	if(artworks.isEmpty()) {
    		System.out.println("\n-----No artwork to display-----\n");
    		return;
    	}
    	for(Artwork a: artworks) {
    		System.out.println(a);
    	}
    	System.out.println();
    }
}

