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
    
    /**
     * Constructor untuk membuat objek Transaction
     * @param amount Jumlah uang
     * @param date Tanggal transaksi
     * @param description Keterangan transaksi
     */
    public Transaction(double amount, String date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
    
    // ENCAPSULATION: Getter dan Setter untuk akses terkendali ke field private
    
    /**
     * Mendapatkan jumlah uang transaksi
     * @return Jumlah uang
     */
    public double getAmount() {
        return amount;
    }
    
    /**
     * Mengubah jumlah uang transaksi
     * @param amount Jumlah uang baru
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    /**
     * Mendapatkan tanggal transaksi
     * @return Tanggal transaksi
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Mengubah tanggal transaksi
     * @param date Tanggal baru
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * Mendapatkan keterangan transaksi
     * @return Keterangan transaksi
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Mengubah keterangan transaksi
     * @param description Keterangan baru
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * ABSTRACTION & POLYMORPHISM:
     * Method abstrak yang harus diimplementasikan oleh setiap subclass
     * Setiap jenis transaksi (Income/Expense) akan memproses saldo dengan cara berbeda
     * 
     * @param currentBalance Saldo saat ini
     * @return Saldo baru setelah transaksi diproses
     */
    public abstract double process(double currentBalance);
    
    /**
     * Mendapatkan tipe transaksi (Income atau Expense)
     * Method ini akan di-override oleh subclass
     * @return Nama tipe transaksi
     */
    public abstract String getType();
}
