// Date Class
public class Date {
	
	// Variables from UML Diagram
    private int month;
    private int day;
    private int year;

    // Date Constructor 
    public Date(String dateString) {
 
    	// Split the String into Month, Day, Year by removing "/"
        String[] mdy = dateString.split("/");
        
        // Validate date
        boolean length = false;
        if (mdy.length == 3) {
        	length = true; }
        
        if (length) {
            this.month = Integer.parseInt(mdy[0]); // Taking first number
            this.day = Integer.parseInt(mdy[1]); // Taking second number
            this.year = Integer.parseInt(mdy[2]); // // Taking third number
            
        // If Date is incorrect
        } else {
            System.out.println("Invalid date format. Please follow example: mm/dd/yyyy.");
        }
    }

    // toString() Method
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year); // Print format in mm/dd/yyyy
    }
}
