/*
3)
(iii). Define a class with the Name, Basic salary and dearness allowance as data 
members.Calculate and print the Name, Basic salary(yearly), dearness allowance and 
tax deduced at source(TDS) and net salary, where TDS is charged on gross salary  
which is basic salary + dearness allowance and TDS rate is as per following table.  
*/
public class Salary {

    String name;        // employee name
    double basicSalary; // yearly basic salary
    double da;          // dearness allowance (74% of basic)

    // Constructor - only name and basic salary needed
    // DA is automatically calculated inside
    Salary(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.da = basicSalary * 0.74; // DA = 74% of basic salary
    }

    // calculateDA() - return DA value
    double calculateDA() {
        return basicSalary * 0.74; // 74% of basic salary
    }

    // calculateGross() - return gross salary
    double calculateGross() {
        return basicSalary + da; // basic + DA
    }

    // calculateTDS() - return TDS based on gross salary
    double calculateTDS() {
        double gross = calculateGross();
        if(gross <= 100000) {
            return 0; // NIL tax
        } else {
            return (gross - 100000) * 0.10; // 10% on excess
        }
    }

    // calculateNet() - return net salary
    double calculateNet() {
        return calculateGross() - calculateTDS(); // gross - TDS
    }

    // display() - print all salary details
    void display() {
        System.out.println("========== Salary Details ==========");
        System.out.println("Name           : " + name);
        System.out.println("Basic Salary   : Rs. " + basicSalary);
        System.out.println("DA (74%)       : Rs. " + calculateDA());
        System.out.println("Gross Salary   : Rs. " + calculateGross());
        System.out.println("TDS            : Rs. " + calculateTDS());
        System.out.println("Net Salary     : Rs. " + calculateNet());
        System.out.println("=====================================\n");
    }

    public static void main(String[] args) {

        // Object 1 - gross below 100000 (NIL TDS)
        Salary emp1 = new Salary("Shreyas", 50000);
        emp1.display();

        // Object 2 - gross exactly 100000 (NIL TDS)
        Salary emp2 = new Salary("Shreya", 57471);
        emp2.display();

        // Object 3 - gross above 100000 (10% TDS on excess)
        Salary emp3 = new Salary("Shrey", 100000);
        emp3.display();
    }
}