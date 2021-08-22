package dev.app.bank;

import dev.app.bank.commands.*;

import java.util.Scanner;

/**
 * Class that responsible for I/O operations based on user's input
 * and sends it into the bank.
 *
 * @author Nikita Petrenko
 */
public class BankClient {

    /**
     * Variable that hold int number (account number)
     */
    private int current;

    /**
     * Variable that creates instance of Scanner.
     */
    private Scanner scanner;

    /**
     * Variable responsible for program status.
     */
    private boolean done;

    /**
     * Variable that holds link to the bank object.
     */
    private Bank bank;

    /**
     * Array of console commands that bank clients can perform
     */
    private InputCommand[] consoleCommands = CommandsList.values();

    /**
     * EVC.
     */
    public BankClient(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    /**
     * Print the menu into the console and wait for user's input.
     */
    public void run() {
        String userMessage = displayMessage();
        while (!done) {
            System.out.println(userMessage);
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
        scanner.close();
    }

    /**
     * Additional message to display options for user input into console from
     * array field.
     */
    private String displayMessage() {
        int lastElement = consoleCommands.length - 1;
        StringBuilder finalMessage = new StringBuilder("Enter Account Type (");
        for (int i = 0; i < consoleCommands.length - 1; i++) {
            finalMessage.append(i)
                    .append("=")
                    .append(consoleCommands[i])
                    .append(", ");
        }
        finalMessage.append(lastElement)
                .append("=").append(consoleCommands[lastElement])
                .append("): ");
        return finalMessage.toString();
    }

    /**
     * Additional method perform specific operation bases on user's command.
     *
     * @param cmd number of command
     */
    private void processCommand(int cmd) {
        InputCommand inputCommands = consoleCommands[cmd];
        current = inputCommands.execute(scanner, bank, current);
        if (current < 0) {
            done = true;
        }
    }

}
