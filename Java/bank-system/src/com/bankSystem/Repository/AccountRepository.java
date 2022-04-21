package com.bankSystem.Repository;

import java.sql.SQLException;
import java.util.Random;

import com.bankSystem.Entity.Account;
import com.bankSystem.Intefaces.IAccount;

public class AccountRepository implements IAccount {
	
	DatabaseConnection conn;
	
	public AccountRepository() {
		conn = new DatabaseConnection();
	}
	
	@Override
	public void depositBalance(int userId, double balance) throws SQLException {
		double currentBalance = checkBalance(userId) + balance;
		
		conn.openConnection();	
		conn.stmt.executeUpdate("UPDATE public.account SET balance = "+ currentBalance +" WHERE user_id = "+ userId +";");		
		conn.closeConnection();
		
		System.out.println("\nSuccessfully Deposited: " + balance + "\nCurrent balance: " + currentBalance);
	}
	
	@Override
	public void withdrawBalance(int userId, double balance) throws SQLException {
		double currentBalance = checkBalance(userId);
		
		if(currentBalance >= balance) {
			currentBalance = currentBalance - balance;	
			
			conn.openConnection();	
			conn.stmt.executeUpdate("UPDATE public.account SET balance = "+ currentBalance +" WHERE user_id = "+ userId +";");		
			conn.closeConnection();
			
			System.out.println("\nWithdrawal: "+ balance +" Tk\nCurrent balance: " + currentBalance);
		} else {
			System.out.println("Balance is insufficient.\nCurrent balance: " + currentBalance);
		}
	} 
	
	public double checkBalance(int userId) throws SQLException {
		double currentBalance = 0;
		
		conn.openConnection();			
		String checkBalanceQuery = "SELECT balance FROM public.account WHERE user_id = "+ userId +";";
		conn.result = conn.stmt.executeQuery(checkBalanceQuery);
		
		if (conn.result.next()) {
			currentBalance = conn.result.getDouble("balance");
		}
		
		conn.closeConnection();
		
		return currentBalance;
	}
	
	public void insertIntoDatabase(Account acc) {
		try {
			String sql = "INSERT INTO public.account (user_id, acc_number, balance)"
					   + "VALUES "
					   + "( "+ acc.getUserId() +", "+ acc.getAccNumber() +","+ acc.getBalance() +");";
			
			conn.openConnection();
			conn.stmt.executeUpdate(sql);
			conn.closeConnection();
		} catch (SQLException e) {
			System.out.println("System exit due to wrong data => " + e.getMessage());
			System.exit(0);
		}
	}
	
	public int generateAccountNumber() {
		Random random = new Random();
		int accNum = 0;
		boolean isExists = true;
	
		while (isExists) {
			accNum = 100000 + random.nextInt(900000);
			String sql = "SELECT id from public.account where acc_number = " + accNum + ";";
			
			try {
				conn.openConnection();
				conn.result = conn.stmt.executeQuery(sql);
				
				if (conn.result.next()) {
					isExists = true;
				} else {
					isExists = false;
				}
				
				conn.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		return accNum; 
	}
	
	public void accountInfo(int userId) throws SQLException {
		conn.openConnection();
		conn.result = conn.stmt.executeQuery("SELECT acc_number FROM public.account WHERE user_id = " + userId + ";");
		conn.result.next();
		System.out.println("Account number: " + conn.result.getInt("acc_number"));
		conn.closeConnection();
	}
	
	
}
