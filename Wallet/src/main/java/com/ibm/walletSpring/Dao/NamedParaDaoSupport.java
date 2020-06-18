package com.ibm.walletSpring.Dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.ibm.walletSpring.bean.User;

public class NamedParaDaoSupport extends NamedParameterJdbcDaoSupport {
	
	public String CheckBalance(User user)
	{
		String currBal="Select Balance from balancedetails where ContactNo=:Cno";
		return getNamedParameterJdbcTemplate().queryForObject(currBal, new MapSqlParameterSource("Cno",user.getContactNo()),String.class);
		
	}

}

