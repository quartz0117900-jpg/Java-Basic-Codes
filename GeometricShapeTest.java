/*
Q.4)  
iv) Define following classes and interfaces. 
    public interface GeometricShape { 
        public void describe(); 
    } 
    public interface TwoDShape extends GeometricShape { 
        public double area(); 
    } 
    public interface ThreeDShape extends GeometricShape { 
        public double volume(); 
    } 
    public class Cone implements ThreeDShape  { 
        private double radius; 
        private double height; 
        public Cone (double radius, double height)  
        public double volume()  
        public void describe()  
    } 
    public class Rectangle implements TwoDShape  { 
    
    
        private double width, height; 
        public Rectangle (double width, double height)  
        public double area()  
        public double perimeter()  
        public void describe() 
    
    } 
    public class Sphere implements ThreeDShape  { 
        private double radius; 
        public Sphere (double radius)  
        public double volume() 
        public void describe()  
    } 
    Define test class to call various methods of Geometric Shape   
    */

    // Base interface - every geometric shape must have describe()
interface GeometricShape {
    public void describe(); // no body - implementing class must define it
}

// 2D interface - extends GeometricShape and adds area()
// any 2D shape must have both describe() AND area()
interface TwoDShape extends GeometricShape {
    public double area(); // no body - implementing class must define it
}

// 3D interface - extends GeometricShape and adds volume()
// any 3D shape must have both describe() AND volume()
interface ThreeDShape extends GeometricShape {
    public double volume(); // no body - implementing class must define it
}

// Rectangle class - implements TwoDShape
// must define area() and describe()
class Rectangle implements TwoDShape {

    private double width;  // width of rectangle
    private double height; // height of rectangle

    // Constructor - initialize width and height
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // area() - calculate area of rectangle
    public double area() {
        return width * height; // area = width × height
    }

    // perimeter() - calculate perimeter of rectangle
    // (not in interface but added as extra method)
    public double perimeter() {
        return 2 * (width + height); // perimeter = 2 × (width + height)
    }

    // describe() - print rectangle details
    public void describe() {
        System.out.println("===== Rectangle =====");
        System.out.println("Shape     : 2D Rectangle");
        System.out.println("Width     : " + width);
        System.out.println("Height    : " + height);
        System.out.println("Area      : " + area());
        System.out.println("Perimeter : " + perimeter());
        System.out.println("=====================\n");
    }
}

// Cone class - implements ThreeDShape
// must define volume() and describe()
class Cone implements ThreeDShape {

    private double radius; // radius of base circle
    private double height; // height of cone

    // Constructor - initialize radius and height
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // volume() - calculate volume of cone
    // formula = (1/3) × π × radius² × height
    public double volume() {
        return (1.0/3) * Math.PI * radius * radius * height;
    }

    // describe() - print cone details
    public void describe() {
        System.out.println("===== Cone =====");
        System.out.println("Shape   : 3D Cone");
        System.out.println("Radius  : " + radius);
        System.out.println("Height  : " + height);
        System.out.println("Volume  : " + String.format("%.2f", volume()));
        System.out.println("================\n");
    }
}

// Sphere class - implements ThreeDShape
// must define volume() and describe()
class Sphere implements ThreeDShape {

    private double radius; // radius of sphere

    // Constructor - initialize radius
    public Sphere(double radius) {
        this.radius = radius;
    }

    // volume() - calculate volume of sphere
    // formula = (4/3) × π × radius³
    public double volume() {
        return (4.0/3) * Math.PI * radius * radius * radius;
    }

    // describe() - print sphere details
    public void describe() {
        System.out.println("===== Sphere =====");
        System.out.println("Shape   : 3D Sphere");
        System.out.println("Radius  : " + radius);
        System.out.println("Volume  : " + String.format("%.2f", volume()));
        System.out.println("==================\n");
    }
}

// Test class - test all shapes
public class GeometricShapeTest {
    public static void main(String[] args) {

        // ===== 2D Shapes =====
        System.out.println("========== 2D Shapes ==========\n");

        // Rectangle object
        Rectangle r1 = new Rectangle(5, 3);
        r1.describe(); // prints all details

        Rectangle r2 = new Rectangle(10, 7);
        r2.describe();

        // ===== 3D Shapes =====
        System.out.println("========== 3D Shapes ==========\n");

        // Cone object
        Cone c1 = new Cone(3, 5);
        c1.describe();

        Cone c2 = new Cone(4, 8);
        c2.describe();

        // Sphere object
        Sphere s1 = new Sphere(4);
        s1.describe();

        Sphere s2 = new Sphere(7);
        s2.describe();

        // ===== Using Interface References =====
        System.out.println("===== Using Interface References =====\n");

        // TwoDShape reference holds Rectangle
        TwoDShape t1 = new Rectangle(6, 4);
        System.out.println("2D Shape area   : " + t1.area());
        t1.describe();

        // ThreeDShape reference holds Cone and Sphere
        ThreeDShape td1 = new Cone(5, 10);
        ThreeDShape td2 = new Sphere(6);
        System.out.println("Cone volume     : " + String.format("%.2f", td1.volume()));
        System.out.println("Sphere volume   : " + String.format("%.2f", td2.volume()));

        // GeometricShape reference holds any shape!
        System.out.println("\n===== GeometricShape Reference =====\n");
        GeometricShape[] shapes = {
            new Rectangle(3, 4),  // 2D shape
            new Cone(2, 6),       // 3D shape
            new Sphere(5)         // 3D shape
        };

        // describe all shapes using loop
        for(GeometricShape shape : shapes) {
            shape.describe(); // calls each shape's own describe()
        }
    }
}