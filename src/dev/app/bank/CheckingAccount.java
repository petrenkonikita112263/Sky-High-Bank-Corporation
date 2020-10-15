package dev.app.bank;

import static dev.app.bank.BankConfiguration.BANK_RATE;

/**
 * Checking account, rely on the indicated name, can only check balance,
 * perform bigger loan operation, change type and print info data.
 *
 * @author Nikita Petrenko
 */
public class CheckingAccount extends AbstractBankAccount {

    /**
     * EVC.
     *
     * @param accountNumber owner account number
     */
    public CheckingAccount(int accountNumber) {
        super(accountNumber);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addInterest() {
        balance += (int) (balance * BANK_RATE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasEnoughMoney(int amountLoan) {
        return balance >= 2 * amountLoan / 3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String displayInfo() {
        return "Checking account "
                + accountNumber + ": balance = " + balance
                + (isForeign ? ", and it's foreign account"
                : ", and it's domestic account");
    }
}
