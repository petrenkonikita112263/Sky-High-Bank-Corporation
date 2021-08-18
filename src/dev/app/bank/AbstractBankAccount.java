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
     * Strategy variable owner.
     */
    protected OwnerStrategy owner = new Domestic();

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
    public boolean hasEnoughMoney(int amountLoan) {
        double ratio = collateralRatio();
        return balance >= amountLoan * ratio;
    }

    /**
     * Helper method for hasEnoughMoney.
     *
     * @return value of ratio depending on account type
     */
    protected abstract double collateralRatio();

    /**
     * Increase account's balance.
     */
    public void addInterest() {
        balance += (int) (balance * interestRate());
    }

    /**
     * Helper method for addInterest method.
     *
     * @return value of rate depending on account type
     */
    protected abstract double interestRate();

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
        owner = foreign ? new Foreign() : new Domestic();
    }

    public int makeFee() {
        return owner.fee();
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
