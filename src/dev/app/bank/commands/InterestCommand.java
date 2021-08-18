package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.util.Scanner;

public class InterestCommand implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        bank.addInterest();
        return current;
    }

    @Override
    public String toString() {
        return "Interest";
    }
}
