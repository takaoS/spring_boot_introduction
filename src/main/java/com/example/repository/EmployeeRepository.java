package com.example.repository;

// Repository ... DB操作を定義したインタフェース

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

// Repositoryクラスであることを明示
@Repository
// JpaRepository を継承していることで、定義せずにデータの CRUD のメソッドを利用可能
// public interface Repository名 extends JpaRepository<利用したいEntityクラス名, 主キーの型> {}
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// Spring Data JPA は自動的に以下のメソッドを生成
	// ・save(Employee entity): エンティティを保存
	// ・findById(Integer id): 主キーでエンティティを検索
	// ・findAll(): すべてのエンティティを検索
	// ・deleteById(Integer id): 主キーでエンティティを削除
	// ・existsById(Integer id): 主キーでエンティティが存在するかどうかを判定
}
