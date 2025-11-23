package com.financeapp.view;

import com.financeapp.model.FinanceManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

/**
 * Panel untuk menampilkan Pie Chart visualisasi keuangan bulanan
 * Menampilkan persentase: Pemasukan Bulan Ini vs Pengeluaran Bulan Ini
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
     * Menampilkan distribusi pemasukan vs pengeluaran bulan ini
     * Tidak menampilkan current balance untuk menghindari double-counting
     */
    public void updateChart() {
        // Clear dataset lama
        dataset.clear();
        
        double income = manager.getMonthlyIncome();
        double expense = manager.getMonthlyExpense();
        
        // Hitung total cash flow bulan ini (income + expense)
        double total = income + expense;
        
        // Jika tidak ada transaksi bulan ini, tampilkan pesan
        if (total == 0) {
            dataset.setValue("Tidak ada transaksi bulan ini", 100);
            return;
        }
        
        // Tampilkan distribusi income vs expense bulan ini
        if (income > 0) {
            double incomePercent = (income / total) * 100;
            dataset.setValue(String.format("Pemasukan Bulan Ini (%.1f%%)", incomePercent), income);
        }
        
        if (expense > 0) {
            double expensePercent = (expense / total) * 100;
            dataset.setValue(String.format("Pengeluaran Bulan Ini (%.1f%%)", expensePercent), expense);
        }
    }
}
