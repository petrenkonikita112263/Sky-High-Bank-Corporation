package dev.app.bank.accounts;

public class RegularChecking implements AccountTypeStrategy {

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
        return 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String accountType() {
        return "Regular checking account";
    }
}
