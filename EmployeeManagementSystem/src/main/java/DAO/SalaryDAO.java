package DAO;

import java.sql.SQLException;
import java.util.List;

import model.Salary;

public interface SalaryDAO {

	boolean processSalary(Salary s)throws SQLException;
	List<Salary> viewSalaryHistory()throws SQLException;
	List<Salary> generateSalarySlip(int id) throws SQLException;
	double calculateSalary(int c,int id)throws SQLException;
}
