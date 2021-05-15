package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private EmployeeRepo employeeRepo;	
	
	@Override
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}

	public List<Employee> getAllEmployees() {

		List <Employee> list = employeeRepo.findAll();
		System.out.println("***** Employee List Size  " + list.size() );
		return list;
	}
}
