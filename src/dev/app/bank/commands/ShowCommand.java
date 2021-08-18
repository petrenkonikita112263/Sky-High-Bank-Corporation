package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.util.Scanner;

public class ShowCommand implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.println(bank.toString());
        return current;
    }

    @Override
    public String toString() {
        return "Show";
    }
}
