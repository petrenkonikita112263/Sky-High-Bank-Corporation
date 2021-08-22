package dev.app.bank;

public class AbstractBankAccount implements BankAccount {

    /**
     * Variable that hold owner account number.
     */
    private int accountNumber;

    /**
     * Balance of owner's account.
     */
    private int balance;

    /**
     * Strategy variable owner.
     */
    private OwnerStrategy owner = Domestic.STATE;

    /**
     * Account type field.
     */
    private AccountTypeStrategy accountTypeStrategy;

    /**
     * EVC
     *
     * @param accountNumber owner account number
     */
    protected AbstractBankAccount(int accountNumber,
                                  AccountTypeStrategy accountTypeStrategy) {
        this.accountNumber = accountNumber;
        this.accountTypeStrategy = accountTypeStrategy;
    }

    /**
     * Checks is there enough money to perform loan.
     *
     * @param amountLoan amount of money to loan
     * @return true - operation can be run, otherwise - it could be
     */
    public boolean hasEnoughMoney(int amountLoan) {
        double ratio = collateralRatio();
        return balance >= amountLoan * ratio;
    }

    /**
     * Helper method that return the collateralRatio value
     * for specific account type.
     *
     * @return collateral ratio
     */
    private double collateralRatio() {
        return accountTypeStrategy.collateralRatio();
    }

    /**
     * Method that returns the name of account.
     *
     * @return name of account
     */
    public String getAccountType() {
        return accountTypeStrategy.accountType();
    }

    /**
     * {@inheritDoc}
     */
    public int makeFee() {
        return owner.fee();
    }

    /**
     * Increase account's balance.
     */
    public void addInterest() {
        balance += (int) (balance * interestRate());
    }

    /**
     * Helper method that return the interestRate value
     * for specific account type.
     *
     * @return interest rate
     */
    private double interestRate() {
        return accountTypeStrategy.interestRate();
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
        return owner.isForeign();
    }

    public void setOwner(OwnerStrategy owner) {
        this.owner = owner;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setForeign(boolean foreign) {
        owner = foreign ? Foreign.STATE : Domestic.STATE;
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

    @Override
    public String toString() {
        String accountType = getAccountType();
        return accountType + " account " + accountNumber + ": balance=" + balance
                + ", is " + owner.toString()
                + ", fee=" + makeFee();
    }
}
