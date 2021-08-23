package dev.app.bank.utils;

import dev.app.bank.accounts.*;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class SavedBankInfo {

    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Path filename;
    private ConcurrentHashMap<Integer, BankAccount> accounts
            = new ConcurrentHashMap<>();
    private int nextAccount;
    private ByteBuffer bb = ByteBuffer.allocate(16);

    public SavedBankInfo(Path filename) {
        this.filename = filename;
        if (!new File(String.valueOf(filename)).exists())
            return;
        try (InputStream is = new FileInputStream(String.valueOf(filename))) {
            readMap(is);
        }
        catch (IOException ex) {
            LOG.severe("File read exception" + ex);
        }
    }

    public ConcurrentHashMap<Integer, BankAccount> getAccounts() {
        return accounts;
    }

    public int getNextAccount() {
        return nextAccount;
    }

    public void saveMap(ConcurrentHashMap<Integer,BankAccount> map,
                        int nextaccount) {
        try (OutputStream os = new FileOutputStream(String.valueOf(filename))) {
            writeMap(os, map, nextaccount);
        }
        catch (IOException ex) {
            LOG.severe("File write exception" + ex);
        }
    }

    private void writeMap(OutputStream os,
                          ConcurrentHashMap<Integer,BankAccount> map,
                          int nextacct) throws IOException {
        writeInt(os, nextacct);
        for (BankAccount ba : map.values())
            writeAccount(os, ba);
    }

    private void readMap(InputStream is) throws IOException {
        nextAccount = readInt(is);
        BankAccount ba = readAccount(is);
        while (ba != null) {
            accounts.put(ba.getAccountNumber(), ba);
            ba = readAccount(is);
        }
    }

    private void writeInt(OutputStream os, int n)
            throws IOException {
        bb.putInt(0, n);
        os.write(bb.array(), 0, 4);
    }

    private int readInt(InputStream is) throws IOException {
        is.read(bb.array(), 0, 4);
        return bb.getInt(0);
    }

    private void writeAccount(OutputStream os, BankAccount ba)
            throws IOException {
        int type = (ba instanceof SavingAccount) ? 1
                : (ba instanceof RegularChecking) ? 2 : 3;
        bb.putInt(0, ba.getAccountNumber());
        bb.putInt(4, type);
        bb.putInt(8, ba.getBalance());
        bb.putInt(12, ba.isForeign() ? 1 : 2);
        os.write(bb.array());
    }

    private BankAccount readAccount(InputStream is)
            throws IOException {
        int n = is.read(bb.array());
        if (n < 0)
            return null;
        int num = bb.getInt(0);
        int type = bb.getInt(4);
        int balance = bb.getInt(8);
        int isforeign = bb.getInt(12);
        AccountTypeStrategy accountTypeStrategy = switch (type) {
            case 1 -> new SavingAccount();
            case 2 -> new RegularChecking();
            default -> new InterestChecking();
        };
        BankAccount ba = new AbstractBankAccount(num, accountTypeStrategy);
        ba.deposit(balance);
        ba.setForeign(isforeign == 1);
        return ba;
    }
}
