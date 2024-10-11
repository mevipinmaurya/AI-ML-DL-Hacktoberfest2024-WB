import java.util.HashMap;
import java.util.Scanner;

public class SimpleBankingSystem {

    static class Account {
        private String accountHolder;
        private double balance;

        public Account(String accountHolder) {
            this.accountHolder = accountHolder;
            this.balance = 0.0;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: $" + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Account> accounts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Simple Banking System!");
        System.out.println("Commands: create, deposit, withdraw, balance, exit");

        while (true) {
            System.out.print("Enter a command: ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "create":
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    if (!accounts.containsKey(name)) {
                        accounts.put(name, new Account(name));
                        System.out.println("Account created for " + name);
                    } else {
                        System.out.println("Account already exists for " + name);
                    }
                    break;

                case "deposit":
                    System.out.print("Enter account holder name: ");
                    String depositName = scanner.nextLine();
                    Account depositAccount = accounts.get(depositName);
                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case "withdraw":
                    System.out.print("Enter account holder name: ");
                    String withdrawName = scanner.nextLine();
                    Account withdrawAccount = accounts.get(withdrawName);
                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case "balance":
                    System.out.print("Enter account holder name: ");
                    String balanceName = scanner.nextLine();
                    Account balanceAccount = accounts.get(balanceName);
                    if (balanceAccount != null) {
                        System.out.println("Balance for " + balanceName + ": $" + balanceAccount.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case "exit":
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}
