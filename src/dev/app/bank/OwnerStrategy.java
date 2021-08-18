package dev.app.bank;

public interface OwnerStrategy {

    boolean isForeign();

    int fee();

}
