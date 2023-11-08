package com.code;

import java.util.Comparator;

public class CustomOrderBydobAndName implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		int i=c1.getDob().compareTo(c2.getDob());
	if(i==-1)
		return -1;
	if(i==0)
		return 0;
	return 1;
	}
	

	
}
