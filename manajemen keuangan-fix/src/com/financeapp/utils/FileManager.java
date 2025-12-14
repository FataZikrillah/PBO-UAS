package com.financeapp.utils;

import com.financeapp.model.Transaction;
import com.financeapp.model.Income;
import com.financeapp.model.Expense;
import com.financeapp.model.FinanceManager;

import java.io.*;
import java.util.List;

/**
 * Utility class untuk menyimpan dan memuat data transaksi ke/dari file
 * Data disimpan dalam format teks sederhana (CSV-like)
 */
public class FileManager {
    
    // Path file penyimpanan data
    private static final String DATA_FILE = "data/transactions.txt";

    public static boolean saveTransactions(FinanceManager manager) {
        try {
            // Buat folder data jika belum ada
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdirs();
            }
            
            // Tulis data ke file
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE));
            
            List<Transaction> transactions = manager.getTransactions();
            for (Transaction t : transactions) {
                // Format: TYPE|AMOUNT|DATE|DESCRIPTION
                String line = String.format("%s|%.2f|%s|%s",
                    t.getType(),
                    t.getAmount(),
                    t.getDate(),
                    t.getDescription()
                );
                writer.write(line);
                writer.newLine();
            }
            
            writer.close();
            return true;
        } catch (IOException e) {
            System.err.println("Error saving transactions: " + e.getMessage());
            return false;
        }
    }
    

    public static boolean loadTransactions(FinanceManager manager) {
        File file = new File(DATA_FILE);
        
        // Jika file tidak ada, skip (bukan error, hanya belum ada data)
        if (!file.exists()) {
            return true;
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = reader.readLine()) != null) {
                // Parse setiap baris
                String[] parts = line.split("\\|");
                if (parts.length != 4) {
                    continue; // Skip baris yang tidak valid
                }
                
                String type = parts[0];
                double amount = Double.parseDouble(parts[1]);
                String date = parts[2];
                String description = parts[3];
                
                // Buat objek transaksi sesuai tipe
                Transaction transaction;
                if (type.equals("Income")) {
                    transaction = new Income(amount, date, description);
                } else {
                    transaction = new Expense(amount, date, description);
                }
                
                // Tambahkan ke manager
                manager.addTransaction(transaction);
            }
            
            reader.close();
            return true;
        } catch (Exception e) {
            System.err.println("Error loading transactions: " + e.getMessage());
            return false;
        }
    }
    
    // Menghapus file data (reset semua transaksi)
    public static boolean clearData() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }
}
