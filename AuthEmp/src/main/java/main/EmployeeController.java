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
	private RoleRepo rolerepo;

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
		return "redirect:/emp/roleNew";
	}
}
