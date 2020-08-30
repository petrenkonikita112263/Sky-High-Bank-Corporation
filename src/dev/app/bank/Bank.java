package dev.app.bank;

import java.util.HashMap;
import java.util.Set;

/**
 * Bank class that stores and edits all information
 * related to it.
 *
 * @author Nikita Petrenko
 */
public class Bank {

    /**
     * Variable that creates HashMap collection that represents
     * the number in the queue of account number as key and
     * additional info about it as value.
     */
    private HashMap<Integer, BankAccount> accounts
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
     * Method that modify type of account domestic<->foreign.
     *
     * @param accountNumber number of account number
     * @param isForeign     domestic - false|foreign - true account
     */
    public void setForeign(int accountNumber, boolean isForeign) {
        BankAccount bankAccount = accounts.get(accountNumber);
        bankAccount.setForeign(isForeign);
    }

    /**
     * Method assign account number to the map with default balance 0.
     *
     * @param isForeign domestic - false|foreign - true account
     * @return new number of account
     */
    public int newAccount(boolean isForeign) {
        int accountNumber = nextAccountNumber++;
        BankAccount bankAccount = new BankAccount(accountNumber);
        bankAccount.setForeign(isForeign);
        accounts.put(accountNumber, bankAccount);
        return accountNumber;
    }

    /**
     * Method that choose the specific account.
     *
     * @param accountNumber number of account number
     * @return chosen account
     */
    public int getBalance(int accountNumber) {
        BankAccount bankAccount = accounts.get(accountNumber);
        return bankAccount.getBalance();
    }

    /**
     * Method increases the account's balance.
     *
     * @param accountNumber number of account number
     * @param amount        amount of deposit
     */
    public void deposit(int accountNumber, int amount) {
        BankAccount bankAccount = accounts.get(accountNumber);
        int balance = bankAccount.getBalance();
        bankAccount.setBalance(balance + amount);
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
        BankAccount bankAccount = accounts.get(accountNumber);
        int balance = bankAccount.getBalance();
        return balance >= amountLoan / 2;
    }

    /**
     * Method increases each existed balances based on bank's percent.
     */
    public void addInterest() {
        for (BankAccount bankAccount : accounts.values()) {
            int balance = bankAccount.getBalance();
            int newBalance = (int) (balance * (1 + BANK_RATE));
            bankAccount.setBalance(newBalance);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        Set<Integer> accts = accounts.keySet();
        StringBuilder result = new StringBuilder("The bank has " + accts.size()
                + " accounts.");
        for (BankAccount bankAccount : accounts.values())
            result.append("\n\tBank account ")
                    .append(bankAccount.getAccountNumber())
                    .append(": balance = ").append(bankAccount.getBalance())
                    .append(bankAccount.isForeign() ? ", and it's foreign account"
                            : ", and it's domestic account");
        return result.toString();
    }

}
