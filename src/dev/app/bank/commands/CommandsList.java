package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.util.Scanner;

public enum CommandsList implements InputCommand{
    ;

    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        return 0;
    }
}
