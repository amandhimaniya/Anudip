package model;

import java.sql.Date;

public class Attendance {
	private int attendance_id;
	private int emp_id;
	private Date attendance_date;
	private String status;
	public Attendance() {
		super();
	}
	public Attendance(int attendance_id, int emp_id, Date attendance_date, String status) {
		super();
		this.attendance_id = attendance_id;
		this.emp_id = emp_id;
		this.attendance_date = attendance_date;
		this.status = status;
	}
	public int getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public Date getAttendance_date() {
		return attendance_date;
	}
	public void setAttendance_date(Date attendance_date) {
		this.attendance_date = attendance_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Attendance_id=" + attendance_id + "\nEmp_id=" + emp_id + "\nAttendance_date="
				+ attendance_date + "\nStatus=" + status + "\n";
	}
	
	

}
