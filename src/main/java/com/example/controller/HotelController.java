package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

/**
 * ホテルの情報を操作するコントローラー.
 * 
 * @author takahiro.suzuki
 *
 */
@Controller
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	/**
	 * ホテル検索ページを表示する.
	 * @return ホテル検索ページ
	 */
	@RequestMapping("")
	public String showHotels() {
		return "search";
	}
	
	/**
	 * 料金で検索されたホテルの一覧を表示する.
	 * @param price 料金
	 * @param model モデル
	 * @return 検索された料金のホテル一覧。もし一件もなければ、0件を返す。
	 */
	@RequestMapping("/input")
	public String searchByPriceHotels( Integer price, Model model){
		List<Hotel> hotelList;
		if(price == null ) {
			hotelList = hotelService.showHotelList();
		} else {
			hotelList = hotelService.serchByLessThanPrice(price);
		}
		model.addAttribute("hotelList", hotelList);
		return "search";
	}
	

}
