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
    private HashMap<Integer, BankAccount> accounts;
    /**
     * Variable that hold next account number.
     */
    private int nextAccountNumber;

    /**EVC.*/
    public Bank(HashMap<Integer, BankAccount> accounts, int nextAccountNumber) {
        this.accounts = accounts;
        this.nextAccountNumber = nextAccountNumber;
    }

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
        bankAccount.deposit(amount);
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
        return bankAccount.hasEnoughMoney(amountLoan);
    }

    /**
     * Method increases each existed balances based on bank's percent.
     */
    public void addInterest() {
        for (BankAccount bankAccount : accounts.values()) {
            bankAccount.addInterest();
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
            result.append("\n\t ").append(bankAccount.toString());
        return String.valueOf(result);
    }

}
