package dev.app.bank.accounts;

/**
 * A subclass of CheckingAccount class and perform deposit
 * with new balance that was increased by bank's rate.
 *
 * @author Nikita Petrenko
 */
public class InterestChecking implements AccountTypeStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public double collateralRatio() {
        return 2.0 / 3.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double interestRate() {
        return 0.02;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String accountType() {
        return "Interest checking account";
    }
}
