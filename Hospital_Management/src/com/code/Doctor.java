package com.code;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Doctor implements Serializable {
private int docId;
private String dname;
private String email;
private String degree;
private LocalDate joining;
private double salary;
private int experience;
private Department deptname;

public Doctor(int docId, String dname, String email, String degree, LocalDate joining, double salary, int experience,
		Department deptname) {
	super();
	this.docId = docId;
	this.dname = dname;
	this.email = email;
	this.degree = degree;
	this.joining = joining;
	this.salary = salary;
	this.experience = experience;
	this.deptname = deptname;
}

public String getDname() {
	return dname;
}

public Department getDeptname() {
	return deptname;
}

public void setDeptname(Department deptname) {
	this.deptname = deptname;
}

public void setDname(String dname) {
	this.dname = dname;
}

public int getDocId() {
	return docId;
}
public void setDocId(int docId) {
	this.docId = docId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public LocalDate getJoining() {
	return joining;
}
public void setJoining(LocalDate joining) {
	this.joining = joining;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}

@Override
public String toString() {
	return "Doctor [docId=" + docId + ", dname=" + dname + ", email=" + email + ", degree=" + degree + ", joining="
			+ joining + ", salary=" + salary + ", experience=" + experience + ", deptname=" + deptname + "]\n";
}






	
	
}
