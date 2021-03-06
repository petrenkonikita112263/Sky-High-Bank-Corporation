package dev.app.bank;

import java.util.HashMap;
import java.util.Set;

/**
 * Bank class that stores and edits all information
 * related to it.
 * @author Nikita Petrenko
 */
public class Bank {

    /**
     * Variable that creates HashMap collection that represents
     * the account number as key and balance as value.
     */
    private HashMap<Integer, Integer> accounts
            = new HashMap<>();
    /**
     * Constant represent bank's interest.
     */
    private final double BANK_RATE = 0.01;
    /**
     * Variable that hold next account number.
     */
    private int nextAccountNumber;

    /**
     * Method assign account number to the map with default balance 0.
     *
     * @return new number of account
     */
    public int newAccount() {
        int accountNumber = nextAccountNumber++;
        accounts.put(accountNumber, 0);
        return accountNumber;
    }

    /**
     * Method that choose the specific account.
     *
     * @param accountNumber number of account number
     * @return chosen account
     */
    public int getBalance(int accountNumber) {
        return accounts.get(accountNumber);
    }

    /**
     * Method increases the account's balance.
     *
     * @param accountNumber number of account number
     * @param amount        amount of deposit
     */
    public void deposit(int accountNumber, int amount) {
        int balance = accounts.get(accountNumber);
        accounts.put(accountNumber, balance + amount);
    }

    /**
     * Method checks if the balance allows to make the loan.
     * Account must have the half of the loan amount.
     *
     * @param accountNumber number of account number
     * @param amountLoan    amount of loan
     * @return true - if account have balance more than half of the loan,
     * orthewise - false
     */
    public boolean authorizeLoan(int accountNumber, int amountLoan) {
        int balance = accounts.get(accountNumber);
        return balance >= amountLoan / 2;
    }

    /**Method increases each existed balances based on bank's percent.*/
    public void addInterest() {
        Set<Integer> accts = accounts.keySet();
        for (int i : accts) {
            int balance = accounts.get(i);
            int newBalance = (int) (balance * (1 + BANK_RATE));
            accounts.put(i, newBalance);
        }
    }

    /**{@inheritDoc}*/
    @Override
    public String toString() {
        Set<Integer> accts = accounts.keySet();
        StringBuilder result = new StringBuilder("The bank has " + accts.size()
                + " accounts.");
        for (int i : accts)
            result.append("\n\tBank account ").append(i).append(": balance=").append(accounts.get(i));
        return result.toString();
    }

}
