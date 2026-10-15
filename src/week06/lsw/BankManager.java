package week06.lsw;

import java.util.Scanner;

public class BankManager {
    private String branchName;
    private BankAccount2[] bankAccount2s = null;
    private final int SIZE;
    private int count = 0;

    private static Scanner scan = new Scanner(System.in);

    public BankManager(String branchName, int SIZE) {
        this.branchName = branchName;
        this.SIZE = SIZE;
        if(this.SIZE > 0) {
            bankAccount2s = new BankAccount2[SIZE];
        }
    }

    public void createAccount() {
        System.out.println("-------- 계좌 개설 --------");
        if(bankAccount2s != null) {
            System.out.print("고객이름 : ");
            String name = scan.next();
            System.out.print("입금금액 : ");
            double amount = scan.nextDouble();

            if(this.count < this.SIZE) {
                bankAccount2s[count++] = BankAccount2.getInstance(name, amount);
            }
            else {
                System.out.println("계좌 개설 불가");
            }
        }
        else {
            System.out.println("은행 거래 불가");
        }
    }

    public void deposit() {
        System.out.println("-------- 입금 --------");
        System.out.print("입금계좌번호 : ");
        int target = scan.nextInt();
        BankAccount2 acc = findAccount(target);
        if(acc != null) {
            System.out.print("입금금액 : ");
            double amount = scan.nextDouble();
            acc.deposit(amount);
            System.out.println("입금 완료");
        }
        else {
            System.out.println("계좌번호 확인 요망");
        }
    }

    public void withdraw() {
        System.out.println("-------- 출금 --------");
        System.out.print("출금계좌번호 : ");
        int target = scan.nextInt();
        BankAccount2 acc = findAccount(target);
        if(acc != null) {
            System.out.print("출금금액 : ");
            double amount = scan.nextDouble();
            acc.withdraw(amount);
            System.out.println("출금 완료");
        }
        else {
            System.out.println("계좌번호 확인 요망");
        }
    }

    public void transfer() {
        System.out.println("-------- 계좌 이체 --------");
        System.out.print("보내는 계좌번호 : ");
        int dest = scan.nextInt();
        BankAccount2 destAcc = findAccount(dest);
        if(destAcc != null) {
            System.out.print("받는 계좌번호 : ");
            int target = scan.nextInt();
            BankAccount2 targetAcc = findAccount(target);
            if(targetAcc != null) {
                System.out.print("이체 금액 : ");
                double amount = scan.nextDouble();
                destAcc.transfer(targetAcc, amount);
            }
            else {
                System.out.println("받는 계좌번호 확인 요망");
            }
        }
        else {
            System.out.println("보내는 계좌번호 확인 요망");
        }
    }

    public BankAccount2 findAccount(int target) {
        System.out.println("-------- 계좌 검색 --------");
        for(BankAccount2 acc : bankAccount2s) {
            if(acc != null) {
                if(acc.getAccountNumber() == target) {
                    return acc;
                }
            }
            else {
                break;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "지점명 : " + branchName + "\n";
        str += "계좌 수 : " + this.count + "\n";
        for (BankAccount2 acc : bankAccount2s) {
            if(acc != null) {
                str += acc.toString() + "\n";
            }
            else {
                break;
            }
        }
        return str;
    }
}
