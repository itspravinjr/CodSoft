package com.intern.atminterface;

import java.util.Scanner;

public class Atmmain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial account balance: 10000");
        double initialBalance = 10000;
        System.out.println();

        BankAccount userAccount = new BankAccount(initialBalance);
        Atm atm = new Atm(userAccount);

        while (true) {
        	atm.displayOptions();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            atm.performTransaction(choice, scanner);
        }
    }
}
