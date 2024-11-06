import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Transaction {
    private double amount;
    private String lastTransaction;
    private int nonce;

    public Transaction(double amount, String lastTransaction) {
        this.amount = amount;
        this.lastTransaction = lastTransaction;
        this.nonce = 0;
    }

    public String getLastTransaction() {
        return lastTransaction;
    }

    public void increaseNonce() {
        this.nonce++;
    }

    public void setLastTransaction(String lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

    @Override
    public String toString() {
        return this.amount + this.lastTransaction + this.nonce;
    }
}

public class App {
    public static Random random = new Random();
    public static List<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        byte[] randomBytes = new byte[16];
        App.random.nextBytes(randomBytes);
        String randomHash = Hex.encodeHexString(randomBytes);

        for(int i = 0; i < 4; i++) {
            double roundedDouble = Math.round((0 + 100 * App.random.nextDouble()) * 100) / 100.0;

            Transaction transaction;
            if(i > 0) transaction = new Transaction(roundedDouble, App.transactions.get(i - 1).getLastTransaction());
            else transaction = new Transaction(roundedDouble, randomHash);

            while (true) {
                String hashedObjString = DigestUtils.md5Hex(transaction.toString());
                if (hashedObjString.endsWith("00000")) {
                    transaction.setLastTransaction(hashedObjString);
                    App.transactions.add(transaction);
                    break;
                }
                transaction.increaseNonce();
            }
        }
        for(Transaction t : App.transactions) {
            System.out.println(t);
        }
    }
}
