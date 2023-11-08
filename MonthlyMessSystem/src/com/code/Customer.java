package com.code;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Customer implements Serializable {
//	Customer id(int) , first name(String), last name (String), 
//	email(String), password(String), Address String, RegisterDate(LocalDate), planEndDate(LocalDate), 
//	Address(String), Phone No(String),plan Enum, final_amount double
private int custId;
private String fname;
private String lname;
private String email;
private String pass;
private String address;
private LocalDate registerDate;
private LocalDate planEndDate;
private String phoneNo;
private double final_amount;
private Plan plan;


public Customer(int custId, String fname, String lname, String email, String pass, String address,String phoneNo,
		LocalDate registerDate, LocalDate planEndDate,  double final_amount, Plan plan) {
	super();
	this.custId = custId;
	this.fname = fname;
	this.lname = lname;
	this.email = email;
	this.pass = pass;
	this.address = address;
	this.registerDate = registerDate;
	this.planEndDate = planEndDate;
	this.phoneNo = phoneNo;
	this.final_amount = final_amount;
	this.plan = plan;
}

public double getFinal_amount() {
	return final_amount;
}

public void setFinal_amount(double final_amount) {
	this.final_amount = final_amount;
}

public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public LocalDate getRegisterDate() {
	return registerDate;
}
public void setRegisterDate(LocalDate registerDate) {
	this.registerDate = registerDate;
}
public LocalDate getPlanEndDate() {
	return planEndDate;
}
public void setPlanEndDate(LocalDate planEndDate) {
	this.planEndDate = planEndDate;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public Plan getPlan() {
	return plan;
}
public void setPlan(Plan plan) {
	this.plan = plan;
}
public String getEmail() {
	return email;
}

@Override
public String toString() {
	return "Customer [custId=" + custId + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", pass="
			+ pass + ", address=" + address + ", registerDate=" + registerDate + ", planEndDate=" + planEndDate
			+ ", phoneNo=" + phoneNo + ", final_amount=" + final_amount + ", plan=" + plan + "]\n";
}

}
