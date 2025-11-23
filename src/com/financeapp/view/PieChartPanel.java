package com.financeapp.view;

import com.financeapp.model.FinanceManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

/**
 * Panel untuk menampilkan Pie Chart visualisasi keuangan
 * Menampilkan persentase: Uang Masuk, Uang Keluar, Uang Sekarang
 */
public class PieChartPanel extends JPanel {
    
    private FinanceManager manager;
    private DefaultPieDataset dataset;
    private ChartPanel chartPanel;
    
    /**
     * Constructor - membuat panel dengan pie chart
     * @param manager Objek FinanceManager sebagai sumber data
     */
    public PieChartPanel(FinanceManager manager) {
        this.manager = manager;
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Visualisasi Keuangan"));
        
        // Buat dataset untuk pie chart
        dataset = new DefaultPieDataset();
        
        // Buat chart
        JFreeChart chart = ChartFactory.createPieChart(
            "",                    // Judul (kosong karena sudah ada border title)
            dataset,               // Dataset
            true,                  // Tampilkan legend
            true,                  // Tooltips
            false                  // URLs
        );
        
        // Kustomisasi appearance
        chart.setBackgroundPaint(Color.WHITE);
        
        // Buat ChartPanel
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(300, 300));
        
        add(chartPanel, BorderLayout.CENTER);
        
        // Update dengan data awal
        updateChart();
    }
    
    /**
     * Update pie chart dengan data terbaru
     * Menghitung persentase dari total uang yang ada
     */
    public void updateChart() {
        // Clear dataset lama
        dataset.clear();
        
        double income = manager.getMonthlyIncome();
        double expense = manager.getMonthlyExpense();
        double balance = manager.getCurrentBalance();
        
        // Hitung total untuk persentase
        double total = income + expense + balance;
        
        // Jika total = 0, tampilkan chart kosong
        if (total <= 0) {
            dataset.setValue("Tidak ada data", 100);
            return;
        }
        
        // Tambahkan data dengan persentase
        if (income > 0) {
            double incomePercent = (income / total) * 100;
            dataset.setValue(String.format("Uang Masuk (%.1f%%)", incomePercent), income);
        }
        
        if (expense > 0) {
            double expensePercent = (expense / total) * 100;
            dataset.setValue(String.format("Uang Keluar (%.1f%%)", expensePercent), expense);
        }
        
        if (balance > 0) {
            double balancePercent = (balance / total) * 100;
            dataset.setValue(String.format("Uang Sekarang (%.1f%%)", balancePercent), balance);
        }
    }
}
