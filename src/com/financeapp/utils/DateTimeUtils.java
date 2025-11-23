package com.financeapp.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class untuk formatting dan parsing tanggal/waktu
 * Menggunakan format standar Indonesia
 */
public class DateTimeUtils {
    
    // Format standar: 2025-11-23 14:30:00
    private static final DateTimeFormatter STANDARD_FORMAT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    // Format untuk tampilan: 23 Nov 2025, 14:30
    private static final DateTimeFormatter DISPLAY_FORMAT = 
        DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");
    
    /**
     * Mendapatkan tanggal dan waktu saat ini dalam format standar
     * @return String tanggal waktu saat ini (yyyy-MM-dd HH:mm:ss)
     */
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(STANDARD_FORMAT);
    }
    
    /**
     * Format LocalDateTime ke string format standar
     * @param dateTime Objek LocalDateTime
     * @return String format yyyy-MM-dd HH:mm:ss
     */
    public static String formatStandard(LocalDateTime dateTime) {
        return dateTime.format(STANDARD_FORMAT);
    }
    
    /**
     * Format string tanggal standar ke format tampilan yang lebih friendly
     * Input: "2025-11-23 14:30:00"
     * Output: "23 Nov 2025, 14:30"
     * 
     * @param standardDateTime String tanggal format standar
     * @return String format tampilan
     */
    public static String formatForDisplay(String standardDateTime) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(standardDateTime, STANDARD_FORMAT);
            return dateTime.format(DISPLAY_FORMAT);
        } catch (Exception e) {
            // Jika gagal parsing, return original string
            return standardDateTime;
        }
    }
    
    /**
     * Parse string tanggal menjadi objek LocalDateTime
     * @param dateTimeString String tanggal (yyyy-MM-dd HH:mm:ss)
     * @return Objek LocalDateTime
     */
    public static LocalDateTime parse(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, STANDARD_FORMAT);
    }
}
