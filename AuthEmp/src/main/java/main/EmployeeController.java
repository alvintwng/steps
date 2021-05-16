package main;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private RoleRepo rolerepo;

	@GetMapping("/")
	public String viewEmpPage(Model model) {
		List<Role> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);
		model.addAttribute("listEmps", employeeDao.getAllEmployees());		
		return "employees";
	}

	@GetMapping("/emp/new")
	public String showNewEmpForm(Model model) {
		
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		List<Role> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);

		return "employeeEdit";
	}

	
	@GetMapping("/emp/edit/{empId}")
	public String editEmployee(@PathVariable("empId") int empId, Model model) {
		
		Employee emp = employeeDao.getEmployeeById(empId);
		model.addAttribute("employee", emp);
		List<Role> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);
		
		return "employeeEdit";
	}
	
	@PostMapping(value = "/emp/save")
	public String saveEmp(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
			return "employeeEdit";

		employeeDao.save(emp);
		return "redirect:/";
	}
	
	@GetMapping("/emp/delete/{empId}")
	public String deleteEmplopyee(@PathVariable(name = "empId") int empId) {
		
		employeeDao.delete(empId);

		return "redirect:/";
	}
	
	@GetMapping("/emp/roleNew")
	public String showNewRoleForm(Model model) {
		
		Role role = new Role();
		model.addAttribute("role", role);

		return "roleNew";
	}
	
	@PostMapping(value = "emp/roleSave")
	public String saveRole(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
			return "roleNew";

		rolerepo.save(role);
		return "redirect:/";
	}
}
