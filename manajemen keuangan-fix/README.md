# 💰 Aplikasi Manajemen Keuangan Sederhana

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

### Opsi 1: Di Replit (Otomatis)
1. Klik tombol **Run** di atas
2. Aplikasi akan otomatis compile dan berjalan
3. GUI muncul di VNC viewer

### Opsi 2: Clone dan Jalankan di Laptop/Komputer Windows

#### Langkah 1: Clone Repository
```bash
# Clone repository ke komputer Anda
git clone <URL_REPOSITORY_INI>
cd <NAMA_FOLDER>
```

Atau **Download ZIP**:
1. Klik tombol "Download ZIP" di repository
2. Extract file ZIP ke folder yang diinginkan
3. Buka Command Prompt/Terminal di folder tersebut

#### Langkah 2: Pastikan Java Terinstal
```bash
# Cek versi Java (minimal Java 11)
java -version
javac -version
```

**Jika Java belum terinstal:**
1. Download Java JDK dari https://www.oracle.com/java/technologies/downloads/
2. Install Java JDK
3. Set PATH environment variable (biasanya otomatis)

#### Langkah 3: Compile Aplikasi

**Di Windows, Linux, atau Mac (Command Prompt/Terminal):**
```bash
javac -d bin src/com/financeapp/*.java src/com/financeapp/model/*.java src/com/financeapp/view/*.java src/com/financeapp/utils/*.java
```

#### Langkah 4: Jalankan Aplikasi

**Di Windows:**
```cmd
java -cp bin com.financeapp.MainApp
```

**Di Linux/Mac:**
```bash
java -cp bin com.financeapp.MainApp
```

#### Langkah 5: Gunakan Aplikasi
- GUI akan muncul secara otomatis
- Mulai tambahkan transaksi keuangan Anda!

### Opsi 3: Jalankan dengan IDE (NetBeans/IntelliJ/Eclipse)

#### NetBeans:
1. Buka NetBeans
2. File → Open Project → Pilih folder project ini
3. Klik kanan `MainApp.java` → Run File

#### IntelliJ IDEA:
1. Buka IntelliJ IDEA
2. File → Open → Pilih folder project ini
3. Klik kanan `MainApp.java` → Run 'MainApp.main()'

#### Eclipse:
1. Buka Eclipse
2. File → Import → Existing Projects into Workspace
3. Pilih folder project ini → Finish
4. Klik kanan `MainApp.java` → Run As → Java Application

#### VS Code:
1. Buka VS Code
2. Install Extension Pack for Java
3. Open Folder → Pilih folder project ini
4. VS Code akan otomatis detect project Java
5. Klik Run pada `MainApp.java`

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
