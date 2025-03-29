package org.example;

public class TransactionReport {
    private double finalBalance;
    private Transaction highestTransaction;
    private int creditCount;
    private int debitCount;

    public TransactionReport(double finalBalance, Transaction highestTransaction,
                             int creditCount, int debitCount) {
        this.finalBalance = finalBalance;
        this.highestTransaction = highestTransaction;
        this.creditCount = creditCount;
        this.debitCount = debitCount;
    }

    // Getters
    public double getFinalBalance() {
        return finalBalance;
    }

    public Transaction getHighestTransaction() {
        return highestTransaction;
    }

    public int getCreditCount() {
        return creditCount;
    }

    public int getDebitCount() {
        return debitCount;
    }
}
