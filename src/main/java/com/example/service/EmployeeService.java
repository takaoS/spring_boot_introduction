package com.example.service;

// Service ... ビジネスロジックを担うクラス。Repository にデータ取得を依頼し、受け取ったデータの加工などを行う

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

// Serviceクラスであることを明示
@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	// 全件取得処理
	public List<Employee> findAllEmployee() {
		// employeesテーブルのデータを employeeオブジェクトに入れて取得
		// 無条件なデータ検索となっているため、Entityクラスの複数取得を想定し、返り値の型は List<Entityクラス> となっている
		return this.employeeRepository.findAll();
	}
	
	// 主キーを指定して1件取得
	public Employee findEmployee(Integer employeeId) {
		// 取得したデータが null の場合、空の Optionalオブジェクトが代入される
		// その状態で get()メソッドを実行すると例外がスローされるため、isPresent()メソッドなどで nullチェックするのが望ましい
		Optional<Employee> opt = this.employeeRepository.findById(employeeId);
		
		// Optionalオブジェクトに値が存在する場合は Employee型の取得したデータを、存在しない場合は null を返す
		return opt.orElse(null);
	}
	
	// 部署による絞り込み検索
	public List<Employee> findByDepartment(String department) {
		return this.employeeRepository.findByDepartment(department);
	}
	
	// 新規登録
	public Employee insert(String name, String department) {
		Employee employee = new Employee();
		
		employee.setName(name);
		employee.setDepartment(department);
		
		// 挿入したデータを Entityクラスとして返す
		return this.employeeRepository.save(employee);
	}
}
