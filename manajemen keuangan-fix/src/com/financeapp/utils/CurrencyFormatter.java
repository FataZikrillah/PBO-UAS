package com.financeapp.utils;

import java.text.NumberFormat;
import java.util.Locale;

// Utility class untuk formatting mata uang Rupiah
public class CurrencyFormatter {
    
    // Locale Indonesia untuk format Rupiah
    private static final Locale LOCALE_ID = new Locale("id", "ID");
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(LOCALE_ID);
    
    /**
     * Format angka menjadi format Rupiah
     * Contoh: 1348000 -> "Rp 1.348.000"
     */
    public static String format(double amount) {
        return currencyFormat.format(amount);
    }

    public static String formatWithSign(double amount) {
        String sign = amount >= 0 ? "+ " : "- ";
        return sign + currencyFormat.format(Math.abs(amount));
    }
    

    public static String formatNumber(double amount) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(LOCALE_ID);
        numberFormat.setMaximumFractionDigits(0);
        return numberFormat.format(amount);
    }
}
