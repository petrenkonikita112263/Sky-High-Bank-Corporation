package dev.app.bank.accounts;

/**
 * Strategy interface class that declares some methods.
 *
 * @author Nikita Petrenko
 */
public interface AccountTypeStrategy {

    /**
     * Helper method for hasEnoughMoney.
     *
     * @return value of ratio depending on account type
     */
    double collateralRatio();

    /**
     * Helper method for addInterest method.
     *
     * @return value of rate depending on account type
     */
    double interestRate();

    /**
     * Helper method for printing the type of account.
     * (saving, interest or checking)
     *
     * @return type of bank account
     */
    String accountType();
}
