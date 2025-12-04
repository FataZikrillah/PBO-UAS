💰 Aplikasi Manajemen Keuangan Sederhana

Aplikasi desktop berbasis **Java Swing** untuk mengelola keuangan pribadi dengan menerapkan prinsip **Object-Oriented Programming (OOP)** secara lengkap.

## 🎯 Fitur Utama

- ✅ **Dashboard Keuangan** - 4 kotak info: Saldo, Uang Masuk, Uang Keluar, Selisih Bulanan
- ✅ **Tabel Transaksi** - Daftar lengkap transaksi dengan warna (hijau=pemasukan, merah=pengeluaran)
- ✅ **Tambah/Edit/Hapus** - Kelola transaksi dengan mudah
- ✅ **Auto-Save** - Data tersimpan otomatis ke file lokal
- ✅ **Laporan Keuangan** - Ringkasan keuangan instant

## 🎓 Prinsip OOP yang Diterapkan

### 1. **Abstraction** (Abstraksi)
```java
// Kelas abstrak Transaction
public abstract class Transaction {
    private double amount;
    private String date;
    private String description;
    
    public abstract double process(double currentBalance);
    public abstract String getType();
}
```

### 2. **Inheritance** (Pewarisan)
```java
// Income mewarisi Transaction
public class Income extends Transaction {
    // Mewarisi semua field dan method dari Transaction
}

// Expense mewarisi Transaction
public class Expense extends Transaction {
    // Mewarisi semua field dan method dari Transaction
}
```

### 3. **Polymorphism** (Polimorfisme)
```java
// Method yang sama, implementasi berbeda
Income:   process() → menambah saldo
Expense:  process() → mengurangi saldo
```

### 4. **Encapsulation** (Enkapsulasi)
```java
// Field private, akses via getter/setter
private double currentBalance;

public double getCurrentBalance() {
    return currentBalance;
}
```

## 📁 Struktur Project

```
FinancialApp/
├── src/com/financeapp/
│   ├── MainApp.java              # Entry point aplikasi
│   ├── model/                    # Model layer (OOP core)
│   │   ├── Transaction.java      # Abstract class
│   │   ├── Income.java           # Inheritance
│   │   ├── Expense.java          # Inheritance
│   │   └── FinanceManager.java   # Core logic
│   ├── view/                     # View layer (GUI)
│   │   ├── MainFrame.java
│   │   ├── DashboardPanel.java
│   │   ├── TransactionTablePanel.java
│   │   └── AddEditDialog.java
│   └── utils/                    # Utility classes
│       ├── CurrencyFormatter.java
│       ├── DateTimeUtils.java
│       └── FileManager.java
├── data/                         # Data storage
│   └── transactions.txt
└── bin/                          # Compiled classes
```

## 🚀 Cara Menjalankan

### langkah 1 Clone dan Jalankan di Laptop/Komputer Windows
#### opsi 1: Clone Repository dan buka melalu vscode
Masuk ke folder mana saja di laptop atau buat folder baru terus buka terminal di folder nya terus lakuin langkah-langkah dibawah
```bash
# Clone repository ke komputer Anda
git clone https://github.com/FataZikrillah/PBO-UAS.git
```
```bash
cd PBO-UAS
```
```bash
code .
```
#### opsi 2: Clone Repository dan buka melalu intellij IDEA
Masuk ke dalam intellij IDEA di pojok kanan atas ada yang nama nya 'clone repository    '
```bash
# URL nya isi dengan ini
https://github.com/FataZikrillah/PBO-UAS.git
```
Directory nya atur sendiri mau dimana simpan project nya
contoh nya kayak digambar
<img width="1205" height="970" alt="image" src="https://github.com/user-attachments/assets/7f1d3210-ffa2-41cc-a2df-0ce793c37bc8" />



#### Langkah 2: Compile Aplikasi

**(Command Prompt/Terminal):**
```bash
javac -d bin src/com/financeapp/*.java src/com/financeapp/model/*.java src/com/financeapp/view/*.java src/com/financeapp/utils/*.java
```

#### Langkah 3: Jalankan Aplikasi

**Di Windows:**
```cmd
java -cp bin com.financeapp.MainApp
```

#### Langkah 4: Gunakan Aplikasi
- GUI akan muncul secara otomatis
- Mulai tambahkan transaksi keuangan Anda!


## 📖 Cara Menggunakan

### 1️⃣ Tambah Transaksi
1. Klik tombol **TAMBAH**
2. Pilih tipe: Pemasukan atau Pengeluaran
3. Isi jumlah (angka saja, tanpa Rp)
4. Tanggal otomatis terisi (bisa diedit)
5. Isi keterangan
6. Klik **Simpan**

### 2️⃣ Edit Transaksi
1. Klik baris transaksi di tabel
2. Klik tombol **EDIT**
3. Ubah data yang diinginkan
4. Klik **Simpan**

### 3️⃣ Hapus Transaksi
1. Klik baris transaksi di tabel
2. Klik tombol **HAPUS**
3. Konfirmasi penghapusan

### 4️⃣ Lihat Laporan
- Klik tombol **LAPORAN**
- Dialog akan menampilkan ringkasan lengkap

### 5️⃣ Refresh Data
- Klik tombol **REFRESH** untuk update semua panel

## 💾 Penyimpanan Data

Data disimpan secara lokal di file `data/transactions.txt` dengan format:
```
Income|500000|2025-11-23 14:30:00|Gaji bulanan
Expense|150000|2025-11-23 16:45:00|Belanja bulanan
```

- **Auto-save**: Data otomatis tersimpan saat menutup aplikasi
- **Auto-load**: Data otomatis dimuat saat membuka aplikasi
- **Offline**: Tidak perlu koneksi internet

## 🎨 Screenshot Tampilan

### Dashboard
```
┌────────────────┬────────────────┬────────────────┬────────────────┐
│ UANG SEKARANG  │ UANG MASUK     │ UANG KELUAR    │ UANG BULAN INI │
│ Rp 1.348.000   │ Rp 401.000     │ Rp 253.000     │ + Rp 148.000   │
│ (Biru)         │ (Hijau)        │ (Merah)        │ (Oranye)       │
└────────────────┴────────────────┴────────────────┴────────────────┘
```

### Tabel Transaksi
```
┌────────────┬──────────────┬─────────────────────┬─────────────────┐
│ Tipe       │ Jumlah       │ Tanggal             │ Keterangan      │
├────────────┼──────────────┼─────────────────────┼─────────────────┤
│ Pemasukan  │ Rp 401.000   │ 23 Nov 2025, 14:30  │ Gaji bulanan    │
│ Pengeluaran│ Rp 253.000   │ 23 Nov 2025, 16:45  │ Belanja bulanan │
└────────────┴──────────────┴─────────────────────┴─────────────────┘
```

## 🔧 Dependencies

| Library | Version | Purpose |
|---------|---------|---------|
| Java SE | 11+ | Runtime |

## 📝 Technical Details

- **Language**: Java
- **GUI Framework**: Swing
- **Design Pattern**: MVC (Model-View-Controller)
- **OOP Principles**: Abstraction, Inheritance, Polymorphism, Encapsulation
- **Data Storage**: File-based (txt)
- **Platform**: Cross-platform (Windows, Linux, macOS)

## 🎓 Educational Purpose

Aplikasi ini dibuat untuk:
- ✅ Demonstrasi prinsip OOP lengkap
- ✅ Contoh implementasi Java Swing GUI
- ✅ Best practices dalam Java development
- ✅ Clean code & documentation

Semua code dilengkapi dengan **comment dalam Bahasa Indonesia** untuk memudahkan pemahaman.

## 📚 Dokumentasi Lengkap

Lihat file `tahapPembuatan.md` untuk dokumentasi detail tentang:
- Tahap-tahap implementasi
- Fitur yang sudah/belum diimplementasikan
- Cara kerja setiap class
- Testing & validasi

## 🚀 Future Development Ideas

- Export laporan ke PDF
- Import data dari Excel/CSV
- Kategori pengeluaran (Makanan, Transport, dll)
- Grafik line chart untuk trend bulanan
- Multiple account support
- Budget planning & alerts

## 📄 License

Project ini dibuat untuk tujuan edukasi dan pembelajaran OOP dengan Java.

## 👨‍💻 Developer

Dibuat dengan ❤️ menggunakan Java Swing

---

**Version**: 1.0.0  
**Last Updated**: 23 November 2025  
**Status**: Production Ready ✅
