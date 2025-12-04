# Implementasi Code - Aplikasi Manajemen Keuangan Sederhana

## Presentasi oleh: [Nama Anggota 3] dan [Nama Anggota 4]

---

## 1. Pendahuluan

Selamat pagi/siang/sore, Bapak/Ibu dosen dan rekan-rekan sekalian.

Perkenalkan, kami [Nama Anggota 3] dan [Nama Anggota 4] akan mempresentasikan **implementasi code** dari aplikasi ini.

Presentasi akan dibagi menjadi 2 bagian:
- **[Nama Anggota 3]**: Model Layer dan Utility Layer (OOP Core)
- **[Nama Anggota 4]**: View Layer dan Main Application

---

# BAGIAN 1: Model Layer dan Utility Layer
## Presenter: [Nama Anggota 3]

---

## 2. Struktur Folder Project

```
src/com/financeapp/
├── MainApp.java              # Entry point aplikasi
├── model/                    # Model layer (OOP core)
│   ├── Transaction.java      # Abstract class
│   ├── Income.java           # Inheritance
│   ├── Expense.java          # Inheritance
│   └── FinanceManager.java   # Core logic
├── view/                     # View layer (GUI)
│   ├── MainFrame.java
│   ├── DashboardPanel.java
│   ├── TransactionTablePanel.java
│   └── AddEditDialog.java
└── utils/                    # Utility classes
    ├── CurrencyFormatter.java
    ├── DateTimeUtils.java
    └── FileManager.java
```

---

## 3. Implementasi Prinsip ABSTRACTION

### 3.1 Kelas Transaction.java (Abstract Class)

```java
package com.financeapp.model;

/**
 * Kelas abstrak Transaction - menerapkan prinsip ABSTRACTION dalam OOP
 * Kelas ini menyembunyikan detail implementasi dan mendefinisikan kontrak
 * yang harus diikuti oleh semua jenis transaksi
 */
public abstract class Transaction {
    
    // ENCAPSULATION: Semua field bersifat private untuk melindungi data
    private double amount;        // Jumlah uang dalam transaksi
    private String date;          // Tanggal transaksi (format: YYYY-MM-DD HH:mm:ss)
    private String description;   // Keterangan/deskripsi transaksi
    
    /**
     * Constructor untuk membuat objek Transaction
     */
    public Transaction(double amount, String date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
    
    // Getter dan Setter untuk ENCAPSULATION
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    /**
     * ABSTRACTION & POLYMORPHISM:
     * Method abstrak yang harus diimplementasikan oleh setiap subclass
     * Setiap jenis transaksi akan memproses saldo dengan cara berbeda
     */
    public abstract double process(double currentBalance);
    
    /**
     * Method abstrak untuk mendapatkan tipe transaksi
     */
    public abstract String getType();
}
```

### 3.2 Penjelasan ABSTRACTION

| Aspek | Penjelasan |
|-------|------------|
| **Kelas Abstract** | `Transaction` tidak bisa di-instantiate langsung |
| **Method Abstract** | `process()` dan `getType()` harus di-override oleh subclass |
| **Kontrak** | Semua transaksi harus bisa "memproses" saldo dan "memberitahu tipe"nya |
| **Menyembunyikan Detail** | Subclass yang menentukan bagaimana proses dilakukan |

---

## 4. Implementasi Prinsip INHERITANCE

### 4.1 Kelas Income.java

```java
package com.financeapp.model;

/**
 * Kelas Income - menerapkan prinsip INHERITANCE dan POLYMORPHISM
 * Kelas ini mewarisi dari Transaction dan mengimplementasikan method process()
 * dengan cara spesifik untuk transaksi pemasukan
 */
public class Income extends Transaction {
    
    /**
     * Constructor - memanggil constructor parent class
     */
    public Income(double amount, String date, String description) {
        super(amount, date, description);  // Memanggil constructor Transaction
    }
    
    /**
     * POLYMORPHISM: Override method process()
     * Implementasi spesifik untuk Income - MENAMBAHKAN amount ke saldo
     */
    @Override
    public double process(double currentBalance) {
        return currentBalance + getAmount();  // PEMASUKAN = saldo + amount
    }
    
    /**
     * Override method getType()
     */
    @Override
    public String getType() {
        return "Income";
    }
}
```

### 4.2 Kelas Expense.java

```java
package com.financeapp.model;

/**
 * Kelas Expense - menerapkan prinsip INHERITANCE dan POLYMORPHISM
 * Kelas ini mewarisi dari Transaction dan mengimplementasikan method process()
 * dengan cara spesifik untuk transaksi pengeluaran
 */
public class Expense extends Transaction {
    
    /**
     * Constructor - memanggil constructor parent class
     */
    public Expense(double amount, String date, String description) {
        super(amount, date, description);  // Memanggil constructor Transaction
    }
    
    /**
     * POLYMORPHISM: Override method process()
     * Implementasi spesifik untuk Expense - MENGURANGI amount dari saldo
     */
    @Override
    public double process(double currentBalance) {
        return currentBalance - getAmount();  // PENGELUARAN = saldo - amount
    }
    
    /**
     * Override method getType()
     */
    @Override
    public String getType() {
        return "Expense";
    }
}
```

### 4.3 Perbandingan Income vs Expense

| Aspek | Income | Expense |
|-------|--------|---------|
| **Extends** | Transaction | Transaction |
| **process()** | `currentBalance + amount` | `currentBalance - amount` |
| **getType()** | return "Income" | return "Expense" |
| **Efek ke Saldo** | Menambah saldo | Mengurangi saldo |

---

## 5. Implementasi Prinsip POLYMORPHISM

### 5.1 Polymorphism dalam FinanceManager.java

```java
/**
 * Menambahkan transaksi baru ke dalam sistem
 * POLYMORPHISM: Menerima objek Transaction (bisa Income atau Expense)
 * Method process() akan dipanggil sesuai tipe transaksi yang sebenarnya
 */
public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
    
    // POLYMORPHISM: Memanggil method process() yang sudah di-override
    // - Jika transaction adalah Income  -> panggil Income.process()
    // - Jika transaction adalah Expense -> panggil Expense.process()
    currentBalance = transaction.process(currentBalance);
    
    calculateMonthlySummary();
}
```

### 5.2 Cara Kerja Polymorphism

```
Skenario: currentBalance = Rp 1.000.000

Kasus 1: Menambah Income Rp 500.000
┌─────────────────────────────────────────────┐
│ manager.addTransaction(new Income(500000))  │
│                     ↓                       │
│ currentBalance = transaction.process(...)   │
│                     ↓                       │
│ Income.process() dipanggil                  │
│ return 1.000.000 + 500.000 = 1.500.000     │
└─────────────────────────────────────────────┘
Hasil: currentBalance = Rp 1.500.000

Kasus 2: Menambah Expense Rp 200.000
┌─────────────────────────────────────────────┐
│ manager.addTransaction(new Expense(200000)) │
│                     ↓                       │
│ currentBalance = transaction.process(...)   │
│                     ↓                       │
│ Expense.process() dipanggil                 │
│ return 1.500.000 - 200.000 = 1.300.000     │
└─────────────────────────────────────────────┘
Hasil: currentBalance = Rp 1.300.000
```

---

## 6. Implementasi Prinsip ENCAPSULATION

### 6.1 Encapsulation dalam FinanceManager.java

```java
public class FinanceManager {
    
    // ENCAPSULATION: Semua field PRIVATE untuk keamanan data
    private double currentBalance;              // Saldo saat ini
    private List<Transaction> transactions;     // Daftar semua transaksi
    private double monthlyIncome;               // Total pemasukan bulan ini
    private double monthlyExpense;              // Total pengeluaran bulan ini
    
    // Constructor - inisialisasi data awal
    public FinanceManager() {
        this.currentBalance = 0.0;
        this.transactions = new ArrayList<>();
        this.monthlyIncome = 0.0;
        this.monthlyExpense = 0.0;
    }
    
    // ENCAPSULATION: Getter untuk akses read-only ke data private
    public double getCurrentBalance() { return currentBalance; }
    public List<Transaction> getTransactions() { return transactions; }
    public double getMonthlyIncome() { return monthlyIncome; }
    public double getMonthlyExpense() { return monthlyExpense; }
    public double getMonthlyBalance() { return monthlyIncome - monthlyExpense; }
    
    // Method untuk manipulasi data (controlled access)
    public void addTransaction(Transaction transaction) { ... }
    public void deleteTransaction(int index) { ... }
    public void editTransaction(int index, Transaction newTransaction) { ... }
    
    // Method PRIVATE - hanya bisa dipanggil dari dalam kelas ini
    private void recalculateBalance() {
        currentBalance = 0.0;
        for (Transaction t : transactions) {
            currentBalance = t.process(currentBalance);
        }
    }
}
```

### 6.2 Keuntungan Encapsulation

| Aspek | Penjelasan |
|-------|------------|
| **Data Protection** | Field private tidak bisa diakses langsung dari luar |
| **Controlled Access** | Akses hanya melalui getter/setter yang terdefinisi |
| **Validation** | Bisa tambahkan validasi di setter jika diperlukan |
| **Maintainability** | Perubahan internal tidak mempengaruhi kode external |

---

## 7. Utility Classes

### 7.1 CurrencyFormatter.java

```java
public class CurrencyFormatter {
    
    // Format angka ke Rupiah: "Rp 1.348.000"
    public static String format(double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        df.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("id", "ID")));
        return "Rp " + df.format(amount);
    }
    
    // Format dengan tanda +/-: "+ Rp 148.000" atau "- Rp 50.000"
    public static String formatWithSign(double amount) {
        String sign = amount >= 0 ? "+ " : "- ";
        return sign + format(Math.abs(amount));
    }
}
```

### 7.2 FileManager.java

```java
public class FileManager {
    private static final String FILE_PATH = "data/transactions.txt";
    
    // Simpan transaksi ke file
    public static void saveTransactions(FinanceManager manager) {
        // Format: TYPE|AMOUNT|DATE|DESCRIPTION
        // Contoh: Income|500000|2025-11-23 14:30:00|Gaji bulanan
    }
    
    // Load transaksi dari file
    public static void loadTransactions(FinanceManager manager) {
        // Baca file dan parse setiap baris
        // Buat objek Income atau Expense sesuai tipe
    }
}
```

---

# BAGIAN 2: View Layer dan Main Application
## Presenter: [Nama Anggota 4]

---

## 8. MainApp.java - Entry Point

```java
package com.financeapp;

public class MainApp {
    
    public static void main(String[] args) {
        // Set Look and Feel ke sistem operasi (tampilan native)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Jalankan GUI di Event Dispatch Thread (EDT) - best practice Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Buat instance FinanceManager (Model)
                FinanceManager manager = new FinanceManager();
                
                // Load data dari file (jika ada)
                FileManager.loadTransactions(manager);
                
                // Buat dan tampilkan Main Frame (View)
                MainFrame frame = new MainFrame(manager);
                frame.setVisible(true);
            }
        });
    }
}
```

---

## 9. MainFrame.java - Window Utama

### 9.1 Struktur Layout

```java
public class MainFrame extends JFrame {
    
    private FinanceManager manager;
    private DashboardPanel dashboardPanel;
    private TransactionTablePanel tablePanel;
    
    public MainFrame(FinanceManager manager) {
        this.manager = manager;
        
        // Setup frame
        setTitle("Manajemen Keuangan Sederhana");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Set layout BorderLayout
        setLayout(new BorderLayout(10, 10));
        
        // Buat komponen
        dashboardPanel = new DashboardPanel(manager);
        tablePanel = new TransactionTablePanel(manager);
        
        // Susun komponen
        // NORTH: Dashboard + Tombol
        // CENTER: Tabel Transaksi
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(dashboardPanel, BorderLayout.NORTH);
        topPanel.add(createButtonPanel(), BorderLayout.CENTER);
        
        add(topPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
    }
}
```

### 9.2 Ilustrasi Layout

```
┌──────────────────────────────────────────────────────────┐
│                    MainFrame (JFrame)                     │
├──────────────────────────────────────────────────────────┤
│ NORTH:                                                    │
│ ┌────────────────────────────────────────────────────┐   │
│ │           DashboardPanel (4 kotak info)            │   │
│ ├────────────┬───────────┬───────────┬──────────────┤   │
│ │   UANG     │   UANG    │   UANG    │    UANG      │   │
│ │  SEKARANG  │   MASUK   │  KELUAR   │  BULAN INI   │   │
│ │  (BIRU)    │  (HIJAU)  │  (MERAH)  │   (ORANYE)   │   │
│ └────────────┴───────────┴───────────┴──────────────┘   │
│ ┌────────────────────────────────────────────────────┐   │
│ │    [TAMBAH]  [HAPUS]  [EDIT]  [REFRESH]            │   │
│ └────────────────────────────────────────────────────┘   │
├──────────────────────────────────────────────────────────┤
│ CENTER:                                                   │
│ ┌────────────────────────────────────────────────────┐   │
│ │           TransactionTablePanel (JTable)            │   │
│ │  ┌──────────┬──────────┬──────────┬─────────────┐  │   │
│ │  │   Tipe   │  Jumlah  │  Tanggal │  Keterangan │  │   │
│ │  ├──────────┼──────────┼──────────┼─────────────┤  │   │
│ │  │ Pemasukan│ Rp 500K  │ 23 Nov   │ Gaji        │  │   │
│ │  │Pengeluaran│ Rp 200K │ 24 Nov   │ Belanja     │  │   │
│ │  └──────────┴──────────┴──────────┴─────────────┘  │   │
│ └────────────────────────────────────────────────────┘   │
└──────────────────────────────────────────────────────────┘
```

---

## 10. DashboardPanel.java - Panel Info Keuangan

```java
public class DashboardPanel extends JPanel {
    
    private FinanceManager manager;
    private JLabel balanceLabel, incomeLabel, expenseLabel, monthlyLabel;
    
    public DashboardPanel(FinanceManager manager) {
        this.manager = manager;
        
        // Layout: GridLayout 1 baris, 4 kolom
        setLayout(new GridLayout(1, 4, 10, 10));
        
        // Buat 4 kotak info dengan warna berbeda
        add(createInfoBox("UANG SEKARANG", new Color(52, 152, 219)));  // Biru
        add(createInfoBox("UANG MASUK", new Color(46, 204, 113)));     // Hijau
        add(createInfoBox("UANG KELUAR", new Color(231, 76, 60)));     // Merah
        add(createInfoBox("UANG BULAN INI", new Color(230, 126, 34))); // Oranye
        
        updateDashboard();  // Update nilai awal
    }
    
    // Update tampilan dengan data terbaru
    public void updateDashboard() {
        balanceLabel.setText(CurrencyFormatter.format(manager.getCurrentBalance()));
        incomeLabel.setText(CurrencyFormatter.format(manager.getMonthlyIncome()));
        expenseLabel.setText(CurrencyFormatter.format(manager.getMonthlyExpense()));
        monthlyLabel.setText(CurrencyFormatter.formatWithSign(manager.getMonthlyBalance()));
    }
}
```

---

## 11. TransactionTablePanel.java - Tabel Transaksi

```java
public class TransactionTablePanel extends JPanel {
    
    private FinanceManager manager;
    private JTable table;
    private DefaultTableModel tableModel;
    
    public TransactionTablePanel(FinanceManager manager) {
        this.manager = manager;
        
        // Kolom tabel
        String[] columns = {"Tipe", "Jumlah", "Tanggal", "Keterangan"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        
        // Custom renderer untuk warna
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(...) {
                // Hijau untuk Income, Merah untuk Expense
                if (value.equals("Pemasukan")) {
                    setForeground(new Color(46, 204, 113));  // Hijau
                } else if (value.equals("Pengeluaran")) {
                    setForeground(new Color(231, 76, 60));   // Merah
                }
                return this;
            }
        });
        
        add(new JScrollPane(table));
        refreshTable();
    }
    
    // Refresh data tabel
    public void refreshTable() {
        tableModel.setRowCount(0);  // Clear table
        for (Transaction t : manager.getTransactions()) {
            Object[] row = {
                t.getType().equals("Income") ? "Pemasukan" : "Pengeluaran",
                CurrencyFormatter.format(t.getAmount()),
                DateTimeUtils.formatForDisplay(t.getDate()),
                t.getDescription()
            };
            tableModel.addRow(row);
        }
    }
}
```

---

## 12. AddEditDialog.java - Dialog Input

```java
public class AddEditDialog extends JDialog {
    
    private JComboBox<String> cmbType;
    private JTextField txtAmount;
    private JTextField txtDate;
    private JTextArea txtDescription;
    private Transaction result;
    
    public AddEditDialog(Frame parent) {
        super(parent, "Tambah Transaksi", true);
        createForm();
    }
    
    private void createForm() {
        // ComboBox untuk tipe transaksi
        cmbType = new JComboBox<>(new String[]{"Pemasukan", "Pengeluaran"});
        
        // TextField untuk jumlah
        txtAmount = new JTextField();
        
        // TextField untuk tanggal (auto-fill dengan tanggal sekarang)
        txtDate = new JTextField(DateTimeUtils.getCurrentDateTime());
        
        // TextArea untuk keterangan
        txtDescription = new JTextArea(3, 20);
        
        // Tombol Simpan
        JButton saveButton = new JButton("Simpan");
        saveButton.addActionListener(e -> saveTransaction());
    }
    
    private void saveTransaction() {
        // Validasi input
        if (txtAmount.getText().isEmpty() || txtDescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            return;
        }
        
        // Buat objek transaksi sesuai tipe
        double amount = Double.parseDouble(txtAmount.getText());
        String type = (String) cmbType.getSelectedItem();
        
        if (type.equals("Pemasukan")) {
            result = new Income(amount, txtDate.getText(), txtDescription.getText());
        } else {
            result = new Expense(amount, txtDate.getText(), txtDescription.getText());
        }
        
        dispose();  // Tutup dialog
    }
    
    public Transaction getTransaction() {
        return result;
    }
}
```

---

## 13. Event Handling - Tombol TAMBAH

```java
// Di MainFrame.java
private void handleAdd() {
    // Buka dialog
    AddEditDialog dialog = new AddEditDialog(this);
    dialog.setVisible(true);
    
    // Ambil hasil (Transaction object atau null)
    Transaction transaction = dialog.getTransaction();
    
    if (transaction != null) {
        // Tambahkan ke manager (POLYMORPHISM terjadi di sini)
        manager.addTransaction(transaction);
        
        // Refresh tampilan
        refreshAll();
        
        // Simpan ke file
        FileManager.saveTransactions(manager);
    }
}
```

---

## 14. Alur Lengkap Aplikasi

```
┌─────────────────────────────────────────────────────────────┐
│                     STARTUP APLIKASI                        │
├─────────────────────────────────────────────────────────────┤
│ 1. MainApp.main() dipanggil                                 │
│ 2. Set Look and Feel ke sistem                              │
│ 3. Jalankan di EDT (Event Dispatch Thread)                  │
│ 4. Buat FinanceManager (model)                              │
│ 5. FileManager.loadTransactions() - load data dari file    │
│ 6. Buat MainFrame (view)                                    │
│ 7. frame.setVisible(true) - tampilkan window                │
└─────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────┐
│                    USER INTERACTION                          │
├─────────────────────────────────────────────────────────────┤
│ User klik TAMBAH:                                           │
│   → AddEditDialog muncul                                    │
│   → User isi form                                           │
│   → Buat Income/Expense object                              │
│   → manager.addTransaction() - POLYMORPHISM                 │
│   → refreshAll() - update dashboard & tabel                 │
│   → FileManager.saveTransactions() - simpan ke file        │
├─────────────────────────────────────────────────────────────┤
│ User klik EDIT:                                             │
│   → Ambil transaksi terpilih dari tabel                     │
│   → AddEditDialog muncul dengan data lama                   │
│   → User ubah data                                          │
│   → manager.editTransaction() - RECALCULATE saldo           │
│   → refreshAll() - update tampilan                          │
│   → FileManager.saveTransactions()                          │
├─────────────────────────────────────────────────────────────┤
│ User klik HAPUS:                                            │
│   → Konfirmasi penghapusan                                  │
│   → manager.deleteTransaction() - RECALCULATE saldo         │
│   → refreshAll() - update tampilan                          │
│   → FileManager.saveTransactions()                          │
└─────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────┐
│                    SHUTDOWN APLIKASI                         │
├─────────────────────────────────────────────────────────────┤
│ 1. User tutup window (klik X)                               │
│ 2. WindowListener.windowClosing() dipanggil                 │
│ 3. FileManager.saveTransactions() - auto-save terakhir      │
│ 4. Aplikasi ditutup                                         │
└─────────────────────────────────────────────────────────────┘
```

---

## 15. Ringkasan Implementasi OOP

| Prinsip | File | Implementasi |
|---------|------|--------------|
| **Abstraction** | Transaction.java | Abstract class dengan abstract method |
| **Inheritance** | Income.java, Expense.java | extends Transaction |
| **Polymorphism** | FinanceManager.java | transaction.process() berbeda tiap subclass |
| **Encapsulation** | Semua model class | Private fields + getter/setter |

---

## 16. Kesimpulan

Implementasi code aplikasi ini meliputi:

1. **Model Layer** - Menerapkan 4 prinsip OOP secara lengkap
2. **View Layer** - GUI Java Swing dengan layout yang rapi
3. **Utility Layer** - Helper functions untuk formatting dan file I/O
4. **MVC Pattern** - Separation of concerns yang jelas

Semua code dilengkapi dengan **comment dalam Bahasa Indonesia** untuk memudahkan pemahaman.

---

**Demikian presentasi implementasi code dari kami. Selanjutnya akan dilanjutkan oleh [Nama Anggota 5] yang akan mendemonstrasikan Tampilan GUI Aplikasi.**

*Terima kasih.*
