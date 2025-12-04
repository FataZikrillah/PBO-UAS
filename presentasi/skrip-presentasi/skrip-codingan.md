# SKRIP VIDEO PRESENTASI: Implementasi Code
## Durasi: 10-15 Menit | Presenter: [Nama Anggota 3] dan [Nama Anggota 4]

---

## OPENING (0:00 - 1:00)

**[TAMPILKAN: Slide judul "Implementasi Code"]**

> **[ANGGOTA 3]:** "Assalamualaikum warahmatullahi wabarakatuh. Selamat pagi/siang/sore, Bapak/Ibu dosen dan rekan-rekan sekalian."

> **[ANGGOTA 3]:** "Perkenalkan, nama saya [NAMA LENGKAP ANGGOTA 3], dengan NIM [NIM], dan rekan saya [NAMA LENGKAP ANGGOTA 4] dengan NIM [NIM]."

> **[ANGGOTA 3]:** "Melanjutkan presentasi dari rekan kami sebelumnya tentang Diagram UML, kali ini kami berdua akan menjelaskan tentang IMPLEMENTASI CODE dari aplikasi Manajemen Keuangan Sederhana."

**[TAMPILKAN: Pembagian tugas]**

> **[ANGGOTA 3]:** "Presentasi kami akan dibagi dua. Saya akan menjelaskan Model Layer dan Utility Layer yang merupakan inti dari penerapan OOP. Selanjutnya, rekan saya [NAMA ANGGOTA 4] akan menjelaskan View Layer dan Main Application."

> **[ANGGOTA 3]:** "Mari kita mulai."

---

# BAGIAN A: MODEL LAYER DAN UTILITY LAYER
## Presenter: [Nama Anggota 3]

---

## BAGIAN 1: STRUKTUR FOLDER (1:00 - 1:30)

**[TAMPILKAN: Struktur folder project]**

> **[ANGGOTA 3]:** "Sebelum masuk ke code, mari kita lihat struktur folder project kami."

> **[ANGGOTA 3]:** "Source code berada di folder src/com/financeapp. Di dalamnya terdapat tiga subfolder."

> **[ANGGOTA 3]:** "Folder MODEL berisi kelas-kelas untuk data dan logika bisnis, yaitu Transaction, Income, Expense, dan FinanceManager."

> **[ANGGOTA 3]:** "Folder VIEW berisi kelas-kelas untuk tampilan GUI, yaitu MainFrame, DashboardPanel, TransactionTablePanel, dan AddEditDialog."

> **[ANGGOTA 3]:** "Folder UTILS berisi kelas-kelas utility, yaitu CurrencyFormatter, DateTimeUtils, dan FileManager."

---

## BAGIAN 2: PRINSIP ABSTRACTION (1:30 - 4:00)

**[TAMPILKAN: Code Transaction.java]**

> **[ANGGOTA 3]:** "Sekarang kita masuk ke implementasi prinsip OOP yang pertama, yaitu ABSTRACTION."

> **[ANGGOTA 3]:** "Ini adalah kelas Transaction.java. Perhatikan kata kunci ABSTRACT di deklarasi kelas."

**[HIGHLIGHT: Deklarasi kelas abstract]**

```java
public abstract class Transaction {
```

> **[ANGGOTA 3]:** "Dengan mendeklarasikan kelas sebagai abstract, kita TIDAK BISA membuat objek langsung dari kelas ini. Kita tidak bisa menulis new Transaction(). Kelas ini hanya bisa menjadi PARENT dari kelas lain."

**[HIGHLIGHT: Field private]**

```java
private double amount;
private String date;
private String description;
```

> **[ANGGOTA 3]:** "Kelas ini memiliki tiga atribut PRIVATE. Amount untuk jumlah uang, date untuk tanggal, dan description untuk keterangan. Semua bersifat private untuk menerapkan ENCAPSULATION."

**[HIGHLIGHT: Constructor]**

```java
public Transaction(double amount, String date, String description) {
    this.amount = amount;
    this.date = date;
    this.description = description;
}
```

> **[ANGGOTA 3]:** "Constructor menerima tiga parameter dan menginisialisasi atribut-atribut tersebut."

**[HIGHLIGHT: Abstract methods]**

```java
public abstract double process(double currentBalance);
public abstract String getType();
```

> **[ANGGOTA 3]:** "Yang paling penting adalah dua method ABSTRACT ini. Method process() akan memproses saldo, dan method getType() akan mengembalikan tipe transaksi."

> **[ANGGOTA 3]:** "Karena ini method abstract, tidak ada implementasinya di sini. Hanya KONTRAK atau signature saja. Semua kelas yang mewarisi Transaction WAJIB mengimplementasikan kedua method ini."

> **[ANGGOTA 3]:** "Inilah esensi dari ABSTRACTION. Kita menyembunyikan detail implementasi dan hanya menunjukkan APA yang harus dilakukan, bukan BAGAIMANA melakukannya."

---

## BAGIAN 3: PRINSIP INHERITANCE (4:00 - 5:30)

**[TAMPILKAN: Code Income.java]**

> **[ANGGOTA 3]:** "Sekarang kita lihat implementasi prinsip INHERITANCE melalui kelas Income.java."

**[HIGHLIGHT: Extends Transaction]**

```java
public class Income extends Transaction {
```

> **[ANGGOTA 3]:** "Perhatikan kata kunci EXTENDS Transaction. Ini berarti kelas Income MEWARISI semua atribut dan method dari kelas Transaction."

**[HIGHLIGHT: Constructor dengan super]**

```java
public Income(double amount, String date, String description) {
    super(amount, date, description);
}
```

> **[ANGGOTA 3]:** "Di constructor, kita memanggil SUPER untuk memanggil constructor parent class. Dengan ini, atribut amount, date, dan description yang ada di Transaction akan diinisialisasi."

**[HIGHLIGHT: Override process()]**

```java
@Override
public double process(double currentBalance) {
    return currentBalance + getAmount();
}
```

> **[ANGGOTA 3]:** "Ini adalah implementasi method process(). Untuk INCOME atau pemasukan, saldo akan DITAMBAH dengan amount. Perhatikan anotasi @Override yang menandakan method ini menimpa method dari parent class."

**[TAMPILKAN: Code Expense.java]**

> **[ANGGOTA 3]:** "Sekarang kita bandingkan dengan kelas Expense.java."

**[HIGHLIGHT: Override process() di Expense]**

```java
@Override
public double process(double currentBalance) {
    return currentBalance - getAmount();
}
```

> **[ANGGOTA 3]:** "Perhatikan perbedaannya. Untuk EXPENSE atau pengeluaran, saldo akan DIKURANGI dengan amount. Method yang sama, yaitu process(), tapi implementasinya BERBEDA."

---

## BAGIAN 4: PRINSIP POLYMORPHISM (5:30 - 7:00)

**[TAMPILKAN: Code FinanceManager.java - method addTransaction]**

> **[ANGGOTA 3]:** "Sekarang kita lihat bagaimana POLYMORPHISM bekerja dalam praktik."

**[HIGHLIGHT: Method addTransaction]**

```java
public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
    currentBalance = transaction.process(currentBalance);
    calculateMonthlySummary();
}
```

> **[ANGGOTA 3]:** "Perhatikan parameter method ini. Tipenya adalah TRANSACTION, yaitu parent class. Artinya, method ini bisa menerima objek APAPUN yang mewarisi Transaction, baik itu Income maupun Expense."

> **[ANGGOTA 3]:** "Ketika kita memanggil transaction.process(currentBalance), Java akan secara otomatis menentukan method mana yang dipanggil berdasarkan TIPE SEBENARNYA dari objek tersebut."

**[TAMPILKAN: Ilustrasi Polymorphism]**

> **[ANGGOTA 3]:** "Mari saya ilustrasikan dengan contoh."

> **[ANGGOTA 3]:** "Misalnya saldo saat ini adalah 1 juta rupiah."

> **[ANGGOTA 3]:** "Jika kita memanggil addTransaction dengan objek Income 500 ribu, maka Income.process() yang dipanggil, dan saldo menjadi 1 juta PLUS 500 ribu sama dengan 1,5 juta."

> **[ANGGOTA 3]:** "Jika kita memanggil addTransaction dengan objek Expense 200 ribu, maka Expense.process() yang dipanggil, dan saldo menjadi 1,5 juta MINUS 200 ribu sama dengan 1,3 juta."

> **[ANGGOTA 3]:** "Inilah kekuatan POLYMORPHISM. Kode yang sama bisa berperilaku berbeda tergantung objek yang diterima."

---

## BAGIAN 5: PRINSIP ENCAPSULATION (7:00 - 8:00)

**[TAMPILKAN: Code FinanceManager.java - fields dan getters]**

> **[ANGGOTA 3]:** "Terakhir untuk bagian saya, mari kita lihat penerapan ENCAPSULATION di kelas FinanceManager."

**[HIGHLIGHT: Private fields]**

```java
private double currentBalance;
private List<Transaction> transactions;
private double monthlyIncome;
private double monthlyExpense;
```

> **[ANGGOTA 3]:** "Semua atribut dideklarasikan sebagai PRIVATE. Ini berarti, tidak ada kelas lain yang bisa mengakses atribut-atribut ini secara langsung."

**[HIGHLIGHT: Getter methods]**

```java
public double getCurrentBalance() { return currentBalance; }
public List<Transaction> getTransactions() { return transactions; }
public double getMonthlyIncome() { return monthlyIncome; }
public double getMonthlyExpense() { return monthlyExpense; }
```

> **[ANGGOTA 3]:** "Untuk membaca data, disediakan method GETTER dengan akses PUBLIC. Ini adalah akses yang TERKONTROL."

**[HIGHLIGHT: Private method]**

```java
private void recalculateBalance() {
    currentBalance = 0.0;
    for (Transaction t : transactions) {
        currentBalance = t.process(currentBalance);
    }
}
```

> **[ANGGOTA 3]:** "Ada juga method PRIVATE yaitu recalculateBalance(). Method ini hanya bisa dipanggil dari dalam kelas FinanceManager sendiri. Ini adalah contoh DATA HIDING yang baik."

> **[ANGGOTA 3]:** "Keuntungan encapsulation adalah: data terlindungi dari perubahan yang tidak diinginkan, dan kita bisa mengubah implementasi internal tanpa mempengaruhi kode di luar kelas."

---

## TRANSISI KE PRESENTER KEDUA (8:00 - 8:15)

> **[ANGGOTA 3]:** "Demikian penjelasan saya tentang Model Layer dan penerapan empat prinsip OOP. Selanjutnya, rekan saya [NAMA ANGGOTA 4] akan menjelaskan View Layer dan Main Application."

---

# BAGIAN B: VIEW LAYER DAN MAIN APPLICATION
## Presenter: [Nama Anggota 4]

---

## BAGIAN 6: MAIN APPLICATION (8:15 - 9:30)

**[TAMPILKAN: Code MainApp.java]**

> **[ANGGOTA 4]:** "Terima kasih [NAMA ANGGOTA 3]. Sekarang saya akan menjelaskan View Layer, dimulai dari kelas MainApp.java yang merupakan entry point aplikasi."

**[HIGHLIGHT: Method main]**

```java
public static void main(String[] args) {
```

> **[ANGGOTA 4]:** "Ini adalah method main, titik awal eksekusi program."

**[HIGHLIGHT: Set Look and Feel]**

```java
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
```

> **[ANGGOTA 4]:** "Pertama, kita mengatur Look and Feel ke tampilan native sistem operasi. Jadi aplikasi akan terlihat seperti aplikasi Windows di Windows, atau seperti aplikasi Mac di macOS."

**[HIGHLIGHT: SwingUtilities.invokeLater]**

```java
SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        FinanceManager manager = new FinanceManager();
        FileManager.loadTransactions(manager);
        MainFrame frame = new MainFrame(manager);
        frame.setVisible(true);
    }
});
```

> **[ANGGOTA 4]:** "Kemudian, kita menjalankan GUI di Event Dispatch Thread atau EDT. Ini adalah BEST PRACTICE untuk Java Swing agar GUI berjalan dengan smooth."

> **[ANGGOTA 4]:** "Di dalam run, pertama kita membuat objek FinanceManager sebagai model. Kedua, kita memuat data dari file dengan FileManager.loadTransactions(). Ketiga, kita membuat MainFrame dan menampilkannya."

---

## BAGIAN 7: MAIN FRAME (9:30 - 11:00)

**[TAMPILKAN: Code MainFrame.java - constructor]**

> **[ANGGOTA 4]:** "Sekarang kita lihat kelas MainFrame.java yang merupakan window utama aplikasi."

**[HIGHLIGHT: Setup frame]**

```java
setTitle("Manajemen Keuangan Sederhana");
setSize(1200, 700);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout(10, 10));
```

> **[ANGGOTA 4]:** "Di constructor, pertama kita mengatur judul window, ukuran 1200 kali 700 piksel, operasi saat ditutup, dan layout menggunakan BorderLayout."

**[HIGHLIGHT: Pembuatan komponen]**

```java
dashboardPanel = new DashboardPanel(manager);
tablePanel = new TransactionTablePanel(manager);
```

> **[ANGGOTA 4]:** "Kemudian kita membuat komponen-komponen utama, yaitu DashboardPanel dan TransactionTablePanel. Perhatikan bahwa objek manager dikirimkan ke kedua panel ini agar mereka bisa mengakses data."

**[TAMPILKAN: Ilustrasi layout]**

> **[ANGGOTA 4]:** "Layout aplikasi menggunakan BorderLayout. Di bagian NORTH terdapat Dashboard dan tombol-tombol. Di bagian CENTER terdapat tabel transaksi."

**[HIGHLIGHT: Event handler tombol]**

```java
JButton addButton = new JButton("TAMBAH");
addButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        handleAdd();
    }
});
```

> **[ANGGOTA 4]:** "Untuk setiap tombol, kita menambahkan ActionListener yang akan dipanggil saat tombol diklik. Contohnya tombol TAMBAH akan memanggil method handleAdd()."

---

## BAGIAN 8: DASHBOARD PANEL (11:00 - 12:00)

**[TAMPILKAN: Code DashboardPanel.java]**

> **[ANGGOTA 4]:** "Sekarang kita lihat DashboardPanel.java yang menampilkan empat kotak informasi keuangan."

**[HIGHLIGHT: GridLayout]**

```java
setLayout(new GridLayout(1, 4, 10, 10));
```

> **[ANGGOTA 4]:** "Panel ini menggunakan GridLayout dengan 1 baris dan 4 kolom. Artinya, keempat kotak info akan tersusun secara horizontal dengan spacing 10 piksel."

**[HIGHLIGHT: Pembuatan kotak info]**

```java
add(createInfoBox("UANG SEKARANG", new Color(52, 152, 219)));  // Biru
add(createInfoBox("UANG MASUK", new Color(46, 204, 113)));     // Hijau
add(createInfoBox("UANG KELUAR", new Color(231, 76, 60)));     // Merah
add(createInfoBox("UANG BULAN INI", new Color(230, 126, 34))); // Oranye
```

> **[ANGGOTA 4]:** "Keempat kotak dibuat dengan warna berbeda. Biru untuk saldo, hijau untuk pemasukan, merah untuk pengeluaran, dan oranye untuk selisih bulanan."

**[HIGHLIGHT: Method updateDashboard]**

```java
public void updateDashboard() {
    balanceLabel.setText(CurrencyFormatter.format(manager.getCurrentBalance()));
    incomeLabel.setText(CurrencyFormatter.format(manager.getMonthlyIncome()));
    expenseLabel.setText(CurrencyFormatter.format(manager.getMonthlyExpense()));
    monthlyLabel.setText(CurrencyFormatter.formatWithSign(manager.getMonthlyBalance()));
}
```

> **[ANGGOTA 4]:** "Method updateDashboard() digunakan untuk memperbarui tampilan. Data diambil dari FinanceManager dan diformat menggunakan CurrencyFormatter untuk tampilan Rupiah."

---

## BAGIAN 9: TRANSACTION TABLE PANEL (12:00 - 13:00)

**[TAMPILKAN: Code TransactionTablePanel.java]**

> **[ANGGOTA 4]:** "TransactionTablePanel.java menampilkan daftar transaksi dalam bentuk tabel."

**[HIGHLIGHT: Pembuatan tabel]**

```java
String[] columns = {"Tipe", "Jumlah", "Tanggal", "Keterangan"};
tableModel = new DefaultTableModel(columns, 0);
table = new JTable(tableModel);
```

> **[ANGGOTA 4]:** "Tabel memiliki empat kolom: Tipe, Jumlah, Tanggal, dan Keterangan. Kita menggunakan DefaultTableModel untuk mengelola data tabel."

**[HIGHLIGHT: Custom renderer untuk warna]**

> **[ANGGOTA 4]:** "Yang menarik adalah custom cell renderer untuk memberikan warna berbeda. Baris pemasukan ditampilkan dengan warna hijau, sedangkan baris pengeluaran dengan warna merah. Ini memudahkan user untuk membedakan jenis transaksi secara visual."

---

## BAGIAN 10: ALUR APLIKASI (13:00 - 14:00)

**[TAMPILKAN: Diagram alur aplikasi]**

> **[ANGGOTA 4]:** "Mari kita rangkum alur lengkap aplikasi."

> **[ANGGOTA 4]:** "SAAT STARTUP: MainApp membuat FinanceManager, FileManager memuat data dari file, MainFrame ditampilkan dengan data yang sudah dimuat."

> **[ANGGOTA 4]:** "SAAT USER MENAMBAH TRANSAKSI: Dialog muncul, user mengisi form, objek Income atau Expense dibuat, FinanceManager memproses dengan polymorphism, tampilan di-refresh, data disimpan ke file."

> **[ANGGOTA 4]:** "SAAT APLIKASI DITUTUP: WindowListener mendeteksi window closing, FileManager menyimpan semua data ke file sebagai auto-save."

---

## CLOSING (14:00 - 15:00)

**[TAMPILKAN: Slide ringkasan]**

> **[ANGGOTA 4]:** "Demikian presentasi kami berdua tentang implementasi code aplikasi Manajemen Keuangan Sederhana."

> **[ANGGOTA 4]:** "[NAMA ANGGOTA 3] telah menjelaskan Model Layer dengan empat prinsip OOP: Abstraction melalui abstract class Transaction, Inheritance melalui Income dan Expense, Polymorphism melalui method process() yang berbeda, dan Encapsulation melalui private fields."

> **[ANGGOTA 4]:** "Saya telah menjelaskan View Layer dengan komponen-komponen GUI seperti MainFrame, DashboardPanel, dan TransactionTablePanel, serta alur aplikasi dari startup hingga shutdown."

> **[ANGGOTA 4]:** "Selanjutnya, rekan kami [NAMA ANGGOTA 5] akan mendemonstrasikan Tampilan GUI aplikasi di video berikutnya."

> **[ANGGOTA 3 & 4]:** "Terima kasih atas perhatiannya. Wassalamualaikum warahmatullahi wabarakatuh."

**[TAMPILKAN: Slide terima kasih]**

---

## CATATAN TEKNIS UNTUK PEMBUATAN VIDEO

### Pembagian Waktu:
- Opening bersama: 1 menit
- Anggota 3 (Model Layer): 7 menit
- Transisi: 15 detik
- Anggota 4 (View Layer): 6 menit
- Closing bersama: 1 menit

### Slide yang Dibutuhkan:
1. Slide judul
2. Slide pembagian tugas
3. Slide struktur folder
4. Slide code Transaction.java (dengan highlight)
5. Slide code Income.java (dengan highlight)
6. Slide code Expense.java (dengan highlight)
7. Slide ilustrasi polymorphism
8. Slide code FinanceManager.java (dengan highlight)
9. Slide code MainApp.java
10. Slide code MainFrame.java
11. Slide ilustrasi layout
12. Slide code DashboardPanel.java
13. Slide code TransactionTablePanel.java
14. Slide diagram alur aplikasi
15. Slide ringkasan
16. Slide terima kasih

### Tips untuk Video Code:
- Gunakan syntax highlighting untuk code
- Highlight bagian yang sedang dijelaskan
- Tampilkan code secara bertahap, bukan sekaligus
- Berikan waktu bagi penonton untuk membaca code
- Gunakan zoom untuk fokus ke bagian penting
