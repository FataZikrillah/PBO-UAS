# Latar Belakang Aplikasi Manajemen Keuangan Sederhana

## Presentasi oleh: [Nama Anggota 1]

---

## 1. Pendahuluan

Selamat pagi/siang/sore, Bapak/Ibu dosen dan rekan-rekan sekalian.

Perkenalkan, saya [Nama Anggota 1] akan mempresentasikan **latar belakang** dan **alasan** mengapa kelompok kami memilih untuk membuat **Aplikasi Manajemen Keuangan Sederhana** berbasis Java Swing.

---

## 2. Latar Belakang Masalah

### 2.1 Kondisi Masyarakat Saat Ini

Dalam era digital saat ini, **manajemen keuangan pribadi** menjadi semakin penting untuk menjaga stabilitas finansial individu atau keluarga. Namun, banyak orang mengalami kesulitan dalam:

- **Melacak pemasukan dan pengeluaran harian**
- **Mencatat transaksi secara konsisten**
- **Menganalisis pola pengeluaran bulanan**
- **Merencanakan anggaran masa depan**

### 2.2 Masalah yang Sering Terjadi

| No | Masalah | Dampak |
|----|---------|--------|
| 1 | Tidak mencatat pengeluaran | Tidak tahu ke mana uang mengalir |
| 2 | Lupa transaksi kecil | Saldo tidak seimbang di akhir bulan |
| 3 | Tidak ada ringkasan bulanan | Sulit merencanakan budget |
| 4 | Menggunakan kertas/catatan manual | Data mudah hilang dan tidak terorganisir |

### 2.3 Solusi yang Ada di Pasaran

Memang sudah ada aplikasi keuangan modern, namun:

- **Berbasis cloud/mobile** - memerlukan internet terus-menerus
- **Memerlukan registrasi** - data dikirim ke server pihak ketiga
- **Berbayar/berlangganan** - tidak semua orang mampu
- **Terlalu kompleks** - fitur berlebihan yang membingungkan pengguna awam

---

## 3. Alasan Membuat Aplikasi

### 3.1 Kemudahan Akses dan Penggunaan

Aplikasi ini dirancang sebagai **solusi offline sederhana** menggunakan **Java Swing**, sehingga:

- Dapat dijalankan di berbagai perangkat (Windows, Linux, macOS)
- Tidak memerlukan koneksi internet
- Tidak perlu registrasi atau akun
- Gratis dan open-source

### 3.2 Penerapan Konsep OOP (Tujuan Akademis)

Sebagai proyek mata kuliah Pemrograman Berorientasi Objek, aplikasi ini **secara eksplisit menerapkan** prinsip-prinsip OOP:

| Prinsip | Implementasi |
|---------|--------------|
| **Abstraction** | Kelas abstrak `Transaction` menyembunyikan detail implementasi |
| **Inheritance** | Kelas `Income` dan `Expense` mewarisi dari `Transaction` |
| **Polymorphism** | Method `process()` berbeda di setiap subclass |
| **Encapsulation** | Data sensitif (saldo) dilindungi dengan field private |

### 3.3 Fitur Esensial untuk Pengguna Awal

Fokus pada fitur dasar yang **tidak membingungkan**:

- Pencatatan transaksi (masuk/keluar)
- Tampilan saldo saat ini
- Ringkasan keuangan bulanan
- Tampilan tabel dengan warna (hijau untuk pemasukan, merah untuk pengeluaran)

### 3.4 Keamanan dan Privasi Data

- Data disimpan **secara lokal** dalam file teks
- Tidak ada pengiriman data ke server pihak ketiga
- Pengguna memiliki kontrol penuh atas data mereka
- File data dapat di-backup secara manual

### 3.5 Potensi Pengembangan

Aplikasi ini dapat dikembangkan lebih lanjut, seperti:

- Integrasi dengan database (SQLite/PostgreSQL)
- Export laporan ke PDF/Excel
- Grafik trend bulanan
- Multi-user dengan login
- Backup otomatis ke cloud

---

## 4. Tujuan Proyek

### 4.1 Tujuan Utama

1. **Membuat aplikasi praktis** untuk manajemen keuangan pribadi
2. **Mendemonstrasikan penerapan OOP** yang profesional dalam Java
3. **Pembelajaran kolaboratif** dalam tim pengembangan software

### 4.2 Target Pengguna

- Mahasiswa yang ingin belajar mencatat keuangan
- Individu/keluarga kecil yang ingin tracking pengeluaran
- Developer pemula yang ingin belajar Java Swing dan OOP

---

## 5. Manfaat Aplikasi

### 5.1 Manfaat Praktis

- Membantu user mencatat setiap transaksi dengan mudah
- Memberikan gambaran visual tentang kondisi keuangan
- Membantu merencanakan anggaran bulanan
- Menghindari pengeluaran yang tidak terkontrol

### 5.2 Manfaat Edukasi

- Contoh implementasi OOP yang lengkap dan terdokumentasi
- Contoh desain GUI dengan Java Swing
- Contoh arsitektur MVC (Model-View-Controller)
- Referensi belajar untuk mahasiswa informatika

---

## 6. Kesimpulan

Aplikasi Manajemen Keuangan Sederhana ini dibuat dengan **dua tujuan utama**:

1. **Sebagai alat praktis** untuk membantu pengguna mengelola keuangan pribadi dengan mudah, aman, dan offline

2. **Sebagai proyek edukasi** yang mendemonstrasikan implementasi prinsip-prinsip Object-Oriented Programming (OOP) secara profesional menggunakan bahasa Java

Dengan demikian, aplikasi ini tidak hanya bermanfaat untuk penggunaan sehari-hari, tetapi juga menjadi contoh nyata bagaimana konsep-konsep OOP diterapkan dalam pengembangan software yang nyata.

---

## 7. Referensi

- Oracle Java Documentation: https://docs.oracle.com/en/java/
- Java Swing Tutorial: https://docs.oracle.com/javase/tutorial/uiswing/
- OOP Concepts: https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/

---

**Demikian presentasi latar belakang dari saya. Selanjutnya akan dilanjutkan oleh [Nama Anggota 2] yang akan menjelaskan tentang Diagram UML.**

*Terima kasih.*
