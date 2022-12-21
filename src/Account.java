import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance -= amount;
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance -= amount;
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance += amount;
        return savingBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount You Want to Withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("Your Remaining Checking Account Balance:" + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient Balance." + "\n");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount You Want to Withdraw from Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("Your Remaining Saving Account Balance:" + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Insufficient Balance." + "\n");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Input The Amount You Want to Deposit: ");
        double amount = input.nextDouble();
        calcCheckingDeposit(amount);
        System.out.println("Your Current Checking Balance: " + moneyFormat.format(checkingBalance));
    }

    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: ");
        System.out.print("Input The Amount You Want to Deposit: ");
        double amount = input.nextDouble();
        calcSavingDeposit(amount);
        System.out.println("Your Current Saving Balance: " + moneyFormat.format(savingBalance));
    }
}
