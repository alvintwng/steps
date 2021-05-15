package main;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeDao {

	public List<Employee> getAllEmployees();
	public void save(Employee employee);

}
