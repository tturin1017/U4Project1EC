package com.example.project;
import java.util.Scanner;

public class Bank {
    private BankAccount savingsAccount;
    private BankAccount checkingAccount;

    // Constructor initializes the accounts with initial balances
    public Bank() {
        savingsAccount = new BankAccount("Savings", 500.00);
        checkingAccount = new BankAccount("Checking", 1000.00);
    }

    public BankAccount getSavingsAccount(){
        return savingsAccount;
    }

    public BankAccount getCheckingAccount(){
        return checkingAccount;
    }

    // Method to start the banking system
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1){
                deposit(scanner);
            }else if(choice == 2){
                withdraw(scanner);
            }else if(choice ==3){
                checkBalance();
            }
            else if (choice == 4){
                running = false;
                System.out.println("Thank you for banking with us!");
            }else{
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method for deposits
    public void deposit(Scanner scanner) {
        System.out.println("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        chooseAccountType(scanner, amount, "deposit");
    }

    // Method for withdrawals
    public void withdraw(Scanner scanner) {
        System.out.println("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        chooseAccountType(scanner, amount, "withdraw");
    }

    public void chooseAccountType(Scanner scanner, double amount, String action){
        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                System.out.println("Do you want to withdraw from your Savings account? (yes/no)");
                String response = scanner.nextLine();
                if (response.equals("yes")) {
                    if (action == "withdraw"){
                        savingsAccount.withdraw(amount);
                    }else{
                        savingsAccount.deposit(amount);
                    }
                    return;
                }
            }
            if (i == 2) {
                System.out.println("Do you want to withdraw from your Checking account? (yes/no)");
                String response = scanner.nextLine();
                if (response.equals("yes")) {
                    if (action == "withdraw"){
                        checkingAccount.withdraw(amount);
                    }else{
                        System.out.println("hi");
                        checkingAccount.deposit(amount);
                    }
                    return;
                }
            }
        }
        System.out.println("No valid account selected.");
    }


    // Method to check the balance of both accounts
    public void checkBalance() {
        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                savingsAccount.checkBalance();
            } else if (i == 2) {
                checkingAccount.checkBalance();
            }
        }
    }
}