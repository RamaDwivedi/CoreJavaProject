package com.test;
import static com.utils.IoUtils.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static com.utils.PopulateCustomer.populateCustomer;
import com.code.Customer;
import com.code.Plan;

import static com.utils.Check.updatePassword;
import static com.utils.ValidateCustomer.validateAll;
import static com.utils.ValidateCustomer.*;
public class CustomerTester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
		
			Map<String, Customer>custMAp=populateCustomer();
			List<Customer>list=new ArrayList<>(custMAp.values());
			boolean exit =false;
			while(!exit)
			{
				System.out.println("1.sign up 2.sigin 3.update password 4.sorted 5.Unsubscribe by plan monthwise(1,4,6,12)\"6.Display 7. display first name as capital 0. exit");
				System.out.println("8.display the registraion date in month 01 9.count the number wo have monthly plan");
				System.out.println("10.Search the Customer who lived in Akurdi.11.set final amount");
				System.out.println("12.store data in binary format 13.restore from binary to application");
				System.out.println("please enter the choice");
				try
				{
					switch(sc.nextInt())
				
				{
				case 1:
					System.out.println("please enter the customer details");
					System.out.println("custId,fname,lname,email,pass,address,phoneNo,final_amount,plan1");
					Customer c=validateAll(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),
							sc.next(),sc.nextDouble(),sc.next(),custMAp);
					custMAp.putIfAbsent(c.getEmail(), c);
					System.out.println(c);
					System.out.println("customer added");
					break;
//				case 2:
//					System.out.println("please enter the email");
//					String email=sc.next();
//					validateDuplicateEmail(custMAp,email);
//					System.out.println("pleasSe enter the password");
//					validatePassword(custMAp,sc.next());
//					System.out.println("login successful");
//					break;
				case 2:
					System.out.println("please enter the email and password");
					validateEmailAndPassword(custMAp,sc.next(),sc.next());
					break;
				
                  case 3:
                	  System.out.println("please enter the old pass and new password");
                	  updatePassword(sc.next(),sc.next(),custMAp);
                	  System.out.println("password updted successfully");
					break;
				case 4:
					custMAp.values().stream().sorted((c1,c2)->c1.getFname().compareTo(c2.getFname())).forEach(k->System.out.println(k));
					System.out.println("........................");
					custMAp.values().stream().sorted((c1,c2)->c1.getPlan().compareTo(c2.getPlan())).forEach(s->System.out.println(s));
					System.out.println("......................");
					custMAp.values().stream().sorted((c1,c2)->c1.getRegisterDate().compareTo(c2.getRegisterDate())).forEach(s->System.out.println(s));
					break;
				
				case 5:
					System.out.println("enter the month(1,3,6,12)");
					int month =sc.nextInt();
					if(month==1)
					{
						custMAp.values().removeIf(p->p.getPlan().equals(Plan.MONTHLY));
					}
					else if (month==3)
					{
						custMAp.values().removeIf(p->p.getPlan().equals(Plan.QUATERLY));
					}
					else if(month==6)
					{
						custMAp.values().removeIf(p->p.getPlan().equals(Plan.HALFYEAR));
					}
					else {
						custMAp.values().removeIf(p->p.getPlan().equals(Plan.YEARLY));
					}
					break;
				case 6:
					custMAp.forEach((k,v)->System.out.println(v));
					break;
				case 7:
					
					for (Customer customer : list) {
			            String firstName = customer.getFname();
			            if (!firstName.isEmpty()) {
			         
			                firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
			                customer.setFname(firstName);
			            }
			        }
					for (Customer customer : list) {
			        	System.out.println(customer);		            
			        }
					break;
					
				case 8:
					 for (Customer customer : list) {
				            if (customer.getRegisterDate().getMonthValue() == 1) {
				                System.out.println(customer.getEmail());
				            }
				        }
					 
					break;
				case 9:
					long count=custMAp.values().stream().filter(p->p.getPlan().equals(Plan.MONTHLY)).count();
					System.out.println("the no of customer who have take monthly plan = "+count);
					break;
				case 10:
					custMAp.values().stream().filter(p->p.getAddress().equals("Akhurdi")).forEach(p->System.out.println(p));
					break;
				case 11:
					custMAp.values().stream().filter(p->p.getPlan().equals(Plan.YEARLY))
					.forEach(p->{
						p.setFinal_amount(p.getFinal_amount()-0.2*p.getFinal_amount());
							System.out.println(p);
				});
		      			break;
				case 12:
					System.out.println("enter the filename to store");
					String file=sc.next();
					storeCustomerDetails(custMAp,file);
					break;
				case 13:
					System.out.println("enter the file name for restore");
					String filename=sc.next();
					System.out.println("Customer details: "+ restoreCustDetails(filename));
					
					break;
				case 0:
					exit =true;
					break;
				}
			}
				catch(Exception e)
				{
					sc.nextLine();
				e.printStackTrace();
				}
		}
	}

}
}
