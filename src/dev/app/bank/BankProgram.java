package dev.app.bank;

import java.nio.file.Path;
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
        Path pathToFile = Path.of("resources", "result.txt");
        SavedBankInfo infoData = new SavedBankInfo(pathToFile);
        ConcurrentHashMap<Integer, BankAccount> bankAccountCollection = new ConcurrentHashMap<>();
        int intNumber = infoData.getNextAccount();
        AtomicInteger number = new AtomicInteger();
        number.set(intNumber);
        Bank bank = new Bank(bankAccountCollection, number);
        try (Scanner scanner = new Scanner(System.in)) {
            BankClient client = new BankClient(scanner, bank);
            client.run();
            infoData.saveMap(bankAccountCollection, bank.getNextAccountNumber().get());
        }
    }

}
