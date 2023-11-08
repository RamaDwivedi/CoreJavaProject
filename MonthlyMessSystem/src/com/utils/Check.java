package com.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.code.Customer;

public interface Check {

public static void updatePassword(String oldpass,String newPass,Map<String,Customer>map)
{
	List<Customer>list=new ArrayList<>(map.values());
	for(Customer c:list)
	{
		if(c.getPass().equals(oldpass))
			c.setPass(newPass);
	}
}
}

//public static void validateExpire(String regdate,Map<String,Customer> map)
//{
//	List<Customer>list=new ArrayList<>(map.values());
//	LocalDate now=LocalDate.now();
//	LocalDate regdate1=LocalDate.parse(regdate);
//	@SuppressWarnings("unused")
//	long totalmonth=Period.between(now,regdate1).toTotalMonths();
//	Iterator<Customer> itr=list.iterator();
//	while(itr.hasNext())
//	{
//		Customer c=itr.next();
////		if(totalmonth>)
//	}
//}