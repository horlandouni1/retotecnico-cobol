package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionProcessor {
    public List<Transaction> readTransactions(String filePath) throws IOException {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Saltar la línea de encabezado
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0].trim());
                String type = values[1].trim();
                double amount = Double.parseDouble(values[2].trim());

                transactions.add(new Transaction(id, type, amount));
            }
        }

        return transactions;
    }

    public TransactionReport generateReport(List<Transaction> transactions) {
        double totalCredit = 0;
        double totalDebit = 0;
        int creditCount = 0;
        int debitCount = 0;
        Transaction highestTransaction = null;

        for (Transaction transaction : transactions) {
            if ("Crédito".equalsIgnoreCase(transaction.getType())) {
                totalCredit += transaction.getAmount();
                creditCount++;
            } else if ("Débito".equalsIgnoreCase(transaction.getType())) {
                totalDebit += transaction.getAmount();
                debitCount++;
            }

            if (highestTransaction == null ||
                    transaction.getAmount() > highestTransaction.getAmount()) {
                highestTransaction = transaction;
            }
        }

        double finalBalance = totalCredit - totalDebit;

        return new TransactionReport(finalBalance, highestTransaction, creditCount, debitCount);
    }
}
