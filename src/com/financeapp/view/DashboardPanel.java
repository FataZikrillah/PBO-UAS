package com.financeapp.view;

import com.financeapp.model.FinanceManager;
import com.financeapp.utils.CurrencyFormatter;

import javax.swing.*;
import java.awt.*;

/**
 * Panel Dashboard - menampilkan 4 kotak informasi keuangan utama
 * 1. Uang Sekarang (Saldo saat ini)
 * 2. Uang Masuk (Total pemasukan bulan ini)
 * 3. Uang Keluar (Total pengeluaran bulan ini)
 * 4. Uang Bulan Ini (Selisih pemasukan - pengeluaran)
 */
public class DashboardPanel extends JPanel {
    
    private FinanceManager manager;
    
    // Label untuk menampilkan nilai
    private JLabel balanceLabel;
    private JLabel incomeLabel;
    private JLabel expenseLabel;
    private JLabel monthlyLabel;
    
    /**
     * Constructor - membuat panel dashboard dengan 4 kotak info
     * @param manager Objek FinanceManager untuk sumber data
     */
    public DashboardPanel(FinanceManager manager) {
        this.manager = manager;
        
        // Set layout GridLayout 1 baris, 4 kolom dengan spacing
        setLayout(new GridLayout(1, 4, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Buat 4 kotak info
        add(createInfoBox("UANG SEKARANG", "Rp 0", new Color(52, 152, 219), "balanceLabel"));
        add(createInfoBox("UANG MASUK", "Rp 0", new Color(46, 204, 113), "incomeLabel"));
        add(createInfoBox("UANG KELUAR", "Rp 0", new Color(231, 76, 60), "expenseLabel"));
        add(createInfoBox("UANG BULAN INI", "+ Rp 0", new Color(230, 126, 34), "monthlyLabel"));
        
        // Update dengan data awal
        updateDashboard();
    }
    
    /**
     * Membuat kotak informasi dengan judul dan nilai
     * @param title Judul kotak (contoh: "UANG SEKARANG")
     * @param initialValue Nilai awal
     * @param bgColor Warna background
     * @param labelName Nama label untuk referensi
     * @return JPanel kotak info
     */
    private JPanel createInfoBox(String title, String initialValue, Color bgColor, String labelName) {
        JPanel box = new JPanel();
        box.setLayout(new BorderLayout(5, 5));
        box.setBackground(bgColor);
        box.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(bgColor.darker(), 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        // Label judul
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Label nilai
        JLabel valueLabel = new JLabel(initialValue);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 20));
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Simpan referensi label berdasarkan nama
        switch (labelName) {
            case "balanceLabel":
                balanceLabel = valueLabel;
                break;
            case "incomeLabel":
                incomeLabel = valueLabel;
                break;
            case "expenseLabel":
                expenseLabel = valueLabel;
                break;
            case "monthlyLabel":
                monthlyLabel = valueLabel;
                break;
        }
        
        box.add(titleLabel, BorderLayout.NORTH);
        box.add(valueLabel, BorderLayout.CENTER);
        
        return box;
    }
    
    /**
     * Update semua nilai di dashboard dengan data terbaru dari FinanceManager
     * Method ini dipanggil setiap kali ada perubahan data (tambah/edit/hapus transaksi)
     */
    public void updateDashboard() {
        // Update saldo saat ini
        balanceLabel.setText(CurrencyFormatter.format(manager.getCurrentBalance()));
        
        // Update pemasukan bulanan
        incomeLabel.setText(CurrencyFormatter.format(manager.getMonthlyIncome()));
        
        // Update pengeluaran bulanan
        expenseLabel.setText(CurrencyFormatter.format(manager.getMonthlyExpense()));
        
        // Update selisih bulanan dengan tanda +/-
        monthlyLabel.setText(CurrencyFormatter.formatWithSign(manager.getMonthlyBalance()));
    }
}
