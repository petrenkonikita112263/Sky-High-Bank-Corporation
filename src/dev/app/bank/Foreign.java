package dev.app.bank;

public class Foreign implements OwnerStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isForeign() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int fee() {
        return 5;           // $5
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "foreign";
    }
}
