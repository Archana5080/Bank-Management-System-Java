import java.util.*;

class BankAccount {
    private static int counter = 1001;
    private String name;
    private int accountNumber;
    private double balance;

    public BankAccount(String name, double initialDeposit) {
        this.name = name;
        this.accountNumber = counter++;
        this.balance = initialDeposit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void displayDetails() {
        System.out.println("\nAccount Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

public class BankManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- BANK MANAGEMENT SYSTEM ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositAmount();
                case 3 -> withdrawAmount();
                case 4 -> displayAccount();
                case 5 -> {
                    System.out.println("Thank you for using our system. Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void createAccount() {
        sc.nextLine(); // consume newline
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit: ₹");
        double deposit = sc.nextDouble();
        BankAccount account = new BankAccount(name, deposit);
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account created successfully. Your account number is: " + account.getAccountNumber());
    }

    static void depositAmount() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            System.out.print("Enter deposit amount: ₹");
            double amount = sc.nextDouble();
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    static void withdrawAmount() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            System.out.print("Enter withdraw amount: ₹");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    static void displayAccount() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            acc.displayDetails();
        } else {
            System.out.println("Account not found.");
        }
    }
}
