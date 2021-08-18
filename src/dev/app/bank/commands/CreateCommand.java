package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.util.Scanner;

public class CreateCommand implements InputCommand{
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.println("Enter account type(1=savings,"
                + " 2=checking, 3=interest checking): ");
        int type = scanner.nextInt();
        System.out.print("Enter 1 for foreign, 2 for domestic: ");
        int valBoolean = scanner.nextInt();
        boolean isForeign = (valBoolean == 1);
        current = bank.newAccount(type, isForeign);
        System.out.println("Your new account number is "
                + current);
        return current;
    }

    @Override
    public String toString() {
        return "Create";
    }
}
