package dev.app.bank.types;

public interface OwnerStrategy {

    boolean isForeign();

    int fee();

}
