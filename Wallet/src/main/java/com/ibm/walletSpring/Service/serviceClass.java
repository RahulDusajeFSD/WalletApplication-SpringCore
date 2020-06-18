package com.ibm.walletSpring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.ibm.walletSpring.Dao.*;
//import com.ibm.walletSpring.Dao.DaoClass;
import com.ibm.walletSpring.bean.User;

@Service("service")
public class serviceClass {

	@Autowired
	DaoClass dao;
	//DaoClass dao =  new DaoClass();
	
	
	public void insertUserNamed(User user)
	{
		dao.insertUserNamed(user);
	}
	
	public void Deposit(User user)
	{
	dao.Deposit(user);
	}
	
	public void withdraw(User user)
	{
		dao.withdraw(user);
	}
	
	public void transfer(User user)
	{
		dao.Transfer(user);
	}
	public List PassBook(User user)
	{
		return dao.PassBook(user);
	}
	
	public String CheckBalance(User user)
	{
		return dao.CheckBalance(user);
	}
	
	
	
}
