package com.financeapp.view;

import com.financeapp.model.Transaction;
import com.financeapp.model.Income;
import com.financeapp.model.Expense;
import com.financeapp.utils.DateTimeUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dialog untuk menambah atau mengedit transaksi
 * Form input: Tipe (Pemasukan/Pengeluaran), Jumlah, Tanggal, Keterangan
 */
public class AddEditDialog extends JDialog {
    
    private JComboBox<String> typeCombo;
    private JTextField amountField;
    private JTextField dateField;
    private JTextArea descriptionArea;
    
    private Transaction result;  // Hasil transaksi yang dibuat/diedit
    private boolean confirmed;   // Flag apakah user klik Save atau Cancel
    
    /**
     * Constructor untuk dialog TAMBAH transaksi baru
     * @param parent Frame parent
     */
    public AddEditDialog(Frame parent) {
        super(parent, "Tambah Transaksi", true);
        initComponents(null);
        setLocationRelativeTo(parent);
    }
    
    /**
     * Constructor untuk dialog EDIT transaksi existing
     * @param parent Frame parent
     * @param transaction Transaksi yang akan diedit
     */
    public AddEditDialog(Frame parent, Transaction transaction) {
        super(parent, "Edit Transaksi", true);
        initComponents(transaction);
        setLocationRelativeTo(parent);
    }
    
    /**
     * Inisialisasi komponen dialog
     * @param transaction Transaksi untuk mode edit (null untuk mode tambah)
     */
    private void initComponents(Transaction transaction) {
        setLayout(new BorderLayout(10, 10));
        setSize(400, 350);
        
        // Panel form
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Row 0: Tipe
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        formPanel.add(new JLabel("Tipe:"), gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        typeCombo = new JComboBox<>(new String[]{"Pemasukan", "Pengeluaran"});
        formPanel.add(typeCombo, gbc);
        
        // Row 1: Jumlah
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        formPanel.add(new JLabel("Jumlah (Rp):"), gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        amountField = new JTextField();
        formPanel.add(amountField, gbc);
        
        // Row 2: Tanggal
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        formPanel.add(new JLabel("Tanggal:"), gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        dateField = new JTextField(DateTimeUtils.getCurrentDateTime());
        dateField.setToolTipText("Format: yyyy-MM-dd HH:mm:ss");
        formPanel.add(dateField, gbc);
        
        // Row 3: Keterangan
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.NORTH;
        formPanel.add(new JLabel("Keterangan:"), gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        descriptionArea = new JTextArea(4, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        formPanel.add(scrollPane, gbc);
        
        // Jika mode edit, isi field dengan data existing
        if (transaction != null) {
            typeCombo.setSelectedItem(transaction instanceof Income ? "Pemasukan" : "Pengeluaran");
            amountField.setText(String.valueOf(transaction.getAmount()));
            dateField.setText(transaction.getDate());
            descriptionArea.setText(transaction.getDescription());
        }
        
        // Panel tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton saveButton = new JButton("Simpan");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateAndSave()) {
                    confirmed = true;
                    dispose();
                }
            }
        });
        
        JButton cancelButton = new JButton("Batal");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = false;
                dispose();
            }
        });
        
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        
        // Tambahkan panel ke dialog
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Validasi input dan buat objek Transaction
     * @return true jika valid dan berhasil, false jika ada error
     */
    private boolean validateAndSave() {
        try {
            // Validasi jumlah
            String amountText = amountField.getText().trim();
            if (amountText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            double amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Jumlah harus lebih dari 0!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            // Validasi tanggal
            String date = dateField.getText().trim();
            if (date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tanggal tidak boleh kosong!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            // Coba parse tanggal untuk validasi format
            try {
                DateTimeUtils.parse(date);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, 
                    "Format tanggal tidak valid! Gunakan: yyyy-MM-dd HH:mm:ss", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            // Validasi keterangan
            String description = descriptionArea.getText().trim();
            if (description.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Keterangan tidak boleh kosong!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            // Buat objek Transaction sesuai tipe
            String type = (String) typeCombo.getSelectedItem();
            if (type.equals("Pemasukan")) {
                result = new Income(amount, date, description);
            } else {
                result = new Expense(amount, date, description);
            }
            
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah harus berupa angka yang valid!", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    /**
     * Mendapatkan transaksi hasil input/edit
     * @return Objek Transaction atau null jika user cancel
     */
    public Transaction getTransaction() {
        return confirmed ? result : null;
    }
}
