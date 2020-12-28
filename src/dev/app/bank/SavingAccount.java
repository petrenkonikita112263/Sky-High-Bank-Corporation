package dev.app.bank;

import static dev.app.bank.BankConfiguration.BANK_RATE;

/**
 * Saving account, which balance can be increased by add interest method.
 * Has account number, balance and type of account - foreign or domestic.
 *
 * @author Nikita Petrenko
 */
public class SavingAccount extends AbstractBankAccount {

    /**
     * EVC.
     *
     * @param accountNumber owner account number
     */
    public SavingAccount(int accountNumber) {
        super(accountNumber);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addInterest() {
        balance += (int) (balance * (1 + BANK_RATE));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasEnoughMoney(int amountLoan) {
        return balance >= amountLoan / 2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Saving account "
                + accountNumber + ": balance = " + balance
                + (isForeign ? ", and it's foreign account"
                : ", and it's domestic account");
    }
}
