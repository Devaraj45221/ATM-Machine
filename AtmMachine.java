package intern3;

import java.util.Scanner;

public class AtmMachine {

	public static void main(String[] args) {
//		Create Scanner class object
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter initial account balance : ");
		System.out.print("");
//		insert the initial amount
		double initialAmount=sc.nextDouble();
//		Create BankAccount class constructor object with parameter
		BankAccount bankAccount=new BankAccount(initialAmount);
//		Create ATM class constructor object with parameter
		ATM atm = new ATM(bankAccount);
		while(true) {
//			calling the displayMenu method
			atm.displayMenu();
			System.out.println("Select an option : ");
			int choice = sc.nextInt();
//			calling the transaction method with 2 parameter
			atm.transaction(choice,sc);
		}

	}
}
	
class BankAccount {
	private double balance;
//	 create initial balance
	public BankAccount(double initialAmount) {
		this.balance=initialAmount;
	}
//	Display the balance by using this getBalance method
	public double getBalance() {
		return balance;
	}
//	To deposit the money
	public void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("Your current account balance is : "+balance);
		}
		else {
			System.out.println("Invalid deposit amount");
		}
	}
//	To withdraw the money
	public void withdraw(double amount) {
		if(amount>0 && amount<=balance) {
			balance-=amount;
			System.out.println("Withdrawal amount "+ amount + " is Successful.");
			System.out.println();
			System.out.println("Current account balance is :"+balance);
		}
		else {
			System.out.println("Invalid withdrawal option or Insufficient balance.");
		}	
	}
}
class ATM {
	
	private BankAccount bankAccount;
	ATM(BankAccount bankAccount) {
		this.bankAccount=bankAccount;
	}
	
//	Choosing an option
	public void displayMenu() {
		System.out.println();
		System.out.println("ATM Menu");
		System.out.println("Press 1 for Check Balance");
		System.out.println("Press 2 for Deposite");
		System.out.println("Press 3 for Amount Withdrwal");
		System.out.println("Press 0 to Exit");
		System.out.println();
	}
	
//	Followed By choosing on option 
	public void transaction(int choice, Scanner sc) {
		switch(choice) {
		case 1:
//			Show the balance by using getBalance method
			System.out.println("Current balance is : "+bankAccount.getBalance());
			break;
		case 2:
			System.out.println("Enter deposite amount : ");
//			Deposit the balance by using deposit method
			double deposit=sc.nextDouble();
			bankAccount.deposit(deposit);
			break;
		case 3:
			System.out.println("Enter withdrawal Amount : ");
//			Withdraw the balance by using withdraw method
			double withdraw=sc.nextDouble();
			bankAccount.withdraw(withdraw);
			break;
		case 0:
			System.out.println("Exiting from Options. Thank You");
//			Exit from the ATM class options
			sc.close();
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice or Time out.");
//			Exit from the ATM class options by choosing invalid input
			sc.close();
			System.exit(0);
			break;
		}
		
	}
}


