package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//このクラスをControllerとして認識させる
@Controller
//ControllerにどんなURLでアクセスするのかを設定
//クラス、メソッドどちらにも指定が可能で、クラスに対して記述することで共通のURLを設定できる
@RequestMapping("/lesson")
public class LessonController {
	// クラスに指定したURL以降のパスを指定
	// http://localhost:8080/lesson/ にリクエストすると index()が実行される
	@GetMapping("/")
	// レスポンスにメソッドの返り値を利用 (ブラウザが画面に出力)
	// 今回は Hello World! をブラウザが解読し画面に表示する
	@ResponseBody
	public String index() {
		return "Hello World!";
	}

	// http://localhost:8080/lesson/test にリクエストすると test()が実行される
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "This is test!";
	}
}
