# SKRIP VIDEO PRESENTASI: Tampilan GUI Aplikasi
## Durasi: 10-15 Menit | Presenter: [Nama Anggota 5]

---

## OPENING (0:00 - 1:00)

**[TAMPILKAN: Slide judul "Tampilan GUI Aplikasi"]**

> "Assalamualaikum warahmatullahi wabarakatuh. Selamat pagi/siang/sore, Bapak/Ibu dosen dan rekan-rekan sekalian."

> "Perkenalkan, nama saya [NAMA LENGKAP], dengan NIM [NIM]. Saya adalah anggota terakhir dari kelompok [NOMOR KELOMPOK] yang akan mempresentasikan proyek ini."

> "Melanjutkan presentasi dari rekan-rekan saya sebelumnya, kali ini saya akan menjelaskan dan MENDEMONSTRASIKAN TAMPILAN GUI dari aplikasi Manajemen Keuangan Sederhana."

**[TAMPILKAN: Outline presentasi]**

> "Presentasi saya akan mencakup: teknologi GUI yang digunakan, penjelasan komponen-komponen tampilan, dan yang paling penting adalah DEMO LANGSUNG aplikasi."

> "Mari kita mulai."

---

## BAGIAN 1: TEKNOLOGI GUI (1:00 - 2:00)

**[TAMPILKAN: Slide "Java Swing"]**

> "Aplikasi ini dibangun menggunakan JAVA SWING sebagai framework GUI. Java Swing adalah library GUI yang sudah built-in di Java SE, jadi tidak memerlukan library eksternal tambahan."

**[TAMPILKAN: Keunggulan Java Swing]**

> "Ada beberapa keunggulan menggunakan Java Swing."

> "Pertama, CROSS-PLATFORM. Aplikasi bisa berjalan di Windows, Linux, dan macOS dengan tampilan yang konsisten."

> "Kedua, LOOK AND FEEL yang bisa disesuaikan. Dalam aplikasi kami, tampilan mengikuti gaya native sistem operasi."

> "Ketiga, KOMPONEN LENGKAP. Swing menyediakan berbagai komponen seperti button, table, dialog, dan lain-lain yang siap pakai."

**[TAMPILKAN: Daftar komponen yang digunakan]**

> "Komponen Swing yang kami gunakan meliputi: JFrame untuk window utama, JPanel untuk container, JTable untuk tabel data, JButton untuk tombol, JLabel untuk teks, JTextField dan JTextArea untuk input, JComboBox untuk dropdown, JDialog untuk pop-up, dan JScrollPane untuk scroll."

---

## BAGIAN 2: LAYOUT APLIKASI (2:00 - 3:30)

**[TAMPILKAN: Screenshot tampilan utama aplikasi]**

> "Ini adalah tampilan utama dari aplikasi kami. Mari kita bahas struktur layoutnya."

**[HIGHLIGHT: Bagian atas - Dashboard]**

> "Di bagian ATAS terdapat DASHBOARD yang menampilkan empat kotak informasi keuangan."

> "Kotak pertama berwarna BIRU menampilkan UANG SEKARANG atau saldo saat ini."

> "Kotak kedua berwarna HIJAU menampilkan UANG MASUK atau total pemasukan bulan ini."

> "Kotak ketiga berwarna MERAH menampilkan UANG KELUAR atau total pengeluaran bulan ini."

> "Kotak keempat berwarna ORANYE menampilkan UANG BULAN INI atau selisih antara pemasukan dan pengeluaran."

**[HIGHLIGHT: Tombol-tombol]**

> "Di bawah dashboard terdapat empat tombol aksi: TAMBAH untuk menambah transaksi baru, HAPUS untuk menghapus transaksi, EDIT untuk mengubah transaksi, dan REFRESH untuk memperbarui tampilan."

**[HIGHLIGHT: Bagian tengah - Tabel]**

> "Di bagian TENGAH terdapat TABEL TRANSAKSI yang menampilkan daftar semua transaksi. Tabel ini memiliki empat kolom: Tipe, Jumlah, Tanggal, dan Keterangan."

> "Perhatikan bahwa baris dengan warna HIJAU menunjukkan transaksi pemasukan, sedangkan baris dengan warna MERAH menunjukkan transaksi pengeluaran. Ini memudahkan pengguna untuk membedakan jenis transaksi secara visual."

---

## BAGIAN 3: DIALOG INPUT (3:30 - 5:00)

**[TAMPILKAN: Screenshot dialog Tambah Transaksi]**

> "Ketika user mengklik tombol TAMBAH, akan muncul dialog seperti ini."

**[HIGHLIGHT: Form input]**

> "Di bagian atas terdapat dropdown TIPE untuk memilih jenis transaksi, yaitu Pemasukan atau Pengeluaran."

> "Kemudian ada field JUMLAH untuk memasukkan nominal uang. User cukup memasukkan angka tanpa simbol Rupiah."

> "Field TANGGAL sudah otomatis terisi dengan tanggal dan waktu saat ini, tapi user bisa mengubahnya jika diperlukan."

> "Terakhir ada field KETERANGAN untuk menjelaskan transaksi, misalnya 'Gaji bulanan' atau 'Belanja mingguan'."

**[HIGHLIGHT: Tombol Simpan dan Batal]**

> "Di bagian bawah ada tombol SIMPAN untuk menyimpan transaksi dan tombol BATAL untuk membatalkan."

**[TAMPILKAN: Screenshot pemasukan dan pengeluaran]**

> "Ini adalah contoh saat menambah transaksi PEMASUKAN, dan ini adalah contoh saat menambah transaksi PENGELUARAN. Perhatikan bahwa form-nya sama, hanya pilihan tipenya yang berbeda."

---

## BAGIAN 4: KONFIRMASI HAPUS (5:00 - 5:30)

**[TAMPILKAN: Screenshot dialog konfirmasi hapus]**

> "Ketika user ingin menghapus transaksi, akan muncul dialog KONFIRMASI seperti ini."

> "Dialog ini bertujuan untuk MENCEGAH penghapusan yang tidak disengaja. User harus mengklik YA untuk mengonfirmasi penghapusan atau TIDAK untuk membatalkan."

> "Ini adalah contoh GOOD UX PRACTICE dalam desain aplikasi."

---

## BAGIAN 5: DEMO APLIKASI - PERSIAPAN (5:30 - 6:00)

**[TAMPILKAN: Aplikasi running]**

> "Sekarang, saya akan melakukan DEMO LANGSUNG aplikasi. Mari kita lihat bagaimana aplikasi ini bekerja."

> "Saat ini aplikasi sudah terbuka. Dashboard menampilkan data yang sudah ada sebelumnya dari file penyimpanan."

---

## BAGIAN 6: DEMO - MENAMBAH PEMASUKAN (6:00 - 8:00)

**[AKSI: Klik tombol TAMBAH]**

> "Pertama, saya akan menambahkan transaksi PEMASUKAN. Saya klik tombol TAMBAH."

**[AKSI: Dialog muncul]**

> "Dialog input muncul. Untuk Tipe, saya pilih PEMASUKAN."

**[AKSI: Isi form]**

> "Jumlahnya saya isi 5.000.000 atau lima juta rupiah. Ini misalnya adalah gaji bulanan."

> "Tanggal sudah terisi otomatis dengan waktu sekarang, saya biarkan saja."

> "Untuk keterangan, saya tulis 'Gaji bulan November'."

**[AKSI: Klik Simpan]**

> "Sekarang saya klik SIMPAN."

**[TAMPILKAN: Hasil setelah tambah]**

> "Perhatikan perubahan yang terjadi. Di tabel muncul baris baru dengan tipe Pemasukan berwarna hijau."

> "Di dashboard, kotak UANG SEKARANG dan UANG MASUK sudah bertambah sesuai dengan jumlah yang kita masukkan. Kotak UANG BULAN INI juga berubah karena selisih bulanan ikut terpengaruh."

> "Data ini sudah otomatis tersimpan ke file, jadi tidak perlu save manual."

---

## BAGIAN 7: DEMO - MENAMBAH PENGELUARAN (8:00 - 9:30)

**[AKSI: Klik tombol TAMBAH lagi]**

> "Sekarang saya akan menambahkan transaksi PENGELUARAN. Saya klik TAMBAH lagi."

**[AKSI: Isi form pengeluaran]**

> "Untuk Tipe, saya pilih PENGELUARAN."

> "Jumlahnya saya isi 500.000 atau lima ratus ribu rupiah."

> "Keterangan saya tulis 'Belanja bulanan'."

**[AKSI: Klik Simpan]**

> "Saya klik SIMPAN."

**[TAMPILKAN: Hasil setelah tambah pengeluaran]**

> "Sekarang di tabel muncul baris baru dengan tipe Pengeluaran berwarna merah."

> "Perhatikan dashboard. UANG SEKARANG berkurang karena ada pengeluaran. UANG KELUAR bertambah. Dan UANG BULAN INI juga berubah sesuai perhitungan."

> "Di sinilah POLYMORPHISM bekerja. Saat kita menambah Income, saldo bertambah. Saat kita menambah Expense, saldo berkurang. Method process() yang sama menghasilkan efek berbeda."

---

## BAGIAN 8: DEMO - MENGEDIT TRANSAKSI (9:30 - 11:00)

**[AKSI: Pilih baris di tabel]**

> "Sekarang saya akan mengedit transaksi. Pertama, saya pilih baris yang ingin diedit dengan mengkliknya."

**[AKSI: Klik tombol EDIT]**

> "Kemudian saya klik tombol EDIT."

**[AKSI: Dialog edit muncul]**

> "Dialog muncul dengan data transaksi yang sudah terisi. Saya bisa mengubah tipe, jumlah, tanggal, atau keterangan."

> "Misalnya saya ubah jumlahnya menjadi 600.000."

**[AKSI: Klik Simpan]**

> "Saya klik SIMPAN."

**[TAMPILKAN: Hasil setelah edit]**

> "Transaksi sudah berubah. Perhatikan di tabel, jumlahnya sudah diperbarui. Dashboard juga sudah menghitung ulang semua nilai berdasarkan perubahan ini."

> "Ini dimungkinkan karena method recalculateBalance() di FinanceManager yang menghitung ulang saldo dari awal setiap ada perubahan."

---

## BAGIAN 9: DEMO - MENGHAPUS TRANSAKSI (11:00 - 12:00)

**[AKSI: Pilih baris di tabel]**

> "Terakhir, saya akan menghapus transaksi. Saya pilih baris yang ingin dihapus."

**[AKSI: Klik tombol HAPUS]**

> "Saya klik tombol HAPUS."

**[AKSI: Dialog konfirmasi muncul]**

> "Muncul dialog konfirmasi yang menanyakan apakah saya yakin ingin menghapus transaksi ini."

**[AKSI: Klik Ya]**

> "Saya klik YA untuk mengonfirmasi."

**[TAMPILKAN: Hasil setelah hapus]**

> "Transaksi sudah dihapus dari tabel. Dashboard juga sudah diperbarui. Saldo dihitung ulang tanpa transaksi yang dihapus."

---

## BAGIAN 10: DEMO - REFRESH (12:00 - 12:30)

**[AKSI: Klik tombol REFRESH]**

> "Tombol REFRESH berfungsi untuk memperbarui semua tampilan. Ini berguna jika ada perubahan data yang perlu di-refresh."

> "Saya klik REFRESH, dan semua panel diperbarui dengan data terbaru."

---

## BAGIAN 11: DEMO - AUTO SAVE (12:30 - 13:30)

**[TAMPILKAN: Penjelasan auto-save]**

> "Satu fitur penting yang perlu saya jelaskan adalah AUTO SAVE."

> "Setiap kali kita menambah, mengedit, atau menghapus transaksi, data langsung disimpan ke file secara otomatis. Jadi kita tidak perlu khawatir lupa menyimpan."

> "Ketika aplikasi ditutup, data juga disimpan sekali lagi sebagai backup terakhir."

**[AKSI: Tutup aplikasi]**

> "Mari saya demonstrasikan. Saya tutup aplikasi."

**[AKSI: Buka aplikasi lagi]**

> "Sekarang saya buka lagi aplikasinya."

**[TAMPILKAN: Data masih ada]**

> "Perhatikan, semua data transaksi yang kita masukkan tadi masih ada. Dashboard menampilkan nilai yang sama. Ini membuktikan bahwa data tersimpan dengan baik di file lokal."

---

## BAGIAN 12: RINGKASAN FITUR (13:30 - 14:00)

**[TAMPILKAN: Slide ringkasan fitur]**

> "Mari kita rangkum fitur-fitur utama aplikasi ini."

> "Pertama, DASHBOARD INFORMATIF dengan empat kotak berwarna yang menampilkan kondisi keuangan secara real-time."

> "Kedua, TABEL TRANSAKSI dengan warna berbeda untuk memudahkan identifikasi pemasukan dan pengeluaran."

> "Ketiga, operasi TAMBAH, EDIT, dan HAPUS yang mudah dengan validasi input."

> "Keempat, AUTO SAVE yang memastikan data selalu tersimpan."

> "Kelima, tampilan yang SEDERHANA dan INTUITIF sehingga user baru pun bisa langsung menggunakan tanpa kebingungan."

---

## CLOSING (14:00 - 15:00)

**[TAMPILKAN: Slide penutup kelompok]**

> "Demikian presentasi saya mengenai Tampilan GUI dari Aplikasi Manajemen Keuangan Sederhana."

> "Dengan ini, seluruh rangkaian presentasi kelompok kami telah selesai. Izinkan saya merangkum presentasi dari seluruh anggota kelompok."

> "[NAMA ANGGOTA 1] telah menjelaskan latar belakang dan alasan pembuatan aplikasi."

> "[NAMA ANGGOTA 2] telah menjelaskan diagram UML yang menjadi dasar perancangan."

> "[NAMA ANGGOTA 3] dan [NAMA ANGGOTA 4] telah menjelaskan implementasi code dengan penerapan empat prinsip OOP."

> "Dan saya, [NAMA ANDA], telah mendemonstrasikan tampilan GUI dan cara penggunaan aplikasi."

**[TAMPILKAN: Slide anggota kelompok]**

> "Kelompok kami terdiri dari:"
> "1. [Nama Anggota 1] - NIM"
> "2. [Nama Anggota 2] - NIM"
> "3. [Nama Anggota 3] - NIM"
> "4. [Nama Anggota 4] - NIM"
> "5. [Nama Anggota 5/Anda] - NIM"

**[TAMPILKAN: Slide terima kasih]**

> "Kami berharap aplikasi ini dapat menjadi contoh yang baik untuk penerapan konsep Object-Oriented Programming dalam pengembangan software yang nyata."

> "Terima kasih atas perhatian Bapak/Ibu dosen dan rekan-rekan sekalian. Mohon maaf apabila ada kekurangan dalam presentasi kami."

> "Wassalamualaikum warahmatullahi wabarakatuh."

---

## CATATAN TEKNIS UNTUK PEMBUATAN VIDEO

### Persiapan Demo:
1. Pastikan aplikasi sudah berjalan dengan baik
2. Siapkan beberapa data transaksi contoh
3. Test semua fitur sebelum recording
4. Pastikan layar bersih dari notifikasi lain

### Slide yang Dibutuhkan:
1. Slide judul
2. Slide outline
3. Slide "Java Swing"
4. Slide keunggulan Java Swing
5. Slide daftar komponen
6. Slide screenshot tampilan utama
7. Slide screenshot dialog tambah
8. Slide screenshot konfirmasi hapus
9. Slide ringkasan fitur
10. Slide penutup kelompok
11. Slide anggota kelompok
12. Slide terima kasih

### Tips Demo Video:
- Gerakkan cursor dengan perlahan agar penonton bisa mengikuti
- Berikan narasi untuk setiap aksi yang dilakukan
- Beri jeda setelah setiap perubahan agar penonton bisa melihat hasilnya
- Gunakan zoom atau highlight jika perlu
- Pastikan suara narasi jelas dan tidak terlalu cepat
- Rekam di tempat yang tenang tanpa noise background

### Software untuk Rekam Demo:
- OBS Studio (gratis)
- Camtasia
- ScreenPal
- Windows Game Bar (Win+G)
- QuickTime Player (macOS)

### Format Video yang Disarankan:
- Resolusi: 1920x1080 (Full HD)
- Frame rate: 30 fps
- Format: MP4
- Bitrate: 5-10 Mbps untuk kualitas baik
