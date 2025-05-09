package com.online;

import java.util.Scanner;
/**
 * MainOperations is the entry point of the Online Shopping System.
 * It provides a console-based menu to access different operations
 * such as managing Admins, Customers, Orders, Payments, and Products.
 */
public class MainOperations {
	static Scanner sc = new Scanner(System.in);
	/**
	 * Displays the main menu and navigates to the selected operation
	 * based on user input. This loop continues until the user chooses to quit.
	 */
	public static void mainOps() {
		while (true) {
			System.out.println("-------Online Shopping System-------");
			// Display the main menu options
			System.out.println("Press 1.Admin Details\n" + "Press2.Customer Details\n"
					+ "Press 3.Order Details\nPress 4.Payment Details\n" + "Press 5.Product Details\n"
					+ "Press 6.for quit\\nEnter your choice:");
			int input = sc.nextInt();// Read user input
			switch (input) {
			case 1:
				AllOpertaions.adminOperations();
				System.out.println("=======================================");
				break;

			case 2:
				// Navigate to customer operations
				AllOpertaions.customerOperations();
				System.out.println("=======================================");
				break;

			case 3:
				// Navigate to order operations
				AllOpertaions.orderOperations();
				System.out.println("=======================================");
				break;

			case 4:
				// Navigate to payment operations
				AllOpertaions.paymentOperations();
				System.out.println("=======================================");
				break;

			case 5:
				// Navigate to product operations
				AllOpertaions.productOperations();
				System.out.println("=======================================");
				break;

			case 6:
				// Exit the application
				System.exit(0);
			default:
				// Handle invalid input
				System.out.println("wrong input");
			}
		}

	}
	/**
	 * Java application entry point. Starts the main menu loop.
	 * @param args Command-line arguments (not used).
	 */

	public static void main(String[] args) {

		mainOps();// Start the menu-driven application

	}
}
