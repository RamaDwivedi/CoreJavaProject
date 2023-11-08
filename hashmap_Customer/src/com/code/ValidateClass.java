package com.code;

import java.time.LocalDate;
import java.util.Map;

public class ValidateClass {

	public static void validateEmail(String email,Map<String,Customer> mp) throws InvalidInputException
	{
		
		String pattern="[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if(!email.matches(pattern))
		{
			throw new InvalidInputException("invalid email");
		}
		
		
		if(mp.containsKey(email))
			throw new InvalidInputException("email is not found");
		
	}
	public static ServicePlan parseAndValidatePlan(String splan) throws  InvalidInputException
	{
		try{
	return ServicePlan.valueOf(splan.toUpperCase());
	}
		catch(Exception e)
		{
			throw new InvalidInputException("you have enter wrong serviceplan");
		}
}
	public static void parseAndValidateRegistration(ServicePlan p, double regspl)throws InvalidInputException
	{
		if(p.getPlanCharge()!=regspl)
		{
			throw new InvalidInputException("Registration amount does not mathc ");
			
		}

		
	}
	public static LocalDate parseDate(String date) throws  InvalidInputException
	{
		try {
		return LocalDate.parse(date);
	}
	catch(Exception e)
	{
		throw new InvalidInputException("you have neterded wrong date ");	
	}
	}
	public static void validPassword(String pass,Map<String,Customer>cust) throws InvalidInputException
	{
		String pattern="[a-z]+@[0-9]*";
		if(!pass.matches(pattern))
		{
			throw new InvalidInputException("wrong password");
		}
	}
	public static Customer validateAll(int custId,String fName, String lName, String email, String pass, double regAmount, String dob,
			String splan,LocalDate lastsubscriptionDate,Map<String,Customer> cust1)throws InvalidInputException
			{
				validPassword(pass,cust1);
				ServicePlan s=parseAndValidatePlan(splan);
				parseAndValidateRegistration(s,regAmount);
				LocalDate l=parseDate(dob);
				return new Customer(custId,fName, lName, email, pass, regAmount, l,
						s,lastsubscriptionDate);
				
			}

	
}
