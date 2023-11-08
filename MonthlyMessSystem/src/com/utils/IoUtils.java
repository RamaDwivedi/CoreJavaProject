package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.code.Customer;

public class IoUtils {
public static void storeCustomerDetails(Map<String,Customer>map,String filename) throws FileNotFoundException, IOException
{
	try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
	{
		out.writeObject(map);
	}
}
public static Object restoreCustDetails(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
	try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(file))){
		return in.readObject();
	}
}
}
