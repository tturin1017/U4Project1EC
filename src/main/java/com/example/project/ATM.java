package com.example.project;

public class ATM{
    private Bank bank;

    public ATM(Bank bank){
        this.bank = bank;
    }

    public Bank getBank(){
        return bank;
    }
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        atm.bank.run();
    }
}

