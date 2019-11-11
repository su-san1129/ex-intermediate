package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテルの情報を操作するサービスクラス.
 * 
 * @author takahiro.suzuki
 *
 */
@Service
@Transactional
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * ホテル情報を取得する.
	 * 
	 * @param price 料金
	 * @return 料金で取得したホテル情報
	 */
	public List<Hotel> serchByLessThanPrice(Integer price){
		return hotelRepository.findByPrice(price);
	}
	
	/**
	 * ホテル情報を全件取得する.
	 * @return 検索されたホテル情報
	 */
	public List<Hotel> showHotelList(){
		return hotelRepository.findAll();
	}

}
