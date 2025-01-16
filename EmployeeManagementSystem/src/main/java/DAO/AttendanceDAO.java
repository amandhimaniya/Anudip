package DAO;

import java.sql.SQLException;
import java.util.List;

import model.Attendance;

public interface AttendanceDAO {
	boolean markAttendence(Attendance a) throws SQLException;
	List<Attendance> viewAttendance() throws SQLException;
	List<Attendance> viewAttendanceByEmp(int id) throws SQLException;
	int countAttendance(Attendance a) throws SQLException;
	//boolean updateAttendence(String status)

}
