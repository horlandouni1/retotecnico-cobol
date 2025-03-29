package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    @Test
    public void testTransactionCreation() {
        Transaction t = new Transaction(1, "Crédito", 100.0);
        assertEquals(1, t.getId());
        assertEquals("Crédito", t.getType());
        assertEquals(100.0, t.getAmount(), 0.001); // Delta para comparar doubles
    }
}
