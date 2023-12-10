// Constructor ProductR
public class ProductR extends Product {
	
	// ProductR Method
    public ProductR(String n, double p, char t) {
        super(n, p, t); // Calling superclass
    }

    // Total Method to calculate total
    @Override
    public double total(int qty) {
        return price * qty; // Total = price multiplied by number of units
    }
}

