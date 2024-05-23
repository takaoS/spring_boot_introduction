package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	//「?」以降の文字列をクエリ文字列 (クエリストリング、URLパラメータ、リクエストパラメータ) と呼ぶ
	//「パラメータ名=値」の形で表され、「&」で区切ることで複数のパラメータを渡すことができる
	// 例：http://localhost:8080/lesson/test?name=太郎&bloodType=AB
	// GETパラメータは様々なところに記録として残るため、パスワードなど第三者に知られてはいけない情報を記述しないのが基本
	@GetMapping("/test")
	// public String メソッド名(@RequestParam(パラメータ名) 型 仮引数名)
	// パラメータ名と仮引数名が同じ場合、@RequestParam String bloodType のようにパラメータ名の指定を省略できる
	public String test(Model model, @RequestParam("name") String nm, @RequestParam String bloodType) {
		String text = "This is test!";
		model.addAttribute("msg", text);
		
		model.addAttribute("name", nm);
		model.addAttribute("bloodType", bloodType);
		
		return "index";
	}
}
