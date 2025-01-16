package DAO;

import java.sql.SQLException;
import java.util.List;

import model.Employee;

public interface EmployeeDAO {
	boolean saveEmployee(Employee e)throws SQLException;
	boolean deleteEmployee(int id) throws SQLException;
	List<Employee> displayEmployee()throws SQLException;
	Employee findEmployeeById(int id) throws SQLException;
	boolean updateEmployee(Employee e) throws SQLException;
	

}
