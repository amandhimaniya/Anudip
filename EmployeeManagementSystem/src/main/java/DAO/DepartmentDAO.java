package DAO;

import java.sql.SQLException;
import java.util.List;

import model.Department;

public interface DepartmentDAO {
	boolean saveDepartment(Department d) throws SQLException;
	boolean deleteDepartment(int id) throws SQLException;
	List<Department> displayDepartment()throws SQLException;
	Department findDepartmentById(int id) throws SQLException;
	boolean updateDepartment(Department d) throws SQLException;
}
