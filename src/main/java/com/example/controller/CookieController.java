package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// Cookieクラスと HttpServletResponseクラスをインポートします
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("cookie")
public class CookieController {
	@GetMapping("/set") // クッキーの保存は、一般的には POSTメソッドを利用する
	@ResponseBody
	// http://localhost:8080/cookie/set?val=test のようにアクセスすると、
	public String setCookie(@RequestParam String val, HttpServletResponse res) {
		// Cookieクラスでクッキーを生成し (test_cookie という名前のクッキーに test という値を入れ) 、
		// HttpServletResponseクラスの addCookieメソッドでブラウザにクッキーの保存を命令
		res.addCookie(new Cookie("test_cookie", val));
		return "保存しました";
	}
	
	@GetMapping("/get")
	@ResponseBody
	public String getCookie(@CookieValue("test_cookie") Cookie cookie) {
		return "cookie の値：" + cookie.getValue();
	}
}