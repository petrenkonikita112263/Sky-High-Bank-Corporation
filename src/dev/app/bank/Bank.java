package dev.app.bank;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Bank class that stores and edits all information
 * related to it.
 *
 * @author Nikita Petrenko
 */
public class Bank {

    /**
     * Int value represents which type is account - saving or checking.
     */
    private int type;

    /**
     * Variable that creates thread safe HashMap collection that represents
     * the number in the queue of account number as key and
     * additional info about it as value.
     */
    private ConcurrentHashMap<Integer, BankAccount> accounts;

    /**
     * Variable that is thread safe and holds next account number.
     */
    private AtomicInteger nextAccountNumber;

    /**
     * EVC.
     */
    public Bank(ConcurrentHashMap<Integer, BankAccount> accounts, AtomicInteger nextAccountNumber) {
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
     * @param type      1 - saving account, otherwise checking
     * @param isForeign domestic - false|foreign - true account
     * @return new number of account
     */
    public int newAccount(int type, boolean isForeign) {
        int accountNumber = nextAccountNumber.incrementAndGet();
        BankAccount bankAccount = switch (type) {
            case 1 -> new SavingAccount(accountNumber);
            case 2 -> new CheckingAccount(accountNumber);
            default -> new InterestChecking(accountNumber);
        };
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
        Set<Integer> accts = accounts.newKeySet();
        StringBuilder result = new StringBuilder("The bank has " + accts.size()
                + " accounts.");
        for (BankAccount bankAccount : accounts.values())
            result.append("\n\t ").append(bankAccount.toString());
        return String.valueOf(result);
    }

}
