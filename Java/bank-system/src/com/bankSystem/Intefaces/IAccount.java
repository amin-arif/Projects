package com.bankSystem.Intefaces;

import java.sql.SQLException;

public interface IAccount {
	
	public void depositBalance(int userId, double balance) throws SQLException;
	public void withdrawBalance(int userId, double balance) throws SQLException;
}
