package com.bankSystem.Entity;

public class User {
	
	private int id;
	private String name;
	private int age;
	private String gender;
	private int nidNumber;
	private String phone;
	private String password;
	
	public User() {}
	
	public User(String name, int age, String gender, int nidNumber, String phone, String password) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.nidNumber = nidNumber;
		this.phone = phone;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNidNumber() {
		return nidNumber;
	}

	public void setNidNumber(int nidNumber) {
		this.nidNumber = nidNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
