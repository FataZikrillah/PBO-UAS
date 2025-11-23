package com.financeapp.view;

import com.financeapp.model.FinanceManager;
import com.financeapp.model.Transaction;
import com.financeapp.utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Main Frame - Window utama aplikasi
 * Menggunakan BorderLayout untuk menyusun komponen:
 * - NORTH: Dashboard Panel (4 kotak info)
 * - CENTER: Transaction Table Panel
 * - EAST: Pie Chart Panel
 * - SOUTH: Button Panel (ADD, DELETE, EDIT, REFRESH, LAPORAN)
 */
public class MainFrame extends JFrame {
    
    private FinanceManager manager;
    
    // Komponen view
    private DashboardPanel dashboardPanel;
    private TransactionTablePanel tablePanel;
    private PieChartPanel chartPanel;
    
    /**
     * Constructor - membuat dan setup main window
     * @param manager Objek FinanceManager sebagai data model
     */
    public MainFrame(FinanceManager manager) {
        this.manager = manager;
        
        // Setup frame
        setTitle("Manajemen Keuangan Sederhana");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Set layout
        setLayout(new BorderLayout(10, 10));
        
        // Buat komponen
        dashboardPanel = new DashboardPanel(manager);
        tablePanel = new TransactionTablePanel(manager);
        chartPanel = new PieChartPanel(manager);
        
        // Tambahkan komponen ke frame
        add(dashboardPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(chartPanel, BorderLayout.EAST);
        add(createButtonPanel(), BorderLayout.SOUTH);
        
        // Auto-save saat window ditutup
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FileManager.saveTransactions(manager);
            }
        });
    }
    
    /**
     * Membuat panel tombol di bagian bawah
     * @return JPanel dengan tombol-tombol aksi
     */
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        // Tombol ADD
        JButton addButton = new JButton("TAMBAH");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAdd();
            }
        });
        
        // Tombol DELETE
        JButton deleteButton = new JButton("HAPUS");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDelete();
            }
        });
        
        // Tombol EDIT
        JButton editButton = new JButton("EDIT");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEdit();
            }
        });
        
        // Tombol REFRESH
        JButton refreshButton = new JButton("REFRESH");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRefresh();
            }
        });
        
        // Tombol LAPORAN
        JButton reportButton = new JButton("LAPORAN");
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleReport();
            }
        });
        
        // Tambahkan tombol ke panel
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(editButton);
        panel.add(refreshButton);
        panel.add(reportButton);
        
        return panel;
    }
    
    /**
     * Handler untuk tombol TAMBAH
     * Membuka dialog untuk menambah transaksi baru
     */
    private void handleAdd() {
        AddEditDialog dialog = new AddEditDialog(this);
        dialog.setVisible(true);
        
        Transaction transaction = dialog.getTransaction();
        if (transaction != null) {
            manager.addTransaction(transaction);
            refreshAll();
            FileManager.saveTransactions(manager);
        }
    }
    
    /**
     * Handler untuk tombol HAPUS
     * Menghapus transaksi yang dipilih di tabel
     */
    private void handleDelete() {
        int selectedRow = tablePanel.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                "Pilih transaksi yang akan dihapus!", 
                "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Yakin ingin menghapus transaksi ini?", 
            "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            manager.deleteTransaction(selectedRow);
            refreshAll();
            FileManager.saveTransactions(manager);
        }
    }
    
    /**
     * Handler untuk tombol EDIT
     * Membuka dialog untuk mengedit transaksi yang dipilih
     */
    private void handleEdit() {
        int selectedRow = tablePanel.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                "Pilih transaksi yang akan diedit!", 
                "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        Transaction oldTransaction = manager.getTransactions().get(selectedRow);
        AddEditDialog dialog = new AddEditDialog(this, oldTransaction);
        dialog.setVisible(true);
        
        Transaction newTransaction = dialog.getTransaction();
        if (newTransaction != null) {
            manager.editTransaction(selectedRow, newTransaction);
            refreshAll();
            FileManager.saveTransactions(manager);
        }
    }
    
    /**
     * Handler untuk tombol REFRESH
     * Memuat ulang semua tampilan dengan data terbaru
     */
    private void handleRefresh() {
        refreshAll();
    }
    
    /**
     * Handler untuk tombol LAPORAN
     * Menampilkan dialog laporan keuangan sederhana
     */
    private void handleReport() {
        StringBuilder report = new StringBuilder();
        report.append("===== LAPORAN KEUANGAN =====\n\n");
        report.append("Saldo Saat Ini: Rp ").append(String.format("%,.0f", manager.getCurrentBalance())).append("\n");
        report.append("Total Pemasukan Bulan Ini: Rp ").append(String.format("%,.0f", manager.getMonthlyIncome())).append("\n");
        report.append("Total Pengeluaran Bulan Ini: Rp ").append(String.format("%,.0f", manager.getMonthlyExpense())).append("\n");
        report.append("Selisih Bulan Ini: Rp ").append(String.format("%,.0f", manager.getMonthlyBalance())).append("\n\n");
        report.append("Jumlah Transaksi: ").append(manager.getTransactions().size()).append(" transaksi\n");
        
        JTextArea textArea = new JTextArea(report.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        JOptionPane.showMessageDialog(this, 
            new JScrollPane(textArea), 
            "Laporan Keuangan", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Refresh semua komponen view dengan data terbaru
     */
    private void refreshAll() {
        dashboardPanel.updateDashboard();
        tablePanel.refreshTable();
        chartPanel.updateChart();
    }
}
