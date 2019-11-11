package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;

/**
 * 衣類情報を操作するサービスクラス.
 * @author takahiro.suzuki
 *
 */
@Service
@Transactional
public class ClothService {
	
	@Autowired
	private ClothRepository clothRepository;
	
	/**
	 * 性別と色で検索された衣類情報を返す.
	 * 
	 * @param gender 性別
	 * @param color 色
	 * @return 検索された衣類情報
	 */
	public List<Cloth> searchByColorAndGender(Integer gender, String color){
		return clothRepository.findByClothesColorAndGender(gender, color);
	}

}
