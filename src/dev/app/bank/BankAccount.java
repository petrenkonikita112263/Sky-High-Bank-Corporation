package dev.app.bank;

/**
 * Class that responsible for info about owner.
 * His account numbers, balance and type of account - foreign or domestic.
 */
public class BankAccount {

    /**
     * Constant represent bank's interest.
     */
    private final double BANK_RATE = 0.01;
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

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean hasEnoughMoney(int amountLoan) {
        return balance >= amountLoan / 2;
    }

    public void addInterest() {
        balance += (int) (balance * (1 + BANK_RATE));
    }

    @Override
    public String toString() {
        return "Bank account "
                + accountNumber + ": balance = " + balance
                + (isForeign ? ", and it's foreign account"
                : ", and it's domestic account");
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
