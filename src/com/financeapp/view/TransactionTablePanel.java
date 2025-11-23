package com.financeapp.view;

import com.financeapp.model.FinanceManager;
import com.financeapp.model.Transaction;
import com.financeapp.model.Income;
import com.financeapp.utils.CurrencyFormatter;
import com.financeapp.utils.DateTimeUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Panel untuk menampilkan tabel transaksi
 * Menampilkan semua transaksi dengan kolom: Tipe, Jumlah, Tanggal, Keterangan
 */
public class TransactionTablePanel extends JPanel {
    
    private FinanceManager manager;
    private JTable table;
    private DefaultTableModel tableModel;
    
    /**
     * Constructor - membuat panel dengan tabel transaksi
     * @param manager Objek FinanceManager sebagai sumber data
     */
    public TransactionTablePanel(FinanceManager manager) {
        this.manager = manager;
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Daftar Transaksi"));
        
        // Buat model tabel dengan kolom
        String[] columns = {"Tipe", "Jumlah", "Tanggal", "Keterangan"};
        tableModel = new DefaultTableModel(columns, 0) {
            // Membuat semua cell tidak bisa diedit langsung
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Buat tabel
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(25);
        table.getTableHeader().setReorderingAllowed(false);
        
        // Set lebar kolom
        table.getColumnModel().getColumn(0).setPreferredWidth(80);   // Tipe
        table.getColumnModel().getColumn(1).setPreferredWidth(120);  // Jumlah
        table.getColumnModel().getColumn(2).setPreferredWidth(150);  // Tanggal
        table.getColumnModel().getColumn(3).setPreferredWidth(300);  // Keterangan
        
        // Custom renderer untuk kolom Jumlah (warna hijau/merah)
        table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                // Ambil tipe transaksi dari kolom pertama
                String type = (String) table.getValueAt(row, 0);
                
                // Set warna: hijau untuk Income, merah untuk Expense
                if (!isSelected) {
                    if (type.equals("Pemasukan")) {
                        c.setForeground(new Color(46, 204, 113));
                    } else {
                        c.setForeground(new Color(231, 76, 60));
                    }
                }
                
                setHorizontalAlignment(SwingConstants.RIGHT);
                return c;
            }
        });
        
        // Tambahkan tabel ke scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        // Load data awal
        refreshTable();
    }
    
    /**
     * Refresh tabel dengan data terbaru dari FinanceManager
     * Menghapus semua baris lama dan menambahkan data baru
     */
    public void refreshTable() {
        // Hapus semua baris
        tableModel.setRowCount(0);
        
        // Tambahkan data transaksi
        for (Transaction t : manager.getTransactions()) {
            Object[] row = new Object[4];
            
            // Kolom 0: Tipe (Income -> "Pemasukan", Expense -> "Pengeluaran")
            row[0] = t instanceof Income ? "Pemasukan" : "Pengeluaran";
            
            // Kolom 1: Jumlah dengan format Rupiah
            row[1] = CurrencyFormatter.format(t.getAmount());
            
            // Kolom 2: Tanggal dengan format display
            row[2] = DateTimeUtils.formatForDisplay(t.getDate());
            
            // Kolom 3: Keterangan
            row[3] = t.getDescription();
            
            tableModel.addRow(row);
        }
    }
    
    /**
     * Mendapatkan index baris yang dipilih
     * @return Index baris yang dipilih, atau -1 jika tidak ada yang dipilih
     */
    public int getSelectedRow() {
        return table.getSelectedRow();
    }
    
    /**
     * Mendapatkan objek JTable
     * @return Objek JTable
     */
    public JTable getTable() {
        return table;
    }
}
