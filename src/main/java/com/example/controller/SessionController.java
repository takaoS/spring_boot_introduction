package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
public class SessionController {
	
	private HttpSession session;
	
	// @Autowired を記載することで、DI (DependencyInjection) を利用できる
	// HttpSessionインターフェースは Servlet API なので実装が変更される可能性は極めて低いが、DI を使用することで依存関係の管理が一貫し、テストが容易になる
	@Autowired
	public SessionController(HttpSession session) {
		this.session = session; // コンストラクタでフィールドに代入
	}
	
	@GetMapping("/set") // セッションの保存は、一般的には POSTメソッドを利用する
	@ResponseBody
	public String set(@RequestParam("name") String nm, @RequestParam("bloodType") String bt) {
		this.session.setAttribute("name", nm);
		this.session.setAttribute("bloodType", bt);
		return "保存しました";
	}
}
