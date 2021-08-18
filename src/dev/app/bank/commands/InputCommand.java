package dev.app.bank.commands;

import dev.app.bank.Bank;

import java.util.Scanner;

public interface InputCommand {
    int execute(Scanner scanner, Bank bank, int current);
}
