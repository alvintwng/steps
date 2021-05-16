package main;

import java.util.List;
import java.util.Optional;

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
		return list;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		Optional <Employee> optional = employeeRepo.findById(empId);
		Employee emp = null;
		
		if(optional.isPresent())
			emp = optional.get();
		else
			throw new RuntimeException(" Employee not found for id :: " + empId);
		
		return emp;
	}

	@Override
	public void delete(int empId) {
		employeeRepo.deleteById(empId);
	}
}
