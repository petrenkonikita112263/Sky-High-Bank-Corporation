package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.util.Scanner;

public class ForeignStatusCommand implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.print("Enter 1 for foreign, 2 for domestic: ");
        int valBoolean = scanner.nextInt();
        boolean isForeign = (valBoolean == 1);
        bank.setForeign(current, isForeign);
        return current;
    }

    @Override
    public String toString() {
        return "Set foreign status";
    }
}
