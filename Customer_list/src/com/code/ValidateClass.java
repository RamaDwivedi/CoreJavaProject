package com.code;
import java.time.LocalDate;
import java.util.List;
public class ValidateClass {
	
//		add a method to parse and validate service plan
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
//		add a method to parse and validate registration amount with plan
		public static void parseAndValidateRegistration(ServicePlan p, double regspl)throws InvalidInputException
		{
			if(p.getPlancharge()!=regspl)
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
//		add a static method to validate email
//		1 well formed email :[a-z] +[a-z0-9]+[@[a-z]*\\(.(com\org\net)"
//		string: public boolean match (String reex)
//		no duplicate
		
		public static void validateDup(String email,List<Customer>c1) throws InvalidInputException
		{
		
			Customer c= new Customer(email);
			String pattern="[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
			if(!email.matches(pattern))
			{
				throw new InvalidInputException("invalid email");
			}
			
			if(c1.contains(c))
			
				throw new InvalidInputException("duplicate email enter");
			
		}
public static void validPassword(String pass,List<Customer>list) throws InvalidInputException
{
	String pattern="[a-z]+@[0-9]*";
	if(!pass.matches(pattern))
	{
		throw new InvalidInputException("wrong password");
	}
}
		
//		add a method to parse and validate All
		public static Customer validateAll(String fName, String lName, String email, String pass, double regAmount, String dob,
		String splan,List<Customer>c1,LocalDate lastsubscriptionDate)throws InvalidInputException
		{
			validPassword(pass,c1);
			validateDup(email,c1);
			ServicePlan s=parseAndValidatePlan(splan);
			parseAndValidateRegistration(s,regAmount);
			LocalDate l=parseDate(dob);
			return new Customer(fName, lName, email, pass, regAmount, l,
					s,lastsubscriptionDate);
			
		}
	}

