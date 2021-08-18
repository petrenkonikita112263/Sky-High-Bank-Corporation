package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.util.Scanner;

public class LoanCommand implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.print("Enter loan amount: ");
        int amountLoan = scanner.nextInt();
        if (bank.authorizeLoan(current, amountLoan))
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
        return current;
    }

    @Override
    public String toString() {
        return "Loan";
    }
}
