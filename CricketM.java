import java.util.Scanner;

// Parent class Cricket
class Cricket {

    String name; // player name
    int age;     // player age

    // setdata() - take input for name and age
    void setdata() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
        name = sc.nextLine();       // read full name
        System.out.println("Enter age:");
        age = sc.nextInt();         // read age
    }

    // display() - print name and age
    void display() {
        System.out.println("Name         : " + name);
        System.out.println("Age          : " + age);
    }
}

// Child class Match - inherits from Cricket using 'extends'
class Match extends Cricket {

    int no_of_odi;  // number of ODI matches played
    int no_of_test; // number of Test matches played

    // setdata() - take input for ODI and Test + call parent's setdata()
    void setdata() {
        super.setdata(); // call Cricket's setdata() for name and age
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of ODI matches:");
        no_of_odi = sc.nextInt();   // read ODI count
        System.out.println("Enter number of Test matches:");
        no_of_test = sc.nextInt();  // read Test count
    }

    // display() - print all details + call parent's display()
    void display() {
        super.display(); // call Cricket's display() for name and age
        System.out.println("ODI Matches  : " + no_of_odi);
        System.out.println("Test Matches : " + no_of_test);
    }
}

// Main class
public class CricketM {

    public static void main(String[] args) {

        // create array of 5 Match objects
        Match players[] = new Match[5];

        // take input for all 5 players
        for(int i = 0; i < 5; i++) {
            players[i] = new Match(); // create each object
            System.out.println("\n--- Enter details for Player " + (i+1) + " ---");
            players[i].setdata();     // take input for each player
        }

        // display all 5 players
        System.out.println("\n========== All Players Details ==========");
        for(int i = 0; i < 5; i++) {
            System.out.println("\n--- Player " + (i+1) + " ---");
            players[i].display(); // print details of each player
            System.out.println("------------------------------------------");
        }
    }
} 
