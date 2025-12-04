# SKRIP VIDEO PRESENTASI: Diagram UML
## Durasi: 10-15 Menit | Presenter: [Nama Anggota 2]

---

## OPENING (0:00 - 1:00)

**[TAMPILKAN: Slide judul "Diagram UML - Aplikasi Manajemen Keuangan"]**

> "Assalamualaikum warahmatullahi wabarakatuh. Selamat pagi/siang/sore, Bapak/Ibu dosen dan rekan-rekan sekalian."

> "Perkenalkan, nama saya [NAMA LENGKAP], dengan NIM [NIM]. Saya adalah anggota dari kelompok [NOMOR KELOMPOK]."

> "Melanjutkan presentasi dari rekan saya sebelumnya tentang latar belakang, kali ini saya akan menjelaskan tentang DIAGRAM UML yang digunakan dalam perancangan aplikasi Manajemen Keuangan Sederhana ini."

**[TAMPILKAN: Outline presentasi]**

> "Presentasi saya akan mencakup: penjelasan tentang UML, Class Diagram, Entity Relationship Diagram, Sequence Diagram, Use Case Diagram, dan bagaimana prinsip OOP tercermin dalam diagram-diagram tersebut."

> "Mari kita mulai."

---

## BAGIAN 1: PENGENALAN UML (1:00 - 2:30)

**[TAMPILKAN: Slide "Apa itu UML?"]**

> "Sebelum masuk ke diagram, izinkan saya menjelaskan terlebih dahulu apa itu UML."

> "UML adalah singkatan dari Unified Modeling Language, yaitu bahasa pemodelan standar yang digunakan untuk merancang dan mendokumentasikan sistem software."

**[TAMPILKAN: Kegunaan UML]**

> "UML memiliki beberapa kegunaan penting dalam pengembangan software."

> "Pertama, untuk MERANCANG STRUKTUR software sebelum mulai coding."

> "Kedua, untuk MEMVISUALISASIKAN arsitektur sistem secara keseluruhan."

> "Ketiga, untuk MENDOKUMENTASIKAN design pattern dan keputusan desain."

> "Keempat, untuk BERKOMUNIKASI antar anggota tim pengembangan."

**[TAMPILKAN: Jenis diagram UML]**

> "UML memiliki banyak jenis diagram. Dalam proyek ini, kami menggunakan empat jenis diagram utama, yaitu: Class Diagram, Entity Relationship Diagram atau ERD, Sequence Diagram, dan Use Case Diagram."

---

## BAGIAN 2: CLASS DIAGRAM (2:30 - 7:00)

**[TAMPILKAN: Slide "Class Diagram"]**

> "Diagram pertama yang akan saya jelaskan adalah Class Diagram. Class Diagram adalah diagram yang menunjukkan struktur STATIS dari sistem, termasuk kelas-kelas yang ada, atribut dan method setiap kelas, serta hubungan antar kelas."

**[TAMPILKAN: Class Diagram lengkap aplikasi]**

> "Ini adalah Class Diagram lengkap dari aplikasi kami. Mari kita bahas satu per satu."

### Bagian Model Layer (3:00 - 4:30)

**[HIGHLIGHT: Kelas Transaction]**

> "Pertama, kita lihat kelas TRANSACTION. Kelas ini adalah ABSTRACT CLASS yang menjadi dasar untuk semua jenis transaksi."

> "Perhatikan bahwa kelas ini memiliki tiga atribut PRIVATE, yaitu: amount untuk jumlah uang, date untuk tanggal transaksi, dan description untuk keterangan."

> "Kelas ini juga memiliki method abstrak yaitu process() dan getType(). Artinya, setiap kelas yang mewarisi Transaction WAJIB mengimplementasikan kedua method ini."

> "Di sinilah prinsip ABSTRACTION diterapkan. Kelas Transaction menyembunyikan detail implementasi dan hanya mendefinisikan KONTRAK yang harus dipenuhi oleh subclass."

**[HIGHLIGHT: Kelas Income dan Expense]**

> "Selanjutnya, kelas INCOME dan EXPENSE. Kedua kelas ini MEWARISI atau EXTENDS dari kelas Transaction."

> "Perhatikan tanda panah dengan ujung segitiga kosong yang mengarah dari Income dan Expense ke Transaction. Ini menunjukkan hubungan INHERITANCE atau pewarisan."

> "Kelas Income mengimplementasikan method process() dengan cara MENAMBAHKAN amount ke saldo. Sedangkan kelas Expense mengimplementasikan method yang sama dengan cara MENGURANGI amount dari saldo."

> "Di sinilah prinsip POLYMORPHISM diterapkan. Method yang sama, yaitu process(), memiliki perilaku yang BERBEDA di setiap subclass."

**[HIGHLIGHT: Kelas FinanceManager]**

> "Kelas berikutnya adalah FINANCEMANAGER. Kelas ini bertindak sebagai controller yang mengelola semua data keuangan."

> "Kelas ini memiliki atribut private seperti currentBalance untuk saldo saat ini, transactions berupa list transaksi, monthlyIncome, dan monthlyExpense."

> "Perhatikan bahwa semua field bersifat PRIVATE dan diakses melalui GETTER method. Ini adalah penerapan prinsip ENCAPSULATION."

> "Ada juga method PRIVATE yaitu recalculateBalance() yang hanya bisa dipanggil dari dalam kelas ini. Ini menunjukkan data hiding yang baik."

### Bagian View Layer (4:30 - 5:30)

**[HIGHLIGHT: Kelas-kelas View]**

> "Selanjutnya, kita lihat kelas-kelas di layer VIEW atau tampilan."

> "MainFrame adalah window utama aplikasi yang berisi DashboardPanel dan TransactionTablePanel."

> "DashboardPanel adalah panel yang menampilkan empat kotak informasi keuangan: saldo saat ini, pemasukan bulan ini, pengeluaran bulan ini, dan selisih bulanan."

> "TransactionTablePanel adalah panel yang menampilkan tabel daftar transaksi."

> "AddEditDialog adalah dialog pop-up untuk menambah atau mengedit transaksi."

### Bagian Utility Layer (5:30 - 6:00)

**[HIGHLIGHT: Kelas-kelas Utility]**

> "Di layer utility, terdapat tiga kelas helper."

> "CurrencyFormatter untuk memformat angka ke format Rupiah."

> "DateTimeUtils untuk mengolah format tanggal."

> "FileManager untuk menyimpan dan memuat data dari file."

> "Ketiga kelas ini bersifat UTILITY dengan method-method STATIC."

### Penjelasan Relasi (6:00 - 7:00)

**[TAMPILKAN: Legenda relasi UML]**

> "Sekarang mari kita lihat jenis-jenis RELASI dalam Class Diagram ini."

> "Pertama, garis dengan panah segitiga kosong menunjukkan INHERITANCE. Contohnya Income extends Transaction."

> "Kedua, garis dengan diamond hitam menunjukkan COMPOSITION, artinya objek yang satu MEMILIKI objek lain dan tidak bisa ada tanpanya. Contohnya FinanceManager memiliki Transaction."

> "Ketiga, garis biasa dengan panah menunjukkan ASSOCIATION atau penggunaan. Contohnya DashboardPanel menggunakan FinanceManager."

> "Keempat, garis putus-putus menunjukkan DEPENDENCY. Contohnya MainApp membuat MainFrame."

---

## BAGIAN 3: ENTITY RELATIONSHIP DIAGRAM (7:00 - 8:30)

**[TAMPILKAN: ERD aplikasi]**

> "Diagram kedua adalah Entity Relationship Diagram atau ERD. Diagram ini menunjukkan hubungan antar ENTITAS data dalam sistem."

**[HIGHLIGHT: Entitas-entitas]**

> "Dalam aplikasi kami, terdapat empat entitas utama."

> "FINANCE_MANAGER adalah entitas yang mengelola keuangan. Atributnya meliputi currentBalance, monthlyIncome, dan monthlyExpense."

> "TRANSACTION adalah entitas transaksi dengan atribut amount, date, description, dan type."

> "INCOME adalah entitas khusus untuk transaksi pemasukan."

> "EXPENSE adalah entitas khusus untuk transaksi pengeluaran."

**[HIGHLIGHT: Relasi antar entitas]**

> "FINANCE_MANAGER mengelola banyak TRANSACTION. Ini adalah relasi ONE TO MANY."

> "TRANSACTION bisa berupa INCOME atau EXPENSE. Ini menunjukkan hubungan inheritance dalam bentuk ERD."

---

## BAGIAN 4: SEQUENCE DIAGRAM (8:30 - 11:30)

**[TAMPILKAN: Slide "Sequence Diagram"]**

> "Diagram ketiga adalah Sequence Diagram. Diagram ini menunjukkan ALUR INTERAKSI antar objek dalam urutan waktu tertentu."

### Sequence Diagram - Tambah Transaksi (8:30 - 10:00)

**[TAMPILKAN: Sequence Diagram Tambah Transaksi]**

> "Ini adalah Sequence Diagram untuk proses MENAMBAH TRANSAKSI. Mari kita ikuti alurnya."

> "Langkah pertama: User mengklik tombol TAMBAH di MainFrame."

> "Langkah kedua: MainFrame membuat objek AddEditDialog baru dan menampilkannya."

> "Langkah ketiga: User mengisi form dan mengklik tombol Simpan."

> "Langkah keempat: AddEditDialog melakukan validasi input. Jika input tidak valid, akan muncul pesan error."

> "Langkah kelima: Jika input valid, AddEditDialog membuat objek Transaction baru. Bisa berupa Income atau Expense tergantung pilihan user."

> "Langkah keenam: Transaction dikembalikan ke MainFrame."

> "Langkah ketujuh: MainFrame memanggil method addTransaction() pada FinanceManager."

> "Langkah kedelapan: Di sinilah POLYMORPHISM terjadi. FinanceManager memanggil method process() pada transaction. Jika itu Income, saldo akan bertambah. Jika Expense, saldo akan berkurang."

> "Langkah kesembilan: FinanceManager menghitung ringkasan bulanan."

> "Langkah kesepuluh: MainFrame menyimpan data ke file melalui FileManager."

> "Langkah terakhir: MainFrame me-refresh tampilan dan menampilkan pesan sukses ke user."

### Sequence Diagram - Hapus Transaksi (10:00 - 11:30)

**[TAMPILKAN: Sequence Diagram Hapus Transaksi]**

> "Ini adalah Sequence Diagram untuk proses MENGHAPUS TRANSAKSI."

> "Langkah pertama: User memilih baris transaksi di tabel."

> "Langkah kedua: User mengklik tombol HAPUS."

> "Langkah ketiga: MainFrame menampilkan dialog konfirmasi. Ini penting untuk mencegah penghapusan tidak sengaja."

> "Langkah keempat: Jika user mengkonfirmasi dengan klik Ya, MainFrame mengambil index baris yang dipilih dari TransactionTablePanel."

> "Langkah kelima: MainFrame memanggil deleteTransaction() pada FinanceManager dengan parameter index."

> "Langkah keenam: FinanceManager menghapus transaksi dari list."

> "Langkah ketujuh: FinanceManager menghitung ulang saldo dari awal dengan method recalculateBalance(). Ini memastikan saldo selalu akurat."

> "Langkah kedelapan: FinanceManager menghitung ulang ringkasan bulanan."

> "Langkah kesembilan: MainFrame menyimpan data ke file."

> "Langkah terakhir: MainFrame me-refresh tampilan."

---

## BAGIAN 5: USE CASE DIAGRAM (11:30 - 12:30)

**[TAMPILKAN: Use Case Diagram]**

> "Diagram keempat adalah Use Case Diagram. Diagram ini menunjukkan FUNGSIONALITAS apa saja yang tersedia untuk pengguna."

**[HIGHLIGHT: Actor dan Use Cases]**

> "Actor utama dalam sistem ini adalah USER, yaitu pengguna aplikasi."

> "User dapat melakukan enam aksi utama."

> "Pertama, TAMBAH TRANSAKSI untuk menambahkan pemasukan atau pengeluaran baru."

> "Kedua, EDIT TRANSAKSI untuk mengubah transaksi yang sudah ada."

> "Ketiga, HAPUS TRANSAKSI untuk menghapus transaksi dengan konfirmasi."

> "Keempat, LIHAT DASHBOARD untuk melihat ringkasan keuangan."

> "Kelima, LIHAT DAFTAR TRANSAKSI untuk melihat semua transaksi dalam tabel."

> "Keenam, REFRESH DATA untuk memperbarui tampilan."

**[HIGHLIGHT: Relasi Include]**

> "Perhatikan bahwa aksi Tambah dan Edit memiliki relasi INCLUDE ke Validasi Input. Artinya, setiap kali user menambah atau mengedit, sistem akan melakukan validasi terlebih dahulu."

> "Semua aksi yang mengubah data juga memiliki relasi INCLUDE ke Simpan ke File. Ini memastikan data selalu tersimpan."

---

## BAGIAN 6: OOP DALAM DIAGRAM (12:30 - 14:00)

**[TAMPILKAN: Slide ringkasan OOP]**

> "Sekarang mari kita rangkum bagaimana keempat prinsip OOP tercermin dalam diagram-diagram yang sudah kita bahas."

**[TAMPILKAN: Abstraction]**

> "ABSTRACTION ditunjukkan oleh kelas abstrak Transaction dalam Class Diagram. Kelas ini menyembunyikan detail implementasi dengan mendefinisikan method abstrak process() dan getType()."

**[TAMPILKAN: Inheritance]**

> "INHERITANCE ditunjukkan oleh panah extends dari Income dan Expense ke Transaction. Kedua subclass mewarisi semua atribut dan method dari parent class."

**[TAMPILKAN: Polymorphism]**

> "POLYMORPHISM ditunjukkan dalam Sequence Diagram, tepatnya saat FinanceManager memanggil transaction.process(). Method yang sama dipanggil, tetapi hasilnya berbeda tergantung apakah objeknya Income atau Expense."

**[TAMPILKAN: Encapsulation]**

> "ENCAPSULATION ditunjukkan oleh tanda minus di depan atribut dalam Class Diagram, yang berarti PRIVATE. Data hanya bisa diakses melalui method getter yang ditandai dengan tanda plus."

---

## BAGIAN 7: DESIGN PATTERN MVC (14:00 - 14:30)

**[TAMPILKAN: Slide MVC Pattern]**

> "Selain prinsip OOP, aplikasi ini juga menerapkan design pattern MVC atau Model-View-Controller."

> "MODEL terdiri dari Transaction, Income, Expense, dan FinanceManager yang mengelola data dan logika bisnis."

> "VIEW terdiri dari MainFrame, DashboardPanel, TransactionTablePanel, dan AddEditDialog yang menampilkan antarmuka ke user."

> "CONTROLLER berfungsi menghubungkan Model dan View, dalam hal ini dijalankan oleh MainApp dan FinanceManager."

> "Keuntungan MVC adalah separation of concerns, yaitu pemisahan tanggung jawab yang membuat kode lebih mudah di-maintain dan dikembangkan."

---

## CLOSING (14:30 - 15:00)

**[TAMPILKAN: Slide penutup]**

> "Demikian presentasi saya mengenai Diagram UML dari Aplikasi Manajemen Keuangan Sederhana."

> "Kita telah membahas Class Diagram yang menunjukkan struktur kelas, ERD yang menunjukkan relasi data, Sequence Diagram yang menunjukkan alur proses, dan Use Case Diagram yang menunjukkan fungsionalitas sistem."

> "Selanjutnya, rekan saya [NAMA ANGGOTA 3] dan [NAMA ANGGOTA 4] akan menjelaskan tentang implementasi code di video berikutnya."

> "Terima kasih atas perhatiannya."

> "Wassalamualaikum warahmatullahi wabarakatuh."

**[TAMPILKAN: Slide terima kasih]**

---

## CATATAN TEKNIS UNTUK PEMBUATAN VIDEO

### Slide yang Dibutuhkan:
1. Slide judul
2. Slide outline
3. Slide "Apa itu UML?"
4. Slide kegunaan UML
5. Slide jenis diagram UML
6. Slide Class Diagram lengkap
7. Slide zoom ke Model Layer
8. Slide zoom ke View Layer
9. Slide zoom ke Utility Layer
10. Slide legenda relasi
11. Slide ERD
12. Slide Sequence Diagram - Tambah Transaksi
13. Slide Sequence Diagram - Hapus Transaksi
14. Slide Use Case Diagram
15. Slide ringkasan OOP (4 slide)
16. Slide MVC Pattern
17. Slide penutup

### Tips Khusus untuk Diagram:
- Gunakan animasi highlight untuk menunjukkan bagian yang sedang dijelaskan
- Zoom in ke bagian tertentu saat menjelaskan detail
- Gunakan pointer atau cursor untuk menunjuk elemen diagram
- Berikan jeda setelah menampilkan diagram baru agar penonton bisa memahami
