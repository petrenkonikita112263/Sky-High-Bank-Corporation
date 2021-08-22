package dev.app.bank;

public enum Owner implements OwnerStrategy{
    DOMESTIC(false, 0, "domestic"),
    FOREIGN(true, 5, "foreign");

    private boolean isForeign;
    private int feeAmount;
    private String ownerName;

    Owner(boolean isForeign, int feeAmount, String ownerName) {
        this.isForeign = isForeign;
        this.feeAmount = feeAmount;
        this.ownerName = ownerName;
    }

    @Override
    public boolean isForeign() {
        return isForeign;
    }

    @Override
    public int fee() {
        return feeAmount;
    }

    @Override
    public String toString() {
        return ownerName;
    }
}
