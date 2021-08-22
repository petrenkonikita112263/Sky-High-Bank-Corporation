package dev.app.bank;

public enum Owner implements OwnerStrategy{
    ;

    @Override
    public boolean isForeign() {
        return false;
    }

    @Override
    public int fee() {
        return 0;
    }
}
