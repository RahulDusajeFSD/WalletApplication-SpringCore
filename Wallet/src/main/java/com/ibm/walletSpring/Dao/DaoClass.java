package com.ibm.walletSpring.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ibm.walletSpring.bean.User;

@Repository("repository")
public class DaoClass {

	DataSource datasource;

	NamedParameterJdbcTemplate namedParam;

	@Autowired
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;

		namedParam = new NamedParameterJdbcTemplate(datasource);
	}

	Date date = new Date();
	String s = date.toString();

	public void insertUserNamed(User user) {
		String qry = "insert into basicdetails(Name,Age,Address,ContactNo,PIN,Date) values(:name,:age,:address,:cNo,:pin,:date)";
		String accQry = "insert into balancedetails(contactNo) values(:Cno)";

		namedParam.update(qry,
				new MapSqlParameterSource("name", user.getName()).addValue("age", user.getAge())
						.addValue("address", user.getAddress()).addValue("cNo", user.getContactNo())
						.addValue("pin", user.getPIN()).addValue("date", s));

		namedParam.update(accQry, new MapSqlParameterSource("Cno", user.getContactNo()));
	}

	public void Deposit(User user) {

		String depositQry = "Update balancedetails set Balance=Balance+:balance where ContactNo=:Cno";

		namedParam.update(depositQry,
				new MapSqlParameterSource("balance", user.getBalance()).addValue("Cno", user.getContactNo()));

	}

	public void withdraw(User user) {
		String checkQry = "select Balance from balancedetails where ContactNo=:Cno";
		String withdrawQry = "Update balancedetails set Balance=Balance-:balance where ContactNo=:Cno";

		int currBalance = namedParam.queryForObject(checkQry, new MapSqlParameterSource("Cno", user.getContactNo()),
				Integer.class);

		if (currBalance < 1000 || currBalance - user.getBalance() < 0) {
			System.out.println("Low Balance");
		} else {
			namedParam.update(withdrawQry,
					new MapSqlParameterSource("balance", user.getBalance()).addValue("Cno", user.getContactNo()));

		}

	}

	public void Transfer(User user) {

		String transferQry = "insert into transactiontable(ContactNo,FromUser,ToUser,Time, Amount) values(:Cno,:fromUsr,:toUsr,:date,:amt)";
		String transferAmtQryUs = "Update balancedetails set balance=balance+:balance where ContactNo=:Cno";
		String transferAmtQryTo = "Update balancedetails set balance=balance-:balance where ContactNo=:Cno";

		Date t = new Date();

		namedParam.update(transferQry,
				new MapSqlParameterSource("Cno", user.getContactNo()).addValue("fromUsr", user.getContactNo())
						.addValue("toUsr", user.getToContactNo()).addValue("date", t)
						.addValue("amt", user.getBalance()));
		namedParam.update(transferAmtQryUs,
				new MapSqlParameterSource("balance", user.getBalance()).addValue("Cno", user.getToContactNo()));
		namedParam.update(transferAmtQryTo,
				new MapSqlParameterSource("balance", user.getBalance()).addValue("Cno", user.getContactNo()));

	}

	public List PassBook(User user) {

		String passbookQry = "select FromUser,ToUser,Time,Amount from transactiontable where ContactNo=:Cno";

		List out = namedParam.queryForList(passbookQry, new MapSqlParameterSource("Cno", user.getContactNo()));

		return out;
	}

	public String CheckBalance(User user) {
		String currBal = "Select Balance from balancedetails where ContactNo=:Cno";

		return namedParam.queryForObject(currBal, new MapSqlParameterSource("Cno", user.getContactNo()), String.class);

	}

}
