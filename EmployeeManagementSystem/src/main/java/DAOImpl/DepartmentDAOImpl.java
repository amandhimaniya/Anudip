package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DepartmentDAO;
import Utility.ConnectionProvider;
import model.Department;

public class DepartmentDAOImpl implements DepartmentDAO{
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement prst;
	String query;
	ResultSet rs;

	@Override
	public boolean saveDepartment(Department d) throws SQLException {
		int i = 0;
		query = "insert into department(department_name,manager_id) values(?,?)";
		prst = con.prepareStatement(query);
		prst.setString(1, d.getDepartment_name());
		prst.setInt(2, d.getManager_id());
		i = prst.executeUpdate();
		return i > 0;
	}

	@Override
	public boolean deleteDepartment(int id) throws SQLException {
		int i = 0;
		query = "delete from department where department_id=?";
		prst = con.prepareStatement(query);
		prst.setInt(1, id);
		i = prst.executeUpdate();
		return i > 0;
	}

	@Override
	public List<Department> displayDepartment() throws SQLException {
		List<Department> dep = new ArrayList<Department>();
		query = "select * from department";
		prst = con.prepareStatement(query);
		rs = prst.executeQuery();
		Department d = null;
		while (rs.next()) {
			d = new Department(rs.getInt(1), rs.getString(2),rs.getInt(3));
			dep.add(d);
		}
		return dep;
	}

	@Override
	public Department findDepartmentById(int id) throws SQLException {
		query = "select * from department where department_id=?";
		prst = con.prepareStatement(query);
		prst.setInt(1, id);
		rs = prst.executeQuery();
		if(rs.next()) 
			return(new Department(rs.getInt(1), rs.getString(2),rs.getInt(3)));
		return null;
	}

	@Override
	public boolean updateDepartment(Department d) throws SQLException{
		int i = 0;
		query = "update department set department_name=?,manager_id=? where department_id=?";
		prst = con.prepareStatement(query);
		prst.setString(1, d.getDepartment_name());
		prst.setInt(2, d.getManager_id());
		prst.setInt(3, d.getDepartment_id());
		i = prst.executeUpdate();
		return i > 0;
	}

}
