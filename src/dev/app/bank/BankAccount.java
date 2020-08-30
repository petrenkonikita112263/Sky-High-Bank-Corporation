package dev.app.bank;

/**
 * Class that responsible for info about owner.
 * His account numbers, balance and type of account - foreign or domestic.
 */
public class BankAccount {

    /**
     * Variable that hold owner account number.
     */
    private int accountNumber;
    /**
     * Balance of owner's account.
     */
    private int balance;
    /**
     * Boolean value - true if foreign, otherwise it's domestic account.
     */
    private boolean isForeign;

    /**
     * EVC.
     *
     * @param accountNumber owner account number
     */
    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }
}
