import java.util.Scanner;

public class Cipher {

    String plainText; // stores the original or encrypted text
    int key;          // stores the shift value

    // Constructor - takes text and key as input
    Cipher(String plainText, int key) {
        this.plainText = plainText; // 'this' means this class's variable
        this.key = key;
    }

    // Encryption - shift every character FORWARD by key
    String Encryption() {
        String encrypted = ""; // start with empty encrypted string
        for(int i = 0; i < plainText.length(); i++) { // loop through every character
            char ch = plainText.charAt(i);             // get character at position i
            // shift forward by key and wrap around using % 26
            char newChar = (char)(((ch - 'A' + key) % 26) + 'A');
            encrypted = encrypted + newChar;           // add to result
        }
        return encrypted; // return final encrypted string
    }

    // Decryption - shift every character BACKWARD by key
    String Decryption() {
        String decrypted = ""; // start with empty decrypted string
        for(int i = 0; i < plainText.length(); i++) { // loop through every character
            char ch = plainText.charAt(i);             // get character at position i
            // shift backward by key, +26 to avoid negative numbers
            char newChar = (char)(((ch - 'A' - key + 26) % 26) + 'A');
            decrypted = decrypted + newChar;           // add to result
        }
        return decrypted; // return final decrypted string
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // take input from command prompt
        System.out.println("Enter text (UPPERCASE only):");
        String text = sc.next().toUpperCase(); // convert to uppercase just in case

        System.out.println("Enter key:");
        int key = sc.nextInt();

        // Object 1 - Encrypt the original text
        Cipher c1 = new Cipher(text, key);
        String encrypted = c1.Encryption();
        System.out.println("Original text: " + text);
        System.out.println("Encrypted text: " + encrypted);

        // Object 2 - Decrypt the encrypted text
        Cipher c2 = new Cipher(encrypted, key);
        String decrypted = c2.Decryption();
        System.out.println("Decrypted text: " + decrypted);

        sc.close();
    }
}