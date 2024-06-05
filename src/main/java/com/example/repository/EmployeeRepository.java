package com.example.repository;

import java.util.List;
import java.util.Optional;

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
	
	
	// 以下のように、ある命名規則に従ってメソッド名を定義すると自動的にクエリを生成してくれる (= クエリメソッド)
	
	// 部署が一致したすべての従業員を取得
	// SELECT * FROM employees WHERE department = '引数';
	public List<Employee> findByDepartment(String department);
	
	// 名前が一致した最初の従業員を取得
	// SELECT * FROM employees WHERE name = '引数' ORDER BY id ASC LIMIT 1;
	public Optional<Employee> findFirstByNameOrderByIdAsc(String name);
	
	
	// クエリメソッドの命名規則：
	// ・findBy や findFirstBy など、"By" より後ろの部分は SELECT文の WHERE句にあたる名前を付ける
	// ・findByName や findByDepartment のように指定したフィールド名を条件に持つSQLがつくられる
	// ・引数は検索に使いたいフィールドの型に合わせる。引数名は自由
	// ・クエリの結果が複数件の場合は List<Entityクラス> を、1件の場合は Optional<Entityクラス> を返り値の型に指定する
	
	
	// AND句や OR句の生成や、
	// SELECT * FROM employees WHERE name = '引数1' AND department = '引数2';
	public List<Employee> findByNameAndDepartment(String name, String department);
	
	// LIKE句を使ったあいまい検索を行うことも可能
	// SELECT * FROM employees WHERE name LIKE '引数'
	public List<Employee> findByNameLike(String name);
}
