package model;

import java.sql.Date;

public class Salary {
	private int salary_id;
	private int emp_id;
	private Date payment_date;
	private Double amount;
	private String payment_method;
	public Salary() {
		super();
	}
	public Salary(int salary_id, int emp_id, Date payment_date, Double amount, String payment_method) {
		super();
		this.salary_id = salary_id;
		this.emp_id = emp_id;
		this.payment_date = payment_date;
		this.amount = amount;
		this.payment_method = payment_method;
	}
	public int getSalary_id() {
		return salary_id;
	}
	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	@Override
	public String toString() {
		return "Salary_id=" + salary_id + "\nEmp_id=" + emp_id + "\nPayment_date=" + payment_date + "\nAmount="
				+ amount + "\nPayment_method=" + payment_method + "\n";
	}
	

}
