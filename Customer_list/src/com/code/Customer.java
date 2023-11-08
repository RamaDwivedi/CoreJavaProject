package com.code;

import java.time.LocalDate;

public class Customer implements Comparable<Customer>{
private int custid;
private String fName;
private String lName;
private String email;
private String pass;
private double regAmount;
private LocalDate dob;
private ServicePlan splan;
private static int count;
private LocalDate lastsubscriptionDate;


public Customer(String fName, String lName, String email, String pass, double regAmount, LocalDate dob,
		ServicePlan splan, LocalDate lastsubscriptionDate) {
	super();
	this.custid = count++;
	this.fName = fName;
	this.lName = lName;
	this.email = email;
	this.pass = pass;
	this.regAmount = regAmount;
	this.dob = dob;
	this.splan = splan;
	this.lastsubscriptionDate = lastsubscriptionDate;
	
}

public void setLastsubscriptionDate(LocalDate lastsubscriptionDate) {
	this.lastsubscriptionDate = lastsubscriptionDate;
}
public LocalDate getLastsubscriptionDate() {
	return lastsubscriptionDate;
}


public Customer(String email) {
	this.email=email;
}


public int getCustid() {
	return custid;
}

public void setCustid(int custid) {
	this.custid = custid;
}

public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}

public String getlName() {
	return lName;
}

public void setlName(String lName) {
	this.lName = lName;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public double getRegAmount() {
	return regAmount;
}

public void setRegAmount(double regAmount) {
	this.regAmount = regAmount;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public ServicePlan getSplan() {
	return splan;
}

public void setSplan(ServicePlan splan) {
	this.splan = splan;
}

public String getEmail() {
	return email;
}


static {
	count=1;
}

@Override
//email is primary key
public boolean equals(Object obj)
{
//	System.out.println("in equals method");
	if(obj instanceof Customer)
	{
		Customer c=(Customer)obj;
		return this.email.equals(c.email);
	}
	return false;
}
@Override
public String toString() {
	return "Customer [custid=" + custid + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", pass="
			+ pass + ", regAmount=" + regAmount + ", dob=" + dob + ", splan=" + splan + ", lastsubscriptionDate="
			+ lastsubscriptionDate + "]";
}


@Override
public int compareTo(Customer c)
{
	return this.email.compareTo(c.email);
	
}

}
