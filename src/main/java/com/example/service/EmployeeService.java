package com.example.service;

// Service ... ビジネスロジックを担うクラス。Repository にデータ取得を依頼し、受け取ったデータの加工などを行う

import java.util.List;

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
}
