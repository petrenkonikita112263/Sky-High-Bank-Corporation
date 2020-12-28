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
    public String toString() {
        return "Regular checking account " + accountNumber
                + ": balance=" + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }
}
