# Diagram UML - Aplikasi Manajemen Keuangan Sederhana

## Presentasi oleh: [Nama Anggota 2]

---

## 1. Pendahuluan

Selamat pagi/siang/sore, Bapak/Ibu dosen dan rekan-rekan sekalian.

Perkenalkan, saya [Nama Anggota 2] akan mempresentasikan **Diagram UML** yang digunakan dalam perancangan aplikasi ini.

---

## 2. Apa itu UML?

**UML (Unified Modeling Language)** adalah bahasa pemodelan standar yang digunakan untuk:

- Merancang struktur software
- Memvisualisasikan arsitektur sistem
- Mendokumentasikan design pattern
- Berkomunikasi antar anggota tim

---

## 3. Class Diagram

### 3.1 Penjelasan Class Diagram

Class Diagram menunjukkan **struktur statis** dari sistem, termasuk:
- Kelas-kelas yang ada
- Atribut dan method setiap kelas
- Hubungan antar kelas

### 3.2 Diagram (Mermaid Format)

```mermaid
classDiagram
    %% ========================================
    %% MODEL LAYER - Menerapkan 4 Prinsip OOP
    %% ========================================
    
    class Transaction {
        <<abstract>>
        -double amount
        -String date
        -String description
        +Transaction(amount, date, description)
        +getAmount() double
        +setAmount(amount) void
        +getDate() String
        +setDate(date) void
        +getDescription() String
        +setDescription(description) void
        +process(currentBalance)* double
        +getType()* String
    }
    
    class Income {
        +Income(amount, date, description)
        +process(currentBalance) double
        +getType() String
    }
    
    class Expense {
        +Expense(amount, date, description)
        +process(currentBalance) double
        +getType() String
    }
    
    class FinanceManager {
        -double currentBalance
        -List~Transaction~ transactions
        -double monthlyIncome
        -double monthlyExpense
        +FinanceManager()
        +addTransaction(transaction) void
        +deleteTransaction(index) void
        +editTransaction(index, newTransaction) void
        -recalculateBalance() void
        +calculateMonthlySummary() void
        +getCurrentBalance() double
        +getTransactions() List~Transaction~
        +getMonthlyIncome() double
        +getMonthlyExpense() double
        +getMonthlyBalance() double
    }
    
    %% ========================================
    %% VIEW LAYER - GUI Components
    %% ========================================
    
    class MainFrame {
        -FinanceManager manager
        -DashboardPanel dashboardPanel
        -TransactionTablePanel tablePanel
        +MainFrame(manager)
        -createButtonPanel() JPanel
        -handleAdd() void
        -handleDelete() void
        -handleEdit() void
        -handleRefresh() void
        -refreshAll() void
    }
    
    class DashboardPanel {
        -FinanceManager manager
        -JLabel balanceLabel
        -JLabel incomeLabel
        -JLabel expenseLabel
        -JLabel monthlyLabel
        +DashboardPanel(manager)
        -createInfoBox(title, value, color, name) JPanel
        +updateDashboard() void
    }
    
    class TransactionTablePanel {
        -FinanceManager manager
        -JTable table
        -DefaultTableModel tableModel
        +TransactionTablePanel(manager)
        +refreshTable() void
        +getSelectedRow() int
    }
    
    class AddEditDialog {
        -JComboBox~String~ cmbType
        -JTextField txtAmount
        -JTextField txtDate
        -JTextArea txtDescription
        -Transaction result
        +AddEditDialog(parent)
        +AddEditDialog(parent, transaction)
        -createForm() void
        -saveTransaction() void
        +getTransaction() Transaction
    }
    
    %% ========================================
    %% UTILITY LAYER
    %% ========================================
    
    class CurrencyFormatter {
        <<utility>>
        +format(amount)$ String
        +formatWithSign(amount)$ String
        +formatNumber(amount)$ String
    }
    
    class DateTimeUtils {
        <<utility>>
        +getCurrentDateTime()$ String
        +formatStandard(dateTime)$ String
        +formatForDisplay(dateTime)$ String
        +parse(dateString)$ LocalDateTime
    }
    
    class FileManager {
        <<utility>>
        -String FILE_PATH$
        +saveTransactions(manager)$ void
        +loadTransactions(manager)$ void
    }
    
    class MainApp {
        <<main>>
        +main(args)$ void
    }
    
    %% ========================================
    %% RELATIONSHIPS
    %% ========================================
    
    %% Inheritance (extends)
    Transaction <|-- Income : extends
    Transaction <|-- Expense : extends
    
    %% Composition (contains)
    FinanceManager "1" *-- "0..*" Transaction : contains
    MainFrame "1" *-- "1" DashboardPanel : contains
    MainFrame "1" *-- "1" TransactionTablePanel : contains
    
    %% Association (uses)
    MainFrame --> FinanceManager : uses
    DashboardPanel --> FinanceManager : uses
    TransactionTablePanel --> FinanceManager : uses
    AddEditDialog --> Transaction : creates
    
    %% Dependency (depends on)
    MainApp ..> MainFrame : creates
    MainFrame ..> FileManager : uses
    DashboardPanel ..> CurrencyFormatter : uses
    TransactionTablePanel ..> CurrencyFormatter : uses
```

### 3.3 Penjelasan Kelas Utama

| Kelas | Tipe | Fungsi |
|-------|------|--------|
| `Transaction` | Abstract Class | Base class untuk semua transaksi |
| `Income` | Concrete Class | Transaksi pemasukan (menambah saldo) |
| `Expense` | Concrete Class | Transaksi pengeluaran (mengurangi saldo) |
| `FinanceManager` | Controller | Mengelola semua data keuangan |
| `MainFrame` | View | Window utama aplikasi |
| `DashboardPanel` | View | Panel 4 kotak info keuangan |
| `TransactionTablePanel` | View | Tabel daftar transaksi |
| `AddEditDialog` | View | Dialog untuk tambah/edit transaksi |

---

## 4. Entity Relationship Diagram (ERD)

### 4.1 Diagram ERD

```mermaid
erDiagram
    FINANCE_MANAGER ||--o{ TRANSACTION : manages
    TRANSACTION ||--|| INCOME : "is a"
    TRANSACTION ||--|| EXPENSE : "is a"
    
    FINANCE_MANAGER {
        double currentBalance
        double monthlyIncome
        double monthlyExpense
    }
    
    TRANSACTION {
        double amount
        string date
        string description
        string type
    }
    
    INCOME {
        double amount
        string date
        string description
    }
    
    EXPENSE {
        double amount
        string date
        string description
    }
```

### 4.2 Penjelasan Relasi

- **FINANCE_MANAGER** mengelola banyak **TRANSACTION** (one-to-many)
- **TRANSACTION** bisa berupa **INCOME** atau **EXPENSE** (inheritance)
- Setiap transaksi memiliki atribut: amount, date, description

---

## 5. Sequence Diagram

### 5.1 Sequence Diagram - Tambah Transaksi

```mermaid
sequenceDiagram
    actor User
    participant MainFrame
    participant AddEditDialog
    participant Transaction
    participant FinanceManager
    participant FileManager
    
    User->>MainFrame: Klik tombol "TAMBAH"
    MainFrame->>AddEditDialog: new AddEditDialog()
    AddEditDialog->>User: Tampilkan form dialog
    User->>AddEditDialog: Isi form & klik "Simpan"
    AddEditDialog->>AddEditDialog: Validasi input
    
    alt Input Valid
        AddEditDialog->>Transaction: new Income/Expense()
        Transaction-->>AddEditDialog: objek transaksi
        AddEditDialog-->>MainFrame: return transaction
        MainFrame->>FinanceManager: addTransaction(transaction)
        FinanceManager->>Transaction: process(currentBalance)
        Note right of Transaction: POLYMORPHISM:<br/>Income menambah saldo<br/>Expense mengurangi saldo
        Transaction-->>FinanceManager: saldo baru
        FinanceManager->>FinanceManager: calculateMonthlySummary()
        MainFrame->>FileManager: saveTransactions()
        FileManager-->>MainFrame: saved
        MainFrame->>MainFrame: refreshAll()
        MainFrame->>User: Tampilkan pesan sukses
    else Input Tidak Valid
        AddEditDialog->>User: Tampilkan pesan error
    end
```

### 5.2 Sequence Diagram - Hapus Transaksi

```mermaid
sequenceDiagram
    actor User
    participant MainFrame
    participant TransactionTablePanel
    participant FinanceManager
    participant FileManager
    
    User->>TransactionTablePanel: Pilih baris transaksi
    User->>MainFrame: Klik tombol "HAPUS"
    MainFrame->>User: Tampilkan dialog konfirmasi
    User->>MainFrame: Konfirmasi "Ya"
    MainFrame->>TransactionTablePanel: getSelectedRow()
    TransactionTablePanel-->>MainFrame: index baris
    MainFrame->>FinanceManager: deleteTransaction(index)
    FinanceManager->>FinanceManager: transactions.remove(index)
    FinanceManager->>FinanceManager: recalculateBalance()
    FinanceManager->>FinanceManager: calculateMonthlySummary()
    MainFrame->>FileManager: saveTransactions()
    FileManager-->>MainFrame: saved
    MainFrame->>MainFrame: refreshAll()
    MainFrame->>User: Tampilkan pesan sukses
```

---

## 6. Use Case Diagram

### 6.1 Diagram Use Case

```mermaid
graph TD
    User((User))
    
    User --> UC1[Tambah Transaksi]
    User --> UC2[Edit Transaksi]
    User --> UC3[Hapus Transaksi]
    User --> UC4[Lihat Dashboard]
    User --> UC5[Lihat Daftar Transaksi]
    User --> UC6[Refresh Data]
    
    UC1 --> Validate[Validasi Input]
    UC2 --> Validate
    UC1 --> Save[Simpan ke File]
    UC2 --> Save
    UC3 --> Save
```

### 6.2 Daftar Use Case

| No | Use Case | Deskripsi |
|----|----------|-----------|
| 1 | Tambah Transaksi | User menambahkan transaksi baru (income/expense) |
| 2 | Edit Transaksi | User mengubah transaksi yang sudah ada |
| 3 | Hapus Transaksi | User menghapus transaksi dengan konfirmasi |
| 4 | Lihat Dashboard | User melihat ringkasan keuangan (saldo, income, expense) |
| 5 | Lihat Daftar Transaksi | User melihat semua transaksi dalam tabel |
| 6 | Refresh Data | User memperbarui tampilan dengan data terbaru |

---

## 7. Penerapan Prinsip OOP dalam Diagram

### 7.1 Abstraction (Abstraksi)

```
Transaction (Abstract Class)
├── method abstrak: process()
├── method abstrak: getType()
└── Menyembunyikan detail implementasi dari subclass
```

### 7.2 Inheritance (Pewarisan)

```
Transaction (Parent Class)
    ├── Income (Child Class) - extends Transaction
    └── Expense (Child Class) - extends Transaction
```

### 7.3 Polymorphism (Polimorfisme)

| Kelas | Method process() | Hasil |
|-------|------------------|-------|
| Income | `return currentBalance + getAmount()` | Menambah saldo |
| Expense | `return currentBalance - getAmount()` | Mengurangi saldo |

### 7.4 Encapsulation (Enkapsulasi)

```java
// Semua field bersifat PRIVATE
private double amount;
private String date;
private String description;

// Akses melalui GETTER dan SETTER
public double getAmount() { return amount; }
public void setAmount(double amount) { this.amount = amount; }
```

---

## 8. Design Pattern: MVC (Model-View-Controller)

### 8.1 Pembagian Layer

| Layer | Kelas | Fungsi |
|-------|-------|--------|
| **Model** | Transaction, Income, Expense, FinanceManager | Mengelola data dan business logic |
| **View** | MainFrame, DashboardPanel, TransactionTablePanel, AddEditDialog | Menampilkan GUI ke user |
| **Controller** | MainApp, FinanceManager | Menghubungkan Model dan View |

### 8.2 Keuntungan MVC

- **Separation of Concerns**: Setiap layer memiliki tanggung jawab berbeda
- **Maintainability**: Mudah diubah tanpa mempengaruhi layer lain
- **Testability**: Setiap layer bisa ditest secara terpisah
- **Reusability**: Komponen bisa dipakai ulang di proyek lain

---

## 9. Kesimpulan

Diagram UML yang kami buat meliputi:

1. **Class Diagram** - Struktur kelas dan relasi antar kelas
2. **ERD** - Relasi entitas data
3. **Sequence Diagram** - Alur proses tambah dan hapus transaksi
4. **Use Case Diagram** - Fungsionalitas yang tersedia untuk user

Semua diagram ini menunjukkan bagaimana **4 prinsip OOP** diterapkan secara konsisten dalam arsitektur aplikasi.

---

**Demikian presentasi Diagram UML dari saya. Selanjutnya akan dilanjutkan oleh [Nama Anggota 3] dan [Nama Anggota 4] yang akan menjelaskan tentang Implementasi Code.**

*Terima kasih.*
