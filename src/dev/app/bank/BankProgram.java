package dev.app.bank;

/**
 * Class that keeps the components into one.
 *
 * @author Nikita Petrenko
 */
public class BankProgram {

    /**
     * Static method that create instance of BankClient and run it.
     *
     * @param args array of string's arguments
     */
    public static void main(String[] args) {
        BankClient client = new BankClient();
        client.run();
    }

}
