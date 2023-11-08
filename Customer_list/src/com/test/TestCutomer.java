package com.test;

import java.util.Scanner;
import com.code.Customer;
import com.code.ServicePlan;
import static com.code.ValidateClass.validateAll;

public class TestCutomer {

	public static void main1(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			for(ServicePlan s:ServicePlan.values())
			{
				System.out.println(s);
			}
			System.out.println("please enter the String fName, String lName, String email, String pass, double regAmount, LocalDate dob,\r\n"
					+ "		ServicePlan splan");
//			Customer c= new Customer(sc.next(),sc.next(), sc.next(), sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()),
//					ServicePlan.valueOf(sc.next()));
			Customer c2=validateAll(sc.next(),sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(),
					sc.next());
//			Customer c1=validateAll()
			System.out.println(c2);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
