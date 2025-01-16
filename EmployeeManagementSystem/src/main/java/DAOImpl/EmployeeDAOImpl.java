package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.EmployeeDAO;
import Utility.ConnectionProvider;
import model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement prst;
	String query;
	ResultSet rs;

	@Override
	public boolean saveEmployee(Employee e) throws SQLException {
		int i = 0;
		query = "insert into employee (first_name,last_name,email,contact,job_title,department_id,salary) values(?,?,?,?,?,?,?)";
		prst = con.prepareStatement(query);
		prst.setString(1, e.getFirst_name());
		prst.setString(2, e.getLast_name());
		prst.setString(3, e.getEmail());
		prst.setLong(4, e.getContact());
		prst.setString(5, e.getJob_title());
		prst.setInt(6, e.getDepartment_id());
		prst.setDouble(7, e.getSalary());
		i = prst.executeUpdate();
		return i > 0;
	}

	@Override
	public boolean deleteEmployee(int id) throws SQLException {
		int i = 0;
		query = "delete from employee where emp_id=?";
		prst = con.prepareStatement(query);
		prst.setInt(1, id);
		i = prst.executeUpdate();
		return i > 0;
	}

	@Override
	public List<Employee> displayEmployee() throws SQLException {
		List<Employee> emp = new ArrayList<Employee>();
		query = "select * from employee";
		prst = con.prepareStatement(query);
		rs = prst.executeQuery();
		Employee e = null;
		while (rs.next()) {
			e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
					rs.getString(6), rs.getInt(7), rs.getDouble(8));
			emp.add(e);
		}
		return emp;
	}

	@Override
	public Employee findEmployeeById(int id) throws SQLException {
		query = "select * from employee where emp_id=?";
		prst = con.prepareStatement(query);
		prst.setInt(1, id);
		rs = prst.executeQuery();
		if (rs.next())
			return (new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
					rs.getString(6), rs.getInt(7), rs.getDouble(8)));
		return null;
	}

	@Override
	public boolean updateEmployee(Employee e) throws SQLException {
		int i = 0;
		query = "update employee set first_name=?,last_name=?,email=?,contact=?,job_title=?,department_id=?,salary=? where emp_id=?";
		prst=con.prepareStatement(query);
		prst.setString(1, e.getFirst_name());
		prst.setString(2, e.getLast_name());
		prst.setString(3, e.getEmail());
		prst.setLong(4, e.getContact());
		prst.setString(5, e.getJob_title());
		prst.setInt(6, e.getDepartment_id());
		prst.setDouble(7, e.getSalary());
		prst.setInt(8,e.getDepartment_id());
		i = prst.executeUpdate();
		return i > 0;
	}

}
