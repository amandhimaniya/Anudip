package com.project.EmployeeManagementSystem;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import DAOImpl.*;
import model.*;

public class Menu {
		public void displayMenu() {
			Scanner sc = new Scanner(System.in);
			char sa = 'y';
			do {
				try {
					System.out.println("--------MAIN MENU--------");
					System.out.println("1. Employee");
					System.out.println("2. Department");
					System.out.println("3. Attendance");
					System.out.println("4. Salary");
					System.out.println("9. Exit");
					System.out.println("-------------------------");
					System.out.println("Chose a option");
					int ch = sc.nextInt();
					switch (ch) {
					case 1:
						employeeMenu();
						break;
					case 2:
						departmentMenu();
						break;
					case 3:
						attendanceMenu();
						break;
					case 4:
						salaryMenu();
						break;
					case 9:
						System.out.println("\nClosing Application!!.");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input, try again!!");
					}
				} catch (InputMismatchException e) {
					System.err.println("Please enter a valid numeric option.");
					sc.nextLine(); // Clear the invalid input
				} catch (Exception e) {
					System.err.println("An error Occured:-" + e.getMessage());
				}
				System.out.println("Do you want to continue(y/n):-");
				sa = sc.next().charAt(0);
			} while (sa == 'y' || sa == 'Y');
		}

		public void employeeMenu() {

			Scanner sc = new Scanner(System.in);
			char sa = 'y';
			do {
				try {
					EmployeeDAOImpl edi = new EmployeeDAOImpl();
					System.out.println("----------EMPLOYEE MENU----------");
					System.out.println("1. Register employee");
					System.out.println("2. Display employee");
					System.out.println("3. Search employee");
					System.out.println("4. Update employee");
					System.out.println("5. Delete employee");
					System.out.println("8. Return to main menu");
					System.out.println("9. Exit");
					System.out.println("-----------------------------");
					System.out.println("Chose a option");
					int ch = sc.nextInt();
					switch (ch) {
					case 1: {
						System.out.println("Enter the required details for employee creation:-");
						sc.nextLine();
						System.out.println("Enter First name:");
						String f_name = sc.nextLine();
						System.out.println("Enter Last name:");
						String l_name = sc.nextLine();
						System.out.println("Enter email:");
						String email = sc.nextLine();
						System.out.println("Enter contact:");
						long contact = sc.nextLong();
						sc.nextLine();
						System.out.println("Enter Job Title");
						String title= sc.nextLine();
						System.out.println("Enter department_id:");
						int d_id= sc.nextInt();
						System.out.println("Enter base salary:");
						double b_salary = sc.nextDouble();
						Employee e= new Employee(0,f_name,l_name,email,contact,title,d_id,b_salary);
						if (edi.saveEmployee(e))
							System.out.println("Employee registered successfully!!");
						else
							System.out.println("Employee cannot be registered,try again!");
						break;
					}
					case 2: {
						List<Employee> emp = edi.displayEmployee();
						if (emp.isEmpty())
							System.out.println("No Employee found");
						else {
							System.out.println("Employees are:-");
							for (Employee a : emp)
								System.out.println(a);
							System.out.println("..................................\n\n");
						}
						break;
					}
					case 3: {
						System.out.println("Enter emp_id:");
						int id = sc.nextInt();
						Employee ab = edi.findEmployeeById(id);
						if (ab != null) {
							System.out.println("Employee:-");
							System.out.println(ab);
							System.out.println("..................................\n\n");
						} else
							System.out.println("Employee not found!");
						break;
					}
					case 4: {
						System.out.println("Enter emp_id whose detail need to be updated:");
						int ids = sc.nextInt();
						if (edi.findEmployeeById(ids) == null)
							System.out.println("Employee with this Id does not exist");
						else {
							System.out.println("Enter the required details:-");
							sc.nextLine();
							System.out.println("Enter First name:");
							String f_name = sc.nextLine();
							System.out.println("Enter Last name:");
							String l_name = sc.nextLine();
							System.out.println("Enter email:");
							String email = sc.nextLine();
							System.out.println("Enter contact:");
							long contact = sc.nextLong();
							sc.nextLine();
							System.out.println("Enter Job Title");
							String title= sc.nextLine();
							System.out.println("Enter department_id:");
							int d_id= sc.nextInt();
							System.out.println("Enter base salary:");
							double b_salary = sc.nextDouble();
							Employee e= new Employee(ids,f_name,l_name,email,contact,title,d_id,b_salary);
							if (edi.updateEmployee(e))
								System.out.println("Employee updated succesfully");
							else
								System.out.println("Something went wrong");

						}
						break;
					}
					case 5:
						System.out.println("Enter emp_id:");
						int ids = sc.nextInt();
						if (edi.findEmployeeById(ids) == null)
							System.out.println("Invalid Employee..");
						else {
							if (edi.deleteEmployee(ids))
								System.out.println("Employee deleted succesfully!!");
							else
								System.out.println("Something went wrong");
						}
						break;
					case 8:
						displayMenu();
						break;
					case 9:
						System.out.println("\nClosing Application!!.");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input, try again!!");
					}
				} catch (InputMismatchException e) {
					System.err.println("Please enter a valid numeric option.");
					sc.nextLine(); // Clear the invalid input
				} catch (Exception e) {
					System.err.println("An error Occured:-" + e.getMessage());
				}
				System.out.println("Do you want to continue(y/n):-");
				sa = sc.next().charAt(0);
			} while (sa == 'y' || sa == 'Y');
		}

		public void departmentMenu() {
			Scanner sc = new Scanner(System.in);
			char sa = 'y';
			do {
				try {
					DepartmentDAOImpl ddi = new DepartmentDAOImpl();
					System.out.println("----------Department MENU----------");
					System.out.println("1. Register department");
					System.out.println("2. Display department");
					System.out.println("3. Search department");
					System.out.println("4. Update department");
					System.out.println("5. Delete department");
					System.out.println("8. Return to main menu");
					System.out.println("9. Exit");
					System.out.println("-------------------------------");
					System.out.println("Chose a option");
					int ch = sc.nextInt();
					switch (ch) {
					case 1: {
						System.out.println("Enter the required details for department creation:-");
						sc.nextLine();
						System.out.println("Enter Department name:");
						String d_name = sc.nextLine();
						System.out.println("Enter manager_id:");
						int m_id = sc.nextInt();
						Department d = new Department(0, d_name, m_id);
						if (ddi.saveDepartment(d))
							System.out.println("Department created successfully!!");
						else
							System.out.println("Department cannot be created,try again!");
						break;
					}
					case 2: {
						List<Department> department = ddi.displayDepartment();
						if (department.isEmpty())
							System.out.println("No department found");
						else {
							System.out.println("Department are:-");
							for (Department a : department)
								System.out.println(a);
							System.out.println("..................................\n\n");
						}
						break;
					}
					case 3: {
						System.out.println("Enter department_id:");
						int id = sc.nextInt();
						Department ab = ddi.findDepartmentById(id);
						if (ab != null) {
							System.out.println("Department:-");
							System.out.println(ab);
							System.out.println("..................................\n\n");
						} else
							System.out.println("Department not found!");
						break;
					}
					case 4: {
						System.out.println("Enter department_id whose detail need to be updated:");
						int id = sc.nextInt();
						if (ddi.findDepartmentById(id) == null)
							System.out.println("Department with this Id does not exist");
						else {
							System.out.println("Enter the required details:-");
							sc.nextLine();
							System.out.println("Enter Department name:");
							String d_name = sc.nextLine();
							System.out.println("Enter manager_id:");
							int m_id = sc.nextInt();
							Department d = new Department(id, d_name, m_id);
							if (ddi.updateDepartment(d))
								System.out.println("Department updated succesfully");
						}
						break;
					}
					case 5:
						System.out.println("Enter Department_id:");
						int id = sc.nextInt();
						if (ddi.findDepartmentById(id) == null)
							System.out.println("Invalid Department..");
						else {
							if (ddi.deleteDepartment(id))
								System.out.println("Department deleted succesfully!!");
						}
						break;
					case 8:
						displayMenu();
						break;
					case 9:
						System.out.println("\nClosing Application!!.");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input, try again!!");
					}
				} catch (InputMismatchException e) {
					System.err.println("Please enter a valid numeric option.");
					sc.nextLine(); // Clear the invalid input
				} catch (Exception e) {
					System.err.println("An error Occured:-" + e.getMessage());
				}
				System.out.println("Do you want to continue(y/n):-");
				sa = sc.next().charAt(0);
			} while (sa == 'y' || sa == 'Y');

		}

		public void attendanceMenu() {
			Scanner sc = new Scanner(System.in);
			char sa = 'y';
			do {
				try {
					AttendanceDAOImpl adi = new AttendanceDAOImpl();
					System.out.println("----------ATTENDANCE MENU----------");
					System.out.println("1. Mark Attendence");
					System.out.println("2. View Attendence");
					System.out.println("3. Attendance Report by Emp");
					System.out.println("8. Return to main menu");
					System.out.println("9. Exit");
					System.out.println("-------------------------------");
					System.out.println("Chose a option");
					int ch = sc.nextInt();
					switch (ch) {
					case 1: {
						System.out.println("Enter the required details for marking the Attendance:-");
						System.out.println("Enter emp_id:");
						int id = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Status:");
						String status = sc.nextLine().toLowerCase();
						System.out.println("Enter Date(yyyy-mm-dd):");
						LocalDate a=LocalDate.parse(sc.nextLine(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						Date d=java.sql.Date.valueOf(a);
						Attendance ab= new Attendance(0,id,d,status);
						if (adi.markAttendence(ab))
							System.out.println("Attendance marked successfully!!");
						break;
					}
					case 2: {
						List<Attendance> att = adi.viewAttendance();
						if (att.isEmpty())
							System.out.println("No Attendance Record is found");
						else {
							System.out.println("Attendance Records:-");
							for (Attendance r : att)
								System.out.println(r);
							System.out.println("..................................\n\n");
						}
						break;
					}
					case 3: {
						System.out.println("Enter the emp_id whose attendance report is to be generated:-");
						int id = sc.nextInt();
						List<Attendance> att = adi.viewAttendanceByEmp(id);
								if (att.isEmpty())
									System.out.println("No Record is found");
								else {
									System.out.println("Attendance Report:-");
									for (Attendance r : att)
										System.out.println(r);
									System.out.println("..................................\n\n");
								}
								break;
					}
					case 8:
						displayMenu();
						break;
					case 9:
						System.out.println("\nClosing Application!!.");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input, try again!!");
					}
				} catch (InputMismatchException e) {
					System.err.println("Please enter a valid numeric option.");
					sc.nextLine(); // Clear the invalid input
				} catch (Exception e) {
					System.err.println("An error Occured:-" + e.getMessage());
				}
				System.out.println("Do you want to continue(y/n):-");
				sa = sc.next().charAt(0);
			} while (sa == 'y' || sa == 'Y');

		}

		public void salaryMenu() {
			Scanner sc = new Scanner(System.in);
			char sa = 'y';
			do {
				try {
					SalaryDAOImpl sdi = new SalaryDAOImpl();
					System.out.println("----------SALARY MENU----------");
					System.out.println("1. Process Salary");
					System.out.println("2. View Salary History");
					System.out.println("3. Generate Salary Slip");
					System.out.println("8. Return to main menu");
					System.out.println("9. Exit");
					System.out.println("-------------------------------");
					System.out.println("Chose a option");
					int ch = sc.nextInt();
					switch (ch) {
					case 1: {
						System.out.println("Enter the required details for processing the salary:-");
						System.out.println("Enter emp_id:- ");
						int id = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter payment_method");
						String method = sc.nextLine();
						AttendanceDAOImpl adi=new AttendanceDAOImpl();
						Attendance a=new Attendance(0,id,null,"Present");
				        int c=adi.countAttendance(a);
				        double amount= sdi.calculateSalary(c, id);
				        Date d=java.sql.Date.valueOf(LocalDate.now());
						Salary s = new Salary(0,id,d,amount,method);
						if (sdi.processSalary(s))
							System.out.println("Salary processed successfully!!");
						else
							System.out.println("Salary cannot processed, try again!");
						break;
					}
					case 2: {
						List<Salary> r = sdi.viewSalaryHistory();
						if (r.isEmpty())
							System.out.println("No transaction exist");
						else {
							System.out.println("Salary History:-");
							for (Salary a : r)
								System.out.println(a);
							System.out.println("..................................\n\n");
						}
						break;
					}
					case 3: {
						System.out.println("Enter the emp_id whose salary slip is to be generated:-");
						int id = sc.nextInt();
						List<Salary> ss = sdi.generateSalarySlip(id);
								if (ss.isEmpty())
									System.out.println("No transaction exist");
								else {
									System.out.println("Salary Slip:- ");
									for (Salary r : ss)
										System.out.println(r);
									System.out.println("..................................\n\n");
								}
								break;
					}
					case 8:
						displayMenu();
						break;
					case 9:
						System.out.println("\nClosing Application!!.");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input, try again!!");
					}
				} catch (InputMismatchException e) {
					System.err.println("Please enter a valid numeric option.");
					sc.nextLine(); // Clear the invalid input
				} catch (Exception e) {
					System.err.println("An error Occured:-" + e.getMessage());
				}
				System.out.println("Do you want to continue(y/n):-");
				sa = sc.next().charAt(0);
			} while (sa == 'y' || sa == 'Y');

		}
	}
