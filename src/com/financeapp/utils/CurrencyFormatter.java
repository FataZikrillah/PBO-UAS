package com.financeapp.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Utility class untuk formatting mata uang Rupiah
 * Mengubah angka menjadi format "Rp 1.234.567"
 */
public class CurrencyFormatter {
    
    // Locale Indonesia untuk format Rupiah
    private static final Locale LOCALE_ID = new Locale("id", "ID");
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(LOCALE_ID);
    
    /**
     * Format angka menjadi format Rupiah
     * Contoh: 1348000 -> "Rp 1.348.000"
     * 
     * @param amount Jumlah uang (double)
     * @return String format Rupiah
     */
    public static String format(double amount) {
        return currencyFormat.format(amount);
    }
    
    /**
     * Format angka dengan tanda + atau - di depan
     * Berguna untuk menampilkan perubahan saldo
     * Contoh: 148000 -> "+ Rp 148.000"
     *         -50000 -> "- Rp 50.000"
     * 
     * @param amount Jumlah uang (bisa positif/negatif)
     * @return String format dengan tanda
     */
    public static String formatWithSign(double amount) {
        String sign = amount >= 0 ? "+ " : "- ";
        return sign + currencyFormat.format(Math.abs(amount));
    }
    
    /**
     * Format tanpa simbol Rp, hanya angka dengan separator
     * Contoh: 1348000 -> "1.348.000"
     * 
     * @param amount Jumlah uang
     * @return String angka dengan separator
     */
    public static String formatNumber(double amount) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(LOCALE_ID);
        numberFormat.setMaximumFractionDigits(0);
        return numberFormat.format(amount);
    }
}
