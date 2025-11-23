package com.financeapp.model;

/**
 * Kelas Expense - menerapkan prinsip INHERITANCE dan POLYMORPHISM
 * Kelas ini mewarisi dari Transaction dan mengimplementasikan method process()
 * dengan cara spesifik untuk transaksi pengeluaran
 */
public class Expense extends Transaction {
    
    /**
     * Constructor untuk membuat transaksi pengeluaran
     * Memanggil constructor parent class (Transaction)
     * 
     * @param amount Jumlah uang yang keluar
     * @param date Tanggal pengeluaran
     * @param description Keterangan pengeluaran (contoh: "Belanja", "Transport", dll)
     */
    public Expense(double amount, String date, String description) {
        super(amount, date, description);
    }
    
    /**
     * POLYMORPHISM: Override method process() dari parent class
     * Implementasi spesifik untuk Expense - mengurangi amount dari saldo
     * 
     * @param currentBalance Saldo saat ini
     * @return Saldo baru (saldo lama - pengeluaran)
     */
    @Override
    public double process(double currentBalance) {
        // Pengeluaran akan mengurangi saldo
        return currentBalance - getAmount();
    }
    
    /**
     * POLYMORPHISM: Override method getType() dari parent class
     * @return Tipe transaksi "Expense"
     */
    @Override
    public String getType() {
        return "Expense";
    }
}
