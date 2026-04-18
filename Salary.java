public class Salary {

    String name;        // employee name
    double basicSalary; // yearly basic salary
    double da;          // dearness allowance

    // Constructor - initialize salary object
    Salary(String name, double basicSalary, double da) {
        this.name = name;               // set name
        this.basicSalary = basicSalary; // set basic salary
        this.da = da;                   // set dearness allowance
    }

    // calculate() - calculate and print all salary details
    void calculate() {

        // Step 1 - calculate gross salary
        double gross = basicSalary + da; // gross = basic + DA

        // Step 2 - calculate TDS based on gross salary
        double tds = 0; // start with 0 TDS
        if(gross <= 100000) {
            tds = 0; // NIL - no tax if gross is 100000 or below
        } else {
            // 10% tax only on amount that exceeds 100000
            tds = (gross - 100000) * 0.10;
        }

        // Step 3 - calculate net salary
        double net = gross - tds; // net = gross - tax

        // Step 4 - print all details
        System.out.println("========== Salary Details ==========");
        System.out.println("Name           : " + name);
        System.out.println("Basic Salary   : Rs. " + basicSalary);
        System.out.println("DA             : Rs. " + da);
        System.out.println("Gross Salary   : Rs. " + gross);
        System.out.println("TDS            : Rs. " + tds);
        System.out.println("Net Salary     : Rs. " + net);
        System.out.println("=====================================\n");
    }

    public static void main(String[] args) {

        // Object 1 - gross below 100000 (NIL TDS)
        Salary emp1 = new Salary("Shrey", 60000, 20000);
        emp1.calculate();

        // Object 2 - gross exactly 100000 (NIL TDS)
        Salary emp2 = new Salary("Shreya", 80000, 20000);
        emp2.calculate();

        // Object 3 - gross above 100000 (10% TDS on excess)
        Salary emp3 = new Salary("Quartz", 100000, 50000);
        emp3.calculate();
    }
}