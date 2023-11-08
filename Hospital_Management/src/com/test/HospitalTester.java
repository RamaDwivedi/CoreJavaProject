package com.test;

import java.util.Map;
import java.util.Scanner;
import static utils.ValidateClass.*;
import static utils.DoctorPopulate.populateDoctor;
import static utils.Serializable.*;

import com.code.Department;
import com.code.Doctor;

public class HospitalTester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
//			Map<String,Doctor>map=populateDoctor();
			System.out.println("please enter the file name");
			@SuppressWarnings("unchecked")
			Map<String,Doctor>map =(Map<String, Doctor>) restoreDetails(sc.next());
			
			 boolean exit=false;
			while(!exit)
			{
				System.out.println("1.signin \n"+"2.add the details\n"+"3.store in binary file"+"4.restore from binary");
				System.out.println("5.name of highest paid doctor"+"6.sort on basis of experince"+"7.details of doctor work in ortho");
				System.out.println("8.display the details");
				System.out.println("please enter the choice");
				try
				{
					switch(sc.nextInt())
				
				{
				case 1:
					System.out.println("please enter the email and doctorid for login");
					validateEmailAndPassword(map,sc.next(),sc.nextInt());
					break;
				case 2:
					System.out.println("enter the doctor deatils");
					System.out.println(" docId, dname,  email, degree,  joining,  salary,  experience,\r\n"
							+ " deptname");
					Doctor d=validateAll(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.nextInt(),sc.next());
					map.putIfAbsent(d.getEmail(), d);
					System.out.println("details added successfully");
					break;
				case 3:
					System.out.println("please enter the filename");
					storeDetails(map,sc.next());
					System.out.println("deatils are stored in file");
					break;
				case 4:
					System.out.println("display record");
					System.out.println("please enter the file name for restore");
					System.out.println(restoreDetails(sc.next()));
					break;
				case 5:
					
					String name=map.values().stream()
					.max((d1,d2)->((Double)d1.getSalary()).compareTo(d2.getSalary())).orElseThrow().getDname();
					System.out.println("name of the ghighest paid doctor "+name);
					break;
				case 6:
					System.out.println("all doctor details on the basis off experinece");
					map.values().stream().sorted((d1,d2)->((Integer)d1.getExperience()).compareTo(d2.getExperience()))
					.forEach(d1->System.out.println(d1));
					break;
				case 7:
					System.out.println("deatils of doctor who have worked in ortho department");
					map.values().stream().filter(d2->d2.getDeptname().equals(Department.ORTHO)).forEach(d2->System.out.println(d2));
					break;
				case 8:
					System.out.println("disply all doctor details");
					map.forEach((k,v)->System.out.println(v));
					break;
				case 0:
					exit=true;
					break;
				}
			}catch(Exception e)
				{
				System.out.println(e);
				e.printStackTrace();
				
			}
		}
		

	}catch(Exception e)
		{
		System.out.println(e);
		e.printStackTrace();
		
	}

}
}
