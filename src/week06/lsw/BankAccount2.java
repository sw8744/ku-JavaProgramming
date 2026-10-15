package week06.lsw;

public class BankAccount2 {
    private static int count = 100;
    private int accountNumber;
    private String customerName;
    private double accountBalance;

    {
        this.accountNumber = count++;
    }

    private BankAccount2(String customerName) {
        this(customerName,0.0);
    }

    private BankAccount2(String customerName, double accountBalance) {
        this.customerName = customerName;
        this.accountBalance = accountBalance;

//        System.out.println("생성자 : " + this);
    }

    public static BankAccount2 getInstance(String customerName, double accountBalance) {
        return new BankAccount2(customerName, accountBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        this.accountBalance += amount;
    }

    public void withdraw(double amount) {
        if (this.accountBalance >= amount) {
            this.accountBalance -= amount;
        }
        else {
            System.out.println("출금 잔액 부족");
        }
    }

    public void transfer(BankAccount2 account, double amount) {
        if(this.accountBalance >= amount) {
            this.withdraw(amount);
            account.deposit(amount);
        }
        else {
            System.out.println("출금 잔액 부족");
        }
    }

    public void showAccount() {
        System.out.println("-".repeat(20));
        System.out.println("고객이름 : " + this.customerName);
        System.out.println("계좌번호 : " + this.accountNumber);
        System.out.println("잔   액 : " + this.accountBalance);
        System.out.println("-".repeat(20));
    }

    @Override
    public String toString() {
        return "-".repeat(20) +
                "\n계좌번호 : " + accountNumber +
                "\n고객이름 : " + customerName +
                "\n잔   액 : " + accountBalance +
                "\n";
    }
}
