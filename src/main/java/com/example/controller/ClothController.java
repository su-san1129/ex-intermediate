package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.service.ClothService;

/**
 * 衣類情報を操作するコントローラー.
 * 
 * @author takahiro.suzuki
 *
 */
@Controller
@RequestMapping("/clothes")
public class ClothController {
	
	@Autowired
	private ClothService clothService;
	
	/**
	 * 衣類検索画面を表示.
	 * 
	 * @return 衣類検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "clothes-search";
	}
	
	/**
	 * 衣類を色と性別で検索し、検索結果を画面に表示する.
	 * 
	 * @param gender 検索したい性別
	 * @param color 検索したい色
	 * @param model モデル
	 * @return 検索結果画面
	 */
	@RequestMapping("/input")
	public String input(Integer gender, String color, Model model) {
		System.out.println(gender + ":" + color);
		Cloth cloth = clothService.searchByColorAndGender(gender, color);
		if(cloth == null) {
			model.addAttribute("errors", "該当する情報がありませんでした。");
		} else {
			model.addAttribute("cloth", cloth);			
		}
		return "clothes-search";
	}

}
