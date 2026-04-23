/*
Q5.
1) Inner Class: 
    Define two nested classes: Processor and RAM inside the outer class: CPU with following 
    data members 
    class CPU { 
        double price; 
        class Processor{   //    nested class 
            double cores; 
            double catch() 
            String manufacturer; 
            double getCache()  
            void displayProcesorDetail() 
        } 
        protected class RAM{ // nested protected class 
            // members of protected nested class 
            double memory; 
            String manufacturer; 
            Double clockSpeed; 
            double getClockSpeed() 
            void displayRAMDetail() 
        } 
    } 
    1. Write appropriate Constructor and create instance of Outer and inner class and call the 
    methods in main function 
    */
// Outer class CPU
class CPU {

    double price; // price of CPU unit

    // Constructor - initialize CPU price
    CPU(double price) {
        this.price = price;
    }

    // display CPU price
    void displayCPUDetail() {
        System.out.println("CPU Price    : Rs. " + price);
    }

    // ===== Inner class Processor =====
    // written INSIDE CPU because Processor belongs to CPU
    class Processor {

        double cores;         // number of processor cores
        double cache;         // cache memory in MB
        String manufacturer;  // who made it (Intel, AMD)

        // Constructor - initialize processor details
        Processor(double cores, double cache, String manufacturer) {
            this.cores = cores;
            this.cache = cache;
            this.manufacturer = manufacturer;
        }

        // getCache() - return cache value
        double getCache() {
            return cache; // return cache memory size
        }

        // displayProcessorDetail() - print all processor details
        void displayProcessorDetail() {
            System.out.println("===== Processor Details =====");
            System.out.println("Cores        : " + cores);
            System.out.println("Cache        : " + getCache() + " MB");
            System.out.println("Manufacturer : " + manufacturer);
            System.out.println("=============================\n");
        }
    }

    // ===== Protected Inner class RAM =====
    // protected means accessible within same package
    // written INSIDE CPU because RAM belongs to CPU
    protected class RAM {

        double memory;        // RAM size in GB
        String manufacturer;  // who made it (Samsung, Kingston)
        double clockSpeed;    // speed in MHz

        // Constructor - initialize RAM details
        RAM(double memory, String manufacturer, double clockSpeed) {
            this.memory = memory;
            this.manufacturer = manufacturer;
            this.clockSpeed = clockSpeed;
        }

        // getClockSpeed() - return clock speed value
        double getClockSpeed() {
            return clockSpeed; // return RAM speed
        }

        // displayRAMDetail() - print all RAM details
        void displayRAMDetail() {
            System.out.println("===== RAM Details =====");
            System.out.println("Memory       : " + memory + " GB");
            System.out.println("Manufacturer : " + manufacturer);
            System.out.println("Clock Speed  : " + getClockSpeed() + " MHz");
            System.out.println("=======================\n");
        }
    }
}

// Main class to test everything
public class CPUMain {
    public static void main(String[] args) {

        // Step 1 - create outer CPU object first
        CPU cpu1 = new CPU(50000);
        cpu1.displayCPUDetail();

        // Step 2 - create Processor object using CPU object
        // syntax: OuterClass.InnerClass obj = outerObj.new InnerClass()
        CPU.Processor processor1 = cpu1.new Processor(8, 12, "Intel");
        processor1.displayProcessorDetail();

        // Step 3 - create RAM object using CPU object
        CPU.RAM ram1 = cpu1.new RAM(16, "Samsung", 3200);
        ram1.displayRAMDetail();

        // ===== Second CPU with different specs =====
        CPU cpu2 = new CPU(75000);
        cpu2.displayCPUDetail();

        CPU.Processor processor2 = cpu2.new Processor(16, 32, "AMD");
        processor2.displayProcessorDetail();

        CPU.RAM ram2 = cpu2.new RAM(32, "Kingston", 4800);
        ram2.displayRAMDetail();

        // ===== Calling individual methods =====
        System.out.println("===== Individual Method Calls =====");
        System.out.println("Cache of Processor1  : " + processor1.getCache() + " MB");
        System.out.println("Cache of Processor2  : " + processor2.getCache() + " MB");
        System.out.println("ClockSpeed of RAM1   : " + ram1.getClockSpeed() + " MHz");
        System.out.println("ClockSpeed of RAM2   : " + ram2.getClockSpeed() + " MHz");
    }
}