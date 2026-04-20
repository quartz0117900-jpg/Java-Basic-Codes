/*
3. Declare an interface called Property containing a method computePrice to compute 
and return the price. The interface is to be implemented by following two classes i) 
Bungalow and ii) Flat. 
Both the classes have following data members - name - constructionArea 
 
The class Bungalow has an additional data member called landArea. Define 
computePrice for both classes for computing total price. Use following rules for 
computing total price by summing up sub-costs: 
Construction cost(for both classes):Rs.500/- per sq.feet 
Additional cost ( for Flat)     : Rs. 200000/- 
( for Bungalow ): Rs. 200/- per sq. 
feet for landArea 
Land cost  ( only for Bungalow ): Rs. 400/- per sq. feet 
Define method main to show usage of method computePrice. 

*/
// Interface - acts like a contract
// any class that implements it MUST have computePrice()
interface Property {
    double computePrice(); // no body - implementing class must define it
}

// Flat class - implements Property interface
class Flat implements Property {

    String name;              // name of flat
    double constructionArea;  // construction area in sq.feet

    // Constructor - initialize flat details
    Flat(String name, double constructionArea) {
        this.name = name;
        this.constructionArea = constructionArea;
    }

    // computePrice() - calculate total price of flat
    public double computePrice() {
        double construction = constructionArea * 500; // Rs.500 per sq.ft
        double additional   = 200000;                 // fixed additional cost
        return construction + additional;             // total = construction + additional
    }

    // display() - print flat details and price
    void display() {
        System.out.println("========== Flat Details ==========");
        System.out.println("Name              : " + name);
        System.out.println("Construction Area : " + constructionArea + " sq.ft");
        System.out.println("----------------------------------");
        System.out.println("Construction Cost : Rs. " + (constructionArea * 500));
        System.out.println("Additional Cost   : Rs. 200000.0");
        System.out.println("----------------------------------");
        System.out.println("Total Price       : Rs. " + computePrice());
        System.out.println("==================================\n");
    }
}

// Bungalow class - implements Property interface
class Bungalow implements Property {

    String name;              // name of bungalow
    double constructionArea;  // construction area in sq.feet
    double landArea;          // extra land area (only in Bungalow)

    // Constructor - initialize bungalow details
    Bungalow(String name, double constructionArea, double landArea) {
        this.name = name;
        this.constructionArea = constructionArea;
        this.landArea = landArea;
    }

    // computePrice() - calculate total price of bungalow
    public double computePrice() {
        double construction = constructionArea * 500; // Rs.500 per sq.ft
        double additional   = landArea * 200;          // Rs.200 per sq.ft of land
        double land         = landArea * 400;          // Rs.400 per sq.ft of land
        return construction + additional + land;       // total = all three costs
    }

    // display() - print bungalow details and price
    void display() {
        System.out.println("========== Bungalow Details ==========");
        System.out.println("Name              : " + name);
        System.out.println("Construction Area : " + constructionArea + " sq.ft");
        System.out.println("Land Area         : " + landArea + " sq.ft");
        System.out.println("--------------------------------------");
        System.out.println("Construction Cost : Rs. " + (constructionArea * 500));
        System.out.println("Additional Cost   : Rs. " + (landArea * 200));
        System.out.println("Land Cost         : Rs. " + (landArea * 400));
        System.out.println("--------------------------------------");
        System.out.println("Total Price       : Rs. " + computePrice());
        System.out.println("======================================\n");
    }
}

// Main class
public class PropertyMain {
    public static void main(String[] args) {

        // Flat Object 1
        Flat f1 = new Flat("Sunshine Apartment", 1000);
        f1.display();

        // Flat Object 2
        Flat f2 = new Flat("Green Valley Flat", 1500);
        f2.display();

        // Bungalow Object 1
        Bungalow b1 = new Bungalow("Royal Villa", 1000, 500);
        b1.display();

        // Bungalow Object 2
        Bungalow b2 = new Bungalow("Garden House", 2000, 1000);
        b2.display();

        // Using interface reference - polymorphism!
        // Property reference can hold both Flat and Bungalow objects
        System.out.println("===== Using Interface Reference =====");
        Property p1 = new Flat("Sky High Flat", 800);      // interface ref
        Property p2 = new Bungalow("Dream Villa", 1200, 600); // interface ref
        System.out.println("Flat Price     : Rs. " + p1.computePrice());
        System.out.println("Bungalow Price : Rs. " + p2.computePrice());
    }
}