package com.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.code.Customer;
import com.code.Plan;

import Exception.InvalidInputException;
public class ValidateCustomer {
public static void validateDuplicateEmail(Map<String,Customer>custMap,String email) throws InvalidInputException
{
	String pattern="[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
if(!email.matches(pattern))
{
	throw new InvalidInputException("invalid email");
}

if(custMap.containsKey(email))
	throw new InvalidInputException("duplicate email found");
	
	
}
public static LocalDate endPlanDate(LocalDate now,Plan newplan) {
LocalDate edate;

if(newplan==Plan.MONTHLY)
{
 edate=now.plusMonths(1);
}
else if(newplan==Plan.QUATERLY)
{
 edate=now.plusMonths(3);
}
else if(newplan==Plan.HALFYEAR)
{
 edate=now.plusMonths(6);
}
else
{
 edate=now.plusMonths(12);
}
return edate;


}
public static void validatePlan(Plan p, double final_amount) throws InvalidInputException
{
	if(final_amount!=p.getMinBalance())
	throw new InvalidInputException("final amount is not amtch with plam");
}
public static void validateLocalDate(String date) throws  InvalidInputException
{
	LocalDate newdate=LocalDate.parse(date);
	LocalDate now=LocalDate.now();
	if(!newdate.isEqual(now)||newdate.isAfter(now))
	
	throw new InvalidInputException("please enter the today date");	
	
	
	
}
public static void validatePhoneNumber(String phonenumber) throws InvalidInputException
{
	  String regex = "^[0-9]{10}$";
	 if(!phonenumber.matches(regex))
		 throw new InvalidInputException("please enter 10 digit number");	
	  
}
public static void validatePassword(Map<String,Customer>map,String pass) throws InvalidInputException
{
	List<Customer>list=new ArrayList<>(map.values());
	
	for(Customer c:list)
	{
		if(c.getPass().equals(pass))
		{
			System.out.println("password match");
	}
		else
		{
			throw new InvalidInputException("invalid password");
		}
	}
	
}
public static void validateEmailAndPassword(Map<String,Customer>map,String email,String pass) throws InvalidInputException
{
	if(map.containsKey(email))
	{
		Customer customer=map.get(email);
		if(customer.getPass().equals(pass))
		{
			System.out.println("login successful");
		}
		else 
		{
			throw new InvalidInputException("please enter valid email and password");
		}
		
	}
}
public static Customer validateAll(int custId, String fname, String lname, String email, String pass, String address,
		 String phoneNo, double final_amount, String plan,Map<String,Customer>map) throws InvalidInputException 
{
	validateDuplicateEmail(map,email);
	validatePhoneNumber(phoneNo);
	LocalDate regdate=LocalDate.now();
	Plan plan1=Plan.valueOf(plan.toUpperCase());
	validatePlan(plan1,final_amount);
	LocalDate enddate=endPlanDate(regdate,plan1);
	return new Customer(custId,fname,lname,email,pass,address,phoneNo,regdate,enddate,final_amount,plan1);
	
}
}
