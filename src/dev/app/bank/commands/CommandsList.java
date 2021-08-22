package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.io.InputStream;
import java.util.Scanner;

public enum CommandsList implements InputCommand {
    QUIT("quit", (scanner, bank, current) ->
    {
        System.out.println("Thanks for using us! Have a nice day!");
        return -1;
    }),
    CREATE("create", (scanner, bank, current) ->
    {
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
    }),
    SELECT("select", (scanner, bank, current) ->
    {
        System.out.print("Enter the bank account number: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account "
                + current + " is " + balance);
        return current;
    }),
    DEPOSIT("deposit", (scanner, bank, current) ->
    {
        System.out.print("Enter deposit amt: ");
        int amount = scanner.nextInt();
        bank.deposit(current, amount);
        return current;
    }),
    LOAN("loan", (scanner, bank, current) ->
    {
        System.out.print("Enter loan amount: ");
        int amountLoan = scanner.nextInt();
        if (bank.authorizeLoan(current, amountLoan))
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
        return current;
    }),
    SHOW("show", (scanner, bank, current) ->
    {
        System.out.println(bank.toString());
        return current;
    }),
    INTEREST("interest", (scanner, bank, current) ->
    {
        bank.addInterest();
        return current;
    }),
    SET_FOREIGN_STATE("set foreign status", (scanner, bank, current) ->
    {
        System.out.print("Enter 1 for foreign, 2 for domestic: ");
        int valBoolean = scanner.nextInt();
        boolean isForeign = (valBoolean == 1);
        bank.setForeign(current, isForeign);
        return current;
    }),
    ;

    private String commandName;
    private InputCommand commandOption;

    CommandsList(String commandName, InputCommand commandOption) {
        this.commandName = commandName;
        this.commandOption = commandOption;
    }

    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        return commandOption.execute(scanner, bank, current);
    }

    @Override
    public String toString() {
        return commandName;
    }
}
