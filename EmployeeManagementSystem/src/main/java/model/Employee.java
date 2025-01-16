package model;

public class Employee {
	
private int emp_id;
private String first_name;
private String last_name;
private String email;
private long contact;
private String job_title;
private int department_id;
private double salary;
public Employee() {
	super();
}
public Employee(int emp_id, String first_name, String last_name, String email, long contact, String job_title,
		int department_id, double salary) {
	super();
	this.emp_id = emp_id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.email = email;
	this.contact = contact;
	this.job_title = job_title;
	this.department_id = department_id;
	this.salary = salary;
}
public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
public String getJob_title() {
	return job_title;
}
public void setJob_title(String job_title) {
	this.job_title = job_title;
}
public int getDepartment_id() {
	return department_id;
}
public void setDepartment_id(int department_id) {
	this.department_id = department_id;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Emp_id=" + emp_id + "\nFirst_name=" + first_name + "\nLast_name=" + last_name + "\nEmail=" + email
			+ "\nContact=" + contact + "\nJob_title=" + job_title + "\nDepartment_id=" + department_id + "\n Base_Salary="
			+ salary + "\n";
}


}
