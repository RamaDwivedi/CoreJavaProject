package com.utils;

import static java.time.LocalDate.parse;

import java.util.HashMap;
import java.util.Map;
import com.code.Customer;
import com.code.Plan;

//int custId, String fname, String lname, String email, String pass, String address,
//LocalDate registerDate, LocalDate planEndDate, String phoneNo, double final_amount, Plan plan
public class PopulateCustomer {

	public static Map<String,Customer> populateCustomer()
	{
		Map<String,Customer> map=new HashMap<>();
		map.put("rama@gmail.com", new Customer(101,"Rama","Dwivedi","rama@gmail.com","ram@123","pune","9893772642",parse("2023-11-14"), parse("2023-12-14"),3000,Plan.MONTHLY));
		map.put("raja@gmail.com", new Customer(102,"ankit","Dwivedi","raja@gmail.com","raj@123","Akhurdi","9893233456",parse("2023-11-04"), parse("2024-05-04"),17500,Plan.HALFYEAR));
		map.put("ankit@gmail.com", new Customer(103,"Rahul","Shukla","ankit@gmail.com","raki@123","pune","9896789809",parse("2023-10-13"), parse("2024-04-13"),17500,Plan.HALFYEAR));
		map.put("golu@gmail.com", new Customer(104,"raja","Mishra","golu@gmail.com","rali@123","mumbai","9893772642",parse("2024-04-28"), parse("2021-08-28"),11700,Plan.QUATERLY));
		map.put("pragya@gmail.com", new Customer(105,"Golu","Dwivedi","pragya@gmail.com","ra@123","Akhurdi","9893772642",parse("2024-01-01"), parse("2025-01-01"),32000,Plan.YEARLY));
		return map;
		}
}


