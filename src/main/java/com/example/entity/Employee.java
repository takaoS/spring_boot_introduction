package com.example.entity;

// Entity ... 各テーブルごと用意し、1レコードにあたるデータを保持するクラス

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

// Entityクラスであることを明示
@Entity
// クラスに、指定したテーブルを紐づけ
// PostgreSQL では、テーブル名は小文字 & アンダースコア区切りが一般的 (例：company_employees)
// クラス名がテーブル名と同じ場合、自動的に紐づけされるため、@Table は省略可能
@Table(name = "employees")
@Data
// クラス名は、テーブル名の単数形をパスカルケースで表現 (例：CompanyEmployee)
public class Employee {
	
	// 主キーであることを明示
	@Id
	// 主キーに利用するシーケンスに対してプログラム上の名前を付けて定義
	// allocationSize で指定した数だけシーケンス番号をキャッシュしておき、エンティティ生成時に主キーとして割り当てられる。エンティティが一度に生成される数を指定するのがベスト
	@SequenceGenerator(name = "EMPLOYEE_ID_GENERATOR", sequenceName = "EMPLOYEE_ID_SEQ", allocationSize = 1)
	// 上述で定義したジェネレータを利用して、データ挿入時にシーケンス番号を主キーとして割り当て
	// 上述で定義したジェネレータを generator で指定
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_ID_GENERATOR")
	// PostgreSQL では、テーブル名と同じく、カラム名は小文字 & アンダースコア区切りが一般的 (例：first_name)
	@Column(name = "id")
	// フィールド名は、カラム名をキャメルケースでそのまま表現 (例：firstName)
	private Integer id;
	
	// フィールド名がカラム名と同じ場合、自動的に紐づけされるため、@Column は省略可能
	private String name;
	private String department;
}
