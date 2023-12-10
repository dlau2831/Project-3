// Imports
import java.util.Scanner;
import java.util.ArrayList;

// Order Class
public class Order {
	
	// Variables from UML Diagram
    private String userName;
    private Product product;
    private int qty;
    private Date date;
    
    // Item Index Variable
    private int itemNum = 1;
    
    // Constructor for Order
    public Order(Product p, int q, Date d) {
        this.product = p;
        this.qty = q;
        this.date = d;
        this.userName = "";
    }

    // toString() Method to print order
    @Override
    public String toString() {
        return String.format("Date: %s\n==========================================\nID,      Name,            Price,      Type\n==========================================\n%d    %s\n==========================================\nQTY: %d\nTotal: %.2f",
                date.toString(), itemNum, product.toString(), qty, calculateTotal());
    }


    // getProduct Method
    public Product getProduct() {
        return product;
    }

    // getQuantity Method
    public int getQuantity() {
        return qty;
    }

    // getDate Method
    public Date getDate() {
        return date;
    }
    
    // Calculate total cost of the order
    public double calculateTotal() {
        return product.total(qty);
    }


    // Method to input quantity and date for an order
    public static Order createOrder(Scanner scanner, ArrayList<Product> inventory) {

    	// User's choice for name
        System.out.println("Enter the name of the product to order:");
        String productName = scanner.nextLine();
        
        // Finding Name 
        Product orderedProduct = findProductByName(productName, inventory);

        // Checking if the product was found
        if (orderedProduct != null) {
        	
        	// Ask user for quantity
            System.out.println("Enter the quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); 

            // Ask user for date
            System.out.println("Enter the order date (mm/dd/yyyy):");
            String dateString = scanner.nextLine();
            
            // Date Object
            Date orderDate = new Date(dateString);
            
            return new Order(orderedProduct, quantity, orderDate);
            
        } else {
        	// If product is not found
            System.out.println("Product not found.");
            return null;
        }
    }

    // Method to find a product by name in the inventory
    private static Product findProductByName(String name, ArrayList<Product> inventory) {
    	for (Product product : inventory) {
    		
    		// Checking if product's name matches 
        	if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}
