package com.test;

import static java.time.LocalDate.parse;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.code.InvalidInputException;
import java.util.Scanner;
import static com.code.ValidateClass.validateAll;
import static com.code.CustomerNew.*;

import com.code.CustomOrderBydobAndName;
//import static com.code.CustomerNew.updatePassword;
import com.code.Customer;

public class TestCustomer1 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
//			get the populated list 
//			List<Customer> cust=new ArrayList<>();
			List<Customer>cust=populateCustomer();
			boolean exit=false;
			while(!exit)
			{
				System.out.println("please enter the choice");
				System.out.println("1.signup  2.sign in 3.Change password 4.Un subscribe customer 5.Display all customers.6.Order by email 7. orser by date of birth 8. order by dob and lastname 9.Display full name who have not paid subscription for reg amount for last 3 month");
			try{switch(sc.nextInt())
			{
			case 1:
				System.out.println("fName, lName,email,pass,regAmount, dob,Plan,lastsubscription paid");
				Customer customer=validateAll(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),cust,parse(sc.next()));
			System.out.println(cust);
			cust.add(customer);
			System.out.println("customer added");
			break;
			
			case 2:
				System.out.println("....login...");
				System.out.println("please enter the email and passwor");
				String email1=sc.next();
				String password=sc.next();
				customer=findByEmail(email1, cust);
				
//				customer=CustomerNew.findByPassword(sc.next(), cust);
//				if(customer.getEmail()==email1&&customer.getPass().equals(password))
				findByPassword(password, customer);
				System.out.println(customer);
				
				break;
				
			case 3:
				System.out.println("update password");
				System.out.println("enter the email");
				customer=findByEmail(sc.next(), cust);
//				findByPassword(sc.next(), customer);
				System.out.println("please enter th eold and new password");
				updatePassword(sc.next(),sc.next(),customer);
				System.out.println("password update successful");
				break;
			case 4:
				System.out.println("remove all");
				System.out.println("enter the email");
//				customer=findByEmail(sc.next(), cust);
//				boolean removed=cust.remove(customer);
				boolean removed=cust.remove(new Customer(sc.next()));
//				
                if(removed)
				{
					System.out.println("customer details are removed succesffuly");
				}
				else
				{
					throw new InvalidInputException("details are not removed");
				}
				break;
				
			case 5:
				for(Customer c :cust)
				{
					System.out.println(c);
				}
				break;
			case 6:
				System.out.println("Data are orderd as by email");
				Collections.sort(cust);
				break;
			case 7:
				System.out.println("Data are ordering as per date");
				Collections.sort(cust,new CustomOrderBydobAndName());
				break;
			case 8:
				System.out.println("Data are sorted as per dob and last name");
				Collections.sort(cust, new Comparator<Customer>() {

					@Override
					public int compare(Customer c1, Customer c2) {
						int ret=c1.getDob().compareTo(c2.getDob());
						if(ret==0)
						{
						int i=	c1.getlName().compareTo(c2.getlName());
							if(i==-1)
								return -1;
						if(i==0)
							return 0;
						return 1;
						}
						return ret;
					}
					
				});
				break;
			case 9:
				System.out.println("display the full name of the customer ");
				subscription(cust);
				 break;
			case 10:
//				add a new option , for the customer to pay the subscription  
//				i/p email , password,plan, subscription
//				subscritption ammount
//				simply set getLastSubscriptionPaidDate to LocalDate.now();
				System.out.println("remove datawhose subscription is pending from 6 month and display there full name");				
			subscription6Month(cust);
			
				break;
				
			
			case 11:
				exit=true;
				break;
			}
			}
			catch(Exception e)
			{
//				to read off the pending input from scanner
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	}
	}

	
}
