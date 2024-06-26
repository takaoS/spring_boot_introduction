package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/create") // データ挿入は、一般的には POSTメソッドを利用する
	public String addEmployee(@RequestParam String name, @RequestParam String department) {
		this.employeeService.insert(name, department);
		
		// リロードされると同じ POSTリクエストが再送信され、データが重複挿入されるため、リダイレクトで新たに GETリクエストを発生させる
		return "redirect:/employee/list";
	}
	
	// 例：http://localhost:8080/employee/update/5?name=桐ヶ谷&department=ゲーム開発部
	@GetMapping("/update/{employeeId}") // データ更新は、一般的には POSTメソッドを利用する
	public String editEmployee(
			@PathVariable Integer employeeId, 
			@RequestParam String name, 
			@RequestParam String department)
	{
		this.employeeService.update(employeeId, name, department);
		return "redirect:/employee/list";
	}
	
	@GetMapping("delete/{employeeId}")
	public String deleteEmployee(@PathVariable Integer employeeId) {
		this.employeeService.delete(employeeId);
		return "redirect:/employee/list";
	}
}
