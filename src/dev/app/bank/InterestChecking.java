package dev.app.bank;

import static dev.app.bank.BankConfiguration.BANK_RATE;

/**
 * A subclass of CheckingAccount class and perform deposit
 * with new balance that was increased by bank's rate.
 *
 * @author Nikita Petrenko
 */
public class InterestChecking extends CheckingAccount {

    /**
     * EVC
     *
     * @param accountNumber owner account number
     */
    public InterestChecking(int accountNumber) {
        super(accountNumber);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addInterest() {
        int newBalance = (int) (getBalance() * BANK_RATE);
        deposit(newBalance);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Interest checking account " + accountNumber
                + ": balance=" + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }
}
