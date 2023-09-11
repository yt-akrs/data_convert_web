package com.example.demo;

import java.io.File;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
	@PostMapping("/register")
	public ModelAndView register(
			@RequestParam("name") String name, 
			@RequestParam("password") String password,
			@RequestParam("gender") int gender, 
			@RequestParam("area") int area,
			@RequestParam("interest") int[] interests, 
			@RequestParam("remarks") String remarks,
			@RequestParam("inputfile") File inputfile,			
			ModelAndView mv) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("名前：" + name);
		sb.append(", パスワード：" + password);
		sb.append(", 性別：" + gender);
		sb.append(", 地域：" + area);
		sb.append(", 興味のある分野：" + Arrays.toString(interests));
		sb.append(", 備考：" + remarks.replaceAll("¥n", ""));
		sb.append(", ファイル名：" + inputfile.getName());
		mv.setViewName("result"); // ①
		mv.addObject("registData", sb.toString());// ②
		return mv;
	}
}
