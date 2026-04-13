public class Wrapper {
    public static void main(String[] args) {

        System.out.println("=== Integer Methods ===");
        System.out.println("Max value of int: " + Integer.MAX_VALUE);
        System.out.println("Min value of int: " + Integer.MIN_VALUE);

        String str = "123";
        int num = Integer.parseInt(str); // "123" becomes 123
        System.out.println("Parsed int: " + num);

        System.out.println("Binary of 10: " + Integer.toBinaryString(10));  // 1010
        System.out.println("Hex of 255: " + Integer.toHexString(255));      // ff
        System.out.println("Octal of 8: " + Integer.toOctalString(8));      // 10

        System.out.println("Compare 5,10: " + Integer.compare(5, 10));  // negative
        System.out.println("Compare 10,5: " + Integer.compare(10, 5));  // positive
        System.out.println("Compare 5,5: " + Integer.compare(5, 5));    // 0

        int n = 99;
        String s = Integer.toString(n); // 99 becomes "99"
        System.out.println("Int to String: " + s);

  
        System.out.println("\n=== Double Methods ===");
        System.out.println("Max value of double: " + Double.MAX_VALUE);
        System.out.println("Min value of double: " + Double.MIN_VALUE);

    
        String ds = "3.14";
        double d = Double.parseDouble(ds); // "3.14" becomes 3.14
        System.out.println("Parsed double: " + d);

    
        double result = 0.0 / 0.0;         // dividing 0 by 0 gives NaN
        System.out.println("Is NaN: " + Double.isNaN(result)); // true


        System.out.println("\n=== Character Methods ===");
        char ch = 'A';

        System.out.println("Is Letter: " + Character.isLetter(ch));      // true
        System.out.println("Is Digit: " + Character.isDigit(ch));        // false
        System.out.println("Is Uppercase: " + Character.isUpperCase(ch));// true
        System.out.println("Is Lowercase: " + Character.isLowerCase(ch));// false
        System.out.println("Is WhiteSpace: " + Character.isWhitespace(' ')); // true

        System.out.println("To Lowercase: " + Character.toLowerCase(ch)); // a
        System.out.println("To Uppercase: " + Character.toUpperCase('z')); // Z

   

        System.out.println("\n=== Boolean Methods ===");

   
        String bs = "true";
        boolean b = Boolean.parseBoolean(bs); // "true" becomes true
        System.out.println("Parsed boolean: " + b);

  
        System.out.println("Boolean to String: " + Boolean.toString(false)); // "false"

   

        System.out.println("\n=== AutoBoxing ===");

        int primitiveInt = 50;
        Integer wrappedInt = primitiveInt; // Java wraps it automatically 📦
        System.out.println("AutoBoxed Integer: " + wrappedInt);

        double primitiveDouble = 9.99;
        Double wrappedDouble = primitiveDouble; // Java wraps it automatically 📦
        System.out.println("AutoBoxed Double: " + wrappedDouble);

  

        System.out.println("\n=== UnBoxing ===");

        Integer wrappedInt2 = 100;
        int primitiveInt2 = wrappedInt2; // Java unwraps it automatically 📦→value
        System.out.println("UnBoxed int: " + primitiveInt2);

        Double wrappedDouble2 = 7.77;
        double primitiveDouble2 = wrappedDouble2; // Java unwraps it automatically
        System.out.println("UnBoxed double: " + primitiveDouble2);
    }
}