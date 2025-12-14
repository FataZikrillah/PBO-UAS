package com.financeapp.model;

/**
 * Kelas abstrak Transaction - menerapkan prinsip ABSTRACTION dalam OOP
 * Kelas ini menyembunyikan detail implementasi dan mendefinisikan kontrak
 * yang harus diikuti oleh semua jenis transaksi
 */
public abstract class Transaction {
    // ENCAPSULATION: Semua field bersifat private untuk melindungi data
    private double amount;        // Jumlah uang dalam transaksi
    private String date;          // Tanggal transaksi (format: YYYY-MM-DD HH:mm:ss)
    private String description;   // Keterangan/deskripsi transaksi
    

     // Constructor untuk membuat objek Transaction
     // @param amount Jumlah uang
     // @param date Tanggal transaksi
     // @param description Keterangan transaksi

    public Transaction(double amount, String date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
    
    // ENCAPSULATION: Getter dan Setter untuk akses terkendali ke field private
    
    //Mendapatkan jumlah uang transaksi
    public double getAmount() {
        return amount;
    }
    
    // Mengubah jumlah uang transaksi
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    // Mendapatkan tanggal transaksi
    public String getDate() {
        return date;
    }
    
    // Mengubah tanggal transaksi
    public void setDate(String date) {
        this.date = date;
    }
    
    // Mendapatkan keterangan transaksi
    public String getDescription() {
        return description;
    }
    
    // Mengubah keterangan transaksi
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * ABSTRACTION & POLYMORPHISM:
     * Method abstrak yang harus diimplementasikan oleh setiap subclass
     * Setiap jenis transaksi (Income/Expense) akan memproses saldo dengan cara berbeda
     */
    public abstract double process(double currentBalance);
    
    // Mendapatkan tipe transaksi (Income atau Expense)
    public abstract String getType();
}
