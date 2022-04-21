package com.bankSystem.Intefaces;

import java.sql.SQLException;

public interface IUser {
	public int getUserId(String phone, String pass) throws SQLException;
	public void userInfo(int userId) throws SQLException;
}
