package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String showList(Model model) {
		List<Employee> employees = this.employeeService.findAllEmployee();
		model.addAttribute("employees", employees);
		return "employee/list";
	}
	
	@GetMapping("/find/{employeeId}")
	// "/find?id=123" のようなクエリパラメータではないため、@RequestParam は使わない
	// "/find/123" のように URLパスの一部であるため、@PathVariable を使う
	public String showEmployee(@PathVariable Integer employeeId, Model uiModel) {
		Employee employee = this.employeeService.findEmployee(employeeId);
		uiModel.addAttribute("employee", employee);
		return "employee/data";
	}
	
	@GetMapping("/searchByDepartment/{department}")
	public String searchEmployee(@PathVariable String department, Model uiModel) {
		List<Employee> employees = this.employeeService.findByDepartment(department);
		uiModel.addAttribute("employees", employees);
		return "employee/list";
	}
}
