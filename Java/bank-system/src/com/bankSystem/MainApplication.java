package com.bankSystem;

import java.util.Scanner;

import com.bankSystem.Entity.Account;
import com.bankSystem.Entity.User;
import com.bankSystem.Repository.AccountRepository;
import com.bankSystem.Repository.UserRepository;

public class MainApplication {

	private void exitSystem() {
		System.out.println("Thank you for using our services.");
		System.exit(0);
	}
	
	private void goToMainMenu() {	
		System.out.println(""
					+ "\n0 Main Menu\n"
					+ "1 Exit"
				);
		
		Scanner input = new Scanner(System.in);
		String option = input.next();
		
		switch (option) {
		case "0":
			break;
			
		case "1":
			exitSystem();
			break;

		default:
			System.out.println("Incorrect option");
			exitSystem();
			break;
		}
	}

	private int validateUser(Scanner input) throws Exception {
		System.out.print("Enter your phone number: ");
		String phone = input.next();
		System.out.print("Enter your password: ");
		String pass = input.next();

		UserRepository userRepo = new UserRepository();
		int userId = userRepo.getUserId(phone, pass);

		if (userId != -1) {
			return userId;
		} else {
			System.out.println("Phone Number or Password is incorrect!");
			System.exit(0);
		}

		return userId;
	}
	
	private void accountInfo() throws Exception {
		UserRepository userRepo = new UserRepository();
		AccountRepository accRepo = new AccountRepository();
		Scanner input = new Scanner(System.in);
		int userId = validateUser(input);
		
		userRepo.userInfo(userId);
		accRepo.accountInfo(userId);
		goToMainMenu();
	}
	
	private void balanceEnquiry() throws Exception {
		AccountRepository accRepo = new AccountRepository();	
		Scanner input = new Scanner(System.in);
		int userId = validateUser(input);
		
		System.out.println("Balance: " + accRepo.checkBalance(userId));		
		goToMainMenu();
	}

	private void makeTransaction(String status) throws Exception {
		AccountRepository accRepo = new AccountRepository();
		Scanner input = new Scanner(System.in);
		
		int userId = validateUser(input);
		System.out.print("Enter Amount: ");
		double balance = input.nextDouble();

		if (balance > 0) {
			if (status.equals("deposit")) {
				accRepo.depositBalance(userId, balance);
			} else {
				accRepo.withdrawBalance(userId, balance);
			}
		} else {
			System.out.println("Amount must be greater than 0");
			System.exit(0);
		}
		
		goToMainMenu();
	}

	private void createAccount() {
		User user = new User();
		Account account = new Account();
		AccountRepository accRepo = new AccountRepository();
		UserRepository userRepo = new UserRepository();

		Scanner userInput = new Scanner(System.in);

		try {
			System.out.print("Name: ");
			user.setName(userInput.nextLine());
			System.out.print("Age: ");
			user.setAge(Integer.parseInt(userInput.nextLine()));
			System.out.print("Gender (Male/Female): ");
			user.setGender(userInput.nextLine());
			System.out.print("NID Number: ");
			user.setNidNumber(Integer.parseInt(userInput.nextLine()));
			System.out.print("Phone: ");
			user.setPhone(userInput.nextLine());
			System.out.print("Password: ");
			user.setPassword(userInput.nextLine());

			userRepo.insertIntoDatabase(user);
			int userId = userRepo.getUserId(user.getPhone(), user.getPassword());

			account.setUserId(userId);
			account.setAccNumber(accRepo.generateAccountNumber());
			account.setBalance(0);

			accRepo.insertIntoDatabase(account);
			System.out.println("Account successfully created.");
			
			goToMainMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/*--------------------
	 *    Main Method
	 * -----------------*/
	public static void main(String[] args) {
		
		MainApplication mainObj = new MainApplication();
		Scanner input = new Scanner(System.in);
		String option = "";

		try {
			while(option != "exit") {
				System.out.println("" 
						+ "----------------------\n" 
						+ "Welcome to Bank System\n" 
						+ "----------------------\n"
				);

				System.out.println("" 
						+ "1 Create Account\n"
						+ "2 Deposit Balance\n"
						+ "3 Withdraw Balance\n"
						+ "4 Balance Enquiry\n" 
						+ "5 Account Info\n" 
						+ "6 Exit\n"
				);
	
				System.out.print("Choose your option: ");
				option = input.next();

				switch (option) {
				case "1":
					mainObj.createAccount();
					break;
	
				case "2":
					mainObj.makeTransaction("deposit");
					break;
	
				case "3":
					mainObj.makeTransaction("withdraw");
					break;
	
				case "4":
					mainObj.balanceEnquiry();
					break;
	
				case "5":
					mainObj.accountInfo();
					break;
					
				case "6":
					mainObj.exitSystem();
					break;
					
				default:
					System.out.println("Please choose correct option.");
					break;
				}
			} // end of while loop

		} catch (Exception e) {
			e.printStackTrace();
		}

		input.close();
	}

}
