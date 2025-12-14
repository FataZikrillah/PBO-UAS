package com.financeapp.model;

/**
 * Kelas Expense - menerapkan prinsip INHERITANCE dan POLYMORPHISM
 * Kelas ini mewarisi dari Transaction dan mengimplementasikan method process()
 * dengan cara spesifik untuk transaksi pengeluaran
 */
public class Expense extends Transaction {
    

    public Expense(double amount, String date, String description) {
        super(amount, date, description);
    }
    

    @Override
    public double process(double currentBalance) {
        // Pengeluaran akan mengurangi saldo
        return currentBalance - getAmount();
    }
    

    @Override
    public String getType() {
        return "Expense";
    }
}
