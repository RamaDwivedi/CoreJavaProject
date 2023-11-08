
package com.code;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CustomerLogin {
	public static void findByEmail(String email,Map<String,Customer>cust) throws InvalidInputException
	{
//		Customer c= new Customer(email);
		String pattern="[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if(!email.matches(pattern))
		{
			throw new InvalidInputException("invalid email");
		}
		
		//Customer c= new Customer(email);
		
		if(cust.containsKey(email))
		{
			System.out.println("found");
		}
		else {
			throw new InvalidInputException("email is not found");
		}
//			System.out.println(cst.get(index));
				
	}
	public static void findByPassword(String password,Map<String,Customer>cust) throws InvalidInputException
	{
		String pattern="[a-z]+@[0-9]*";
		if(!password.matches(pattern))
		{
			throw new InvalidInputException("wrong password");
		}
		List<Customer>custlist=new ArrayList<>(cust.values());
		for(Customer c1:custlist)
		{
			
			if(c1.getPass().equals(password))
//				throw new InvalidInputException("password is is not found");
			System.out.println("login successful");
		}
		
		
	}
	public static void disableCustomer(Map<String, Customer> custMap)
	{
		  ArrayList<Customer> valueList = new ArrayList<Customer>(custMap.values());
		//for(Customer c1:custMap.values())
		  Iterator<Customer> itr=valueList.iterator();
		  while (itr.hasNext())
			  
		  { 
			 Customer c1 = itr.next();
			 
			long periondinmonth=Period.between(c1.getLastsubscriptionDate(), LocalDate.now()).toTotalMonths();
			if(periondinmonth>6)
			{
				custMap.remove(c1.getEmail());
			}
			
		}System.out.println("Customer status is update by admin!");
	}
	public static void updatePassword(String oldpass,String newpass, Map<String,Customer>cust) throws InvalidInputException 
	{
		String pattern="[a-z]+@[0-9]*";
		if(!oldpass.matches(pattern))
		{
			throw new InvalidInputException("wrong password");
		}
		List<Customer>custlist=new ArrayList<>(cust.values());
		for(Customer c1:custlist)
		{
			
			if(c1.getPass().equals(oldpass))
//				throw new InvalidInputException("password is is not found");
				c1.setPass(newpass);
//		
		}
		
//		if(c.getPass().equals(oldpass))
//		{
//		c.setPass(newpass);
//		}
//		else 
//		{
//			throw new InvalidInputException("passwor is updated successfully");
//		}
			
	}
}
