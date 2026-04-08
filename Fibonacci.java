//Write A Java Code To prints Fibonacci series.

class Fibonacci {
    public static void main(String args[]) {
        int x = 0, y = 1, z, count = 10;
        System.out.println(x);   // prints 0
        System.out.println(y);   // prints 1
        for (int i = 2; i < count; i++) {
            z = x + y;
            System.out.println(z);
            x = y;
            y = z;
        }
    }
}