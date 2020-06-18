package com.ibm.walletSpring.bean;


public class User {
	                                         //#3
	Integer PIN;
	
	Integer balance;
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public User(String name,Integer age,String contactNo, String address,Integer pIN) {
		super();
		PIN = pIN;
		Name = name;
		Address = address;
		//Date = date;
		ContactNo = contactNo;
		Age = age;
	}
	public User(String contactNo,Integer balance ) {
		super();
		this.balance = balance;
		ContactNo = contactNo;
	}
	public User(Integer balance) {
		super();
		this.balance = balance;
	}
	public User(String name,Integer age,String address,String contactNo,Integer pIN, String date) {
		super();
		PIN = pIN;
		Name = name;
		Address = address;
		Date = date;
		ContactNo = contactNo;
		Age = age;
	}
	public User(Integer pIN, Integer balance) {
		super();
		PIN = pIN;
		this.balance = balance;
	}
	public User(Integer balance, String contactNo) {
		super();
		this.balance = balance;
		ContactNo = contactNo;
	}
	public User(){
		
	}
	public User(Integer pIN, String name, String address, String date, String contactNo, Integer age) {
		super();
		PIN = pIN;
		Name = name;
		Address = address;
		Date = date;
		ContactNo = contactNo;
		Age = age;
	}
	public User(String name, String contactNo) {
		super();
		Name = name;
		ContactNo = contactNo;
	}

	String toContactNo;
	public String getToContactNo() {
		return toContactNo;
	}
	public void setToContactNo(String toContactNo) {
		this.toContactNo = toContactNo;
	}

	public User(String toContactNo, String contactNo,Integer balance) {
		this.balance = balance;
		this.toContactNo = toContactNo;
		ContactNo = contactNo;
	}

	public User(String contactNo) {
		super();
		ContactNo = contactNo;
	}

	String Name;
	String Address;
	String Date;
	String ContactNo;
	Integer Age;
	public Integer getPIN() {
		return PIN;
	}
	public void setPIN(Integer pIN) {
		PIN = pIN;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}

	
	@Override
	public String toString()
	{
		return getContactNo()+" " + getToContactNo()+ " "+ getBalance()+" "+getDate();
	}
}

