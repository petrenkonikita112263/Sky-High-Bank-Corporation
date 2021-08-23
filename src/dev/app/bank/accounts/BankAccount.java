package dev.app.bank.accounts;

/**
 * Interface class, which object can be transformed into SavingAccount
 * or CheckingAccount classes, stores major functionality.
 *
 * @author Nikita Petrenko
 */
public interface BankAccount extends Comparable<BankAccount> {

    /**
     * Selects existed account number.
     *
     * @return typed account number
     */
    int getAccountNumber();

    /**
     * Selects balance of existed account.
     *
     * @return balance in int type value
     */
    int getBalance();

    /**
     * One of convenience methods. Creates a savings account having a specified
     * initial balance.
     *
     * @param acctnum owner account number
     * @param cash    amount of money to deposit
     * @return created bank account object
     */
    static BankAccount createSavingsWithDeposit(int acctnum, int cash) {
        AccountTypeStrategy accountTypeStrategy = new SavingAccount();
        BankAccount bankAccount = new AbstractBankAccount(acctnum, accountTypeStrategy);
        bankAccount.deposit(cash);
        return bankAccount;
    }

    /**
     * Last convenience methods.
     *
     * @return true if the account’s balance is zero, and false otherwise
     */
    default boolean isEmpty() {
        return getBalance() == 0;
    }

    /**
     * Checks type of account (inside or outside country).
     *
     * @return true - foreign, otherwise - domestic
     */
    boolean isForeign();

    /**
     * Sets foreign or domestic type for account.
     *
     * @param foreign true - foreign, otherwise - domestic
     */
    void setForeign(boolean foreign);

    /**
     * Increase account's balance.
     */
    void addInterest();

    /**
     * Performs deposit operation for chosen account.
     *
     * @param amount money values in int type
     */
    void deposit(int amount);

    /**
     * Checks is there enough money to perform loan.
     *
     * @param amountLoan amount of money to loan
     * @return true - operation can be run, otherwise - it could be
     */
    boolean hasEnoughMoney(int amountLoan);

    /**
     * Retuns the fee.
     *
     * @return fee value
     */
    int makeFee();

    /**
     * {@inheritDoc}
     */
    @Override
    int compareTo(BankAccount o);

}
