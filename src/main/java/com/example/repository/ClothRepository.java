package com.example.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Cloth;

/**
 * 衣類情報を操作するリポジトリ.
 * 
 * @author takahiro.suzuki
 *
 */
@Repository
public class ClothRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Clothオブジェクトを生成するROWMAPPER.
	 */
	private final RowMapper<Cloth> CLOTH_ROW_MAPPER = (rs, i) ->{
		Cloth cloth = new Cloth();
		cloth.setId(rs.getInt("id"));
		cloth.setGenre(rs.getString("genre"));
		cloth.setCategory(rs.getString("category"));
		cloth.setGender(rs.getInt("gender"));
		cloth.setColor(rs.getString("color"));
		cloth.setPrice(rs.getInt("price"));
		cloth.setSize(rs.getString("size"));
		return cloth;
	};
	
	/**
	 * 検索された性別と色の衣類を取得.
	 * 
	 * @param gender 検索された性別
	 * @param color 検索された色
	 * @return 検索された衣類
	 */
	public Cloth findByClothesColorAndGender(Integer gender, String color){
		try {
			String sql = "SELECT id, category, genre, color, gender, price, size FROM clothes WHERE gender = :gender AND color = :color ORDER BY id;";
			SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
			Cloth cloth = template.queryForObject(sql, param, CLOTH_ROW_MAPPER);
			return cloth;
		} catch (Exception e) {
			System.out.println("該当する情報がありませんでした。");
			e.printStackTrace();
			return null;
		}
	}
	
	

}
