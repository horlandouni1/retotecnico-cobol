package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, proporcione la ruta del archivo CSV como argumento.");
            return;
        }

        String filePath = args[0];
        TransactionProcessor processor = new TransactionProcessor();

        try {
            // Leer transacciones desde el archivo CSV
            List<Transaction> transactions = processor.readTransactions(filePath);

            // Generar reporte
            TransactionReport report = processor.generateReport(transactions);

            // Mostrar resultados
            printReport(report);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void printReport(TransactionReport report) {
        System.out.println("Reporte de Transacciones");
        System.out.println("---------------------------------------------");
        System.out.printf("Balance Final: %.2f%n", report.getFinalBalance());
        System.out.printf("Transacción de Mayor Monto: ID %d - %.2f%n",
                report.getHighestTransaction().getId(),
                report.getHighestTransaction().getAmount());
        System.out.printf("Conteo de Transacciones: Crédito: %d Débito: %d%n",
                report.getCreditCount(), report.getDebitCount());
    }
}