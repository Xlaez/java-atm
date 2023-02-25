package oop.com.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Menu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat(" '$' ###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(10102384, 3131);
                data.put(81302785, 1100);

                System.out.println("Welcome to the Kamou's ATM");
                System.out.println("Enter your account number: ");
                setAccountNumber(menuInput.nextInt());

                System.out.println("Enter your pin number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only Numbers." + "\n");
                x = 2;
            }
            int accNum = getAccountNumber();
            int pinNum = getPinNumber();

            if (data.containsKey(accNum) && data.get(accNum) == pinNum) {
                getAccountType();
            } else {
                System.out.println("\n" + "Wrong customer number or pin number " + "\n");
            }
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the account you wan tot access: ");
        System.out.println(" Type 1 - Checking Account");
        System.out.println(" Type 2 - Saving Account");
        System.out.println(" Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using the ATM, bye..." + " \n");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
                break;
        }
    }

    public void getChecking() {
        System.out.println("Checking account ....");
        System.out.println(" Type 1 - View balance");
        System.out.println(" Type 2 - Withdraw funds");
        System.out.println(" Type 3 - Deposit funds");
        System.out.println(" Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking account balance: " + moneyFormat.format(getCheckingBalance()));
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
            case 4:
                System.out.println("Thank You for using this ATM, bye ....");
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
                break;
        }
    }

    public void getSaving() {
        System.out.println("Checking account ....");
        System.out.println(" Type 1 - View balance");
        System.out.println(" Type 2 - Withdraw funds");
        System.out.println(" Type 3 - Deposit funds");
        System.out.println(" Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking account balance: " + moneyFormat.format(getSavingBalance()));
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
            case 4:
                System.out.println("Thank You for using this ATM, bye ....");
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getSaving();
                break;
        }
    }
}
