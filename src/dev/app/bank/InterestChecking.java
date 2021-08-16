package dev.app.bank;

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
        int newBalance = (int) (getBalance() * interestRate());
        deposit(newBalance);
    }

    /**{@inheritDoc}*/
    @Override
    protected double interestRate() {
        return 0.02;
    }

    @Override
    public String toString() {
        return "Interest checking account " + accountNumber
                + ": balance=" + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }
}
