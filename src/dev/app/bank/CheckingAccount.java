package dev.app.bank;

/**
 * Checking account, rely on the indicated name, can only check balance,
 * perform bigger loan operation, change type and print info data.
 *
 * @author Nikita Petrenko
 */
public class CheckingAccount implements BankAccount {

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
    public CheckingAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBalance() {
        return balance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isForeign() {
        return isForeign;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addInterest() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasEnoughMoney(int amountLoan) {
        return balance >= 2 * amountLoan / 3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(BankAccount o) {
        int balance1 = getBalance();
        int balance2 = o.getBalance();
        return balance1 == balance2
                ? getAccountNumber() - o.getAccountNumber()
                : balance1 - balance2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Checking account "
                + accountNumber + ": balance = " + balance
                + (isForeign ? ", and it's foreign account"
                : ", and it's domestic account");
    }
}
