package dev.app.bank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class that keeps the components into one.
 *
 * @author Nikita Petrenko
 */
public class BankProgram {

    /**
     * Static method that create instance of BankClient and run it.
     *
     * @param args array of string's arguments
     */
    public static void main(String[] args) {
        HashMap<Integer, BankAccount> bankAccountCollection = new HashMap<>();
        Bank bank = new Bank(bankAccountCollection, 0);
        try (Scanner scanner = new Scanner(System.in)) {
            BankClient client = new BankClient(scanner, bank);
            client.run();
        }
    }

}
