package com.financeapp.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Kelas FinanceManager - Core Logic & Controller
 * Menerapkan prinsip ENCAPSULATION untuk melindungi dan mengelola data keuangan
 * Kelas ini bertindak sebagai "Model" dalam pola MVC (Model-View-Controller)
 */
public class FinanceManager {
    // ENCAPSULATION: Semua field private untuk keamanan data
    private double currentBalance;              // Saldo saat ini
    private List<Transaction> transactions;     // Daftar semua transaksi
    private double monthlyIncome;               // Total pemasukan bulan ini
    private double monthlyExpense;              // Total pengeluaran bulan ini
    
    /**
     * Constructor - inisialisasi data awal
     * Saldo awal = 0, list transaksi kosong
     */
    public FinanceManager() {
        this.currentBalance = 0.0;
        this.transactions = new ArrayList<>();
        this.monthlyIncome = 0.0;
        this.monthlyExpense = 0.0;
    }
    
    /**
     * Menambahkan transaksi baru ke dalam sistem
     * POLYMORPHISM: Menerima objek Transaction (bisa Income atau Expense)
     * Method process() akan dipanggil sesuai tipe transaksi yang sebenarnya
     * 
     * @param transaction Objek transaksi (Income atau Expense)
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        // POLYMORPHISM: Memanggil method process() yang sudah di-override
        currentBalance = transaction.process(currentBalance);
        // Update ringkasan bulanan
        calculateMonthlySummary();
    }
    
    /**
     * Menghapus transaksi berdasarkan index
     * Saldo akan di-recalculate dari awal untuk konsistensi
     * 
     * @param index Index transaksi yang akan dihapus (mulai dari 0)
     */
    public void deleteTransaction(int index) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
            // Recalculate saldo dari awal
            recalculateBalance();
            calculateMonthlySummary();
        }
    }
    
    /**
     * Mengedit transaksi yang sudah ada
     * Mengganti transaksi lama dengan transaksi baru di index tertentu
     * 
     * @param index Index transaksi yang akan diedit
     * @param newTransaction Objek transaksi baru pengganti
     */
    public void editTransaction(int index, Transaction newTransaction) {
        if (index >= 0 && index < transactions.size()) {
            transactions.set(index, newTransaction);
            // Recalculate saldo dari awal
            recalculateBalance();
            calculateMonthlySummary();
        }
    }
    
    /**
     * Menghitung ulang saldo dari awal
     * Digunakan setelah delete atau edit untuk memastikan saldo akurat
     * POLYMORPHISM: Setiap transaksi akan diproses sesuai tipenya
     */
    private void recalculateBalance() {
        currentBalance = 0.0;
        for (Transaction t : transactions) {
            currentBalance = t.process(currentBalance);
        }
    }
    
    /**
     * Menghitung ringkasan bulanan (total pemasukan dan pengeluaran bulan ini)
     * Menggunakan bulan dan tahun saat ini sebagai filter
     */
    public void calculateMonthlySummary() {
        monthlyIncome = 0.0;
        monthlyExpense = 0.0;
        
        // Dapatkan bulan dan tahun saat ini
        LocalDateTime now = LocalDateTime.now();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();
        
        // Iterasi semua transaksi
        for (Transaction t : transactions) {
            try {
                // Parse tanggal transaksi
                LocalDateTime transactionDate = LocalDateTime.parse(
                    t.getDate(), 
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                );
                
                // Cek apakah transaksi di bulan dan tahun yang sama
                if (transactionDate.getMonthValue() == currentMonth && 
                    transactionDate.getYear() == currentYear) {
                    
                    // POLYMORPHISM: Cek tipe transaksi
                    if (t instanceof Income) {
                        monthlyIncome += t.getAmount();
                    } else if (t instanceof Expense) {
                        monthlyExpense += t.getAmount();
                    }
                }
            } catch (Exception e) {
                // Jika format tanggal tidak valid, skip transaksi ini
                System.err.println("Error parsing date: " + t.getDate());
            }
        }
    }
    
    // ENCAPSULATION: Getter untuk akses read-only ke data private
    
    /**
     * Mendapatkan saldo saat ini
     * @return Saldo terkini
     */
    public double getCurrentBalance() {
        return currentBalance;
    }
    
    /**
     * Mendapatkan semua transaksi
     * @return List semua transaksi
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    /**
     * Mendapatkan total pemasukan bulan ini
     * @return Total pemasukan bulanan
     */
    public double getMonthlyIncome() {
        return monthlyIncome;
    }
    
    /**
     * Mendapatkan total pengeluaran bulan ini
     * @return Total pengeluaran bulanan
     */
    public double getMonthlyExpense() {
        return monthlyExpense;
    }
    
    /**
     * Mendapatkan selisih pemasukan dan pengeluaran bulan ini
     * @return Selisih (pemasukan - pengeluaran)
     */
    public double getMonthlyBalance() {
        return monthlyIncome - monthlyExpense;
    }
}
