
	package com.code;

	import java.time.LocalDate;

	public class Customer {
	private int custid;
	private String fName;
	private String lName;
	private String email;
	private String pass;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan splan;
	private boolean isActive;
	private LocalDate lastsubscriptionDate;

	
	public Customer(String email) {
		super();
		this.email = email;
	}

	public Customer(int custid, String fName, String lName, String email, String pass, double regAmount, LocalDate dob,
			ServicePlan splan, LocalDate lastsubscriptionDate) {
		super();
		this.custid = custid;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pass = pass;
		this.regAmount = regAmount;
		this.dob = dob;
		this.splan = splan;
		this.lastsubscriptionDate = lastsubscriptionDate;
		this.isActive=true;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setLastsubscriptionDate(LocalDate lastsubscriptionDate) {
		this.lastsubscriptionDate = lastsubscriptionDate;
	}
	public LocalDate getLastsubscriptionDate() {
		return lastsubscriptionDate;
	}


	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", pass="
				+ pass + ", regAmount=" + regAmount + ", dob=" + dob + ", splan=" + splan + ", lastsubscriptionDate="
				+ lastsubscriptionDate + "]";
	}

	
	
}

	
