package com.example.form;

// ① DTOクラスの用意

// DTO (Data Transfer Object) クラス...データを転送する目的で作成される Beanクラス
// サーバ側でのメッセージボディの受信は、一般的にこのクラスを介して行われる

// Beanクラス...フィールドとアクセサメソッドを持つ基本的なクラス全般

public class SampleForm {
	// ルール1. クライアントから送信されるフィールドをすべて定義する
	private String name;
	private String bloodType;
	
	// ルール2. アクセサメソッドをすべて定義する
	public void setName(String name) { this.name = name; }
	public void setBloodType(String bloodType) { this.bloodType = bloodType; }
	
	public String getName() { return name; }
	public String getBloodType() { return bloodType; }
}
