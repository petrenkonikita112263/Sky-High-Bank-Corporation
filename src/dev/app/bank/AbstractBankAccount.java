package dev.app.bank;

public abstract class AbstractBankAccount implements BankAccount {

    /**
     * Variable that hold owner account number.
     */
    protected int accountNumber;

    /**
     * Balance of owner's account.
     */
    protected int balance;

    /**
     * Boolean value - true if foreign, otherwise it's domestic account.
     */
    protected boolean isForeign;

    /**
     * EVC
     *
     * @param accountNumber owner account number
     */
    protected AbstractBankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Checks is there enough money to perform loan.
     *
     * @param amountLoan amount of money to loan
     * @return true - operation can be run, otherwise - it could be
     */
    public abstract boolean hasEnoughMoney(int amountLoan);

//    /**
//     * Prints all info about selected bank account.
//     *
//     * @return account number, it's type and balance
//     */
//    public abstract String displayInfo();

    /**
     * Increase account's balance.
     */
    public abstract void addInterest();

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
    public int compareTo(BankAccount o) {
        int balance1 = getBalance();
        int balance2 = o.getBalance();
        return balance1 == balance2
                ? getAccountNumber() - o.getAccountNumber()
                : balance1 - balance2;
    }
}
