package com.example.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * チームの情報を操作するリポジトリ.
 * 
 * @author takahiro.suzuki
 *
 */
@Repository
public class TeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * teamオブジェクトを生成するrowマッパー.
	 */
	private final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	/**
	 * 各球団情報を発足日順で表示します.
	 * 
	 * @return 各球団一覧。データがない場合0件で返します。
	 */
	public List<Team> findAll(){
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration;";
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		return teamList;
	}
	
	/**
	 * 主キーから球団情報を取得します.
	 * 
	 * @param id 検索したい球団の主キー
	 * @return 検索された球団情報
	 */
	public Team load(Integer id) {
		try {
			String sql ="SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id = :id;";
			SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
			Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
			return team;
		} catch (Exception e) {
			System.out.println("検索に失敗しました。");
			return null;
		}
	}

}
