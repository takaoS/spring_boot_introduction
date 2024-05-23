package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	@GetMapping("/")
	// HTML をレスポンスにする場合、@ResponseBody は不要
	public String index() {
		return "index";  // return "テンプレートファイル名";
	}

	@GetMapping("/test")
	// Model型の仮引数を持つ
	public String test(Model model) {
		String text = "This is test!";
		// msg という属性名で "This is test!" を保持
		model.addAttribute("msg", text);
		return "index";
	}
}
