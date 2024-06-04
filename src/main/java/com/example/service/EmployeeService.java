package com.example.service;

// Service ... ビジネスロジックを担うクラス。Repository にデータ取得を依頼し、受け取ったデータの加工などを行う

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.EmployeeRepository;

// Serviceクラスであることを明示
@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
}
