package com.test;

import static java.time.LocalDate.parse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import static com.code.ValidateClass.*;
import static com.code.CustomerLogin.*;
import com.code.Customer;
import com.code.InvalidInputException;
import static com.code.CustomerPopulate.populateCustomer;

public class CustomerTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Customer> cust1 = populateCustomer();
			boolean exit = false;
			while (!exit) {
				System.out.println("please enter the choice");
				System.out.println("1.signup 2.signin 3.update password 4.display 5.find the detail by gmail");
				System.out.println("6.find the detail by gmail 7. sort by email 8.sort by dob");
				System.out.println("9.sort by dob and lastname,10.remove datawhose subscription is pending from 6 month and display there full nam");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("enter the custid,fname,lname,email,passwoed,regamt,dob,splan,lastsubs");
						Customer c = validateAll(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), parse(sc.next()), cust1);
						// Customer c =new Customer
						// (sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),parse(sc.next()),ServicePlan.valueOf(sc.next()),parse(sc.next()));
						System.out.println("enter keyvalue customerid ");
						cust1.put(sc.next(), c);
					System.out.println("customer get added");
				    
						break;
					case 2:
						System.out.println("signin");
						System.out.println("enter email");
						findByEmail(sc.next(), cust1);
						System.out.println("enter password");
						findByPassword(sc.next(), cust1);
						 

						break;
					case 3:
						System.out.println("update password");
						System.out.println("enter oldpw");
						System.out.println("enter newps");
						updatePassword(sc.next(), sc.next(), cust1);
						break;
					case 4:
						for (Customer c2 : cust1.values()) {
							System.out.println(c2);
						}
						break;
					case 5:
						System.out.println("find the detail by gmail");
						c = cust1.get(sc.next());
						if (c == null)
							throw new InvalidInputException("invalid customer id");
						System.out.println("Customer details " + c);
						break;
					case 6:
						System.out.println("Remove details by gmail");
						c = cust1.remove(sc.next());
						if (c == null)
							throw new InvalidInputException("invalid customer id");
						System.out.println("Customer details removed with name " + c.getfName() + " " + c.getlName());
						break;
					case 7:
						System.out.println("Sort by key ");
						TreeMap<String, Customer> tm = new TreeMap<>(cust1);
						for (Customer c1 : tm.values()) {
							System.out.println(c1);
						}
						break;
					case 8:
						System.out.println("sort by Date of birth");
						List<Customer> acctlist = new ArrayList<>(cust1.values());
						Collections.sort(acctlist, new Comparator<Customer>() {

							@Override
							public int compare(Customer o1, Customer o2) {

								return o1.getDob().compareTo(o2.getDob());
							}

						});
						for (Customer c2 : acctlist) {
							System.out.println(c2);
						}
						break;
					case 9:
						System.out.println("sort by dob and last name");
						List<Customer> custlist = new ArrayList<>(cust1.values());
						Collections.sort(custlist, new Comparator<Customer>() {

							@Override
							public int compare(Customer o1, Customer o2) {
								int i = o1.getDob().compareTo(o2.getDob());
								if (i == 0) {
									return o1.getlName().compareTo(o2.getlName());
								}
								return i;
							}
						});
						for (Customer c3 : custlist) {
							System.out.println(c3);
						}
						break;
					case 10:
						System.out.println(
								"remove datawhose subscription is pending from 6 month and display there full name");
						disableCustomer(cust1);
						break;
					
					case 0:
						exit = true;
						break;

					}

				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}

			}
		}

	}

}
