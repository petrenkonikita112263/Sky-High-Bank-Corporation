package dev.app.bank;

public class RegularChecking extends CheckingAccount {

    public RegularChecking(int accountNumber) {
        super(accountNumber);
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
    protected double interestRate() {
        return 0.0;
    }
    
    @Override
    public String toString() {
        return "Regular checking account " + accountNumber
                + ": balance=" + balance + ", is "
                + (owner.isForeign() ? "foreign" : "domestic");
    }
}
