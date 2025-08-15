package Artist;

import java.io.FileWriter;
import java.io.IOException;

public class GenerateInvoice {
    private Customer customer;
    private Artwork artwork;

    public GenerateInvoice(Customer customer, Artwork artwork) {
        this.customer = customer;
        this.artwork = artwork;
    }

    public void generateInvoice() {
        String fileName = "Invoice_" + customer.getName().replaceAll(" ", "_") + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("==== Invoice ====\n");
            writer.write("Customer Name: " + customer.getName() + "\n");
            writer.write("Customer Email: " + customer.getEmail() + "\n");
            writer.write("Artwork Title: " + artwork.getTitle() + "\n");
            writer.write("Artist: " + artwork.getArtist() + "\n");
            writer.write("Price: $" + artwork.getbasePrice()+ "\n");
            writer.write("Final price after discount: $" + artwork.calculateFinalPrice()+ "\n");
            writer.write("=================\n");

            System.out.println("Invoice saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing invoice: " + e.getMessage());
        }
    }
}
