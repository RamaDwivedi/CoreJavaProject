package utils;

import java.time.LocalDate;
import java.util.Map;

import com.code.Department;
import com.code.Doctor;
import com.exception.CustomException;

public class ValidateClass {
public static LocalDate validateDateOfJoining(String doj) throws CustomException
{
	LocalDate newdate=LocalDate.of(2001, 05, 10);

	LocalDate date=LocalDate.parse(doj);
	if(date.isAfter(newdate))		
	return date;
	throw new CustomException("please enter the date after 10 may 2001");	
}
public static void validateEmailAndPassword(Map<String,Doctor>map,String email,int docId) throws CustomException
{
	if(map.containsKey(email))
	{
		Doctor d=map.get(email);
	if(d.getDocId()==docId)
	{
		System.out.println("login successful");
	}
	else
	{
		throw new CustomException("invalid password");
	}
}
	else {
		throw new CustomException("invalid email");
	}
}

public static Doctor validateAll(int docId, String dname, String email, String degree, String joining, double salary, int experience,
		String deptname) throws CustomException
{
	validateDateOfJoining(joining);
	LocalDate doj=LocalDate.parse(joining);
	Department dept=Department.valueOf(deptname.toUpperCase());
	
	return new Doctor(docId,dname,email,degree,doj,salary,experience,dept);

	
	
	
	
	
	
	
	
	
}
}
