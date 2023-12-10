// Imports
import java.util.ArrayList;

// Product Class
public abstract class Product {
	
	// Variables from UML Diagram
    protected static int invSize = 0;
    protected String name;
    protected double price;
    protected char type;
    
    // Item Count
    protected int productIndex;

    // Product Method
    public Product(String n, double p, char t) {
        this.name = n;
        this.price = p;
        this.type = t;
        this.productIndex = ++invSize;
    }
    
    // getInvSize Method
    public static int getInvSize() {
        return invSize;
    }
    
    // getName Method
    public String getName() {
        return name;
    }

    // total Method
    public abstract double total(int qty);

    // toString() Method
    @Override
    public String toString() {
        return String.format("   %s     %.2f        %s", name, price, type);
    }

}

qwe

