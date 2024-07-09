package Tasks;
	import java.util.Scanner;

	// Class to represent the user's bank account
	class BankAccount {
	    private double balance;

	    public BankAccount(double initialBalance) {
	        this.balance = initialBalance;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposit successful. Your new balance is: $" + balance);
	        } else {
	            System.out.println("Deposit amount must be positive.");
	        }
	    }

	    public boolean withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
	            return true;
	        } else if (amount > balance) {
	            System.out.println("Insufficient balance for this withdrawal.");
	            return false;
	        } else {
	            System.out.println("Withdrawal amount must be positive.");
	            return false;
	        }
	    }
	}

	// Class to represent the ATM machine
	class ATM {
	    private BankAccount account;

	    public ATM(BankAccount account) {
	        this.account = account;
	    }

	    public void start() {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("\nATM Menu:");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    checkBalance();
	                    break;
	                case 2:
	                    deposit(scanner);
	                    break;
	                case 3:
	                    withdraw(scanner);
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the ATM. Goodbye!");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }

	    private void checkBalance() {
	        System.out.println("Your current balance is: $" + account.getBalance());
	    }

	    private void deposit(Scanner scanner) {
	        System.out.print("Enter amount to deposit: ");
	        double amount = scanner.nextDouble();
	        account.deposit(amount);
	    }

	    private void withdraw(Scanner scanner) {
	        System.out.print("Enter amount to withdraw: ");
	        double amount = scanner.nextDouble();
	        account.withdraw(amount);
	    }
	}

	// Main class to run the ATM system
	public class AtmInterface {
	    public static void main(String[] args) {
	        BankAccount userAccount = new BankAccount(1000.00);  // Initial balance
	        ATM atm = new ATM(userAccount);
	        atm.start();
	    }
	}
