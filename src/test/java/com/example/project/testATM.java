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
    public void testSavingsDeposit(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        

         // Simulate multiple inputs (e.g., user chooses Deposit, enters 100, then exits)
         String simulatedInput = "1\n100\nyes\n4\n";  // Choose Deposit, deposit 100, and then Exit
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

        double expectedOutput = 600.0;
        double studentOutput = bank.getSavingsAccount().getBalance();
        assertEquals(expectedOutput, studentOutput);

        // undo the binding in System
        // System.setOut(originalOut);
        // System.setIn(System.in);
    }

    @Test
    public void testSavingsWithdraw(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        

         // Simulate multiple inputs (e.g., user chooses Deposit, enters 100, then exits)
         String simulatedInput = "2\n20\nyes\n4\n";  // Choose Withdraw, withdraw 20, and then Exit
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

        double expectedOutput = 480.0;
        double studentOutput = bank.getSavingsAccount().getBalance();
        assertEquals(expectedOutput, studentOutput);
    }

    @Test
    public void testCheckingDeposit(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        
         // Simulate multiple inputs 
         String simulatedInput = "1\n5623.75\nno\nyes\n4\n";  // Choose Deposit, deposit 100, and then Exit
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

        double expectedOutput = 6623.75;
        double studentOutput = bank.getCheckingAccount().getBalance();
        assertEquals(expectedOutput, studentOutput);
    }

    @Test
    public void testCheckingWithdraw(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        

         // Simulate multiple inputs (e.g., user chooses Deposit, enters 100, then exits)
         String simulatedInput = "2\n50\nno\nyes\n4\n";  // Choose Withdraw, withdraw 20, and then Exit
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

        double expectedOutput = 950.0;
        double studentOutput = bank.getCheckingAccount().getBalance();
        assertEquals(expectedOutput, studentOutput);
    }

    @Test
    public void testOverdraw(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        

         // Simulate multiple inputs (e.g., user chooses Deposit, enters 100, then exits)
         String simulatedInput = "2\n1500\nno\nyes\n4\n";  // Choose Withdraw, withdraw 20, and then Exit
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

        double expectedOutput = 1000;
        double studentOutput = bank.getCheckingAccount().getBalance();
        assertEquals(expectedOutput, studentOutput);
    }

    @Test //overall tests of account types and withdraw/deposit methods
    public void testEverything(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        

         // Simulate multiple inputs 
         String simulatedInput = "1\n34.56\nyes\n2\n890.89\nno\nyes\n4\n";  // Choose Withdraw, withdraw 20, and then Exit
         ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
         System.setIn(in);

         atm.getBank().run();

        double[] expectedOutput = {534.56,109.11};
        double studentOutputSavingsBalance = bank.getSavingsAccount().getBalance();
        double studentOutputCheckingBalance = bank.getCheckingAccount().getBalance();
        double[] studentOutput = {studentOutputSavingsBalance,studentOutputCheckingBalance};
        assertArrayEquals(expectedOutput, studentOutput);
    }

    @Test //tests if the user does not choose a correct account type, the current amount will not be withdrawn or deposited. 
    public void testInvalidAccountType(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        

         // Simulate multiple inputs (e.g., user chooses Deposit, enters 100, then exits)
         String simulatedInput = "2\n45\nno\nno\n4\n";  // Choose Withdraw, withdraw 20, and then Exit
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
