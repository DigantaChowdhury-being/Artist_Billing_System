package Customer;
import Artist.*;
import java.util.ArrayList;

public class AddCustomer {
    public ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public void viewAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.println("\n--- Customer Records ---\n");
        for (Customer customer : customers) {
            System.out.println("Name: " + customer.getName() +
                               ", Email: " + customer.getEmail() +
                               ", Phone: " + customer.getPhone());
        }
    }
}
