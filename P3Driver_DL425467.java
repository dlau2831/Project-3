/**
 * ICIS 201 Introduction to Computer Science>
 * Fall 2023
 * Lab Section <Lab section <Friday 11:40 A.M - 12:35 P.M>
 * David Lau
 * DL425467
 * dlau2@albany.edu
 *
 * This project is an inventory management system, it allows the user to view the inventory, create orders and review them.
 * It also uses file storage system to handle items and dates for orders.
 */

// Imports
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


// Main Class Driver
public class P3Driver_DL425467 {
	
	// Main Method
    public static void main(String[] args) {
    	
    	// Scanner Keyboard
        Scanner keyboard = new Scanner(System.in);
        // Create an ArrayList to store items
        ArrayList<Product> inventory = new ArrayList<>();
        // Create an Array list to store orders
        ArrayList<Order> orders = new ArrayList<>();

     // Read file from orders.txt
     try (Scanner fileScanner = new Scanner(new File("orders.txt"))) {
         while (fileScanner.hasNextLine()) {
             String line = fileScanner.nextLine();
             
             // Split the line by ,
             String[] parts = line.split(",");
             
             // Trim the lines
             String name = parts[0].trim();
             double price = Double.parseDouble(parts[1].trim());
             char type = parts[2].trim().charAt(0);

             // Create Products based on their types
             switch (type) {
             
                 case 'R':
                     inventory.add(new ProductR(name, price, type));
                     break;
                     
                 case 'B':
                     inventory.add(new ProductB(name, price, type));
                     break;
                     
                 case 'S':
                     inventory.add(new ProductS(name, price, type));
                     break;
                     
                 default:
                     break;
             }
         }
     } catch (FileNotFoundException e) {
    	 // In case file is not found
         System.out.println("File not found: " + e.getMessage());
     }

        // Boolean to exit program
        boolean exit = false;

        // Loop to display inventory
        while (!exit) {
            System.out.println("(I)nventory");
            System.out.println("(O)rder");
            System.out.println("(R)eview the order");
            System.out.println("(E)xit");
            System.out.print("Your choice: ");

            // User's Menu Choice
            String choice = keyboard.nextLine();

            // Switch Case to direct user's to appropriate panel
            switch (choice.toUpperCase()) {
                case "I":
                    // Show Inventory
                    System.out.println("The inventory:");
                    for (Product product : inventory) {
                        System.out.printf("%d. %s %.2f %s%n", 
                                          product.productIndex, 
                                          product.getName(), 
                                          product.price,
                                          product.type); }
                    break;
                case "O":
                    // Make an Order
                    Order newOrder = Order.createOrder(keyboard, inventory);
                    if (newOrder != null) {
                        orders.add(newOrder);
                    }
                    break;
                case "R":
                    // Review Orders
                    System.out.println("\nOrders:");
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    break;
                case "E":
                    // Exit
                    saveFile(orders);
                    System.out.println("Your order is saved. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to save orders to a file ("orders.txt")
    private static void saveFile(ArrayList<Order> orders) {
        try (FileWriter writer = new FileWriter("orders.txt")) {
            for (Order order : orders) {
                writer.write(order.toString() + "\n");
            }
            System.out.println("Orders saved to orders.txt");
        } catch (IOException e) {
            System.out.println("Error saving orders to file: " + e.getMessage());
        }
    }
}
