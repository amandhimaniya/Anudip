package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.SalaryDAO;
import Utility.ConnectionProvider;
import model.Salary;

public class SalaryDAOImpl implements SalaryDAO {
	
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement prst;
	String query;
	ResultSet rs;

	@Override
	public boolean processSalary(Salary s) throws SQLException {
		int i=0;
		query="insert into salary(emp_id,payment_date,amount,payment_method) values(?,?,?,?)";
		prst=con.prepareStatement(query);
		prst.setInt(1, s.getEmp_id());
		prst.setDate(2, s.getPayment_date());
		prst.setDouble(3,s.getAmount());
		prst.setString(4, s.getPayment_method());
		i=prst.executeUpdate();
		return i>0;
	}

	@Override
	public List<Salary> viewSalaryHistory() throws SQLException {
		List<Salary> history=new ArrayList<Salary>();
		Salary s=null;
		query="select * from salary";
		prst=con.prepareStatement(query);
		rs=prst.executeQuery();
		while(rs.next())
		{
			s= new Salary(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDouble(4),rs.getString(5));
			history.add(s);
		}
		return history;
	}

	@Override
	public List<Salary> generateSalarySlip(int id) throws SQLException {
		List<Salary> slip=new ArrayList<Salary>();
		Salary s=null;
		query="select * from salary where emp_id=?";
		prst=con.prepareStatement(query);
		prst.setInt(1, id);
		rs=prst.executeQuery();
		while(rs.next())
		{
			s= new Salary(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDouble(4),rs.getString(5));
			slip.add(s);
		}
		return slip;
	}

	@Override
	public double calculateSalary(int c,int id) throws SQLException {
		query="select salary from employee where emp_id=?";
		prst=con.prepareStatement(query);
		prst.setInt(1, id);
		rs=prst.executeQuery();
		if(rs.next())
			return (c*rs.getDouble(1));
		return 0;
	}

}
