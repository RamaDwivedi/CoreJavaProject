package com.code;

import static java.time.LocalDate.parse;

import java.util.HashMap;
import java.util.Map;

public class CustomerPopulate {

	public static Map<String, Customer> populateCustomer()
	{
		Map<String,Customer> cust=new HashMap<String, Customer>();
		System.out.println("Added"+cust.put("rama@gmail.com", new Customer(101,"Raja","Dwivedi","rama@gmail.com","ram@1234",1000,parse("1928-12-01"),ServicePlan.SILVER,parse("2023-05-01"))));
		System.out.println("Added"+cust.put("raj@gmail.com", new Customer(102,"Raj","Dwivedi","raj@gmail.com","raj@1234",2000,parse("2023-12-01"),ServicePlan.GOLD,parse("2021-10-01"))));
		System.out.println("Added"+cust.put("rahul@gmail.com", new Customer(103,"Rahul","Dwivedi","rahul@gmail.com","rahul@1234",5000,parse("2022-12-01"),ServicePlan.dIAMOND,parse("2023-09-01"))));
		System.out.println("Added"+cust.put("ram@gmail.com", new Customer(101,"Ram","Dwivedi","ram@gmail.com","rama@1234",5000,parse("2020-10-01"),ServicePlan.dIAMOND,parse("2022-09-01"))));
		System.out.println("Added"+cust.putIfAbsent("ankit@gmail.com", new Customer(104,"Ankit","Dwivedi","ankit@gmail.com","ankit@1234",10000,parse("2021-05-01"),ServicePlan.PLATINUM,parse("2023-01-01"))));
		return cust;
		
	}
}
