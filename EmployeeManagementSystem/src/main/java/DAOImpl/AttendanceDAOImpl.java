package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.AttendanceDAO;
import Utility.ConnectionProvider;
import model.Attendance;

public class AttendanceDAOImpl  implements AttendanceDAO{
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement prst;
	String query;
	ResultSet rs;

	@Override
	public boolean markAttendence(Attendance a) throws SQLException {
		int i=0;
		query="insert into attendance(emp_id,attendance_date,status) values(?,?,?)";
		prst=con.prepareStatement(query);
		prst.setInt(1, a.getEmp_id());
		prst.setDate(2,a.getAttendance_date());
		prst.setString(3, a.getStatus());
		i=prst.executeUpdate();
		return i>0;
	}

	@Override
	public List<Attendance> viewAttendance() throws SQLException {
		List<Attendance> att= new ArrayList<Attendance>();
		Attendance a= null;
		query="select * from attendance";
		prst=con.prepareStatement(query);
		rs=prst.executeQuery();
		while(rs.next())
		{
			a=new Attendance(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4));
			att.add(a);
		}
		return att;
	}

	@Override
	public List<Attendance> viewAttendanceByEmp(int id) throws SQLException {
		List<Attendance> att= new ArrayList<Attendance>();
		Attendance a= null;
		query="select * from attendance where emp_id=?";
		prst=con.prepareStatement(query);
		prst.setInt(1, id);
		rs=prst.executeQuery();
		while(rs.next())
		{
			a=new Attendance(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4));
			att.add(a);
		}
		return att;
	}

	@Override
	public int countAttendance(Attendance a) throws SQLException {
		query="select count(*) from attendance where emp_id=? and status=?";
		prst=con.prepareStatement(query);
		prst.setInt(1, a.getEmp_id());
		prst.setString(2,a.getStatus());
		rs=prst.executeQuery();
		if(rs.next())
			return rs.getInt(1);
		return 0;
	}

}
