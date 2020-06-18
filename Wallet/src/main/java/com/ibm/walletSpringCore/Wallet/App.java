package com.ibm.walletSpringCore.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.ibm.walletSpring.ui.common;
//import com.ibm.walletSpring.ui.walletSpringUI;

public class App 
{
    public static void main( String[] args )
    {
       
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
    	
    	common wallet=(common)context.getBean("UI", common.class);
    	//NamedParameterJdbcDaoSupport m=(NamedParameterJdbcDaoSupport)context.getBean("daoSupport", NamedParameterJdbcDaoSupport.class);
    	
    	
    	//common c=new common();
    	wallet.selection();
    	
    }
}
