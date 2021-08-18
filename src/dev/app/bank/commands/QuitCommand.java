package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.util.Scanner;

public class QuitCommand implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.println("Thanks for using us! Have a nice day!");
        return -1;
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
