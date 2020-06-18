package com.ibm.walletSpring.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.walletSpring.Service.serviceClass;
import com.ibm.walletSpring.bean.User;

@Component("UI")       // Bean is created automatically
public class common {

	@Autowired
	serviceClass service;
	Scanner scan = new Scanner(System.in);

	public void selection() {
		int option = 0;

		while (option != 7) {
			System.out.println("Welcome to Payment Wallet Application");
			System.out.println("Press 1 to create Bank Account:");
			System.out.println("Press 2 to Deposit to bank acoount:");
			System.out.println("Press 3 to Withdraw from bank account:");
			System.out.println("Press 4 to Transfer Fund:");
			System.out.println("Press 5 to Print PassBook");
			System.out.println("Press 6 to Check Balance");
			System.out.println("Press 7 to exit");

			System.out.println("Enter your choice");

			option = scan.nextInt();
			scan.nextLine();

			switch (option) {
			case 1:
				System.out.println("Enter name");
				String name = scan.nextLine();

				System.out.println("Enter Age");
				int age = scan.nextInt();

				scan.nextLine();

				System.out.println("Enter Contact Number");
				String Cno = scan.nextLine();

				System.out.println("Enter Address");
				String Addrs = scan.nextLine();

				System.out.println("Enter 4 digit Pin");
				int pin = scan.nextInt();
				scan.nextLine();

				User c = new User(name, age, Cno, Addrs, pin);

			service.insertUserNamed(c);
				break;
 case 2:
			System.out.println("Enter Contact Number");
			String ww=scan.nextLine();
			System.out.println("Enter Deposit amount");
			int ff=scan.nextInt();
			User user=new User(ww,ff);
				service.Deposit(user);
			break;
	case 3:
		System.out.println("Enter Contact Number");
		String ww1=scan.nextLine();
		System.out.println("Enter amount to withdraw");
		int ff1=scan.nextInt();
		
		User c1=new User(ww1,ff1);
		
		service.withdraw(c1);
		
	
		break;
		
		
		
	case 4:
			System.out.println("Enter Contact Number to transfer amount");
			String toSend=scan.nextLine();
			System.out.println("Enter your contact number");
			String our=scan.nextLine();
			System.out.println("Enter Amount to transfer");
			int amt=scan.nextInt();
			
			
			User userTransfer=new User(toSend,our,amt);
			service.transfer(userTransfer);
			break;
			
		
			
	case 5:
			System.out.println("Enter your Contact Number");
			String g=scan.nextLine();
			
			User u1=new User(g);
			
			
			
			System.out.println(service.PassBook(u1));
	
			
			
			break;
			
	case 6:
		System.out.println("Enter your Contact Number");
		String g1=scan.nextLine();
		
		User userBalance=new User(g1);
		
		String out =service.CheckBalance(userBalance);
		System.out.println(out);
		
		break;		
			
	case 7: System.exit(0);
			
	default:continue;	
	
			} 

			}
			
		}
	}