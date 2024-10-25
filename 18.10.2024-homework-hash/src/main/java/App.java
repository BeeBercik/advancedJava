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

    public double getAmount() {
        return amount;
    }

    public String getLastTransaction() {
        return lastTransaction;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public void increaseNounce() {
        this.nonce++;
    }

    public void setLastTransaction(String lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

    public String generateObjString() {
        return this.amount + this.lastTransaction + this.nonce;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", lastTransaction='" + lastTransaction + '\'' +
                ", nonce=" + nonce +
                '}';
    }
}

public class App {
    public static Random random = new Random();
    public static List<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        byte[] randomBytes = new byte[16];
        App.random.nextBytes(randomBytes);
        String randomHash = Hex.encodeHexString(randomBytes);
        System.out.println("Initial random hash: " + randomHash);

        for(int i = 0; i < 4; i++) {
            double randomDouble = 0 + 100 * App.random.nextDouble();
            double roundedDouble = Math.round(randomDouble * 100) / 100.0;

            Transaction transaction;
            if(i > 0) {
                String previousHash = App.transactions.get(i - 1).getLastTransaction();
                transaction = new Transaction(roundedDouble, previousHash);
            } else {
                transaction = new Transaction(roundedDouble, randomHash);
            }

            while (true) {
                String hashedObjString = DigestUtils.md5Hex(transaction.generateObjString());
                if (hashedObjString.endsWith("00000")) {
                    transaction.setLastTransaction(hashedObjString);
                    App.transactions.add(transaction);
                    break;
                }
                transaction.increaseNounce();
            }
        }
        for(Transaction t : App.transactions) {
            System.out.println(t);
        }
    }
}
