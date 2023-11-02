import java.util.Scanner;

class User {
    private String userId;
    private String pin;
    private double balance;

    public User(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class ATM {
    private User user;

    public ATM(User user) {
        this.user = user;
    }

    public void displayMenu() {
        System.out.println("Welcome, " + user.getUserId() + "!");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public void viewBalance() {
        System.out.println("Your balance is: $" + user.getBalance());
    }

    public void withdraw(double amount) {
        if (amount <= user.getBalance()) {
            user.setBalance(user.getBalance() - amount);
            System.out.println("Withdrawal successful. New balance is: $" + user.getBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        user.setBalance(user.getBalance() + amount);
        System.out.println("Deposit successful. New balance is: $" + user.getBalance());
    }

    public void transfer(User recipient, double amount) {
        if (amount <= user.getBalance()) {
            user.setBalance(user.getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);
            System.out.println("Transfer successful. New balance is: $" + user.getBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        User user = new User("user123", "1234", 1000.0);
        ATM atm = new ATM(user);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (userId.equals(user.getUserId()) && pin.equals(user.getPin())) {
            int choice;

            do {
                atm.displayMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atm.viewBalance();
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient's user ID: ");
                        String recipientUserId = scanner.next();
                        System.out.print("Enter transfer amount: $");
                        double transferAmount = scanner.nextDouble();
                        User recipient = new User(recipientUserId, "", 0.0); // Dummy user, replace with actual user lookup
                        atm.transfer(recipient, transferAmount);
                        break;
                    case 5:
                        System.out.println("Thank you for using our ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 5);

        } else {
            System.out.println("Invalid user ID or PIN. Exiting...");
        }

        scanner.close();
    }
}
