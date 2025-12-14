package com.financeapp;

import com.financeapp.model.FinanceManager;
import com.financeapp.view.MainFrame;
import com.financeapp.utils.FileManager;

import javax.swing.*;

/**
 * Main Application Class
 * Entry point aplikasi - menjalankan GUI Swing
 * 
 * Aplikasi ini menerapkan prinsip-prinsip OOP:
 * 1. ABSTRACTION: Kelas Transaction sebagai abstraksi transaksi keuangan
 * 2. INHERITANCE: Income dan Expense mewarisi dari Transaction
 * 3. POLYMORPHISM: Method process() di-override berbeda di setiap subclass
 * 4. ENCAPSULATION: Data disembunyikan dengan private fields dan diakses via getter/setter
 */
public class MainApp {
    
    // Method main - entry point aplikasi
    public static void main(String[] args) {
        // Set Look and Feel ke sistem operasi (agar tampilan native)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Jalankan GUI di Event Dispatch Thread (EDT) - best practice untuk Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Buat instance FinanceManager (Model)
                FinanceManager manager = new FinanceManager();
                
                // Load data dari file (jika ada)
                FileManager.loadTransactions(manager);
                
                // Buat dan tampilkan Main Frame (View)
                MainFrame frame = new MainFrame(manager);
                frame.setVisible(true);
                
                System.out.println("==============================================");
                System.out.println("Aplikasi Manajemen Keuangan Sederhana");
                System.out.println("Menerapkan Prinsip OOP (Java Swing)");
                System.out.println("==============================================");
            }
        });
    }
}
