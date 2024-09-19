import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0; // Ensure balance is not negative
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }

    private void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. You withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    private void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. You deposited: $" + amount);
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.checkBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount myAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(myAccount);
        atm.showMenu();
    }
}
