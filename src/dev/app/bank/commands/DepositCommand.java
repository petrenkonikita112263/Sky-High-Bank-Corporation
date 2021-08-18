package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.util.Scanner;

public class DepositCommand implements InputCommand{
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.print("Enter deposit amt: ");
        int amount = scanner.nextInt();
        bank.deposit(current, amount);
        return current;
    }

    @Override
    public String toString() {
        return "Deposit";
    }
}
