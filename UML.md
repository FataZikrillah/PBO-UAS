
# UML Diagram - Aplikasi Manajemen Keuangan

## 1. Entity Relationship Diagram (ERD)

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

## 2. Class Diagram

```mermaid
classDiagram
    %% Abstract Class
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
    
    %% Inheritance - Income
    class Income {
        +Income(amount, date, description)
        +process(currentBalance) double
        +getType() String
    }
    
    %% Inheritance - Expense
    class Expense {
        +Expense(amount, date, description)
        +process(currentBalance) double
        +getType() String
    }
    
    %% Core Manager
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
    
    %% View Classes
    class MainFrame {
        -FinanceManager financeManager
        -DashboardPanel dashboardPanel
        -TransactionTablePanel tablePanel
        -PieChartPanel chartPanel
        +MainFrame()
        -initComponents() void
        -addButtonPanel() void
        -refreshAllPanels() void
        -handleAdd() void
        -handleDelete() void
        -handleEdit() void
        -handleRefresh() void
        -handleReport() void
    }
    
    class DashboardPanel {
        -FinanceManager financeManager
        -JLabel lblCurrentBalance
        -JLabel lblMonthlyIncome
        -JLabel lblMonthlyExpense
        -JLabel lblMonthlyNet
        +DashboardPanel(financeManager)
        +updateDashboard() void
    }
    
    class TransactionTablePanel {
        -FinanceManager financeManager
        -JTable table
        -DefaultTableModel tableModel
        +TransactionTablePanel(financeManager)
        +refreshTable() void
        +getSelectedRow() int
    }
    
    class PieChartPanel {
        -FinanceManager financeManager
        -DefaultPieDataset dataset
        -ChartPanel chartPanel
        +PieChartPanel(financeManager)
        +updateChart() void
    }
    
    class AddEditDialog {
        -JComboBox~String~ cmbType
        -JTextField txtAmount
        -JTextField txtDate
        -JTextArea txtDescription
        -Transaction result
        +AddEditDialog(parent, title)
        +AddEditDialog(parent, title, transaction)
        -createForm() void
        -saveTransaction() void
        +getResult() Transaction
    }
    
    %% Utility Classes
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
        +formatDisplay(dateTime)$ String
        +isValidDate(dateString)$ boolean
    }
    
    class FileManager {
        <<utility>>
        -String FILE_PATH$
        +saveTransactions(transactions)$ void
        +loadTransactions()$ List~Transaction~
        -parseTransaction(line)$ Transaction
    }
    
    class MainApp {
        <<main>>
        +main(args)$ void
    }
    
    %% Relationships - Inheritance
    Transaction <|-- Income : extends
    Transaction <|-- Expense : extends
    
    %% Relationships - Composition
    FinanceManager "1" *-- "0..*" Transaction : contains
    MainFrame "1" *-- "1" FinanceManager : manages
    MainFrame "1" *-- "1" DashboardPanel : contains
    MainFrame "1" *-- "1" TransactionTablePanel : contains
    MainFrame "1" *-- "1" PieChartPanel : contains
    
    %% Relationships - Association
    DashboardPanel --> FinanceManager : uses
    TransactionTablePanel --> FinanceManager : uses
    PieChartPanel --> FinanceManager : uses
    AddEditDialog --> Transaction : creates
    MainFrame --> AddEditDialog : uses
    
    %% Relationships - Dependency
    MainApp ..> MainFrame : creates
    MainFrame ..> FileManager : uses
    DashboardPanel ..> CurrencyFormatter : uses
    TransactionTablePanel ..> CurrencyFormatter : uses
    TransactionTablePanel ..> DateTimeUtils : uses
    AddEditDialog ..> DateTimeUtils : uses
    FileManager ..> Transaction : uses
    FileManager ..> Income : uses
    FileManager ..> Expense : uses
```

## 3. Sequence Diagram - Add Transaction

```mermaid
sequenceDiagram
    actor User
    participant MainFrame
    participant AddEditDialog
    participant Transaction
    participant FinanceManager
    participant FileManager
    
    User->>MainFrame: Click "TAMBAH" button
    MainFrame->>AddEditDialog: new AddEditDialog()
    AddEditDialog->>User: Show dialog form
    User->>AddEditDialog: Fill form & click "Simpan"
    AddEditDialog->>AddEditDialog: Validate input
    alt Valid Input
        AddEditDialog->>Transaction: new Income/Expense()
        Transaction-->>AddEditDialog: transaction object
        AddEditDialog-->>MainFrame: return transaction
        MainFrame->>FinanceManager: addTransaction(transaction)
        FinanceManager->>Transaction: process(currentBalance)
        Transaction-->>FinanceManager: new balance
        FinanceManager->>FinanceManager: calculateMonthlySummary()
        MainFrame->>FileManager: saveTransactions()
        FileManager-->>MainFrame: saved
        MainFrame->>MainFrame: refreshAllPanels()
        MainFrame->>User: Show success message
    else Invalid Input
        AddEditDialog->>User: Show error message
    end
```

## 4. Sequence Diagram - Delete Transaction

```mermaid
sequenceDiagram
    actor User
    participant MainFrame
    participant TransactionTablePanel
    participant FinanceManager
    participant FileManager
    
    User->>TransactionTablePanel: Select transaction row
    User->>MainFrame: Click "HAPUS" button
    MainFrame->>User: Show confirmation dialog
    User->>MainFrame: Confirm deletion
    MainFrame->>TransactionTablePanel: getSelectedRow()
    TransactionTablePanel-->>MainFrame: row index
    MainFrame->>FinanceManager: deleteTransaction(index)
    FinanceManager->>FinanceManager: transactions.remove(index)
    FinanceManager->>FinanceManager: recalculateBalance()
    FinanceManager->>FinanceManager: calculateMonthlySummary()
    MainFrame->>FileManager: saveTransactions()
    FileManager-->>MainFrame: saved
    MainFrame->>MainFrame: refreshAllPanels()
    MainFrame->>User: Show success message
```

## 5. Use Case Diagram

```mermaid
graph TD
    User((User))
    
    User --> UC1[Add Transaction]
    User --> UC2[Edit Transaction]
    User --> UC3[Delete Transaction]
    User --> UC4[View Dashboard]
    User --> UC5[View Transaction List]
    User --> UC6[View Pie Chart]
    User --> UC7[Generate Report]
    User --> UC8[Refresh Data]
    
    UC1 --> Validate[Validate Input]
    UC2 --> Validate
    UC1 --> Save[Save to File]
    UC2 --> Save
    UC3 --> Save
    UC7 --> Save
```

## 6. Penjelasan Prinsip OOP

### Abstraction (Abstraksi)
- **Transaction** adalah abstract class yang mendefinisikan kontrak untuk semua transaksi
- Method `process()` dan `getType()` adalah abstract method yang harus diimplementasikan

### Inheritance (Pewarisan)
- **Income** extends Transaction
- **Expense** extends Transaction
- Kedua subclass mewarisi properties dan behavior dari parent class

### Polymorphism (Polimorfisme)
- Method `process()` di-override berbeda di Income (menambah saldo) dan Expense (mengurangi saldo)
- FinanceManager dapat menerima Transaction (parent class) tapi memproses sesuai tipe sebenarnya (Income/Expense)

### Encapsulation (Enkapsulasi)
- Semua field di Transaction, Income, Expense, dan FinanceManager bersifat **private**
- Akses ke data melalui **getter** dan **setter** methods
- Data terlindungi dari akses langsung

## 7. Design Pattern

### MVC (Model-View-Controller)
- **Model**: Transaction, Income, Expense, FinanceManager
- **View**: MainFrame, DashboardPanel, TransactionTablePanel, PieChartPanel, AddEditDialog
- **Controller**: FinanceManager mengelola logic, MainFrame mengelola interaksi user

### Singleton Pattern (Implicit)
- MainApp hanya membuat satu instance FinanceManager yang dibagikan ke semua panel
