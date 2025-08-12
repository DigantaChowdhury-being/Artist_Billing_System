package Artist;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		new Login();
		

	}

	public static void startConsoleApp() {
		System.out.println("Welcome to Artist Billing System.");
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
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
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
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
                sc.nextLine();
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