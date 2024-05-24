package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.form.SampleForm;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// 後述の test()メソッドと、同じパス名・メソッド名だが、リクエストが GET か POST かで分岐される
	@GetMapping("/test")
	// public String メソッド名(@RequestParam(パラメータ名) 型 仮引数名)
	// パラメータ名と仮引数名が同じ場合、@RequestParam String bloodType のようにパラメータ名の指定を省略できる
	// required属性を false に指定することで、GETパラメータがなくてもアクセスできる
	// その場合、引数には null がセットされが、defaultValue属性でデフォルト値を指定することもできる
	public String test(Model model, @RequestParam(value="name", required=false) String nm, @RequestParam(value="bloodType", required=false, defaultValue="AB") String bt) {
		String text = "This is test!";
		model.addAttribute("msg", text);

		model.addAttribute("name", nm);
		model.addAttribute("bloodType", bt);

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
	// @ModelAttribute を使ってモデルにオブジェクトを自動的に渡すこともできる
	// こっちの方が明示的で、コードを理解しやすいかも
	public String formTest(@ModelAttribute SampleForm sf) {
		return "lesson/form_test";
		// また、この場合の属性名は、オブジェクトのクラス名がキャメルケースに変換されたもの (sampleForm) になる
	}
}
