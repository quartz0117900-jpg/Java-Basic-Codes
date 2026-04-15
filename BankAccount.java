import java.util.Scanner;

public class BankAccount {

    String depositorName; // name of account holder
    int acc_no;           // unique account number
    String acc_type;      // Saving or Current
    double balance;       // current account balance

    // static counter - shared by ALL accounts
    // every new account gets next number automatically
    static int nextAccNo = 1;

    // createAcc() - create a new bank account
    void createAcc() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter depositor name:");
        depositorName = sc.nextLine(); // read full name

        System.out.println("Enter account type (Saving/Current):");
        acc_type = sc.nextLine(); // read account type

        System.out.println("Enter initial balance:");
        balance = sc.nextDouble(); // read starting balance

        acc_no = nextAccNo; // assign current counter as account number
        nextAccNo++;        // increase counter for next account

        System.out.println("✅ Account created successfully!");
        System.out.println("Your Account Number is: " + acc_no);
    }

    // Deposit() - add money to account
    void Deposit() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount to deposit:");
        double amount = sc.nextDouble(); // read deposit amount

        if(amount <= 0) {
            // reject zero or negative amount
            System.out.println("❌ Invalid amount! Must be greater than 0");
        } else {
            balance = balance + amount; // add amount to balance
            System.out.println("✅ Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        }
    }

    // Withdraw() - take money from account
    void Withdraw() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount to withdraw:");
        double amount = sc.nextDouble(); // read withdrawal amount

        if(amount <= 0) {
            // reject zero or negative amount
            System.out.println("❌ Invalid amount! Must be greater than 0");
        } else if(amount > balance) {
            // reject if not enough balance
            System.out.println("❌ Insufficient balance!");
            System.out.println("Available balance: " + balance);
        } else {
            balance = balance - amount; // subtract from balance
            System.out.println("✅ Withdrawn: " + amount);
            System.out.println("Remaining Balance: " + balance);
        }
    }

    // BalanceInquiry() - show account details
    void BalanceInquiry() {
        System.out.println("\n====== Account Details ======");
        System.out.println("Account No   : " + acc_no);
        System.out.println("Name         : " + depositorName);
        System.out.println("Account Type : " + acc_type);
        System.out.println("Balance      : ₹" + balance);
        System.out.println("==============================\n");
    }

    public static void main(String[] args) {

        // ===== Account 1 =====
        BankAccount account1 = new BankAccount();
        account1.createAcc();       // create first account (gets acc_no = 1)
        account1.Deposit();         // deposit some money
        account1.Withdraw();        // withdraw some money
        account1.BalanceInquiry();  // check balance

        // ===== Account 2 =====
        BankAccount account2 = new BankAccount();
        account2.createAcc();       // create second account (gets acc_no = 2)
        account2.Deposit();         // deposit some money
        account2.BalanceInquiry();  // check balance

        // ===== Account 3 =====
        BankAccount account3 = new BankAccount();
        account3.createAcc();       // create third account (gets acc_no = 3)
        account3.Withdraw();        // try to withdraw
        account3.BalanceInquiry();  // check balance
    }
}