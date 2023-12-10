// Imports
import java.util.Calendar;

//Constructor ProductS
public class ProductS extends Product {
	
	// ProductS Method
    public ProductS(String n, double p, char t) {
        super(n, p, t); // Calling superclass
    }

    // Total Method to calculate total
    @Override
    public double total(int qty) {
    	
    	// Object made for now
        Calendar now = Calendar.getInstance();
        
        // Assigning month to current date
        int month = now.get(Calendar.MONTH);

        // Checking if month is within November & January
        boolean season = (month >= Calendar.NOVEMBER && month <= Calendar.JANUARY);
        
        // Calculating total based seasonal condition
        if (season) {
        	return (0.6 * price) * qty; // 40% Discount
        }
        else {
        	return price * qty; // No Discount
        }
    }
}
