package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.SampleForm;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// POSTパラメータは、GETパラメータと違い、HTTPリクエストメッセージボディという専用の領域に追加されるので、URLに表示されない
	// POSTパラメータを受け取るには、①DTOクラスを用意 ②コントローラでパラメータを受信 が必要

	// ② コントローラでパラメータを受信
	// POST通信で /lesson/test にリクエストした場合に test() を実行
	@PostMapping("/test")
	// DTOクラスを仮引数に定義することで、メッセージボディが代入されたDTOクラスのオブジェクトが実引数として渡される
	public String test(Model model, SampleForm  sf) {
		String text = "This is test!";
		model.addAttribute("msg", text);
		
		model.addAttribute("name", sf.getName());
		model.addAttribute("bloodType", sf.getBloodType());
		
		return "index";
	}
	
	// POSTパラメータ送信用フォーム
	@GetMapping("/form")
	public String formTest(Model model) {
		// フォーム内で DTOクラスを利用するため、SampleFormオブジェクトを用意し、Model を介して渡す
		SampleForm sf = new SampleForm();
		model.addAttribute("sf", sf);
		
		return "lesson/form_test";
	}
}
