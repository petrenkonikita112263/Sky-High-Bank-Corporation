package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.util.Scanner;

public class SelectCommand implements InputCommand{
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.print("Enter the bank account number: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account "
                + current + " is " + balance);
        return current;
    }

    @Override
    public String toString() {
        return "Select";
    }
}
