package dev.app.bank;

/**
 * Saving account, which balance can be increased by add interest method.
 * Has account number, balance and type of account - foreign or domestic.
 *
 * @author Nikita Petrenko
 */
public class SavingAccount implements BankAccount {

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
    public SavingAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addInterest() {
        balance += (int) (balance * (1 + BANK_RATE));
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
    public void deposit(int amount) {
        balance += amount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasEnoughMoney(int amountLoan) {
        return balance >= amountLoan / 2;
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
        return "Saving account "
                + accountNumber + ": balance = " + balance
                + (isForeign ? ", and it's foreign account"
                : ", and it's domestic account");
    }
}
