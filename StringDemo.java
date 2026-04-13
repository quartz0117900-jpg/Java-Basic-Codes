public class StringDemo {
    public static void main(String[] args) {

        // =================== STRING METHODS ===================
        System.out.println("=== String Methods ===\n");

        String s = "Hello World";

        // length() - count total characters including spaces
        System.out.println("String: " + s);
        System.out.println("Length: " + s.length()); // 11

        // charAt() - get character at given position
        System.out.println("Char at 0: " + s.charAt(0));   // H
        System.out.println("Char at 6: " + s.charAt(6));   // W

        // indexOf() - find position of character or word
        System.out.println("Index of 'o': " + s.indexOf('o'));        // 4
        System.out.println("Index of 'World': " + s.indexOf("World")); // 6

        // substring() - cut a part of string
        System.out.println("Substring from 6: " + s.substring(6));     // World
        System.out.println("Substring 0 to 5: " + s.substring(0, 5)); // Hello

        // toUpperCase() and toLowerCase() - change case
        System.out.println("Uppercase: " + s.toUpperCase()); // HELLO WORLD
        System.out.println("Lowercase: " + s.toLowerCase()); // hello world

        // trim() - remove spaces from both sides
        String spacedStr = "   Hello   ";
        System.out.println("Before trim: '" + spacedStr + "'");         // '   Hello   '
        System.out.println("After trim: '" + spacedStr.trim() + "'");   // 'Hello'

        // replace() - replace a character or word with another
        System.out.println("Replace 'l' with 'r': " + s.replace('l', 'r')); // Herro Worrd
        System.out.println("Replace 'World' with 'Java': " + s.replace("World", "Java")); // Hello Java

        // equals() - compare two strings (case sensitive)
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "hello";
        System.out.println("s1 equals s2: " + s1.equals(s2));              // true
        System.out.println("s1 equals s3: " + s1.equals(s3));              // false
        System.out.println("s1 equalsIgnoreCase s3: " + s1.equalsIgnoreCase(s3)); // true

        // contains() - check if string has given text
        System.out.println("Contains 'World': " + s.contains("World")); // true
        System.out.println("Contains 'Java': " + s.contains("Java"));   // false

        // startsWith() and endsWith() - check beginning and end
        System.out.println("Starts with 'Hello': " + s.startsWith("Hello")); // true
        System.out.println("Ends with 'World': " + s.endsWith("World"));     // true

        // isEmpty() - check if string is empty
        String emptyStr = "";
        System.out.println("Is empty: " + emptyStr.isEmpty()); // true
        System.out.println("Is empty: " + s.isEmpty());        // false

        // split() - break string into array by separator
        String csv = "Apple,Banana,Mango";
        String[] fruits = csv.split(","); // split by comma
        System.out.println("Split result:");
        for(String fruit : fruits) {      // print each part
            System.out.println("  " + fruit);
        }

        // concat() - join two strings
        String first = "Hello";
        String second = " World";
        System.out.println("Concat: " + first.concat(second)); // Hello World

        // valueOf() - convert other types to String
        int num = 100;
        String numStr = String.valueOf(num); // 100 becomes "100"
        System.out.println("valueOf int: " + numStr);

        // toCharArray() - convert String to array of characters
        char[] chars = s.toCharArray();
        System.out.print("Char array: ");
        for(char c : chars) {
            System.out.print(c + " "); // H e l l o   W o r l d
        }
        System.out.println();

        // =================== STRINGBUFFER METHODS ===================
        System.out.println("\n=== StringBuffer Methods ===\n");

        StringBuffer sb = new StringBuffer("Hello");

        // length() - count characters in StringBuffer
        System.out.println("StringBuffer: " + sb);
        System.out.println("Length: " + sb.length()); // 5

        // capacity() - internal storage size (default 16 + initial length)
        System.out.println("Capacity: " + sb.capacity()); // 21 (16+5)

        // append() - add text at the end
        sb.append(" World"); // adds " World" at end
        System.out.println("After append: " + sb); // Hello World

        // insert() - add text at specific position
        sb.insert(5, "!!!"); // inserts "!!!" at position 5
        System.out.println("After insert: " + sb); // Hello!!! World

        // delete() - remove characters from start to end position
        sb.delete(5, 8); // removes characters from position 5 to 8
        System.out.println("After delete: " + sb); // Hello World

        // replace() - replace portion of StringBuffer
        sb.replace(6, 11, "Java"); // replace "World" with "Java"
        System.out.println("After replace: " + sb); // Hello Java

        // reverse() - reverse all characters
        sb.reverse();
        System.out.println("After reverse: " + sb); // avaJ olleH

        // reverse back for next operations
        sb.reverse();
        System.out.println("Reversed back: " + sb); // Hello Java

        // charAt() - get character at position
        System.out.println("Char at 0: " + sb.charAt(0)); // H

        // setCharAt() - change character at position
        sb.setCharAt(0, 'J'); // change first character to J
        System.out.println("After setCharAt: " + sb); // Jello Java

        // deleteCharAt() - delete one character at position
        sb.deleteCharAt(0); // delete character at position 0
        System.out.println("After deleteCharAt: " + sb); // ello Java

        // indexOf() - find position of text
        System.out.println("Index of 'Java': " + sb.indexOf("Java")); // 5

        // toString() - convert StringBuffer to String
        String result = sb.toString();
        System.out.println("Converted to String: " + result);

        // =================== STRING vs STRINGBUFFER ===================
        System.out.println("\n=== String vs StringBuffer Speed Test ===\n");

        // String - creates new object every time (slow)
        long startTime = System.currentTimeMillis(); // record start time
        String str = "";
        for(int i = 0; i < 10000; i++) {
            str = str + "a"; // creates new String 10000 times!
        }
        long endTime = System.currentTimeMillis(); // record end time
        System.out.println("String time: " + (endTime - startTime) + "ms");

        // StringBuffer - modifies same object (fast)
        startTime = System.currentTimeMillis(); // record start time
        StringBuffer sbuf = new StringBuffer();
        for(int i = 0; i < 10000; i++) {
            sbuf.append("a"); // modifies same object 10000 times!
        }
        endTime = System.currentTimeMillis(); // record end time
        System.out.println("StringBuffer time: " + (endTime - startTime) + "ms");
    }
}