package assignment.bank.control;

import assignment.assignment1.student.exception.InvalidGradeException;
import assignment.bank.entity.*;
import assignment.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        System.out.println(bank.createSavingsAccount("홍길동", 10000.0, 3.0));
        System.out.println(bank.createCheckingAccount("김철수", 20000.0, 5000.0));
        System.out.println(bank.createSavingsAccount("이영희", 30000.0, 2.0));
        System.out.println();

        System.out.println("=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================\n");

        System.out.println("=== 입금/출금 테스트 ===");
       
        try {
        	bank.deposit("AC1000", 5000);
        	
        	
        } catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
        
        try {
        	bank.withdraw("AC1001", 3000);
  
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
        
        
        System.out.println("=== 이자 적용 테스트 ===");
        
        try {
        	SavingsAccount sa = (SavingsAccount) bank.findAccount("AC1002");
   
        	System.out.println("이자가 적용되었습니다. 적용 전 잔액:"+ sa.getBalance());
        	sa.applyInterst();
        	System.out.println("적용 후 잔액:"+ sa.getBalance());
        } catch ( AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
      
        System.out.println();

        
        
        
        
        System.out.println("=== 계좌 이체 테스트 ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000.0);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        
        
        
        
        System.out.println("=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================\n");

        // 예외 테스트
        try {
            bank.findAccount("AC1001").withdraw(6000.0);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            bank.transfer("AC1001", "AC1000", 6000.0);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
