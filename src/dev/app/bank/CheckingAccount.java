package dev.app.bank;

import static dev.app.bank.BankConfiguration.BANK_RATE;

/**
 * Checking account, rely on the indicated name, can only check balance,
 * perform bigger loan operation, change type and print info data.
 *
 * @author Nikita Petrenko
 */
public abstract class CheckingAccount extends AbstractBankAccount {

    /**
     * EVC.
     *
     * @param accountNumber owner account number
     */
    protected CheckingAccount(int accountNumber) {
        super(accountNumber);
    }

    public abstract void addInterest();

    protected abstract double interestRate();

    /**
     * {@inheritDoc}
     */
    @Override
    protected double collateralRatio() {
        return 2.0 / 3.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasEnoughMoney(int amountLoan) {
        return balance >= 2 * amountLoan / 3;
    }
}
