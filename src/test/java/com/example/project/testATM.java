package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class testATM {
    @Test 
    public void testSavingsToCheckingsBalance(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        
         // Simulate multiple inputs (e.g., user chooses Deposit, enters 100, then exits)
         String simulatedInput = "4\n10\n2\n5\n";  
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

         double[] expectedOutput = {490.0,1010.0};
         double studentOutputSavingsBalance = bank.getSavingsAccount().getBalance();
         double studentOutputCheckingBalance = bank.getCheckingAccount().getBalance();
         double[] studentOutput = {studentOutputSavingsBalance,studentOutputCheckingBalance};
         assertArrayEquals(expectedOutput, studentOutput);
    }

    @Test
    public void testSavingsToCheckingsTransferLimit(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        

         // Simulate multiple inputs (e.g., user chooses Deposit, enters 100, then exits)
         String simulatedInput = "4\n10\n2\n4\n35\n2\n4\n100\n2\n5\n";  
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

         double[] expectedOutput = {455.0,1045.0};
         double studentOutputSavingsBalance = bank.getSavingsAccount().getBalance();
         double studentOutputCheckingBalance = bank.getCheckingAccount().getBalance();
         double[] studentOutput = {studentOutputSavingsBalance,studentOutputCheckingBalance};
         assertArrayEquals(expectedOutput, studentOutput);
    }

    @Test 
    public void testSavingsToCheckingsAmountLimit(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        

         // Simulate multiple inputs (e.g., user chooses Deposit, enters 100, then exits)
         String simulatedInput = "4\n525\n2\n5\n";  
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

         double[] expectedOutput = {500.0,1000.0};
         double studentOutputSavingsBalance = bank.getSavingsAccount().getBalance();
         double studentOutputCheckingBalance = bank.getCheckingAccount().getBalance();
         double[] studentOutput = {studentOutputSavingsBalance,studentOutputCheckingBalance};
         assertArrayEquals(expectedOutput, studentOutput);
    }

    @Test 
    public void testCheckingToSavingsBalance(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        

         // Simulate multiple inputs (e.g., user chooses Deposit, enters 100, then exits)
         String simulatedInput = "4\n50\n1\n5\n";  
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

         double[] expectedOutput = {550.0,950.0};
         double studentOutputSavingsBalance = bank.getSavingsAccount().getBalance();
         double studentOutputCheckingBalance = bank.getCheckingAccount().getBalance();
         double[] studentOutput = {studentOutputSavingsBalance,studentOutputCheckingBalance};
         assertArrayEquals(expectedOutput, studentOutput);
    }

    @Test 
    public void testCheckingToSavingsAmountLimit(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        

         // Simulate multiple inputs (e.g., user chooses Deposit, enters 100, then exits)
         String simulatedInput = "4\n1025\n1\n5\n";  
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

         double[] expectedOutput = {500.0,1000.0};
         double studentOutputSavingsBalance = bank.getSavingsAccount().getBalance();
         double studentOutputCheckingBalance = bank.getCheckingAccount().getBalance();
         double[] studentOutput = {studentOutputSavingsBalance,studentOutputCheckingBalance};
         assertArrayEquals(expectedOutput, studentOutput);
    }


    
}
