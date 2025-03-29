package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionProcessorTest {
    @Test
    public void testReadTransactions() throws Exception {
        TransactionProcessor processor = new TransactionProcessor();
        List<Transaction> transactions = processor.readTransactions("src/test/resources/test_transactions.csv");

        assertEquals(2, transactions.size());
        assertEquals("Crédito", transactions.get(0).getType());
    }

    @Test
    public void testGenerateReport() {
        List<Transaction> transactions = List.of(
                new Transaction(1, "Crédito", 100.0),
                new Transaction(2, "Débito", 50.0)
        );

        TransactionProcessor processor = new TransactionProcessor();
        TransactionReport report = processor.generateReport(transactions);

        assertEquals(50.0, report.getFinalBalance(), 0.001); // 100 - 50 = 50
        assertEquals(1, report.getCreditCount());
        assertEquals(1, report.getDebitCount());
    }
}
