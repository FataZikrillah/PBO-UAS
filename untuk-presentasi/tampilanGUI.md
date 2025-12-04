# Tampilan GUI Aplikasi - Manajemen Keuangan Sederhana

## Presentasi oleh: [Nama Anggota 5]

---

## 1. Pendahuluan

Selamat pagi/siang/sore, Bapak/Ibu dosen dan rekan-rekan sekalian.

Perkenalkan, saya [Nama Anggota 5] akan mempresentasikan **Tampilan GUI (Graphical User Interface)** dari aplikasi Manajemen Keuangan Sederhana ini.

---

## 2. Teknologi GUI yang Digunakan

### 2.1 Java Swing

Aplikasi ini menggunakan **Java Swing** sebagai framework GUI dengan alasan:

| Aspek | Keterangan |
|-------|------------|
| **Platform** | Cross-platform (Windows, Linux, macOS) |
| **Tipe** | Desktop application |
| **Library** | Built-in Java SE (tidak perlu library eksternal) |
| **Look and Feel** | Mengikuti tampilan native sistem operasi |

### 2.2 Komponen Swing yang Digunakan

- **JFrame** - Window utama aplikasi
- **JPanel** - Container untuk komponen lain
- **JTable** - Tabel untuk menampilkan data transaksi
- **JButton** - Tombol aksi (Tambah, Hapus, Edit, Refresh)
- **JLabel** - Menampilkan teks/nilai
- **JTextField** - Input teks satu baris
- **JTextArea** - Input teks multi-baris
- **JComboBox** - Dropdown selection
- **JDialog** - Pop-up dialog untuk input data
- **JScrollPane** - Scroll wrapper untuk tabel

---

## 3. Layout Aplikasi

### 3.1 Struktur Window Utama

```
┌────────────────────────────────────────────────────────────────┐
│                 Manajemen Keuangan Sederhana                   │
│                        (Title Bar)                              │
├────────────────────────────────────────────────────────────────┤
│                                                                 │
│  ┌────────────┐ ┌────────────┐ ┌────────────┐ ┌────────────┐  │
│  │   UANG     │ │   UANG     │ │   UANG     │ │   UANG     │  │
│  │  SEKARANG  │ │   MASUK    │ │  KELUAR    │ │ BULAN INI  │  │
│  │            │ │            │ │            │ │            │  │
│  │ Rp 1.348.000│ │ Rp 401.000│ │ Rp 253.000│ │+ Rp 148.000│  │
│  │   (BIRU)   │ │  (HIJAU)   │ │  (MERAH)   │ │  (ORANYE)  │  │
│  └────────────┘ └────────────┘ └────────────┘ └────────────┘  │
│                                                                 │
│  ┌──────────────────────────────────────────────────────────┐  │
│  │  [TAMBAH]   [HAPUS]    [EDIT]    [REFRESH]               │  │
│  └──────────────────────────────────────────────────────────┘  │
│                                                                 │
│  ┌──────────────────────────────────────────────────────────┐  │
│  │                    TABEL TRANSAKSI                        │  │
│  ├────────────┬──────────────┬───────────────┬──────────────┤  │
│  │    Tipe    │    Jumlah    │    Tanggal    │  Keterangan  │  │
│  ├────────────┼──────────────┼───────────────┼──────────────┤  │
│  │ Pemasukan  │ Rp 401.000   │ 23 Nov 2025   │ Gaji         │  │
│  │ Pengeluaran│ Rp 253.000   │ 24 Nov 2025   │ Belanja      │  │
│  │ Pemasukan  │ Rp 1.200.000 │ 25 Nov 2025   │ Bonus        │  │
│  │    ...     │     ...      │     ...       │    ...       │  │
│  └────────────┴──────────────┴───────────────┴──────────────┘  │
│                                                                 │
└────────────────────────────────────────────────────────────────┘
```

---

## 4. Komponen Dashboard

### 4.1 Panel Dashboard (4 Kotak Info)

Dashboard terdiri dari **4 kotak informasi** dengan warna berbeda:

| No | Kotak | Warna | Fungsi | Nilai Contoh |
|----|-------|-------|--------|--------------|
| 1 | UANG SEKARANG | Biru (#3498DB) | Total saldo saat ini | Rp 1.348.000 |
| 2 | UANG MASUK | Hijau (#2ECC71) | Total pemasukan bulan ini | Rp 401.000 |
| 3 | UANG KELUAR | Merah (#E74C3C) | Total pengeluaran bulan ini | Rp 253.000 |
| 4 | UANG BULAN INI | Oranye (#E67E22) | Selisih (masuk - keluar) | + Rp 148.000 |

### 4.2 Kode Warna (RGB)

```java
// Warna Dashboard
Color biru   = new Color(52, 152, 219);   // #3498DB - Saldo
Color hijau  = new Color(46, 204, 113);   // #2ECC71 - Pemasukan
Color merah  = new Color(231, 76, 60);    // #E74C3C - Pengeluaran
Color oranye = new Color(230, 126, 34);   // #E67E22 - Selisih
```

### 4.3 Screenshot Dashboard

Lihat file: `Tampilan/DashboardUtama.png`

---

## 5. Komponen Tabel Transaksi

### 5.1 Struktur Tabel

| Kolom | Tipe Data | Keterangan |
|-------|-----------|------------|
| Tipe | String | "Pemasukan" (hijau) atau "Pengeluaran" (merah) |
| Jumlah | String | Format Rupiah: "Rp 1.234.567" |
| Tanggal | String | Format: "23 Nov 2025, 14:30" |
| Keterangan | String | Deskripsi transaksi |

### 5.2 Fitur Tabel

- **Scroll** - JScrollPane untuk data yang banyak
- **Selection** - Single row selection untuk edit/hapus
- **Color Coding** - Hijau untuk pemasukan, merah untuk pengeluaran
- **Not Editable** - Data tidak bisa diedit langsung di tabel

### 5.3 Custom Cell Renderer

```java
// Warna text berdasarkan tipe transaksi
if (tipe.equals("Pemasukan")) {
    setForeground(new Color(46, 204, 113));   // Hijau
} else if (tipe.equals("Pengeluaran")) {
    setForeground(new Color(231, 76, 60));    // Merah
}
```

---

## 6. Komponen Tombol Aksi

### 6.1 Panel Tombol

```
┌──────────────────────────────────────────────────────────────┐
│     [TAMBAH]      [HAPUS]      [EDIT]      [REFRESH]         │
└──────────────────────────────────────────────────────────────┘
```

### 6.2 Fungsi Masing-Masing Tombol

| Tombol | Fungsi | Interaksi |
|--------|--------|-----------|
| **TAMBAH** | Menambah transaksi baru | Membuka dialog input |
| **HAPUS** | Menghapus transaksi terpilih | Konfirmasi + hapus |
| **EDIT** | Mengedit transaksi terpilih | Membuka dialog edit |
| **REFRESH** | Memperbarui tampilan | Update dashboard & tabel |

---

## 7. Dialog Tambah/Edit Transaksi

### 7.1 Struktur Dialog

```
┌─────────────────────────────────────────┐
│         Tambah Transaksi                │
├─────────────────────────────────────────┤
│                                         │
│  Tipe:       [▼ Pemasukan          ]    │
│                                         │
│  Jumlah:     [_____________________ ]   │
│                                         │
│  Tanggal:    [2025-11-23 14:30:00  ]    │
│                                         │
│  Keterangan:                            │
│  ┌─────────────────────────────────┐    │
│  │                                 │    │
│  │                                 │    │
│  └─────────────────────────────────┘    │
│                                         │
│         [Simpan]      [Batal]           │
│                                         │
└─────────────────────────────────────────┘
```

### 7.2 Komponen Dialog

| Komponen | Tipe | Keterangan |
|----------|------|------------|
| Tipe | JComboBox | Dropdown: "Pemasukan" atau "Pengeluaran" |
| Jumlah | JTextField | Input angka (tanpa "Rp") |
| Tanggal | JTextField | Auto-fill dengan tanggal sekarang |
| Keterangan | JTextArea | Input multi-baris |
| Simpan | JButton | Validasi dan simpan data |
| Batal | JButton | Tutup dialog tanpa simpan |

### 7.3 Validasi Input

- Jumlah harus berupa angka positif
- Keterangan tidak boleh kosong
- Tanggal harus dalam format yang valid

### 7.4 Screenshot Dialog

Lihat file:
- `Tampilan/pemasukan.png` - Dialog tambah pemasukan
- `Tampilan/pengeluaran.png` - Dialog tambah pengeluaran

---

## 8. Interaksi Pengguna

### 8.1 Alur Menambah Transaksi

```
┌────────────┐     ┌────────────────┐     ┌────────────────┐
│ User klik  │ --> │ Dialog muncul  │ --> │ User isi form  │
│  TAMBAH    │     │                │     │                │
└────────────┘     └────────────────┘     └────────────────┘
                                                   │
                                                   ▼
┌────────────┐     ┌────────────────┐     ┌────────────────┐
│ Tampilan   │ <-- │ Data tersimpan │ <-- │ User klik      │
│ ter-update │     │ ke file        │     │ SIMPAN         │
└────────────┘     └────────────────┘     └────────────────┘
```

### 8.2 Alur Menghapus Transaksi

```
┌────────────┐     ┌────────────────┐     ┌────────────────┐
│ User pilih │ --> │ User klik      │ --> │ Dialog         │
│ baris tabel│     │ HAPUS          │     │ konfirmasi     │
└────────────┘     └────────────────┘     └────────────────┘
                                                   │
                                                   ▼
┌────────────┐     ┌────────────────┐     ┌────────────────┐
│ Tampilan   │ <-- │ Data dihapus   │ <-- │ User klik      │
│ ter-update │     │ dari file      │     │ "Ya"           │
└────────────┘     └────────────────┘     └────────────────┘
```

### 8.3 Screenshot Hapus

Lihat file: `Tampilan/hapusData.png`

---

## 9. Fitur Tambahan

### 9.1 Auto-Save

- Data otomatis tersimpan saat menutup aplikasi
- Data otomatis tersimpan setelah setiap operasi (tambah/edit/hapus)

### 9.2 Auto-Load

- Data otomatis dimuat saat membuka aplikasi
- Tidak perlu import manual

### 9.3 Format Rupiah

- Angka ditampilkan dalam format Indonesia: `Rp 1.348.000`
- Tanda +/- untuk selisih bulanan: `+ Rp 148.000` atau `- Rp 50.000`

### 9.4 Format Tanggal

- Input: `2025-11-23 14:30:00`
- Display: `23 Nov 2025, 14:30`

---

## 10. Screenshot Lengkap

### 10.1 Daftar File Screenshot

| File | Keterangan |
|------|------------|
| `Tampilan/DashboardUtama.png` | Tampilan utama aplikasi dengan dashboard dan tabel |
| `Tampilan/pemasukan.png` | Dialog tambah transaksi pemasukan |
| `Tampilan/pengeluaran.png` | Dialog tambah transaksi pengeluaran |
| `Tampilan/hapusData.png` | Konfirmasi hapus data |

### 10.2 Lokasi Screenshot

```
Tampilan/
├── DashboardUtama.png    # Main screen
├── hapusData.png         # Delete confirmation
├── pemasukan.png         # Add income dialog
└── pengeluaran.png       # Add expense dialog
```

---

## 11. Responsive Design

### 11.1 Ukuran Window

- **Default Size**: 1200 x 700 piksel
- **Resizable**: Ya, window bisa di-resize
- **Minimum Size**: Tidak ada batasan (tergantung konten)

### 11.2 Layout Manager

| Komponen | Layout Manager | Keterangan |
|----------|----------------|------------|
| MainFrame | BorderLayout | NORTH + CENTER |
| DashboardPanel | GridLayout(1,4) | 4 kolom sejajar |
| ButtonPanel | FlowLayout(CENTER) | Tombol di tengah |
| TablePanel | BorderLayout | JScrollPane di CENTER |

---

## 12. User Experience (UX)

### 12.1 Kemudahan Penggunaan

- **Intuitif**: Layout jelas dengan label yang deskriptif
- **Feedback Visual**: Warna berbeda untuk income (hijau) dan expense (merah)
- **Konfirmasi**: Dialog konfirmasi sebelum hapus data
- **Auto-fill**: Tanggal otomatis terisi dengan waktu sekarang

### 12.2 Accessibility

- **Font Size**: Cukup besar untuk mudah dibaca
- **Color Contrast**: Warna kontras tinggi (putih di atas warna gelap)
- **Keyboard Navigation**: Bisa navigasi dengan Tab dan Enter

---

## 13. Demo Langsung (Live Demo)

### 13.1 Skenario Demo

1. **Tampilkan aplikasi** - Tunjukkan dashboard dan tabel kosong/berisi
2. **Tambah Pemasukan** - Demo tambah transaksi "Gaji" Rp 5.000.000
3. **Tambah Pengeluaran** - Demo tambah transaksi "Belanja" Rp 500.000
4. **Lihat Dashboard** - Tunjukkan perubahan saldo dan ringkasan
5. **Edit Transaksi** - Demo ubah jumlah transaksi
6. **Hapus Transaksi** - Demo hapus dengan konfirmasi
7. **Refresh** - Demo tombol refresh
8. **Tutup & Buka Lagi** - Demo auto-save dan auto-load

### 13.2 Checklist Demo

- [ ] Aplikasi terbuka dengan normal
- [ ] Dashboard menampilkan 4 kotak info
- [ ] Tabel menampilkan data transaksi
- [ ] Tombol TAMBAH membuka dialog
- [ ] Data tersimpan setelah tambah
- [ ] Dashboard update setelah tambah transaksi
- [ ] Tombol EDIT bekerja dengan benar
- [ ] Tombol HAPUS menampilkan konfirmasi
- [ ] Tombol REFRESH memperbarui tampilan
- [ ] Data tersimpan saat tutup aplikasi

---

## 14. Kesimpulan

Tampilan GUI aplikasi ini dirancang dengan prinsip:

1. **Sederhana** - Tidak ada fitur yang membingungkan
2. **Informatif** - Dashboard memberikan gambaran cepat kondisi keuangan
3. **Intuitif** - User langsung tahu cara menggunakan
4. **Konsisten** - Warna dan layout konsisten di seluruh aplikasi
5. **Responsive** - Bisa di-resize sesuai kebutuhan

Semua komponen GUI dibuat menggunakan **Java Swing** tanpa library eksternal, sehingga aplikasi ringan dan mudah dijalankan di berbagai platform.

---

**Demikian presentasi Tampilan GUI dari saya. Dengan ini, presentasi kelompok kami telah selesai.**

**Apakah ada pertanyaan dari Bapak/Ibu dosen atau rekan-rekan sekalian?**

*Terima kasih atas perhatiannya.*

---

## 15. Penutup Kelompok

### Anggota Kelompok:

| No | Nama | Bagian Presentasi |
|----|------|-------------------|
| 1 | [Nama Anggota 1] | Latar Belakang |
| 2 | [Nama Anggota 2] | Diagram UML |
| 3 | [Nama Anggota 3] | Code (Model & Utility) |
| 4 | [Nama Anggota 4] | Code (View & Main) |
| 5 | [Nama Anggota 5] | Tampilan GUI |

### Repository:
- GitHub: [URL Repository]
- Replit: [URL Replit Project]

### Teknologi:
- Java SE 11+
- Java Swing
- File I/O (txt)

---

*Terima kasih telah menyimak presentasi kami.*
