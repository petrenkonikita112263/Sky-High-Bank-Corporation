package dev.app.bank;

/**
 * Saving account, which balance can be increased by add interest method.
 * Has account number, balance and type of account - foreign or domestic.
 *
 * @author Nikita Petrenko
 */
public class SavingAccount implements AccountTypeStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public double collateralRatio() {
        return 1.0 / 2.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double interestRate() {
        return 0.01;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String accountType() {
        return "Saving account";
    }
}
