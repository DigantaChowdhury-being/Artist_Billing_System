package Artist;
import Customer.*;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		new Login();
		

	}

	public static void startConsoleApp() {
		System.out.println("Welcome to Artist Billing System.");
		
		Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        
		ArtMannager manager = new ArtMannager();
		
		AddCustomer addCustomer = new AddCustomer();
		while(true) {
			System.out.println("1. Add artwork.");
            System.out.println("2. Update artwork.");
            System.out.println("3. Delete artwork.");
            System.out.println("4. List artwork");
            System.out.println("5. Add customers.");
            System.out.println("6. View customers.");
            System.out.println("7. Generate invoice.");
            System.out.println("8. Exit");
            
            while (true) {
                try {
                    System.out.print("Enter choice (1-8): ");
                    
                    if (!sc.hasNextInt()) {
                        sc.nextLine();
                        throw new Invalid_Choice_Exception("Please enter a number between 1 and 8.");
                    }
                    
                    choice = sc.nextInt();
                    sc.nextLine();

                    if (choice < 1 || choice > 8) {
                        throw new Invalid_Choice_Exception("Choice must be between 1 and 8.");
                    }
                    break;
                    
                } catch (Invalid_Choice_Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            System.out.println("You selected: " + choice);
            
            switch (choice) {
            case 1:
                manager.addArtwork();
                break;
            case 2:
                manager.updateArtwork();
                break;
            case 3:
                manager.deleteArtwork();
                break;
            case 4:
                manager.listArtworks();
                break;
            case 5:
                System.out.print("Enter customer name: ");
                String cname = sc.nextLine();
                System.out.println();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter phone: ");
                String phone = sc.nextLine();
                Customer newCustomer = new Customer(cname, email, phone);
                addCustomer.addCustomer(newCustomer);
                break;

            case 6:
            	addCustomer.viewAllCustomers();
                break;

            case 7:
            	System.out.print("Enter customer name: ");
                String customerName = sc.nextLine();

                System.out.print("Enter customer email: ");
                String customerEmail = sc.nextLine();

                Customer customer = new Customer(customerName, customerEmail);

                System.out.print("Enter artwork ID: ");
                String artworkId = sc.nextLine();

                Artwork selectedArtwork = null;

                for (Artwork art : manager.artworks) {
                    if (art.getId().equalsIgnoreCase(artworkId)) {
                        selectedArtwork = art;
                        break;
                    }
                }

                if (selectedArtwork != null) {
                    GenerateInvoice invoice = new GenerateInvoice(customer, selectedArtwork);
                    invoice.generateInvoice();
                } else {
                    System.out.println("\n=======Artwork not found.========\n");
                   
                }
                	break;
            case 8:
            	System.out.println("\n======System closed.======\n");
            	return;
            
            default:
                System.out.println("\n======Invalid choice. Try again.=====\n");
            }
		
		
		}
	
	}
}