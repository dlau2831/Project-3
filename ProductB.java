// Constructor ProductB
public class ProductB extends Product {
	
	// ProductB Method
    public ProductB(String n, double p, char t) { 
        super(n, p, t); // Calling superclass
    }

    // Total Method 
    @Override
    public double total(int qty) {
    	
    	// If number is less than 100, total is price multiplied by units
        if (qty < 100) {
            return price * qty; // Return Formula
        
        // If number is more than 100 but less than 500, total is 5% discounted multiplied by units
        } else if (qty < 500 && qty < 100) {
            return (0.95 * price) * qty; 
            
         // If number is more than 100 but less than 1500, total is 10% discounted multiplied by units    
        } else if (qty < 1500 && qty > 500) {
            return (0.85 * price) * qty; 
            
            // If number is more than 1500, total is 25% discounted multiplied by units     
        } else if (qty > 1500) {
            return (0.75 * price) * qty; 
        }
        else {
        	return qty;
        }
    }
}
