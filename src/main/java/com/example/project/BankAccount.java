package com.example.project;


public class BankAccount{
    private String accountType;
    private double balance;


    // Constructor with account type and initial balance
    public BankAccount(String accountType, double initialBalance) {
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            this.balance = Math.round(balance*100)/100.0;
            System.out.println(amount + " has been deposited to your " + accountType + " account.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            this.balance = Math.round(balance*100)/100.0;
            System.out.println(amount + " has been withdrawn from your " + accountType + " account.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your " + accountType + " account balance is: $" + balance);
    }

    // Getter for account type
    public String getAccountType() {
        return accountType;
    }
}