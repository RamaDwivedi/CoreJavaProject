package utils;

import static utils.DoctorPopulate.populateDoctor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.code.Doctor;

public interface Serializable {
public static Object restoreDetails(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
{
	try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename)))
	{
		return in.readObject();
	}
	catch(Exception e)
	{
		System.out.println(e);
		e.printStackTrace();
		return  populateDoctor();
	}
}
public static void storeDetails(Map<String,Doctor>map, String filename) throws FileNotFoundException, IOException
{
	try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
	{
	out.writeObject(map);	
	}
}
}
