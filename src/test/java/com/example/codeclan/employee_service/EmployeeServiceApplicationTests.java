package com.example.codeclan.employee_service;

import com.example.codeclan.employee_service.models.Department;
import com.example.codeclan.employee_service.models.Employee;
import com.example.codeclan.employee_service.models.Project;
import com.example.codeclan.employee_service.repositories.DepartmentRepository;
import com.example.codeclan.employee_service.repositories.EmployeeRepository;
import com.example.codeclan.employee_service.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceApplicationTests {

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	DepartmentRepository deptRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment(){
		Department dept = new Department("Software Department");
		deptRepo.save(dept);
		Employee employee = new Employee("Allen", "Kelly", "65FRT", dept);
		employeeRepo.save(employee);
	}

	@Test
	public void addEmployeesAndProjects() {
		Department dept = new Department("Software Department");
		deptRepo.save(dept);

		Employee employee = new Employee("Allen", "Kelly", "65FRT", dept);
		employeeRepo.save(employee);

		Project project1 = new Project("Massive new Facebook Clone", 150);
		projectRepo.save(project1);

		project1.addEmployee(employee);
		employee.addProject(project1);
		projectRepo.save(project1);
	}

}
