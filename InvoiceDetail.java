/* 
Q.6 Generics:
1). Declare a class InvoiceDetail which accepts a type parameter which is of type 
Number with following  data members 
class InvoiceDetail <N extends Number> { 
private String invoiceName; 
private  N amount; 
private N discount 
 // write getters, setters and constructors 
} 
Call the methods in Main class */

public class InvoiceDetail<N extends Number> {

    private String invoiceName;
    private N amount;
    private N discount;

    public InvoiceDetail(String invoiceName, N amount, N discount) {
        this.invoiceName = invoiceName;
        this.amount = amount;
        this.discount = discount;
    }

    public String getInvoiceName() { return invoiceName; }
    public N getAmount() { return amount; }
    public N getDiscount() { return discount; }

    public void setInvoiceName(String invoiceName) { this.invoiceName = invoiceName; }
    public void setAmount(N amount) { this.amount = amount; }
    public void setDiscount(N discount) { this.discount = discount; }

    public void displayDetails() {
        double finalAmount = amount.doubleValue() - discount.doubleValue();
        System.out.println("Invoice Name : " + invoiceName);
        System.out.println("Amount       : " + amount);
        System.out.println("Discount     : " + discount);
        System.out.println("Final Amount : " + finalAmount);
    }

    public static void main(String[] args) {

        InvoiceDetail<Integer> intInvoice = new InvoiceDetail<>("Office Supplies", 5000, 500);
        System.out.println("--- Integer Invoice ---");
        intInvoice.displayDetails();

        System.out.println();

        InvoiceDetail<Double> doubleInvoice = new InvoiceDetail<>("Laptop Purchase", 75999.99, 3000.50);
        System.out.println("--- Double Invoice ---");
        doubleInvoice.displayDetails();

        System.out.println();

        InvoiceDetail<Float> floatInvoice = new InvoiceDetail<>("Software License", 1200.0f, 200.0f);
        floatInvoice.setInvoiceName("Annual Software License");
        floatInvoice.setAmount(1500.0f);
        floatInvoice.setDiscount(250.0f);
        System.out.println("--- Float Invoice (after setters) ---");
        floatInvoice.displayDetails();
    }
}