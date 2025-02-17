import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public double getBalance(){
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf(" Successfully deposited: $%.2f\n", amount);
        } else{
            System.out.println(" Deposit amount must be positive ");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew: $%.2f\n", amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this withdrawal ");
            return false;
        } else {
            System.out.println(" Withdrawal amount must be positive ");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println(" ******** ATM Menu *********");
        System.out.println("1  Check Balance");
        System.out.println("2  Deposit");
        System.out.println("3  Withdraw");
        System.out.println("4  Exit");
        System.out.print(" Choose an option: ");
    }

    public void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", account.getBalance());
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit : ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    public void withdraw(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw : ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }
}

public class ATMApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000.00); // Initial balance
        ATM atm = new ATM(userAccount);
        int choice;

        do {
            atm.displayMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    atm.deposit();
                    break;
                case 3:
                    atm.withdraw();
                    break;
                case 4:
                    System.out.println(" Thank you for using the ATM ");
                    break;
                default:
                    System.out.println("Invalid option.......Please try again ");
            }
        } while (choice != 4);
    }
}