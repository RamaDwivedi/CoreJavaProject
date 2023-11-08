package utils;

import java.util.HashMap;
import java.util.Map;
import static java.time.LocalDate.parse;
import com.code.Department;
import com.code.Doctor;
//int docId, String dname, String email, String degree, LocalDate joining, double salary, int experience,
//Department deptname)
public class DoctorPopulate {
public static Map<String,Doctor> populateDoctor()
{
	Map<String,Doctor> map=new HashMap<>();
	map.put("raja@gmail.com", new Doctor(101,"Raja","raja@gamil.com","MBBS",parse("2001-10-09"),50000,23,Department.ORTHO));
	map.put("ankit@gmail.com", new Doctor(102,"Ankit","ankit@gamil.com","MD",parse("2005-10-09"),70000,18,Department.GASTROLOGY));
	map.put("rahul@gmail.com", new Doctor(103,"Rahul","rahul@gamil.com","MBBS",parse("2007-08-09"),60000,16,Department.PEDIATRICS));
	map.put("golu@gmail.com", new Doctor(104,"Golu","golu@gamil.com","MSCNursing",parse("2010-10-09"),80000,13,Department.PHYSIIOTHEROPY));
	map.put("pragya@gmail.com", new Doctor(105,"Pragya","pragya@gamil.com","MD",parse("2011-10-09"),60000,12,Department.ORTHO));
	return map;
}
	
}
