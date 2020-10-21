package dev.app.bank;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

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
        ConcurrentHashMap<Integer, BankAccount> bankAccountCollection = new ConcurrentHashMap<>();
        AtomicInteger number = new AtomicInteger();
        Bank bank = new Bank(bankAccountCollection, number);
        try (Scanner scanner = new Scanner(System.in)) {
            BankClient client = new BankClient(scanner, bank);
            client.run();
        }
    }

}
