package com.code;
import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class CustomerNew {

	public static Customer findByEmail(String email,List<Customer> cst) throws InvalidInputException
	{
//		Customer c= new Customer(email);
		String pattern="[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if(!email.matches(pattern))
		{
			throw new InvalidInputException("invalid email");
		}
		Customer c= new Customer(email);
		int index=cst.indexOf(c);
		if(index==-1)
			throw new InvalidInputException("email is not found");
//			System.out.println(cst.get(index));
		return cst.get(index);
		
	}
	
	public static void findByPassword(String password,Customer c) throws InvalidInputException
	{
		String pattern="[a-z]+@[0-9]*";
		if(!password.matches(pattern))
		{
			throw new InvalidInputException("wrong password");
		}
		if(c.getPass().equals(password))
		{
			System.out.println("login succesful");
		}
		else
		{
		throw new InvalidInputException("password is is not found");
		
	}
	}
	public static void updatePassword(String oldpass,String newpass, Customer c) throws InvalidInputException 
	{
		String pattern="[a-z]+@[0-9]*";
		if(!oldpass.matches(pattern))
		{
			throw new InvalidInputException("wrong password");
		}
		
		if(c.getPass().equals(oldpass))
		{
		c.setPass(newpass);
		}
		else 
		{
			throw new InvalidInputException("passwor is updated successfully");
		}
			
	}
	public static void subscription(List<Customer> cst)
	{
		LocalDate today=LocalDate.now();
//		System.out.println("please enter the email");
//		customer=findByEmail(sc.next(), cust);
		for(Customer c:cst) {
		 Period period = Period.between(c.getLastsubscriptionDate(), today);
//		 System.out.println(period);
		 int monthsDifference = period.getMonths();
		 int yearsDifference = period.getYears();
		 int totalMonthDifference = (yearsDifference * 12) + monthsDifference;
//		 System.out.println("monthdiffrence"+monthsDifference);
		 if(totalMonthDifference>3)
		 {
			 System.out.println (c.getfName()+" "+c.getlName());
			 System.out.println("please paid your subscription");
		 }
		}
	}
	public static void subscription6Month(List<Customer> cst)
	{
		Iterator<Customer> itr=cst.iterator();
		 while (itr.hasNext()) {
	            Customer c1 = itr.next();
             LocalDate today=LocalDate.now();
	            Period period = Period.between(c1.getLastsubscriptionDate(), today);
	            int monthsDifference = period.getMonths();
				 int yearsDifference = period.getYears();
				 int totalMonthDifference = (yearsDifference * 12) + monthsDifference;

	            if (totalMonthDifference >= 6) {
	                itr.remove(); 
	                System.out.println (c1.getfName()+" "+c1.getlName());
	            }
	        }
	}
	public static List<Customer> populateCustomer()
	{
		
		List<Customer> list=new ArrayList<>();
		list.add(new Customer("Ram","Dwivedi","rama@gmail.com","ram@1234",1000,parse("1928-12-01"),ServicePlan.SILVER,parse("2023-09-01")));
		list.add(new Customer("Golu","Mishra","ram@gmail.net","raj@12",2000,parse("1928-10-02"),ServicePlan.GOLD,parse("2023-10-01")));
		list.add(new Customer("Ankit","gautam","ankit@gmail.com","raja@1234",2000,parse("2023-10-02"),ServicePlan.GOLD,parse("2023-03-02")));
		list.add(new Customer("shashi","Dwivedi","sashi@gmail.com","raj1234",5000,parse("2022-10-01"),ServicePlan.dIAMOND,parse("2023-04-01")));
		list.add(new Customer("monika","Shukla","monika@gmail.com","raju@1235",5000,parse("2022-10-01"),ServicePlan.dIAMOND,parse("2023-05-01")));
		list.add(new Customer("sandy","Sharma","sandy@gmail.org","rak@1238",10000,parse("2023-10-02"),ServicePlan.pLATINUM,parse("2022-10-01")));
		
		return list;
		
	}
	
}
