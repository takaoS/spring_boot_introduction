package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cookie")
public class CookieController {
	@GetMapping("/set") // cookie の保存は、一般的には POSTメソッドを利用する
	@ResponseBody
	public String setCookie(@RequestParam String val) {
		return "保存しました";
	}
}
