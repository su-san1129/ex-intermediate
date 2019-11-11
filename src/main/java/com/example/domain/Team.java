package com.example.domain;


/**
 * チーム情報のドメインクラス.
 * 
 * @author takahiro.suzuki
 *
 */
public class Team {
	
	/** ID */
	private Integer id;
	/** リーグ名 */
	private String leagueName;
	/** チーム名 */
	private String teamName;
	/** 本拠地 */
	private String headquarters;
	/** 発足 */
	private String inauguration;
	/** 歴史 */
	private String history;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getInauguration() {
		return inauguration;
	}
	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}
	
	

}
