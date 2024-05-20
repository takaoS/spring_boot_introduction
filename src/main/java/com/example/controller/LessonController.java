package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	@GetMapping("/")
	// HTML をレスポンスにする場合、@ResponseBody は不要
	public String index() {
		return "index";  // return "テンプレートファイル名";
	}

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "This is test!";
	}
}
