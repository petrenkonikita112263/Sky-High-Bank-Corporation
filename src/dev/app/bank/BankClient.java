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
    private InputCommand[] consoleCommands = {
            new QuitCommand(),
            new CreateCommand(),
            new SelectCommand(),
            new DepositCommand(),
            new LoanCommand(),
            new ShowCommand(),
            new InterestCommand(),
            new ForeignStatusCommand()
    };

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
        for (int i = 0; i < consoleCommands.length-1; i++) {
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
        switch (cmd) {
            case 0 -> quit();
            case 1 -> newAccount();
            case 2 -> select();
            case 3 -> deposit();
            case 4 -> authorizeLoan();
            case 5 -> showAll();
            case 6 -> addInterest();
            case 7 -> setForeign();
            default -> System.out.println("Wrong input! Try again. Please type only the integer number");
        }
    }

    /**
     * Additional method that sets the global variable to true, to
     * perform terminate operation on this app.
     */
    private void quit() {
        done = true;
        System.out.println("Thanks for using us! Have a nice day!");
    }

    /**
     * Additional method creates new account number in the bank,
     * sets it as current and prints it.
     */
    private void newAccount() {
        System.out.println("Enter account type(1=savings,"
                + " 2=checking, 3=interest checking): ");
        int type = scanner.nextInt();
        boolean isForeign = requestForAnswer();
        current = bank.newAccount(type, isForeign);
        System.out.println("Your new account number is "
                + current);
    }

    /**
     * Additional method that modify type of account.
     */
    private void setForeign() {
        bank.setForeign(current, requestForAnswer());
    }

    /**
     * Additional method that take the number from user input and
     * returns boolean.
     *
     * @return true if 0 - foreign, otherwise false - domestic
     */
    private boolean requestForAnswer() {
        System.out.println("Type 0 for foreign account, 1 - domestic account");
        int answerNumber = scanner.nextInt();
        return (answerNumber == 0);
    }

    /**
     * Additional method selects existed account and sets it as current.
     * Prints the balance.
     */
    private void select() {
        System.out.print("Enter the bank account number: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account "
                + current + " is " + balance);
    }

    /**
     * Additional method increases the balance in the account.
     */
    private void deposit() {
        System.out.print("Enter deposit amt: ");
        int amount = scanner.nextInt();
        bank.deposit(current, amount);
    }

    /**
     * Additional method checks whether the account has enough money
     * in the balance, if it's so performs loan operation.
     */
    private void authorizeLoan() {
        System.out.print("Enter loan amount: ");
        int amountLoan = scanner.nextInt();
        if (bank.authorizeLoan(current, amountLoan))
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
    }

    /**
     * Additional method displays all existed accounts and its balance.
     */
    private void showAll() {
        System.out.println(bank.toString());
    }

    /**
     * Additional method increases the balance of all accounts.
     */
    private void addInterest() {
        bank.addInterest();
    }

}
