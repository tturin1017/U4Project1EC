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
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1){
                deposit(scanner);
            }else if(choice == 2){
                withdraw(scanner);
            }else if(choice ==3){
                checkBalance();
            }else if(choice == 4){
                transfer(scanner);
            }else if (choice == 5){
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

    public void transfer(Scanner scanner){
        System.out.println("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Choose which account to transfer to: \n1. Checking Account\n2. Savings Account");
        int option = scanner.nextInt();
        String fromAccount;
        scanner.nextLine();
        if(option == 1){
            fromAccount = checkingAccount.getAccountType();
        }else{
            fromAccount = savingsAccount.getAccountType();
        }

        if(fromAccount.equals("Savings")){
            System.out.println("You are transferring from your savings to checking account.");
            savingsAccount.addTransferNum();
            if(savingsAccount.getTransferNum()<3){
                if(amount<=500.0){
                    System.out.println("Your remaining number of transfers for today is "+(2-savingsAccount.getTransferNum())+
                    ".");
                    savingsAccount.withdraw(amount);
                    checkingAccount.deposit(amount);
                }else{
                    System.out.println("You cannot transfer more than $500 to your checking account today.");
                }
            }else{
                System.out.println("You've reached your daily transfer limit for your savings account.");
            }
        }else{ //coming from Checking account
            System.out.println("You are transferring from your checking to savings account.");
            if(amount<=1000.0){
                checkingAccount.withdraw(amount);
                savingsAccount.deposit(amount);
            }else{
                System.out.println("You cannot transfer more than $1000 to your savings account today.");
            }
        }
    }
}