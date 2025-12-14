package com.financeapp.model;

/**
 * Kelas Income - menerapkan prinsip INHERITANCE dan POLYMORPHISM
 * Kelas ini mewarisi dari Transaction dan mengimplementasikan method process()
 * dengan cara spesifik untuk transaksi pemasukan
 */
public class Income extends Transaction {
    

     // Constructor untuk membuat transaksi pemasukan
     // Memanggil constructor parent class (Transaction)
     //
     // @param amount Jumlah uang yang masuk
     // @param date Tanggal pemasukan
     // @param description Keterangan pemasukan (contoh: "Gaji", "Bonus", dll)

    public Income(double amount, String date, String description) {
        super(amount, date, description);
    }
    
    // POLYMORPHISM: Override method process() dari parent class
    @Override
    public double process(double currentBalance) {
        // Pemasukan akan menambah saldo
        return currentBalance + getAmount();
    }
    
    // POLYMORPHISM: Override method getType() dari parent class
    @Override
    public String getType() {
        return "Income";
    }
}
