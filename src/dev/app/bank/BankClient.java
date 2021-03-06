package dev.app.bank;

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
    private Scanner scanner = new Scanner(System.in);

    /**
     * Variable responsible for program status.
     */
    private boolean done = false;

    /**
     * Variable that holds link to the bank object.
     */
    private Bank bank = new Bank();

    /**
     * Print the menu into the console and wait for user's input.
     */
    public void run() {
        scanner = new Scanner(System.in);
        while (!done) {
            System.out.println("Enter command:\n\t0 - quit\n\t1 - new"
                    + "\n\t2 - select\n\t3 - deposit\n\t4 - loan"
                    + "\n\t5 - show\n\t6 - interest");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
        scanner.close();
    }

    /**
     * Additional method perform specific operation bases on user's command.
     *
     * @param cmd number of command
     */
    private void processCommand(int cmd) {
        switch (cmd) {
            case 0 -> quit();
            case 1 -> newAccount();
            case 2 -> select();
            case 3 -> deposit();
            case 4 -> authorizeLoan();
            case 5 -> showAll();
            case 6 -> addInterest();
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
        current = bank.newAccount();
        System.out.println("Your new account number is "
                + current);
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
