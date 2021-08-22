package dev.app.bank;

public enum Domestic implements OwnerStrategy {

    STATE;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isForeign() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int fee() {
        return 1;           // $1
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "domestic";
    }
}
